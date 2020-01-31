import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {RpiBackLight} from "./rpi-backlight.model";
import {Observable} from "rxjs";

@Injectable()
export class RpiBackLightService {
  url = '/api/rpi-backlight';

  constructor(private httpClient: HttpClient) {

  }

  getBackLightIntensity(): Observable<number> {
    return this.httpClient.get<number>(this.url);
  }

  setBackLightIntensity(rpiBackLight:RpiBackLight): Observable<RpiBackLight> {
    return this.httpClient.post<RpiBackLight>(this.url, rpiBackLight);
  }
}
