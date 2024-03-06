import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { ProductComponent } from './product/product.component';
import { DetailProductComponent } from './detail-product/detail-product.component';
import { OrderComponent } from './order/order.component';
import { OrderConfirmComponent } from './order-confirm/order-confirm.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule } from '@angular/material/card';
import { FlexLayoutModule } from '@angular/flex-layout';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatDialogModule } from '@angular/material/dialog';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { DashboardComponent } from './admin/dashboard/dashboard.component';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatMenuModule } from '@angular/material/menu';
import { SharedModule } from './admin/shared/shared.module';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';
import { FullComponent } from './admin/layouts/full/full.component';
import { AppSidebarComponent } from './admin/layouts/full/sidebar/sidebar.component';
import { AppHeaderComponent2 } from './admin/layouts/full/headerad/header2.component';
import { NgxUiLoaderConfig, NgxUiLoaderHttpModule, NgxUiLoaderModule, SPINNER } from 'ngx-ui-loader';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { BestSellerComponent } from './admin/best-seller/best-seller.component';
import { TokenInterceptorInterceptor } from './admin/services/token-interceptor.interceptor';
import { AppRoutingModule } from './app-routing.module';
import { MatListModule } from '@angular/material/list';

const ngxUiLoaderConfig: NgxUiLoaderConfig = {
  text: "Loading...",
  textColor: "#FFFFFF",
  textPosition: "center-center",
  bgsColor: "#7b1fa2",
  fgsColor: "#7b1fa2",
  fgsType: SPINNER.squareJellyBox,
  fgsSize: 100,
  hasProgressBar: false
}
@NgModule({
  declarations: [
    HomeComponent,
        HeaderComponent,
         FooterComponent,
         ProductComponent,
         DetailProductComponent,
         OrderComponent,
         OrderConfirmComponent,
         LoginComponent,
         RegisterComponent,
         FullComponent,
         AppSidebarComponent,
         AppHeaderComponent2,
         BestSellerComponent,
         DashboardComponent,
         
  ],
  imports: [
    MatSnackBarModule,
    MatDialogModule,
    BrowserModule,
    ReactiveFormsModule,
    FontAwesomeModule,
    BrowserAnimationsModule,
    FormsModule,
    FlexLayoutModule,
    HttpClientModule,
    MatCardModule,
    CommonModule,
    RouterModule,
    MatSidenavModule,
    MatMenuModule,
    SharedModule,
    MatIconModule,
    MatToolbarModule,
    HttpClientModule,
    NgxUiLoaderHttpModule.forRoot(ngxUiLoaderConfig),
    NgxUiLoaderModule,
    MatInputModule,
    MatFormFieldModule,
    AppRoutingModule,
    MatListModule  

  ],
  providers: [HttpClientModule, {provide: HTTP_INTERCEPTORS, useClass: TokenInterceptorInterceptor, multi: true}],
  bootstrap: [FullComponent]
    
})
export class AppModule { }
