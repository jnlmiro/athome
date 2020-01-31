import {Component} from "@angular/core";
import {AlarmGroup} from "../alarm-group.model";
import {AlarmGroupService} from "../alarm-group.service";

/**
 * Created by jorgma on 2020-01-30.
 */

@Component({
  selector: 'alarm-group-list',
  templateUrl: 'alarm-group.list.component.html',
  styleUrls: ['alarm-group.list.component.scss']
})
export class AlarmGroupListComponent{

  alarmGroups: AlarmGroup[] = [];

  constructor(private alarmGroupService: AlarmGroupService) {
  }

  ngOnInit() {
    this.getAlarmGroups();
  }

  private getAlarmGroups() {
    this.alarmGroupService.getAlarmGroups()
      .subscribe(alarmGroups => this.alarmGroups = alarmGroups);
  }

}
