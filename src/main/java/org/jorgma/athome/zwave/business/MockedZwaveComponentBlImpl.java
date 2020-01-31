package org.jorgma.athome.zwave.business;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jorgma.athome.zwave.dao.ZwaveSensorRepository;
import org.jorgma.athome.zwave.domain.ZwaveHaComponent;
import org.jorgma.athome.zwave.domain.ZwaveSensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jorgma on 2018-08-02.
 */
@Profile("mock")
@Service()
public class MockedZwaveComponentBlImpl implements ZwaveComponentBl {


    @Autowired
    private ZwaveSensorRepository zwaveSensorRepository;
    @Autowired
    private ZwaveComponentBl zwaveComponentBl;

    public List<ZwaveSensor> getSensorsFromHa() {
        Gson gson = new Gson();
        return gson.fromJson("[{\"id\":0,\"haId\":\"sensor.aeotec_zw100_multisensor_6_ultraviolet_7\"," +
                "\"name\":\"Ultraviolet\",\"state\":\"0.0\",\"nodeId\":11,\"enabled\":false," +
                "\"sensorType\":\"ultraviolet\",\"unitOfMeasurement\":\"\",\"alarming\":false}" +
                ",{\"id\":0,\"haId\":\"sensor.aeotec_zw100_multisensor_6_temperature_7\",\"name\":\"Temperature\"," +
                "\"state\":\"19.5\",\"nodeId\":11,\"enabled\":false,\"sensorType\":\"temperature\"," +
                "\"unitOfMeasurement\":\"°C\",\"alarming\":false},{\"id\":0," +
                "\"haId\":\"sensor.aeotec_zw100_multisensor_6_luminance_7\",\"name\":\"Luminance\",\"state\":\"4.0\"," +
                "\"nodeId\":11,\"enabled\":false,\"sensorType\":\"luminance\",\"unitOfMeasurement\":\"lux\"," +
                "\"alarming\":false},{\"id\":0,\"haId\":\"sensor.aeotec_zw100_multisensor_6_burglar_6\"," +
                "\"name\":\"Burglar\",\"state\":\"0\",\"nodeId\":11,\"enabled\":false,\"sensorType\":\"alarm\"," +
                "\"unitOfMeasurement\":\"\",\"alarming\":false},{\"id\":0," +
                "\"haId\":\"sensor.aeotec_zw100_multisensor_6_relative_humidity_7\"," +
                "\"name\":\"Humidity\",\"state\":\"52.0\",\"nodeId\":11,\"enabled\":false,\"sensorType\":\"humidity\"," +
                "\"unitOfMeasurement\":\"%\",\"alarming\":false}]", new TypeToken<List<ZwaveSensor>>() {
        }.getType());
    }

    @Override
    public ZwaveSensor getSensorFromHa(String haId) {
        List<ZwaveSensor> zwavesensors = getSensorsFromHa();
       return zwavesensors.stream().filter(zwaveSensor -> zwaveSensor.getHaId().equals(haId)).findFirst().get();
    }

    @Override
    public List<ZwaveHaComponent> getHaComponents() {
        return null;
    }

    @Override
    public ZwaveSensor toZwaveSensor(ZwaveHaComponent zwaveHaComponent) {
       return null;
    }


    @Override
    public ZwaveSensor saveSensor(ZwaveSensor zwaveSensor) {
        return zwaveComponentBl.saveSensor(zwaveSensor);
    }

    @Override
    public List<ZwaveSensor> getAllSensors() {
        return zwaveComponentBl.getAllSensors();
    }


    @Override
    public ZwaveSensor getSensor(int id) {
        return zwaveSensorRepository.findById(id).get();
    }

    @Override
    public ZwaveSensor removeSensor(int id) {
        return zwaveComponentBl.removeSensor(id);
    }

}


