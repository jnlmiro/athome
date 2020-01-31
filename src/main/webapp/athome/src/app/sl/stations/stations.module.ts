import {NgModule} from "@angular/core";

import {BrowserModule} from "@angular/platform-browser";
import {StationsConfigurationComponent} from "./configuration/stations.configuration.component";
import {StationsService} from "./stations.service";
import {FormsModule} from "@angular/forms";

@NgModule({
  imports: [BrowserModule, FormsModule],
  declarations: [StationsConfigurationComponent],
  providers: [StationsService]
})
export class StationsModule {
}
