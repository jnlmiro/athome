/**
 * Created by jorgma on 2017-07-09.
 */

import {Component, OnInit, AfterViewInit, OnDestroy} from "@angular/core";
import {WeatherService} from "../weather.service";
import {WeatherForecast, TimeSeries, WeatherLocation} from "../weather.model";

import {flatMap} from "rxjs/operators";


@Component({
  selector: 'weather-forecast',
  templateUrl: './weather-forecast.component.html',
  styleUrls: ['./weather-forecast.component.scss']
})
export class WeatherForecastComponent implements OnInit, AfterViewInit, OnDestroy {


  weatherForecast: WeatherForecast;
  intervalId: number;
  currentWeatherLocation: WeatherLocation;


  constructor(private weatherService: WeatherService) {
  }

  ngOnInit() {
  }


  ngAfterViewInit(): void {
    this.getWeatherForecast();
    this.intervalId = <number>setInterval(() => this.getWeatherForecast(), 30 * 60000);
  }


  public getWeatherForecast() {
    this.weatherService.getCurrentWeatherForecast().pipe(
      flatMap(res => {
        if(res) {
          this.currentWeatherLocation = res;
          return this.weatherService.getWeatherForecast(res);
        }
      }))
      .subscribe((res) => {
        return this.weatherService.mapForecast(res)
          .subscribe(weatherForecast => {
            this.weatherForecast = weatherForecast;
          })
      });
  };


  public getMinMaxParameterValue(timeSeries: TimeSeries[], paramName: string, min: boolean): number {
    return this.weatherService.getMinMaxParameterValue(timeSeries, paramName, min);
  }

  public getMeanParameterValue(timeSeries: TimeSeries[], paramName: string): number {
    return this.weatherService.getMeanParameterValue(timeSeries, paramName);
  }

  ngOnDestroy(): void {
    clearInterval(this.intervalId);
  }
}
