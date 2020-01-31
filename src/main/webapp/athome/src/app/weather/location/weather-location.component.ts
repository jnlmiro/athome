import {Component, OnInit} from '@angular/core';
import {WeatherLocation} from "../weather.model";
import {WeatherLocationService} from "./weather-location.service";
import {Subject} from "rxjs";
import {debounceTime, distinctUntilChanged, switchMap} from "rxjs/operators";


@Component({
  selector: 'weather-location-component',
  templateUrl: 'weather-location.component.html',
  styleUrls: ['weather-location.component.scss']
})

export class WeatherLocationComponent implements OnInit {

  private foundLocations: WeatherLocation[] = [];
  private selectedLocation: WeatherLocation = null;
  private locations: WeatherLocation[] = [];

  private searchInputSrc$: Subject<string> = new Subject<string>();


  constructor(private weatherLocationService: WeatherLocationService) {
    this.searchInputSrc$.pipe(
      debounceTime(500),
      distinctUntilChanged(),
      switchMap(x => this.weatherLocationService.searchLocations(x)))
      .subscribe(locations => this.foundLocations = locations);
  }


  ngOnInit() {
    this.getAllLocations();
  }

  getAllLocations() {
    this.weatherLocationService.getAllLocations()
      .subscribe(
        locations => this.locations = locations,
        () => {
        }
      )
  }


  search(event) {
    this.searchInputSrc$.next(event.target.value);

  }


  onLocationSelected(selectedLocation: WeatherLocation) {
    this.selectedLocation = selectedLocation;
  }

  saveLocation(location: WeatherLocation) {
    const existsAlready = typeof this.locations.find(y => y.geonameid == location.geonameid) !== 'undefined';
    if (existsAlready) {
      return;
    }

    this.weatherLocationService.saveLocation(location)
      .subscribe(
        savedLocation => this._onSaveLocation(savedLocation),
        () => {
        });
  }

  _onSaveLocation(location: WeatherLocation) {
    this.locations.push(location);
  }


  setCurrentLocation(location: WeatherLocation, isCurrent: boolean) {
    location.current = isCurrent;
    this.weatherLocationService.assertAtLeastOneCurrent(this.locations)
      .subscribe(
        () => {
        },
        (err) => console.log(err));

    this.weatherLocationService.setCurrentLocation(location)
      .subscribe(
        current => this._onSetCurrentLocation(current),
        () => {
        });
  }

  _onSetCurrentLocation(location: WeatherLocation) {
    this.locations.forEach(loc => {
      if (loc.id !== location.id) {
        loc.current = false;
      } else {
        loc.current = location.current;
      }
    });
  }

  removeLocation(location: WeatherLocation) {
    this.weatherLocationService.removeLocation(location)
      .subscribe(res => {
        this._onRemoveLocation(location);
      });
  }

  _onRemoveLocation(location: WeatherLocation) {
    this.locations = this.locations.filter(loc => {
      return loc.id !== location.id
    });
    if (this.locations.length > 0 && location.current === true) {
      const isCurrent: boolean = true;
      this.setCurrentLocation(this.locations[0], isCurrent);
    }
  }

  locationViewValueFormatter = (x: { place: string }) => x.place;

}
