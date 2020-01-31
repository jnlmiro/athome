import {NgModule} from "@angular/core";
import {WsService} from "../websocket/ws.service";
import {StompRService} from "@stomp/ng2-stompjs";


@NgModule({
  exports: [],
  providers: [
    WsService,
    StompRService,
  ]
})
export class WsModule {
}
