/**
 * Created by jorgma on 2017-07-09.
 */
// smhi api stockholm
// https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/18.0686/lat/59.3293/data.json
// http://opendata.smhi.se/apidocs/metfcst/parameters.html
import {Injectable} from "@angular/core";
import {Geometry, Parameters, TimeSeries, WEATHER_SYMBOL, WeatherForecast, WeatherLocation} from "./weather.model";
import * as moment from "moment";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable, of} from "rxjs";


@Injectable()
export class WeatherService {
  now: Date;
  url = `/api/weather-forecast`;
  locationUrl = `/api/weather-locations`;
  weather_symbol = WEATHER_SYMBOL;

  constructor(private httpClient: HttpClient) {

  }


  public getCurrentWeatherForecast(): Observable<WeatherLocation> {
    return this.httpClient.get<WeatherLocation>(`${this.locationUrl}/current`);
  }


  public getWeatherForecast(location: WeatherLocation): Observable<WeatherLocation> {

    let params = new HttpParams();
    params = params.append('longitude', location.lon.toString());
    params = params.append('latitude', location.lat.toString());

    return this.httpClient.get<WeatherLocation>(this.url, {params: params});
  }


  public mapForecast(forecast: any): Observable<WeatherForecast> {
    this.now = new Date();
    let weatherForecast = new WeatherForecast();
    weatherForecast.approvedTime = forecast.approvedTime;
    weatherForecast.referenceTime = forecast.referenceTime;

    weatherForecast.geometry = this.mapGeometry(forecast);
    weatherForecast.timeSeries = this.mapTimeSeries(forecast.timeSeries);
    weatherForecast.currentTimeSeries = this.getCurrentWeather(weatherForecast);
    return of(weatherForecast);
  }


  private mapGeometry(forecast: any): Geometry {
    let geometry = new Geometry();
    geometry.type = forecast.type;
    geometry.coordinates = forecast.coordinates;
    return geometry;
  }

  private mapTimeSeries(forecastTimeSeries: any): TimeSeries[] {
    let timeSeries: TimeSeries[] = [];

    // forecastTimeSeries = this.removeZoneFromDate(forecastTimeSeries);
    forecastTimeSeries = this.filterTimeSeriesOutOfRange(forecastTimeSeries);

    for (let i = 0; i < forecastTimeSeries.length; i++) {
      let series = this.mapPerTimeSeries(forecastTimeSeries[i]);
      let validTime = new Date(series.validTime);
      if (this.isSameHour(validTime, this.now)) {
        series.current = true;

      }
      timeSeries.push(series);
    }
    return timeSeries;
  }


  private filterTimeSeriesOutOfRange(forecastTimeSeries: any): TimeSeries[] {
    return forecastTimeSeries.filter((series) => {
      return this.isTimeSeriesInRange(series)
    });
  }

  private removeZoneFromDate(forecastTimeSeries: any): TimeSeries[] {
    return forecastTimeSeries.map((series) => {
      // series.validTime = series.validTime.slice(0, 19).replace('T', ' ');
      return series;
    });
  }

  private mapPerTimeSeries(series: any): TimeSeries {
    let forecastSeries: TimeSeries = new TimeSeries();
    forecastSeries.validTime = series.validTime;
    forecastSeries.hour = new Date(series.validTime).getHours();
    forecastSeries.parameters = this.mapTimeSeriesParameters(series.parameters);
    return forecastSeries;
  }

  private mapTimeSeriesParameters(parameters: any): Parameters {
    let forecastParametersArr: any = {};

    for (let i = 0; i < parameters.length; i++) {
      let forecastParameters: Parameters = new Parameters();
      forecastParameters.name = parameters[i].name;
      forecastParameters.levelType = parameters[i].levelType;
      forecastParameters.level = parameters[i].level;
      forecastParameters.unit = parameters[i].unit;
      forecastParameters.value = parameters[i].values[0];
      forecastParametersArr[forecastParameters.name] = forecastParameters;
    }
    return forecastParametersArr
  }

  private isTimeSeriesInRange(forecastTimeSeries: TimeSeries, hoursDiff: number = 12): boolean {
    let limit = moment().add(hoursDiff, 'h');
    let validTime = new Date(forecastTimeSeries.validTime);
    return moment(forecastTimeSeries.validTime) <= limit
      && this.isSameHourOrAfter(validTime, this.now);
  }


  public isSameHour(date1: Date, date2: Date): boolean {
    return date1.getHours() === date2.getHours() && date1.getDate() === date2.getDate();
  }


  public isSameHourOrAfter(date1: Date, date2: Date): boolean {
    if (date1 > date2) {
      return true;
    }
    return date1.getHours() >= date2.getHours();
  }

  public getCurrentWeather(weatherForecast: WeatherForecast): TimeSeries {
    for (let i = 0; i < weatherForecast.timeSeries.length; i++) {
      if (weatherForecast.timeSeries[i].current) {
        return weatherForecast.timeSeries[i];
      }
    }
  }

  public getWeatherImageClass(timeSeries: TimeSeries): string {
    return this.weather_symbol[timeSeries.parameters['Wsymb2'].value].imgclass;
  }


  public getMinMaxParameterValue(timeSeries: TimeSeries[], paramName: string, min: boolean = false): number {
    let minMaxParamValue: number;

    if (timeSeries.length) {
      minMaxParamValue = timeSeries[0].parameters[paramName].value;
    }

    for (let i = 0; i < timeSeries.length; i++) {

      if (this.isTimeSeriesFromToday(timeSeries[i])) {
        if (min) {
          if (timeSeries[i].parameters[paramName].value < minMaxParamValue) {
            minMaxParamValue = timeSeries[i].parameters[paramName].value;
          }
        } else {
          if (timeSeries[i].parameters[paramName].value > minMaxParamValue) {
            minMaxParamValue = timeSeries[i].parameters[paramName].value;
          }
        }
      }
    }
    return minMaxParamValue;
  }


  public getMeanParameterValue(timeSeries: TimeSeries[], paramName: string): number {
    if (!timeSeries.length) {
      return 0;
    }

    let sum = timeSeries.reduce((previous, current) => previous + current.parameters[paramName].value, 0);
    return Math.round((sum / timeSeries.length) * 10) / 10;
  }


  private isTimeSeriesFromToday(timeSeries: TimeSeries) {
    return timeSeries.validTime.slice(0, 10) === this.now.toJSON().slice(0, 10);
  }
}
