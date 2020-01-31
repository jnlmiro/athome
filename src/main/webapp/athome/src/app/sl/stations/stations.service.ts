import {Injectable} from "@angular/core";
import {Observable, throwError} from 'rxjs';
import {Station} from "./station.model";
import {HttpClient} from "@angular/common/http";
import {catchError, map} from "rxjs/operators";

@Injectable()
export class StationsService {
  private url: string = "/api/stations";

  constructor(private httpClient: HttpClient) {
  }

  public getStations(): Observable<Station[]> {
    return this.httpClient.get<Station[]>(`${this.url}`)
      .pipe(
        map(res => res),
        catchError((error: any) => throwError(error || 'Server error')));
  }


  public getStation(id: string): Observable<Station> {
    return this.httpClient.get<Station>(`${this.url}/${id}`)
      .pipe(
        map(res => res),
        catchError((error: any) => throwError(error || 'Server error')));
  }


  public searchStation(searchStr: string): Observable<Station[]> {
    return this.httpClient.get<Station[]>(`${this.url}/search?stationName=${searchStr}`)
      .pipe(
        map(res => res),
        catchError((error: any) => throwError(error || 'Server error')));
  }

  public saveStation(station: Station): Observable<any> {
    return this.httpClient.post<Station>(`${this.url}`, station)
      .pipe(
        map(res => res),
        catchError((error: any) => throwError(error || 'Server error')));
  }


  updateStation(station: Station): Observable<Station> {
    return this.httpClient.put<Station>(`${this.url}`, station)
      .pipe(
        map(_ => station),
        catchError((error: any) => throwError(error || 'Server error')));
  }

  public removeStation(station: Station): Observable<any> {
    return this.httpClient.delete(`${this.url}/${station.id}`)
      .pipe(
        map(res => res),
        catchError((error: any) => throwError(error || 'Service error')));
  }

  getEnabledStations(): Observable<Station[]> {
    return this.httpClient.get<Station[]>(`${this.url}/enabled`)
      .pipe(
      map(res => res),
      catchError((error: any) => throwError(error || 'Server error')));
  }


}
