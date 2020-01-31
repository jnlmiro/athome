/**
 * Created by jorgma on 2020-01-20.
 */


import {Component, OnInit} from '@angular/core';
import {AlarmGroup} from "./../alarm-group.model";
import {AlarmGroupService} from "./../alarm-group.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'alarm-group-details',
  templateUrl: 'alarm-group.details.component.html'
})
export class AlarmGroupDetailsComponent implements OnInit {
  alarmGroup: AlarmGroup;

  constructor(private alarmGroupService: AlarmGroupService, private router: ActivatedRoute) {
  }

  ngOnInit() {
    this.router.params.subscribe(params => {
      this.getAlarmGroup(params.id)
    });
  }


  private getAlarmGroup(id: number): void {
    /*this.alarmGroupService.getAlarmGroup(id)
      .subscribe(alarmgroup => this.alarmGroup = alarmgroup);*/

    this.alarmGroup = new AlarmGroup();
    this.alarmGroup.name = "One";
    this.alarmGroup.enabled = true;
    this.alarmGroup.fired = false;

    console.log(this.alarmGroup);

  }

  private enableAlarmGroup(enabled: boolean): void {
    this.alarmGroup.enabled = enabled;
    this.alarmGroupService.updateAlarmGroup(this.alarmGroup)
      .subscribe(alarmGroup => this.alarmGroup = alarmGroup);
  }

}
