import {Journey} from "./journey";

export interface Destination {
  id: number;
  destinationName: string;
  destinationStart: Date;
  destinationEnd: Date;
  country: string;
  journeyList: Journey[];
}
