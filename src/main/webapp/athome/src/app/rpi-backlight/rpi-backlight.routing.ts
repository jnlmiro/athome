/**
 * Created by jorgma on 2017-07-06.
 */
import {Routes, RouterModule} from "@angular/router";
import {RpiBackLightComponent} from "./rpi-backlignt.component";


export const routes: Routes = [
  {path: 'rpi-backlight', component: RpiBackLightComponent},
];

export const RPiBacklightRouting = RouterModule.forChild(routes);
