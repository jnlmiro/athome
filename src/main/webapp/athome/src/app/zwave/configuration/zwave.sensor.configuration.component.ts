import {Component, OnInit} from '@angular/core';
import {ZwaveSensorService} from "../zwave.sensor.service";
import {ZwaveSensor} from "../zwave.sensor.model";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {switchMap} from "rxjs/operators";

@Component({
  selector: 'zwave-sensor-configuration',
  templateUrl: './zwave.sensor.configuration.component.html'
})
export class ZwaveSensorConfigurationComponent implements OnInit {
  title: string = "Zwave Sensor Configuration";
  sensor: ZwaveSensor;

  constructor(private zwaveSensorService: ZwaveSensorService, private route: ActivatedRoute) {

  }

  ngOnInit() {
    this.getSensor();
  }

  getSensor() {
    let sensor$ = this.route.paramMap.pipe(
      switchMap((params: ParamMap) =>
        this.zwaveSensorService.getSensor(+params.get("id"))
      ));
    sensor$.subscribe(sensor => this.sensor = sensor);
  }
}
