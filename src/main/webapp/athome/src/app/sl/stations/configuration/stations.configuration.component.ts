import {Component, OnInit} from "@angular/core";
import {StationsService} from "../stations.service";
import {Station} from "../station.model";


@Component({
  selector: 'stations',
  templateUrl: './stations.configuration.component.html',
  styleUrls: ['./stations.configuration.component.scss']
})
export class StationsConfigurationComponent implements OnInit {

  stations: Station[];
  stationsSearchResult: Station[] = [];
  searchString: string;

  constructor(private stationsService: StationsService) {

  }


  ngOnInit(): void {
    this.getStations()
  }

  getStations() {
    this.stationsService.getStations()
      .subscribe(stations => this.stations = stations);
  }

  search(stationName: string): void {
    this.stationsService.searchStation(stationName)
      .subscribe(stations => this.stationsSearchResult = stations.filter(station => !this.stationAlreadyAdded(station, this.stations)));
  }

  stationAlreadyAdded(station, stations) {
    return !!stations.find(s => s.siteId == station.siteId);
  }

  saveStation(station: Station): void {
    this.stationsService.saveStation(station)
      .subscribe(_ => this.getStations());
  }


  enableStation(station: Station, enabled: boolean) {
    station.enabled = enabled;
    this.stationsService.updateStation(station)
      .subscribe(station => {
        console.log("Station updated", station);

        this.getStations();
      });
  }


  removeStation(station: Station): void {
    this.stationsService.removeStation(station)
      .subscribe(_ => this.getStations());
  }
}
