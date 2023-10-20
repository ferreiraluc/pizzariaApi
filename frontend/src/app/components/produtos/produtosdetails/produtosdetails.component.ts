import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, EventEmitter, Input, Output, inject } from '@angular/core';
import { Produto } from 'src/app/models/produto';
import { ProdutosService } from 'src/app/services/produtos.services';

@Component({
  selector: 'app-produtosdetails',
  templateUrl: './produtosdetails.component.html',
  styleUrls: ['./produtosdetails.component.scss']
})
export class ProdutosdetailsComponent {

  @Input() produto: Produto = new Produto();
  @Output() retorno = new EventEmitter<Produto>();

  produtosService = inject(ProdutosService);

  constructor(private http: HttpClient) { }

  addProduto() {
    // Crie um objeto com os dados do formulário
    const jsonData = JSON.stringify(this.produto);

    // Defina os cabeçalhos para indicar que você está enviando JSON
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    // Faça a solicitação HTTP POST para a sua API
    this.http.post('http://localhost:8080/api/produto', jsonData, { headers: headers })
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


