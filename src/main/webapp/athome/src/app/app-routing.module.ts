/**
 * Created by jorgma on 2017-07-06.
 */
import {RouterModule, Routes} from "@angular/router";
import {PageNotFoundComponent} from "./page-not-found.component";
import {EntryBoardComponent} from "./entry-board/entry-board.component";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {NgModule} from "@angular/core";

const appRoutes: Routes = [
  {
    path: 'dashboard',
    component: DashboardComponent
  },
  {
    path: 'entry-board',
    component: EntryBoardComponent
  },
  {
    path: '',
    redirectTo: 'entry-board',
    pathMatch: 'full'
  },
  {path: '**', component: PageNotFoundComponent},
];


@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {
}
