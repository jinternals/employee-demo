import { Component, OnInit } from '@angular/core';
import {NgbModal, ModalDismissReasons, NgbModalRef} from '@ng-bootstrap/ng-bootstrap';
import { FormBuilder, FormGroup ,Validators } from '@angular/forms';
import {EmployeeService} from "../services/employee.service";

@Component({
  selector: 'employee-register',
  templateUrl: './employee-register.component.html',
  styleUrls: ['./employee-register.component.css']
})
export class EmployeeRegisterComponent   {
  employeeForm: FormGroup;
  model: NgbModalRef;
  saving: boolean;

  constructor(private modalService: NgbModal,private fb: FormBuilder,private employeeService : EmployeeService) {

    this.employeeForm = fb.group({
      'firstName':['',Validators.compose([Validators.required])],
      'lastName': ['',Validators.compose([Validators.required])],
      'gender': ['',Validators.compose([Validators.required])],
      'department': ['',Validators.compose([Validators.required])],
      'dateOfBirth': ['',Validators.compose([Validators.required])],
    });
  }

  open(content) {
    this.model = this.modalService.open(content, {ariaLabelledBy: 'register-employee'});
  }

  onSubmit(employee: Employee): void {
    this.saving = true;
    this.employeeService.registerEmployee(employee).subscribe(value => {
      this.saving = false;
      this.employeeForm.reset();
      this.model.close();
      this.model = null;
    })
  }

}
