import {Component, OnInit} from '@angular/core';
import {WorkationTableComponent} from './workation-table/workation-table.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  imports: [
    WorkationTableComponent
  ],
  styleUrl: './app.component.css'
})
export class AppComponent {}

