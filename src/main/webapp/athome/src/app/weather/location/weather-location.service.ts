import {Injectable} from '@angular/core';

import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable, of, throwError} from "rxjs";
import {WeatherLocation} from "../weather.model";
import {catchError, map} from "rxjs/operators";
import {BaseService} from "../../common/base.service";

@Injectable()
export class WeatherLocationService extends BaseService {
  searchLocationUrl = '/api/weather-locations/search';
  locationUrl = '/api/weather-locations';


  constructor(private httpClient: HttpClient) {
    super();
  }

  searchLocations(text): Observable<WeatherLocation[]> {
    let params = new HttpParams();
    params = params.append('place', text);
    return this.httpClient
      .get<WeatherLocation[]>(this.searchLocationUrl, {params: params})
      .pipe(map((response: WeatherLocation[]) => {
        return <WeatherLocation[]>response;
      }), catchError(this.handleError));
  }

  getAllLocations(): Observable<WeatherLocation[]> {
    return this.httpClient.get<WeatherLocation[]>(this.locationUrl).pipe(catchError(this.handleError));
  }


  saveLocation(location): Observable<WeatherLocation> {
    return this.httpClient.post<WeatherLocation>(this.locationUrl, location)
      .pipe(catchError(this.handleError));
  }

  setCurrentLocation(location): Observable<WeatherLocation> {
    return this.httpClient.put<any>(this.locationUrl, location).pipe(
      catchError(this.handleError));
  }

  assertAtLeastOneCurrent(locations): Observable<any> {
    const currentLocation: WeatherLocation = locations.find(loc => loc.current === true);
    if (!currentLocation) {
      return throwError("At least one weather location must be set to current");
    }
    return of(locations);
  }


  removeLocation(location: WeatherLocation): Observable<WeatherLocation> {
    let params = new HttpParams();
    params = params.append('id', location.id.toString());
    return this.httpClient.delete<any>(this.locationUrl, {params: params});
  }
}
