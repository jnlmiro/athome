import {NgModule} from "@angular/core";
import {ZwaveSensorComponent} from "./zwave.sensor.component";
import {ZwaveRouting} from "./zwave.routing";
import {ZwaveSensorsComponent} from "./zwave.sensors.component";
import {CommonModule} from "@angular/common";
import {HttpClientModule} from "@angular/common/http";
import {PincodeModule} from "../shared/pincode/pincode.module";
import {ZwaveSensorsConfigurationComponent} from "./configuration/zwave.sensors.configuration.component";
import {ZwaveComponent} from "./zwave.component";
import {ZwaveSensorConfigurationComponent} from "./configuration/zwave.sensor.configuration.component";
import {ZwaveMySensorsConfigurationComponent} from "./configuration/zwave.my.sensors.configuration.component";
import {ZwaveHaSensorsConfigurationComponent} from "./configuration/zwave.ha.sensors.configuration.component";


@NgModule({
  imports: [ZwaveRouting, CommonModule, HttpClientModule, PincodeModule],
  declarations: [
    ZwaveComponent,
    ZwaveSensorComponent,
    ZwaveSensorsComponent,
    ZwaveMySensorsConfigurationComponent,
    ZwaveHaSensorsConfigurationComponent,
    ZwaveSensorsConfigurationComponent,
    ZwaveSensorConfigurationComponent
  ],
  exports: [],
  providers: []
})
export class ZwaveModule {
}
