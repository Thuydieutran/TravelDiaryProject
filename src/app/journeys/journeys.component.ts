import { Component, OnInit } from '@angular/core';
import {Journey} from "../models/journey";

@Component({
  selector: 'app-journeys',
  templateUrl: './journeys.component.html',
  styleUrls: ['./journeys.component.scss']
})
export class JourneysComponent implements OnInit {

  journeyList: Journey[] | undefined;

  constructor() { }

  ngOnInit(): void {
  }



}
