/**
 * Created by jorgma on 2017-08-07.
 */
import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {DashboardService} from "./dashbaord.service";
import {Board} from "./board.model";

@Component({
  selector: 'dashboard',
  templateUrl: 'dashboard.component.html',
  styleUrls:['dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  title = 'Dashboard';
  boards: Board[] = [];

  constructor(private router: Router, private dashboardService: DashboardService) {
  }

  ngOnInit() {
    this.boards = this.dashboardService.getRoutes(this.router);
  }


  public navigate(board:Board) {
    this.router.navigateByUrl(board.path);
  }


}
