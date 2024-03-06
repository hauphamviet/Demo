// home.component.ts
import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { RegisterComponent } from '../register/register.component';
import { LoginComponent } from '../login/login.component';
import { UserService } from '../admin/services/user.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit{

  constructor(private router: Router) { }

  ngOnInit(): void { }
    
  redirectToProduct() {
    // Chuyển hướng đến trang sản phẩm (đặt URL của trang sản phẩm ở đây)
    this.router.navigate(['/product']);
  }
  showAlert() {
    alert('Chuyển trang'); // Hiển thị hộp thoại thông báo khi được gọi
  }

 
}
