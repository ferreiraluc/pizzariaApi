import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BalcaolistComponent } from './components/balcao/balcaolist/balcaolist.component';
import { BalcaodetailsComponent } from './components/balcao/balcaodetails/balcaodetails.component';
import { ClienteslistComponent } from './components/clientes/clienteslist/clienteslist.component';
import { ClientesdetailsComponent } from './components/clientes/clientesdetails/clientesdetails.component';
import { FuncionarioslistComponent } from './components/funcionarios/funcionarioslist/funcionarioslist.component';
import { FuncionariosdetailsComponent } from './components/funcionarios/funcionariosdetails/funcionariosdetails.component';
import { PedidoslistComponent } from './components/pedidos/pedidoslist/pedidoslist.component';
import { PedidosdetailsComponent } from './components/pedidos/pedidosdetails/pedidosdetails.component';
import { ProdutoslistComponent } from './components/produtos/produtoslist/produtoslist.component';
import { ProdutosdetailsComponent } from './components/produtos/produtosdetails/produtosdetails.component';
import { LoginComponent } from './components/sistema/login/login.component';
import { FooterComponent } from './components/layout/footer/footer.component';
import { HeaderComponent } from './components/layout/header/header.component';
import { IndexComponent } from './components/layout/index/index.component';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    BalcaolistComponent,
    BalcaodetailsComponent,
    ClienteslistComponent,
    ClientesdetailsComponent,
    FuncionarioslistComponent,
    FuncionariosdetailsComponent,
    PedidoslistComponent,
    PedidosdetailsComponent,
    ProdutoslistComponent,
    ProdutosdetailsComponent,
    LoginComponent,
    FooterComponent,
    HeaderComponent,
    IndexComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    NgbModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
