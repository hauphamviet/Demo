import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../admin/services/user.service';
import { SnackbarService } from '../admin/services/snackbar.service';
import { MatDialogRef } from '@angular/material/dialog';
import { NgxUiLoaderService } from 'ngx-ui-loader';
import { GlobalConstants } from '../admin/shared/global-constants';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit{

  matKhau = true;
  confirmPassword = true;
  signupForm:any = FormGroup;
  responseMessage:any;

  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private userService: UserService,
    private snackbarService: SnackbarService,
    public dialogRef: MatDialogRef<RegisterComponent>,
    private ngxService: NgxUiLoaderService
    ) {}

  ngOnInit(): void {
    this.signupForm = this.formBuilder.group({
      hoTen:[null, [Validators.required, Validators.pattern(GlobalConstants.nameRegex)]],
      email:[null, [Validators.required, Validators.pattern(GlobalConstants.emailRegex)]],
      SDT: [null, [Validators.required, Validators.pattern(GlobalConstants.sdtRegex)]],
      diaChi:[null, [Validators.required]],
      matKhau:[null, [Validators.required]],
      confirmPassword:[null, [Validators.required]]
    })
   }

   validateSubmit() {
    if (this.signupForm.controls['matKhau'].value != this.signupForm.controls['confirmPassword'].value) {
      return true;
    }
    else {
      return false;
    }
   }

   handleSubmit() {
    this.ngxService.start();
    var formData = this.signupForm.value;
    var data = {
      hoTen: formData.hoTen,
      email: formData.email,
      diaChi: formData.diaChi,
      matKhau: formData.matKhau,
      SDT: formData.SDT
    }

    this.userService.signup(data).subscribe((response: any)=> {
      this.ngxService.stop();
      this.dialogRef.close();
      this.responseMessage = response?.message;
      this.snackbarService.openSnackBar(this.responseMessage, "");
      this.router.navigate(['/']);
    }, (error)=>{
      this.ngxService.stop();
      if (error.error?.message) {
        this.responseMessage = error.error?.message;
      }
      else {
        this.responseMessage = GlobalConstants.genericError;
      }
      this.snackbarService.openSnackBar(this.responseMessage, GlobalConstants.error);
    })

   }

}
