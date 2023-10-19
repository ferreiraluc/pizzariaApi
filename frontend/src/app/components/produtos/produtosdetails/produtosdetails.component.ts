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

  constructor() { }

  addProduto() {
    this.produtosService.save(this.produto).subscribe({
      next: produto => {
        this.retorno.emit(produto);
        alert('Produto adicionado com sucesso!');
      },
      error: erro => {
        alert('Erro ao adicionar produto! Observe o erro no console!');
        console.error(erro);
      }
    });
  }


}


