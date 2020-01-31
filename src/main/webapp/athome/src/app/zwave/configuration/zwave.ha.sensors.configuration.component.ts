import {Component, OnInit} from '@angular/core';
import {ZwaveSensorService} from "../zwave.sensor.service";
import {ZwaveSensor} from "../zwave.sensor.model";

@Component({
  selector: 'zwave-ha-sensors-configuration',
  templateUrl: './zwave.ha.sensors.configuration.component.html'
})
export class ZwaveHaSensorsConfigurationComponent implements OnInit {
  title: string = "HA Zwave Sensors Configuration";
  sensors: ZwaveSensor[] = [];
  selectedSensors: ZwaveSensor[] = [];

  constructor(private zwaveSensorService: ZwaveSensorService) {

  }

  ngOnInit() {
    this.getHaSensors();
  }


  getHaSensors() {
    this.zwaveSensorService.getHaSensors()
      .subscribe(sensors => {
        this.sensors = sensors;
      });
  }


  selectSensor(sensor: ZwaveSensor): void {
    let foundSensor = this.selectedSensors.find(s => s.haId === sensor.haId);
    if (!foundSensor) {
      this.selectedSensors.push(sensor);
    }
  }


  deselectSensor(sensor: ZwaveSensor): void {
    let foundSensor = this.selectedSensors.find(s => s.haId === sensor.haId);
    if (foundSensor) {
      this.selectedSensors = this.selectedSensors.filter(s => s.haId !== sensor.haId)
    }

  }


  saveSensor(sensor): void {
    this.zwaveSensorService.saveSensor(sensor)
      .subscribe(_ => this.getHaSensors());
  }

  isSelected(sensor: ZwaveSensor): boolean {
    return !!this.selectedSensors.find(s => s.haId === sensor.haId);
  }
}
