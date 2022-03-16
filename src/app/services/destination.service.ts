import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Destination} from "../models/destination";
import {environment} from "../../environments/environment";
import {Journey} from "../models/journey";

@Injectable({
  providedIn: 'root'
})
export class DestinationService {

  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  public getDestinations(): Observable<Destination[]> {
    return this.http.get<Destination[]>(`${this.apiUrl}/destinations/all`);
  }

  public getDestinationById(destinationId: Destination): Observable<Journey[]> {
    return this.http.get<Journey[]>(`${this.apiUrl}/destinations/${destinationId}/journeys`);
  }

  public addDestination(destination: Destination): Observable<Destination> {
    return this.http.post<Destination>(`${this.apiUrl}/destinations/create`, destination);
  }

  public updateDestination(destination: Destination): Observable<Destination> {
    return this.http.put<Destination>(`${this.apiUrl}/destinations/update`, destination);
  }

  public deleteDestination(destinationId: number): Observable<void> {
   return this.http.delete<void>(`${this.apiUrl}/destinations/delete/${destinationId}`);
  }
}
