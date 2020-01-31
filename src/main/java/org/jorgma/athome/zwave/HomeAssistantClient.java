package org.jorgma.athome.zwave;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.jorgma.athome.configuration.MqttConfigurationContainer;
import org.springframework.stereotype.Service;

/**
 * Created by jorgma on 2018-06-29.
 */
@Service
public class HomeAssistantClient {

    private MqttConfigurationContainer mqttConfigurationContainer;
    private SimpleMqttCallback simpleMqttCallback;

    private MqttClient mqttClient;

    public HomeAssistantClient(MqttConfigurationContainer mqttConfigurationContainer, SimpleMqttCallback simpleMqttCallback) {
        this.mqttConfigurationContainer = mqttConfigurationContainer;
        this.simpleMqttCallback = simpleMqttCallback;
        createMqttClient();
    }


    private void createMqttClient() {
        if (mqttClient == null) {
            try {
                mqttClient = new MqttClient(mqttConfigurationContainer.getTcpBrokerUrl(), MqttClient.generateClientId());
                mqttClient.setCallback(simpleMqttCallback);
                mqttClient.connect();

                mqttClient.subscribe("homeassistant/#");

            } catch (MqttException e) {
                e.printStackTrace();
            }
        }
    }

}
