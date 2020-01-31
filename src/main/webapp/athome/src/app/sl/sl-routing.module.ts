import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {StationsConfigurationComponent} from "./stations/configuration/stations.configuration.component";
import {SlComponent} from "./sl.component";
import {SlDeparturesComponent} from "./sl-departures/sl-departures.component";

const SlRoutes: Routes = [
  {
    path: 'sl',
    component: SlComponent,
    children: [
      {
        path: '',
        component: SlDeparturesComponent
      },
      {
        path: 'config',
        component: StationsConfigurationComponent
      }
    ]
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(SlRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class SlRoutingModule {
}
