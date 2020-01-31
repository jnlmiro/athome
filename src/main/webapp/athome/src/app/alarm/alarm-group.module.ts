import {NgModule} from '@angular/core';
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {AlarmGroupRoutingModule} from "./alarm-group.routing.module";
import {AlarmGroupsComponent} from "./alarm-groups.component";
import {AlarmGroupComponent} from "./list/alarm-group.component";
import {AlarmGroupService} from "./alarm-group.service";
import {AlarmGroupDetailsComponent} from "./details/alarm-group.details.component";
import {AlarmGroupListComponent} from "./list/alarm-group.list.component";

@NgModule({
  imports: [BrowserModule, FormsModule, AlarmGroupRoutingModule],
  declarations: [AlarmGroupComponent, AlarmGroupsComponent, AlarmGroupDetailsComponent, AlarmGroupListComponent],
  providers: [AlarmGroupService],
})
export class AlarmGroupModule {
}
