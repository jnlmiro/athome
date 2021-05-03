import {Component, OnInit} from '@angular/core';
import {PincodeService} from "./pincode.service";

@Component({
  selector: 'pincode',
  templateUrl: 'pincode.component.html',
  styleUrls: ['pincode.component.scss']
})
export class PincodeComponent implements OnInit {

  enteredDigits:number[] = [];

  constructor(private pincodeService: PincodeService) {
    this.enteredDigits = this.pincodeService.enteredDigits;
  }

  ngOnInit() {
  }

  getDigits():number[][] {
    return this.pincodeService.getDigitGroups();
  }

  enterDigit(digit:number) {
    this.pincodeService.enterDigit(digit);
  }

  removeDigit() {
    this.pincodeService.removeDigit();
  }

  confirm() {
    this.enteredDigits = this.pincodeService.confirm();
  }
}
