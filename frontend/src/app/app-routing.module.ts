import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/sistema/login/login.component';
import { IndexComponent } from './components/layout/index/index.component';
import { BalcaolistComponent } from './components/balcao/balcaolist/balcaolist.component';

const routes: Routes = [
  { path: "", redirectTo: "login", pathMatch: 'full' },
  { path: "login", component: LoginComponent },
  {
    path: "admin", component: IndexComponent, children: [
      { path: "balcaolist", component: BalcaolistComponent }
      
    ]
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
