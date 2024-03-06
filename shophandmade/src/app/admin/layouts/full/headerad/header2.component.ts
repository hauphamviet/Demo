import { Component } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ConfirmationComponent } from 'src/app/admin/material-component/dialog/confirmation/confirmation.component';

@Component({
  selector: 'app-header2',
  templateUrl: './header2.component.html',
  styleUrls: []
})
export class AppHeaderComponent2 {

  role:any;
  constructor(private router:Router,
    private dialog: MatDialog) {
  }

  logout() {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.data = {
      message: 'Logout',
      confirmation: true
    };
    const dialogRef = this.dialog.open(ConfirmationComponent, dialogConfig);
    const sub = dialogRef.componentInstance.onEmitStatusChange.subscribe((response)=> {
      dialogRef.close();
      localStorage.clear();
      this.router.navigate(['/']);
    })
  }

}
