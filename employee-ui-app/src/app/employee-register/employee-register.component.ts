import { Component, OnInit } from '@angular/core';
import {NgbModal, ModalDismissReasons, NgbModalRef} from '@ng-bootstrap/ng-bootstrap';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
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
      'dateOfBirth': ['',Validators.compose([Validators.required,Validators.pattern('^((0[1-9]|[12]\\d|3[01])\\/(0[1-9]|1[0-2])\\/[12]\\d{3})$')
      ])],
    });

  }

  get firstName() { return this.employeeForm.get('firstName'); }
  get lastName() { return this.employeeForm.get('lastName'); }
  get gender() { return this.employeeForm.get('gender'); }
  get department() { return this.employeeForm.get('department'); }
  get dateOfBirth() { return this.employeeForm.get('dateOfBirth'); }

  open(content) {
    this.model = this.modalService.open(content, {ariaLabelledBy: 'register-employee'});
  }

  onCancel(): void {
    this.resetForm();
  }

  onSubmit(employee: Employee): void {
    this.saving = true;
    this.employeeService.registerEmployee(employee).subscribe(value => {
      this.resetForm();
      this.employeeService.refereshEventEmitter().emit(value);

    })
  }

  resetForm():void{
    this.saving = false;
    this.employeeForm.reset();
    this.model.close();
    this.model = null;
  }

}
