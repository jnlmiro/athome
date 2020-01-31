/**
 * Created by jorgma on 2017-07-06.
 */
import {Injectable} from '@angular/core';
import {Departure, Group, SlDeparture} from "./sl-departure.model";
import {Station} from "../stations/station.model";
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";


const TYPES = {
  'busGroups': 'Buss',
  'metroGroups': 'Tunnelbana'
};


const TYPE_IMGS = {
  'Bus': 'bus',
  'Metro': 'metro'
};


const NUMBER_OF_DEPARTURES = 4;

@Injectable()
export class SlDepartureService {
  // private url: string = 'http://sl.se/api/sv/RealTime/GetDepartures/';
  private url: string = 'api/sl/station/';

  constructor(private httpClient: HttpClient) {

  }


  public getDepartures(station: Station) {
    let stationId = station.siteId;
    return this.httpClient.get(`${this.url}${stationId}`)
      .pipe(map((res) => this.mapDepartures(res)));
  }


  private mapDepartures(res): SlDeparture {
    let resObj = res;
    let slDeparture = new SlDeparture();
    let mappedGroups: Group[] = [];
    if (resObj.data && resObj.data.hasResultData === true) {
      let dataObjProperties = Object.keys(resObj.data);

      for (let i = 0; i < dataObjProperties.length; i++) {
        let property = dataObjProperties[i];
        if (typeof resObj.data[property] === "object") {
          let tmpGroups = this.mapGroups(resObj.data[property], property);
          mappedGroups.push(...tmpGroups);
        }
      }
    }

    slDeparture.hasResultData = resObj.data.hasResultData;
    slDeparture.hasStopPointDeviations = resObj.data.hasStopPointDeviations;
    slDeparture.lastUpdate = resObj.data.lastUpdate;
    slDeparture.groups = mappedGroups;
    return slDeparture;
  }


  private mapGroups(groups: any[], groupName: string): Group[] {
    let departureGroups: Group[] = [];

    for (let i = 0; i < groups.length; i++) {
      let departureGroup = new Group();

      departureGroup.name = groupName;
      departureGroup.groupId = groups[i].groupId;

      departureGroup.currentServerTime = groups[i].currentServerTime;

      departureGroup.title = groups[i].title;
      departureGroup.transportSymbol = groups[i].transportSymbol;
      departureGroup.type = TYPES[groupName];

      departureGroup.departures = [];

      if (groups[i].departures) {
        let maxNumberOfDepartures = groups[i].departures.length > NUMBER_OF_DEPARTURES ? NUMBER_OF_DEPARTURES : groups[i].departures.length;
        for (let j = 0; j < maxNumberOfDepartures; j++) {
          departureGroup.departures.push(this.mapDeparture(groups[i].departures[j]))
        }
      }

      departureGroups.push(departureGroup);
    }
    return departureGroups;
  }

  private mapDeparture(departure: any) {
    let groupDeparture = new Departure();
    groupDeparture.destination = departure.destination;
    groupDeparture.deviations = departure.deviations;
    groupDeparture.displayTime = departure.displayTime;
    groupDeparture.expectedDateTime = departure.expectedDateTime;
    groupDeparture.lineNumber = departure.lineNumber;
    groupDeparture.stopPointNumber = departure.stopPointNumber;
    return groupDeparture;
  }


  public getTransportationImageClass(group: Group) {
    return TYPE_IMGS[group.type];
  }
}
