import {Injectable} from '@angular/core';
import * as _ from 'lodash';

@Injectable()
export class PincodeService {
  private MAX_NUMBER_OF_DIGITS: number = 4;
  enteredDigits: number[] = [];

  constructor() {
  }


  getDigits(): number[] {
    return Array.from(Array(9).keys()).map(digit => digit + 1);
  }

  getDigitGroups(): number[][] {
    return _.chunk(this.getDigits(), 3);
  }

  enterDigit(digit: number): void {
    if (this.enteredDigits.length >= this.MAX_NUMBER_OF_DIGITS) {
      this.enteredDigits.shift();
    }
    this.enteredDigits.splice(this.enteredDigits.length, 0, digit);
  }

  removeDigit(): void {
    if (this.enteredDigits.length > 0) {
      this.enteredDigits.pop();
    }
  }

  confirm() {
    this.enteredDigits = [];
    return this.enteredDigits;
  }
}

