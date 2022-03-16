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
import { BannerComponent } from './banner/banner.component';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';

const appRoutes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'about', component: AboutComponent},
  { path: 'destinations', component: DestinationsComponent,
    children: [
      {
        path: 'journeys', // child route path
        component: JourneysComponent // child route component that the router renders
      },
      {
        path: 'create',
        component: AddDestinationComponent,
      },
      {
        path: 'edit',
        component: EditDestinationComponent,
      },
    ],
  },
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
        BannerComponent,
        HomeComponent,
        FooterComponent,
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
