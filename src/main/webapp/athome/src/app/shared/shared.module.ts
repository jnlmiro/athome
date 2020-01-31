import {NgModule} from '@angular/core';
import {TypeaheadModule} from "./typeahead/typeahead.module";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {NavigationModule} from "./navigation/navigation.module";
import {DirectivesModule} from "./directives/directives.module";


@NgModule({
  imports: [TypeaheadModule, DirectivesModule, NavigationModule, CommonModule, FormsModule],
  exports: [TypeaheadModule, DirectivesModule, NavigationModule, CommonModule, FormsModule],
  declarations: [],
  providers: [],
})
export class SharedModule {
}
