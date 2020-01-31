import {RouterModule, Routes} from "@angular/router";
import {ZwaveSensorsConfigurationComponent} from "./configuration/zwave.sensors.configuration.component";
import {ZwaveComponent} from "./zwave.component";
import {ZwaveSensorsComponent} from "./zwave.sensors.component";
import {ZwaveSensorConfigurationComponent} from "./configuration/zwave.sensor.configuration.component";
import {ZwaveMySensorsConfigurationComponent} from "./configuration/zwave.my.sensors.configuration.component";
import {ZwaveHaSensorsConfigurationComponent} from "./configuration/zwave.ha.sensors.configuration.component";

export const zwaveRoutes: Routes = [
  {
    path: 'zwave',
    component: ZwaveComponent,
    children: [
      {
        path: 'config',
        component: ZwaveSensorsConfigurationComponent,
        children: [
          {
            path: 'ha',
            component: ZwaveHaSensorsConfigurationComponent
          },
          {
            path: 'mine',
            component: ZwaveMySensorsConfigurationComponent,
            children: [
              {
                path: ':id',
                component: ZwaveSensorConfigurationComponent
              }
            ]
          },
          {
            path: '',
            component: ZwaveMySensorsConfigurationComponent,
          },
        ]
      },
      {
        path: '',
        component: ZwaveSensorsComponent,
      },
    ]
  }
];

export const ZwaveRouting = RouterModule.forChild(zwaveRoutes);
