/**
 * Created by jorgma on 2017-08-07.
 */
import {NgModule} from "@angular/core";
import {DashboardComponent} from "./dashboard.component";
import {DashboardService} from "./dashbaord.service";
import {BrowserModule} from "@angular/platform-browser";

@NgModule({
  imports: [BrowserModule],
  exports: [],
  declarations: [DashboardComponent],
  providers: [DashboardService],
})
export class DashboardModule {
}
