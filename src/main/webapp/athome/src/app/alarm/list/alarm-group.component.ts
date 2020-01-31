import {Component, Input, OnInit} from '@angular/core';
import {AlarmGroup} from "../alarm-group.model";
import {AlarmGroupService} from "../alarm-group.service";

@Component({
  selector: 'alarm-group',
  templateUrl: 'alarm-group.component.html'
})
export class AlarmGroupComponent implements OnInit {
  @Input() alarmGroup: AlarmGroup;

  constructor(private alarmGroupService: AlarmGroupService) {
  }

  ngOnInit() {

  }


  private enableAlarmGroup(enabled: boolean): void {
    this.alarmGroup.enabled = enabled;
    this.alarmGroupService.updateAlarmGroup(this.alarmGroup)
      .subscribe(alarmGroup => this.alarmGroup = alarmGroup);
  }

}
