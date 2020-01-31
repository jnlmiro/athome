import {Injectable} from "@angular/core";
import {ZwaveSensor} from "./zwave.sensor.model";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class ZwaveSensorService {
  sensors: ZwaveSensor[] = [];
  url: string = '/api/zwave/sensors';
  haUrl: string = '/api/zwave/ha-sensors';


  constructor(private httpClient: HttpClient) {
  }


  getHaSensors(): Observable<ZwaveSensor[]> {
    return this.httpClient.get<ZwaveSensor[]>(this.haUrl);
  }


  getHaSensor(haId: string): Observable<ZwaveSensor> {
    return this.httpClient.get<ZwaveSensor>(`this.haUrl/${haId}`);
  }

  cacheSensor(sensor: ZwaveSensor): ZwaveSensor[] {
    let found = this.sensors.find(s => s.haId == sensor.haId);
    if (!found) {
      this.sensors.push(sensor);
    } else {
      found.state = sensor.state;
      found.alarming = sensor.alarming;
    }
    return this.sensors;
  }


  decacheSensor(sensor: ZwaveSensor): ZwaveSensor[] {
    return this.sensors.filter(s => s.haId !== sensor.haId);
  }

  updateSensorValue(sensorToUpdate: ZwaveSensor, sensor: ZwaveSensor): ZwaveSensor {
    sensorToUpdate = sensor;
    return sensorToUpdate;
  }

  jsonToZwaveSensor(msg: string): ZwaveSensor {
    let obj = new ZwaveSensor();
    try {
      obj = JSON.parse(msg);
      console.log(`Sensor automation received: ${obj}`);
    } catch (Error) {
      console.log(`Error when parsing ${msg}`);
    }
    return obj;
  }

  saveSensor(sensor: ZwaveSensor): Observable<ZwaveSensor> {
    return this.httpClient.post<ZwaveSensor>(this.url, sensor);
  }


  getSensors(): Observable<ZwaveSensor[]> {
    return this.httpClient.get<ZwaveSensor[]>(this.url);
  }


  getSensor(id: number): Observable<ZwaveSensor> {
    return this.httpClient.get<ZwaveSensor>(`${this.url}/${id}`);
  }


  removeSensor(id: number): Observable<ZwaveSensor> {
    return this.httpClient.delete<ZwaveSensor>(`${this.url}/${id}`);
  }
}
