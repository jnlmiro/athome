/**
 * Created by jorgma on 2017-08-07.
 */
import {Injectable} from '@angular/core';
import {Router} from "@angular/router";
import {Board} from "./board.model";

@Injectable()
export class DashboardService {

  constructor() {
  }


  public getRoutes(router: Router): Board[] {
    let boards: Board[] = [];
    for (let i in router.config) {
      let board = new Board();
      let path = router.config[i].path;
      if (this.isPathToShow(path)) {
        board.path = router.config[i].path;
        board.name = board.path[0] + board.path.slice(1);
        boards.push(board);
      }
    }
    return boards;
  }



  private isPathToShow(path:string):boolean {
    return path && path !== '**' && path !== 'dashboard';
  }
}
