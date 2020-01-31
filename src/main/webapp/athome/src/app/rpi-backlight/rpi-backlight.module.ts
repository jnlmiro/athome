/**
 * Created by jorgma on 2017-08-09.
 */
import {NgModule} from "@angular/core";
import {RpiBackLightComponent} from "./rpi-backlignt.component";
import {RPiBacklightRouting} from "./rpi-backlight.routing";
import {FormsModule} from "@angular/forms";
import {RpiBackLightService} from "./rpi-backlight.service";


@NgModule({
  imports: [RPiBacklightRouting, FormsModule],
  exports: [],
  declarations: [RpiBackLightComponent],
  providers: [RpiBackLightService],
})
export class RpiBackLightModule {
}
