import { Component, OnInit } from '@angular/core';
import { BrowserModule }    from '@angular/platform-browser';
import { HttpClient } from "@angular/common/http";

import {DataService} from 'src/app/grocery-service.service';


@Component({
  selector: 'app-grocery-list',
  templateUrl: './grocery-list.component.html',
  styleUrls: ['./grocery-list.component.css']
})


export class GroceryListComponent implements OnInit {
  constructor(private dataService: DataService) {}

  Grocerylist = [];


  ngOnInit(): void {}

}
