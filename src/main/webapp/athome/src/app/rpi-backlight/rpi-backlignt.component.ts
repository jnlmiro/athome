/**
 * Created by jorgma on 2017-08-09.
 */

import {Component, OnInit} from '@angular/core';
import {RpiBackLightService} from "./rpi-backlight.service";
import {RpiBackLight} from "./rpi-backlight.model";



@Component({
  selector: 'rpi-backlight',
  templateUrl: 'rpi-backlight.component.html'
})
export class RpiBackLightComponent implements OnInit {
  title = 'RPI BACKLIGHT';
  backListIntensity:number;

  constructor(private rpiBackLightService: RpiBackLightService) {
    this.rpiBackLightService.getBackLightIntensity()
      .subscribe(blIntensity => this.backListIntensity = blIntensity);

  }

  ngOnInit() {
  }

  onChange(event) {
    this.backListIntensity = event.target.value;
    let rpiBackLight = new RpiBackLight();
    rpiBackLight.intensity = this.backListIntensity;

    this.rpiBackLightService.setBackLightIntensity(rpiBackLight)
      .subscribe(res => {
        console.log(`this.backListIntensity ${res}`);
      });
  }
}
