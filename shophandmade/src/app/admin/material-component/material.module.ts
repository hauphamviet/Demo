import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { CdkTableModule } from '@angular/cdk/table';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FlexLayoutModule } from '@angular/flex-layout';

import { MaterialRoutes } from './material.routing';
import { MaterialModule } from '../shared/material-module';
import { ViewBillProductsComponent } from './dialog/view-bill-products/view-bill-products.component';
import { MatCardModule } from '@angular/material/card';
import { ManageCategoryComponent } from './manage-category/manage-category.component';
import { CategoryComponent } from './dialog/category/category.component';
import { ManageProductComponent } from './manage-product/manage-product.component';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { ProductComponent } from './dialog/product/product.component';
import { ConfirmationComponent } from './dialog/confirmation/confirmation.component';
import { ManageOrderComponent } from './manage-order/manage-order.component';
import { ManageUserComponent } from './manage-user/manage-user.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(MaterialRoutes),
    MaterialModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    FlexLayoutModule,
    CdkTableModule,
    MatCardModule,
    MatSlideToggleModule
  ],
  providers: [],
  declarations: [
    ViewBillProductsComponent,
    ManageCategoryComponent,
    CategoryComponent,
    ManageProductComponent,
    ProductComponent,
    ConfirmationComponent,
    ManageOrderComponent,
    ManageUserComponent
  ]
})
export class MaterialComponentsModule {}
