package org.jorgma.athome.zwave.business;

import org.springframework.stereotype.Service;

/**
 * Created by jorgma on 2018-07-30.
 */
@Service
public class SimpleMqttCallbackDispatcherBlImpl implements SimpleMqttCallbackDispatcherBl {

    private ZwaveWsBl zwaveWsBl;

    public SimpleMqttCallbackDispatcherBlImpl(ZwaveWsBl zwaveWsBl) {
        this.zwaveWsBl = zwaveWsBl;

    }

    @Override
    public void dispatch(String topic, String msg) {
        assert !topic.isEmpty();
        zwaveWsBl.send(msg);

    }

}
