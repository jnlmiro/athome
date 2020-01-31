/**
 * Created by jorgma on 2017-07-06.
 */
import {NgModule} from "@angular/core";
import {SlDepartureComponent} from "./sl-departures/sl-departure.component";
import {HttpModule} from "@angular/http";
import {SlDepartureService} from "./sl-departures/sl-departure.service";
import {BrowserModule} from "@angular/platform-browser";
import {DeparturesFilter} from "./departuresFilter";
import {SlComponent} from "./sl.component";
import {StationsModule} from "./stations/stations.module";
import {SlDeparturesComponent} from "./sl-departures/sl-departures.component";
import {SlRoutingModule} from "./sl-routing.module";


@NgModule({
  imports: [HttpModule, BrowserModule, StationsModule, SlRoutingModule],
  exports: [SlComponent, SlDeparturesComponent],
  declarations: [SlDepartureComponent, SlDeparturesComponent, DeparturesFilter, SlComponent],
  providers: [SlDepartureService],
})
export class SlDepartureModule {
}
