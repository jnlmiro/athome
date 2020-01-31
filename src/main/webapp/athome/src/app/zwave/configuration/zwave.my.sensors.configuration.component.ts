import {Component, OnInit} from '@angular/core';
import {ZwaveSensorService} from "../zwave.sensor.service";
import {ZwaveSensor} from "../zwave.sensor.model";
import {Observable} from "rxjs";

@Component({
  selector: 'zwave-my-sensors-configuration',
  templateUrl: './zwave.my.sensors.configuration.component.html'
})
export class ZwaveMySensorsConfigurationComponent implements OnInit {
  title: string = "My Zwave Sensors Configuration";
  sensors: ZwaveSensor[] = [];
  selectedSensors: ZwaveSensor[] = [];

  constructor(private zwaveSensorService: ZwaveSensorService) {

  }

  ngOnInit() {
    this.getSensors();
  }


  getSensors() {
    this.zwaveSensorService.getSensors()
      .subscribe(sensors => this.sensors = sensors);
  }


  selectSensor(sensor: ZwaveSensor): void {
    let foundSensor = this.selectedSensors.find(s => s.id === sensor.id);
    if (!foundSensor) {
      this.selectedSensors.push(sensor);
    }
  }

  deselectSensor(sensor: ZwaveSensor): void {
    let foundSensor = this.selectedSensors.find(s => s.id === sensor.id);
    if (foundSensor) {
      this.selectedSensors = this.selectedSensors.filter(s => s.id !== sensor.id)
    }

  }

  saveSensor(sensor): void {
    this.zwaveSensorService.saveSensor(sensor)
      .subscribe(_ => this.getSensors());
  }

  isSelected(sensor: ZwaveSensor): boolean {
    return !!this.selectedSensors.find(s => s.id === sensor.id);
  }

  removeSensor(id: number): void {
    this.zwaveSensorService.removeSensor(id)
      .subscribe(x => {
        this.zwaveSensorService.decacheSensor(x);
        this.getSensors();
      });
  }

}
