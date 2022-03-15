import {Journey} from "./journey";
import {ResourceCategory} from "./ResourceCategory";

export interface JourneyResources {
  id: number;
  category: ResourceCategory;
  resourceUrl: string;
  journey: Journey;
}
