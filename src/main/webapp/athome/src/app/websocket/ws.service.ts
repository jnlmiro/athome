import {Injectable} from "@angular/core";
import {StompConfig, StompRService, StompService} from '@stomp/ng2-stompjs';


export const WsConfig = {
  // Which server?
  url: 'ws://127.0.0.1:8080/socket',

  // Headers
  // Typical keys: login, passcode, host
  headers: {},

  // How often to heartbeat?
  // Interval in milliseconds, set to 0 to disable
  heartbeat_in: 0, // Typical value 0 - disabled
  heartbeat_out: 20000, // Typical value 20000 - every 20 seconds
  // Wait in milliseconds before attempting auto reconnect
  // Set to 0 to disable
  // Typical value 5000 (5 seconds)
  reconnect_delay: 5000,

  // Will log diagnostics on console
  debug: false
};

@Injectable()
export class WsService {
  private DESTINATION_PREFIX = '/app';

  constructor(private stompService: StompRService) {
    this.initStomp()
  }


  public initStomp() {
    this.stompService.config = WsConfig;
    this.stompService.initAndConnect();
  }

  getWs(): StompRService {
    return this.stompService;
  }


  sendMsg(endpoint:string, data:any) {
    return this.stompService.publish(`${this.DESTINATION_PREFIX}/${endpoint}`, data);
  }


}
