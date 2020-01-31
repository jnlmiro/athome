package org.jorgma.athome.zwave.business;

import org.jorgma.athome.exceptions.AlreadyExistsException;
import org.jorgma.athome.exceptions.NotFoundException;
import org.jorgma.athome.zwave.dao.ZwaveSensorRepository;
import org.jorgma.athome.zwave.domain.ZwaveHaComponent;
import org.jorgma.athome.zwave.domain.ZwaveSensor;
import org.jorgma.athome.zwave.utils.AlarmUtils;
import org.jorgma.athome.zwave.utils.HaRestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jorgma on 2018-08-02.
 */
@Profile("!mock")
@Service()
public class ZwaveComponentBlImpl implements ZwaveComponentBl {

    @Value("${ha.api.url}")
    private String haApiUrl;

    @Value("${ha.api.bearer-token}")
    private String haApiBearerToken;

    @Autowired
    private ZwaveSensorRepository zwaveSensorRepository;

    @Autowired
    private RestTemplate haRestTemplate;


    public List<ZwaveSensor> getSensorsFromHa() {
        HttpHeaders headers = HaRestUtils.buildHttpHeaders(haApiBearerToken);
        HttpEntity<String> entity = HaRestUtils.buildHttpEntity(headers);

        ResponseEntity<ZwaveHaComponent[]> responseEntity = haRestTemplate.exchange(getRpiSensorStatesUrl(), HttpMethod.GET, entity, ZwaveHaComponent[].class);


        List<String> alreadyAddedHaIds = getAllSensors().stream().map(x -> x.getHaId()).collect(Collectors.toList());

        List<ZwaveHaComponent> allComponents = Arrays.asList(responseEntity.getBody());
        List<ZwaveSensor> zwaveSensors = allComponents.stream()
                .filter(zwaveComponent -> zwaveComponent.isSensor())
                .map(zwaveHaComponent -> toZwaveSensor(zwaveHaComponent))
                .filter(zwaveSensor -> !alreadyAddedHaIds.contains(zwaveSensor.getHaId()))
                .map(zwaveSensor -> mergeAndUpdate(zwaveSensor))
                .collect(Collectors.toList());

        return zwaveSensors;
    }

    @Override
    public ZwaveSensor getSensorFromHa(String haId) {
        HttpHeaders headers = HaRestUtils.buildHttpHeaders(haApiBearerToken);
        HttpEntity<String> entity = HaRestUtils.buildHttpEntity(headers);

        String _url = String.format("%s/%s", getRpiSensorStatesUrl(), haId);
        ResponseEntity<ZwaveHaComponent> responseEntity = haRestTemplate.exchange(_url, HttpMethod.GET, entity, ZwaveHaComponent.class);
        ZwaveHaComponent zwaveHaComponent = responseEntity.getBody();
        return toZwaveSensor(zwaveHaComponent);
    }

    @Override
    public List<ZwaveHaComponent> getHaComponents() {
        return null;
    }

    @Override
    public ZwaveSensor toZwaveSensor(ZwaveHaComponent zwaveHaComponent) {
        ZwaveSensor zwaveSensor = new ZwaveSensor();
        zwaveSensor.setHaId(zwaveHaComponent.getId());
        zwaveSensor.setName(zwaveHaComponent.getAttributes().getFriendlyName());
        zwaveSensor.setState(zwaveHaComponent.getState());
        zwaveSensor.setUnitOfMeasurement(zwaveHaComponent.getAttributes().getUnitOfMeasurement());
        zwaveSensor.setNodeId(zwaveHaComponent.getAttributes().getNodeId());
        zwaveSensor.setSensorType(zwaveHaComponent.getAttributes().getResponsibility());
        zwaveSensor = AlarmUtils.setAlarms(zwaveSensor);
        return zwaveSensor;
    }

    private ZwaveSensor mergeAndUpdate(ZwaveSensor zwaveSensorFromHa) {
        ZwaveSensor zwaveSensor = zwaveSensorRepository.findByHaId(zwaveSensorFromHa.getHaId());
        if (zwaveSensor != null) {
            zwaveSensorFromHa.setName(zwaveSensor.getName());
        }
        return zwaveSensorFromHa;
    }


    private String getRpiSensorStatesUrl() {
        return String.format("http://%s/api/states", haApiUrl);
    }

    public void save(ZwaveSensor sensor) {
        zwaveSensorRepository.save(sensor);
    }

    @Override
    public ZwaveSensor saveSensor(ZwaveSensor zwaveSensor) {
        ZwaveSensor sensor = zwaveSensorRepository.findByHaId(zwaveSensor.getHaId());
        if (sensor != null) {
            throw new AlreadyExistsException("Sensor already in database");
        }
        return zwaveSensorRepository.save(zwaveSensor);
    }

    @Override
    public List<ZwaveSensor> getAllSensors() {
        return (List<ZwaveSensor>) zwaveSensorRepository.findAll();
    }


    @Override
    public ZwaveSensor getSensor(int id) {
        return zwaveSensorRepository.findById(id).get();
    }

    @Override
    public ZwaveSensor removeSensor(int id) {
        ZwaveSensor zwaveSensor1 = getSensor(id);

        if (zwaveSensor1 == null) {
            throw new NotFoundException("ZwaveSensor not found");
        }

        zwaveSensorRepository.deleteById(id);
        return zwaveSensor1;
    }
}


