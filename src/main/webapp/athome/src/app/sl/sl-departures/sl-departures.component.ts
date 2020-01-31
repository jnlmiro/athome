/**
 * Created by jorgma on 2017-07-06.
 */
import {Component, OnInit, OnDestroy, Input} from "@angular/core";
import {SlDepartureService} from "./sl-departure.service";
import {SlDeparture, Departure, Group} from "./sl-departure.model";
import {style, animate, transition, trigger} from "@angular/animations";
import {Station} from "../stations/station.model";
import {StationsService} from "../stations/stations.service";

@Component({
  selector: 'sl-departures',
  templateUrl: 'sl-departures.component.html',
})
export class SlDeparturesComponent implements OnInit {

  enabledStations: Station[] = [];

  constructor(private stationsService: StationsService) {
  }

  ngOnInit() {
    this.getEnabledStations();
  }


  getEnabledStations() {
    this.stationsService.getEnabledStations()
      .subscribe(stations => this.enabledStations = stations);
  }
}
