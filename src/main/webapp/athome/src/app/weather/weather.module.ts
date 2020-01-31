/**
 * Created by jorgma on 2017-07-09.
 */
import {NgModule} from "@angular/core";
import {WeatherComponent} from "./weather.component";
import {WeatherService} from "./weather.service";
import {TimeSeriesComponent} from "./timeseries/timeseries.component";
import {CurrentWeatherComponent} from "./current-weather/current-weather.component";
import {BrowserModule} from "@angular/platform-browser";
import {CurrentWeatherTimeseriesFilter} from "./currentWeatherTimeSeriesFilter";

import {WeatherRoutingModule} from "./weather-routing.module";
import {WeatherForecastComponent} from "./forecast/weather-forecast.component";
import {SharedModule} from "../shared/shared.module";
import {WeatherLocationService} from "./location/weather-location.service";
import {WeatherLocationComponent} from "./location/weather-location.component";


@NgModule({
  imports: [BrowserModule, WeatherRoutingModule, SharedModule],
  exports: [WeatherForecastComponent],
  declarations: [WeatherComponent, WeatherForecastComponent, TimeSeriesComponent, CurrentWeatherComponent, CurrentWeatherTimeseriesFilter, WeatherLocationComponent],
  providers: [WeatherService, WeatherLocationService],
})
export class WeatherModule {
}
