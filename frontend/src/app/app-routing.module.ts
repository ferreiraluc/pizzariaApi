import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/sistema/login/login.component';
import { IndexComponent } from './components/layout/index/index.component';
import { BalcaolistComponent } from './components/balcao/balcaolist/balcaolist.component';
import { ProdutoslistComponent } from './components/produtos/produtoslist/produtoslist.component';
import { PedidoslistComponent } from './components/pedidos/pedidoslist/pedidoslist.component';
import { FuncionarioslistComponent } from './components/funcionarios/funcionarioslist/funcionarioslist.component';
import { ClienteslistComponent } from './components/clientes/clienteslist/clienteslist.component';



const routes: Routes = [
  { path: "", redirectTo: "login", pathMatch: 'full' },
  { path: "login", component: LoginComponent },
  {
    path: "admin", component: IndexComponent, children: [
      { path: "balcaolist", component: BalcaolistComponent },
      { path: "produtoslist", component: ProdutoslistComponent },
      { path: "pedidoslist", component: PedidoslistComponent },
      { path: "funcionarioslist", component: FuncionarioslistComponent },
      { path: "clienteslist", component: ClienteslistComponent }
      
    ]
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
