import {Injectable} from "@angular/core";
import {Observable, Observer, Subject} from "rxjs";

@Injectable()
export class WebSocketService2 {
  private subject: Subject<any>;

  constructor() {

  }


  public connect(url: string): Subject<MessageEvent> {
    if (!this.subject) {
      this.subject = this.create(url);
    }
    return this.subject;
  }


  private create(url: string): Subject<MessageEvent> {

    let ws = new WebSocket(url);

    let observable = Observable.create(
      (observer: Observer<any>) => {
        ws.onmessage = observer.next.bind(observer);
        ws.onerror = observer.error.bind(observer);
        ws.onclose = observer.complete.bind(observer);
        return ws.close.bind(ws);
      });

    let observer = {
      next: (data: object) => {
        if (ws.readyState === WebSocket.OPEN) {
          ws.send(JSON.stringify(data));
        }
      }
    };

    return Subject.create(observer, observable);
  }
}
