/**
 * Created by jorgma on 2017-07-06.
 */

class SlDepartureDeviation {
  importanceLevel: number;
  text: string;
  deviationType: string;
  classification: string;
}


class SlDepartureTransport {
  destination: string;
  line: string;
  direction: number;
  transportType: string;
  transportSubType: string;
}

class SlDepartureTime {
  timeTabledDateTime: string;
  expectedDateTime: string;
  displayTime: string;
}

export class SlDeparture {
  destination: string;
  stopAreaName: string;
  journeyNumber: number;
  time: SlDepartureTime;
  transport: SlDepartureTransport;
  deviations: SlDepartureDeviation[];

}


export class SlDepartureGroup {


  constructor(departures: SlDeparture[], type: string, transportSymbol: string) {
    this.departures = departures;
    this.type = type;
    this.transportSymbol = transportSymbol;
  }

  departures: SlDeparture[];
  type: string;
  transportSymbol: string;
}


export class Group {
  name: string;
  groupId: string;
  currentServerTime: string;
  departures: Departure[];
  title: string;
  transportSymbol: string;
  type: string;
}

export class Departure {
  destination: string;
  deviations: any[];
  time: {
    displayTime: string,
    expectedDateTime: string,
    timeTabledDateTime: string
  };
  stopPointNumber: string;
  lineNumber: number;
}


