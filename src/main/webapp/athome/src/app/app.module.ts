import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {AppComponent} from "./app.component";
import {PageNotFoundComponent} from "./page-not-found.component";
import {EntryBoardModule} from "./entry-board/entry-board.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {DashboardModule} from "./dashboard/dashboard.module";
import {RpiBackLightModule} from "./rpi-backlight/rpi-backlight.module";
import {StationsModule} from "./sl/stations/stations.module";
import {AppRoutingModule} from "./app-routing.module";
import {WeatherModule} from "./weather/weather.module";
import {HttpClientModule} from "@angular/common/http";
import {SharedModule} from "./shared/shared.module";
import {ZwaveModule} from "./zwave/zwave.module";
import {WsModule} from "./websocket/ws.module";
import {WsService} from "./websocket/ws.service";
import {StompService} from "@stomp/ng2-stompjs";
import {ZwaveSensorService} from "./zwave/zwave.sensor.service";
import {AlarmGroupModule} from "./alarm/alarm-group.module";

@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    EntryBoardModule,
    DashboardModule,
    RpiBackLightModule,
    StationsModule,
    WeatherModule,
    WsModule,
    ZwaveModule,
    AlarmGroupModule,
    AppRoutingModule,
    SharedModule
  ],
  providers: [WsService, StompService, ZwaveSensorService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
