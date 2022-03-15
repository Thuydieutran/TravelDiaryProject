import {Component, OnInit} from '@angular/core';
import {Destination} from "./models/destination";
import {DestinationService} from "./services/destination.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{

  constructor() {
  }

  ngOnInit(): void {}

}
