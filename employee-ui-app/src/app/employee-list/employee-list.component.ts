import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit{

  @Input() employees: Employee[];

  constructor() {}

  ngOnInit(){
    console.log(this.employees);
  }

}
