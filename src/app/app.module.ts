import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { HttpClientModule} from "@angular/common/http";
import {RouterModule, Routes} from "@angular/router";
import { DestinationsComponent } from './destinations/destinations.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSliderModule} from "@angular/material/slider";
import {MatExpansionModule} from "@angular/material/expansion";
import { AboutComponent } from './about/about.component';
import {MatGridListModule} from "@angular/material/grid-list";
import {MatCardModule} from "@angular/material/card";
import { JourneysComponent } from './journeys/journeys.component';
import {MatButtonModule} from "@angular/material/button";
import {DestinationService} from "./services/destination.service";
import { NavbarComponent } from './navbar/navbar.component';
import { AddDestinationComponent } from './destinations/add-destination/add-destination.component';
import { EditDestinationComponent } from './destinations/edit-destination/edit-destination.component';

const appRoutes: Routes = [
  { path: 'about', component: AboutComponent},
  { path: 'destinations', component: DestinationsComponent},
  { path: 'journeys', component: JourneysComponent},
];

@NgModule({
    declarations: [
        AppComponent,
        DestinationsComponent,
        AboutComponent,
        JourneysComponent,
        NavbarComponent,
        AddDestinationComponent,
        EditDestinationComponent,
    ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    BrowserAnimationsModule,
    MatSliderModule,
    MatExpansionModule,
    MatGridListModule,
    MatCardModule,
    MatButtonModule,
  ],
    providers: [],
    exports: [
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
