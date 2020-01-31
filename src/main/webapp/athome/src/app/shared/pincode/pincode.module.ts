import {NgModule} from '@angular/core';
import {PincodeComponent} from "./pincode.component";
import {PincodeService} from "./pincode.service";
import {CommonModule} from "@angular/common";


@NgModule({
 imports: [CommonModule],
 exports: [PincodeComponent],
 declarations: [PincodeComponent],
 providers: [PincodeService],
})
export class PincodeModule { }
