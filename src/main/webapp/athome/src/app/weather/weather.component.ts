/**
 * Created by jorgma on 2017-07-09.
 */

import {Component, OnInit, AfterViewInit, OnDestroy} from "@angular/core";
import {WeatherService} from "./weather.service";
import {WeatherForecast, TimeSeries} from "./weather.model";

@Component({
  selector: 'weather',
  templateUrl: 'weather.component.html',
})
export class WeatherComponent {
}
