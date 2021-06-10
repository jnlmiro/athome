/**
 * Created by jorgma on 2017-07-06.
 */
import {Component, OnInit} from "@angular/core";
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
    this.getEnabledStations()
  }

  getEnabledStations() {
    this.stationsService.getEnabledStations()
      .subscribe(stations => this.enabledStations = stations);
  }
}
