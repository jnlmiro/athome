import {Component} from "@angular/core";
import {Location} from "@angular/common";

@Component({
  selector: 'navigation',
  templateUrl: 'navigation.component.html',
  styleUrls: ['navigation.component.scss'],
})
export class NavigationComponent{

  constructor(private location: Location) {

  }


  back() {
    this.location.back()
  }

  forward() {
    this.location.forward();
  }
}
