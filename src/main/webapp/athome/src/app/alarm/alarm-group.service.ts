import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {AlarmGroup} from "./alarm-group.model";
import {catchError, map} from "rxjs/operators";

@Injectable()
export class AlarmGroupService {

  private url: string = "/api/alarm-groups";

  constructor(private httpClient: HttpClient) {
  }

  getAlarmGroups(): Observable<AlarmGroup[]> {
    return this.httpClient.get<AlarmGroup[]>(this.url)
      .pipe(
        map(res => res),
        catchError((error: any) => throwError(error || 'Server error')));
  }


  createAlarmGroup(alarmGroup: AlarmGroup): Observable<AlarmGroup> {
    return this.httpClient.post<AlarmGroup>(this.url, alarmGroup)
      .pipe(
        map(res => res),
        catchError((error: any) => throwError(error || 'Server error')));
  }

  updateAlarmGroup(alarmGroup: AlarmGroup): Observable<AlarmGroup> {
    return this.httpClient.put<AlarmGroup>(`${this.url}/${alarmGroup.id}`, alarmGroup)
      .pipe(
        map(res => res),
        catchError((error: any) => throwError(error || 'Server error')));
  }

  getAlarmGroup(id: number): Observable<AlarmGroup> {
    return this.httpClient.get<AlarmGroup>(`${this.url}/${id}`)
      .pipe(
        map(res => res),
        catchError((error: any) => throwError(error || 'Server error')));

  }
}
