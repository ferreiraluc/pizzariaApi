import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, EventEmitter, Input, Output, inject } from '@angular/core';
import { Pedido } from 'src/app/models/pedido';
import { PedidoService } from 'src/app/services/pedidos.services';

@Component({
  selector: 'app-pedidosdetails',
  templateUrl: './pedidosdetails.component.html',
  styleUrls: ['./pedidosdetails.component.scss']
}) 
export class PedidosdetailsComponent {

  @Input() pedido: Pedido = new Pedido();
  @Output() retorno = new EventEmitter<Pedido>();

  pedidoService = inject(PedidoService);

  constructor(private http: HttpClient) { }

  addPedido() {
     // Crie um objeto com os dados do formulário
     const jsonData = JSON.stringify(this.pedido);

     // Defina os cabeçalhos para indicar que você está enviando JSON
     const headers = new HttpHeaders({
       'Content-Type': 'application/json'
     });
 
     // Faça a solicitação HTTP POST para a sua API
     this.http.post('http://localhost:8080/api/pedido', jsonData, { headers: headers })
       .subscribe(
         response => {
           console.log('Dados enviados com sucesso:', response);
           // Faça o que for necessário com a resposta da API
         },
         error => {
           console.error('Erro ao enviar os dados para a API:', error);
         }
       );
  }
  

}
