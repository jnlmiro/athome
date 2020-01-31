package org.jorgma.athome.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by jorgma on 2018-06-22.
 */
@Component
public class MqttConfigurationContainer {
    @Value("${mqtt.broker}")
    private String broker;

    @Value("${mqtt.qos}")
    private int qos;

    @Value("${mqtt.has.ssl}")
    private boolean hasSsl;

    @Value("${mqtt.port}")
    private int port;

    @Value("${mqtt.username}")
    private String username;

    @Value("${mqtt.password}")
    private String password;

    @Value("${mqtt.tcp}")
    private String tcp;

    @Value("${mqtt.ssl}")
    private String ssl;


    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    public int getQos() {
        return qos;
    }

    public void setQos(int qos) {
        this.qos = qos;
    }

    public boolean isHasSsl() {
        return hasSsl;
    }

    public void setHasSsl(boolean hasSsl) {
        this.hasSsl = hasSsl;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTcp() {
        return tcp;
    }

    public void setTcp(String tcp) {
        this.tcp = tcp;
    }

    public String getSsl() {
        return ssl;
    }

    public void setSsl(String ssl) {
        this.ssl = ssl;
    }


    public String getTcpBrokerUrl() {
        return String.format("%s%s:%s", this.tcp, this.broker, this.port);
    }
}
