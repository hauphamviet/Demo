import { RouterModule, Routes } from "@angular/router";
import { NgModule } from "@angular/core";
import { HomeComponent } from "./home/home.component";
import { RouteGuardService } from "./admin/services/route-guard.service";
import { FullComponent } from "./admin/layouts/full/full.component";

const routes: Routes = [
    {path: '', component: HomeComponent},
    {
    path: 'cafe',
    // component: FullComponent,
    children: [
        {
            path: '',
            redirectTo: '/cafe/dashboard',
            pathMatch: 'full'
        },
        {
            path: '',
            loadChildren: 
                () => import('./admin/material-component/material.module').then(m => m.MaterialComponentsModule),
                canActivate:[RouteGuardService],
                data: {
                    expectedRole:['admin', 'user']
                }
        },      
        {
            path: 'dashboard',
            loadChildren: () => import('./admin/dashboard/dashboard.module').then(m => m.DashboardModule),
            canActivate:[RouteGuardService],
                data: {
                    expectedRole:['admin', 'user']
                }
        },
    ]}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule {}