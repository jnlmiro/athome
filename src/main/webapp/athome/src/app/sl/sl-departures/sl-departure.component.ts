/**
 * Created by jorgma on 2017-07-06.
 */
import {Component, OnInit, OnDestroy, Input} from "@angular/core";
import {SlDepartureService} from "./sl-departure.service";
import {SlDeparture, Departure, Group, SlDepartureGroup} from "./sl-departure.model";
import {style, animate, transition, trigger} from "@angular/animations";
import {Station} from "../stations/station.model";

@Component({
  selector: 'sl-departure',
  templateUrl: 'sl-departure.component.html',
  styleUrls: ['sl-departure.component.scss'],
  animations: [
    trigger('fadeIn', [
      transition(':enter', [
        style({ opacity: '0' }),
        animate('.5s ease-out', style({ opacity: '1' })),
      ]),
    ]),
  ],
})
export class SlDepartureComponent implements OnInit, OnDestroy {

  slDepartureGroups: SlDepartureGroup[];
  updateInterval: number;
  departureGroupType:string;

  @Input() station: Station;
  @Input() set depGroupType(groupType:string) {
    this.departureGroupType = groupType;
  }

  constructor(private slDepartureService: SlDepartureService) {
    this.updateInterval = <number>setInterval(() => this.getDepartureGroups(this.station), 30000)
  }

  ngOnInit() {
    this.getDepartureGroups(this.station);

  }

  ngOnDestroy() {
    clearInterval(this.updateInterval)
  }

  public getDepartureGroups(station: Station) {
    this.slDepartureService.getDepartureGroups(station)
      .subscribe((slDepartureGroup) => {
        this.slDepartureGroups=slDepartureGroup;
      });
  }


  public shouldAlert(departure: Departure): boolean {
    return (departure.time.displayTime === 'Nu' || departure.time.displayTime !== 'Nu' && departure.time.displayTime.split(' min')[0].length === 1 && parseInt(departure.time.displayTime) <= 5)

  }


  public getTransportationImageClass(group: Group): string {

    return this.slDepartureService.getTransportationImageClass(group);
  }

}
