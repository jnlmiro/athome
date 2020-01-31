package org.jorgma.athome.zwave.utils;

import org.jorgma.athome.zwave.domain.ZwaveSensor;

/**
 * Created by jorgma on 2018-08-06.
 */
public class AlarmUtils {

    public static ZwaveSensor setAlarms(ZwaveSensor zwaveSensor) {
        zwaveSensor.setAlarming(false);
        if (zwaveSensor.getHaId().equals("haSensor.aeotec_zw100_multisensor_6_burglar_6")) {
            if (Integer.valueOf(zwaveSensor.getState()) == 8 || Integer.valueOf(zwaveSensor.getState()) == 3) {
                zwaveSensor.setAlarming(true);
            }
        }
        if (zwaveSensor.getHaId().equals("haSensor.aeotec_zw100_multisensor_6_temperature_7")) {
            if (Double.valueOf(zwaveSensor.getState()) >= 29) {
                zwaveSensor.setAlarming(true);
            }
        }
        return zwaveSensor;
    }
}
