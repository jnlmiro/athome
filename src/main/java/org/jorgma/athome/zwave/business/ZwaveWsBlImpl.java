package org.jorgma.athome.zwave.business;

import com.google.gson.Gson;
import org.jorgma.athome.zwave.domain.ZwaveSensor;
import org.jorgma.athome.zwave.utils.AlarmUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by jorgma on 2018-07-30.
 */
@Service
public class ZwaveWsBlImpl implements ZwaveWsBl {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public ZwaveWsBlImpl(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    public void send(String msg) {
        Gson gson = new Gson();
        try {

            ZwaveSensor sensor = gson.fromJson(msg, ZwaveSensor.class);
            sensor = AlarmUtils.setAlarms(sensor);
            System.out.println(String.format("Sending msg: %s",msg));
            msg = gson.toJson(sensor);
            messagingTemplate.convertAndSend("/topic", msg);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
