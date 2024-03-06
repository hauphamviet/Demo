import { Component, EventEmitter, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { CategoryService } from 'src/app/admin/services/category.service';
import { ProductService } from 'src/app/admin/services/product.service';
import { SnackbarService } from 'src/app/admin/services/snackbar.service';
import { GlobalConstants } from 'src/app/admin/shared/global-constants';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit{

  onAddProduct = new EventEmitter();
  onEditProduct = new EventEmitter();
  productForm:any = FormGroup;
  dialogAction:any = "Add";
  action:any = "Add";
  responseMessage:any;
  categorys:any = [];

  constructor(@Inject(MAT_DIALOG_DATA) public dialogData:any,
  private formBuilder: FormBuilder,
  private productService: ProductService,
  public dialogRef: MatDialogRef<ProductComponent>,
  private categoryService: CategoryService,
  private snackbarService: SnackbarService) {}

  ngOnInit(): void {
      this.productForm = this.formBuilder.group({
        ten: [null, [Validators.required]],
        dmspId: [null, [Validators.required]],
        gia: [null, [Validators.required]],
        moTa: [null, Validators.required]
      });
      
      if(this.dialogData.action === "Edit") {
        this.dialogAction = "Edit";
        this.action = "Update";
        this.productForm.patchValue(this.dialogData.data);
      }
      this.getCategorys();
  }
  
  getCategorys() {
    this.categoryService.getDMSP().subscribe((response:any)=> {
      this.categorys = response;
    }, (error:any)=> {
      console.log(error);
      if(error.error?.message) {
        this.responseMessage = error.error?.message;
      } else {
        this.responseMessage = GlobalConstants.genericError;
      }
      this.snackbarService.openSnackBar(this.responseMessage, GlobalConstants.error);
    })
  }

  handleSubmit() {
    if(this.dialogAction === "Edit") {
      this.edit();
    }
    else {
      this.add();
    }
  }

  add() {
    var formData = this.productForm.value;
    var data = {
      ten: formData.ten,
      dmspId: formData.dmspId,
      gia:formData.gia,
      moTa:formData.moTa
    }

    this.productService.add(data).subscribe((response:any)=> {
      this.dialogRef.close();
      this.onAddProduct.emit();
      this.responseMessage = response.message;
      this.snackbarService.openSnackBar(this.responseMessage, "success");
    }, (error:any)=> {
      console.log(error);
      if(error.error?.message) {
        this.responseMessage = error.error?.message;
      } else {
        this.responseMessage = GlobalConstants.genericError;
      }
      this.snackbarService.openSnackBar(this.responseMessage, GlobalConstants.error);
    })
  }

  edit() {
    var formData = this.productForm.value;
    var data = {
      // id: this.dialogData.data.id,
      ten: formData.ten,
      dmspId: formData.dmspId,
      gia:formData.gia,
      moTa:formData.moTa
    }

    this.productService.update(this.dialogData.data.id, data).subscribe((response:any)=> {
      this.dialogRef.close();
      this.onAddProduct.emit();
      this.responseMessage = response.message;
      this.snackbarService.openSnackBar(this.responseMessage, "success");
    }, (error:any)=> {
      console.log(error);
      if(error.error?.message) {
        this.responseMessage = error.error?.message;
      } else {
        this.responseMessage = GlobalConstants.genericError;
      }
      this.snackbarService.openSnackBar(this.responseMessage, GlobalConstants.error);
    })
  }

}
