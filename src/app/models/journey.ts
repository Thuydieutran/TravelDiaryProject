import {Destination} from "./destination";
import {JourneyResources} from "./journeySource";

export interface Journey {
  id: number;
  city: string;
  journeyDate: Date;
  summary: string;
  destination: Destination;
  journeyResources: JourneyResources[];
}
