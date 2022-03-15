import { Component, OnInit } from '@angular/core';
import {Destination} from "../models/destination";
import {DestinationService} from "../services/destination.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-destinations',
  templateUrl: './destinations.component.html',
  styleUrls: ['./destinations.component.scss']
})
export class DestinationsComponent implements OnInit {

  panelOpenState = false;
  destinations: Destination[] | undefined;

  // inject service into the component controller
  constructor(private destinationService: DestinationService) {
  }

  // in order that the function getAllDestinations() is called whenever this component is loaded or initialized
  // then we have to implement interface OnInIt and override a function called ngOnInIt()
  ngOnInit(): void {
    this.getAllDestinations();
  }


  // Since this method is unobservable so it's gonna make a request over the network and that will take some times, thats why it return unobseravle
  // So we need to "subscribe" to this observable, so after we call the function, we have to call "subscribe"
  // so we can be notified whenever some datas come back from the server either that could be the actual destinations that we requested or some kind of errors
  public getAllDestinations():void {
    this.destinationService.getDestinations().subscribe(
      (response: Destination[]) => {
        this.destinations = response;
      },
      (error : HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

}
