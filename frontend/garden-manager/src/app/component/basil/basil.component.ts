import { Component, OnInit } from '@angular/core';
import {BasilService} from "../../service/basil.service";

@Component({
  selector: 'app-basil',
  templateUrl: './basil.component.html',
  styleUrls: ['./basil.component.scss']
})
export class BasilComponent implements OnInit {

  constructor(basilService: BasilService) { }

  ngOnInit(): void {
  }


}
