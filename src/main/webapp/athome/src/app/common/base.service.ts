import {Injectable} from '@angular/core';
import {throwError} from "rxjs";

@Injectable()
export class BaseService {

  constructor() {
  }

  handleError(error: Response) {
    return throwError(error.statusText);
  }

}
