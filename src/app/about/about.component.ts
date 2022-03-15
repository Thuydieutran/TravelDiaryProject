import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.scss']
})
export class AboutComponent implements OnInit {

  aboutMe = {
    firstname: "Thuy",
    lastname: "Dieu",
    birthDate: "01/01/2000",
    email: "thuy@gmail.com",
    city: "Orleans, France",
    profession: "Software developer",
    phone:"06.01.02.03.04",
    profile:"Hi, i'm a newcomer in the IT world, eager to learn new technologies and willing to share my knowledge and skills. Let's build useful projects together and make the world better. Pray for our world peace."
  }

  constructor() { }

  ngOnInit(): void {
  }

}
