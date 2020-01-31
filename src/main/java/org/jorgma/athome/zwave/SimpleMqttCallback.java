package org.jorgma.athome.zwave;

import org.jorgma.athome.zwave.service.SimpleMqttCallbackDispatcherService;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

/**
 * Created by jorgma on 2018-06-29.
 */
@Component
public class SimpleMqttCallback implements MqttCallback {

    @Autowired
    private SimpleMqttCallbackDispatcherService simpleMqttCallbackDispatcherService;

    @Override
    public void connectionLost(Throwable throwable) {
        System.out.println("Connection lost");
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        byte[] payload = mqttMessage.getPayload();
        String msg = new String(payload, StandardCharsets.UTF_8);
        System.out.println(String.format("Msg arrived: %s, %s", msg, LocalDateTime.now().toString()));
        simpleMqttCallbackDispatcherService.dispatch(s, msg);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        System.out.println("Message delivered");
    }
}
