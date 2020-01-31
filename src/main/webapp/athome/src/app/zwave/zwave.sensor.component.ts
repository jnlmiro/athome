import {Component, Input, OnInit} from '@angular/core';
import {ZwaveSensor} from "./zwave.sensor.model";

@Component({
  selector: 'zwave-sensor',
  styleUrls: ['zwave.sensor.component.scss'],
  templateUrl: 'zwave.sensor.component.html'
})
export class ZwaveSensorComponent implements OnInit {
  @Input() sensor: ZwaveSensor;

  ngOnInit(): void {
  }
}
