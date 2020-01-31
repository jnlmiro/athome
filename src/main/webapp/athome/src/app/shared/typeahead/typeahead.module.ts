import {NgModule} from '@angular/core';

import {TypeaheadComponent} from './typeahead.component';
import {FormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";

@NgModule({
  imports: [CommonModule, FormsModule],
  exports: [TypeaheadComponent],
  declarations: [TypeaheadComponent],
  providers: [],
})
export class TypeaheadModule {
}
