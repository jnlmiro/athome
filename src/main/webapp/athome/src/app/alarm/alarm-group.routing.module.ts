import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {AlarmGroupsComponent} from "./alarm-groups.component";
import {AlarmGroupListComponent} from "./list/alarm-group.list.component";
import {AlarmGroupDetailsComponent} from "./details/alarm-group.details.component";

const alarmGroupRoutes: Routes = [
  {
    path: 'alarm-groups',
    component: AlarmGroupsComponent,
    children: [
      {
        path: '',
        component: AlarmGroupListComponent
      },
      {
        path: ':id',
        component: AlarmGroupDetailsComponent
      }
    ]
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(alarmGroupRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AlarmGroupRoutingModule {
}
