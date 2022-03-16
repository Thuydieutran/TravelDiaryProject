import {Component, Input, OnInit} from '@angular/core';
import {Journey} from "../models/journey";
import {Destination} from "../models/destination";
import {DestinationService} from "../services/destination.service";

@Component({
  selector: 'app-journeys',
  templateUrl: './journeys.component.html',
  styleUrls: ['./journeys.component.scss']
})
export class JourneysComponent implements OnInit {
  @Input() journeyList: Journey[] | undefined;

  constructor(private destinationService: DestinationService) { }

  // @ts-ignore
  ngOnInit(destinationId: Destination): void {
    this.getAllJourneysById(destinationId);
  }

  public getAllJourneysById(destinationId: Destination){
    let journeyList = this.destinationService.getDestinationById(destinationId);
  }

}
