import {RouterModule, Routes} from "@angular/router";
import {WeatherLocationComponent} from "./location/weather-location.component";
import {NgModule} from "@angular/core";
import {WeatherComponent} from "./weather.component";
import {WeatherForecastComponent} from "./forecast/weather-forecast.component";

const weatherRoutes: Routes = [
  {
    path: 'weather',
    component: WeatherComponent,
    children: [
      {
        path: '',
        component: WeatherForecastComponent,
      }, {
        path: 'config',
        component: WeatherLocationComponent
      }
    ]
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(weatherRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class WeatherRoutingModule {
}
