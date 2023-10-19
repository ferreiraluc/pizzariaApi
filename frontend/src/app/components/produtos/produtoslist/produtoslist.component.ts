import { Component, inject } from '@angular/core';
import { Produto } from 'src/app/models/produto';
import { ProdutosService } from 'src/app/services/produtos.services';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';



@Component({
  selector: 'app-produtoslist',
  templateUrl: './produtoslist.component.html',
  styleUrls: ['./produtoslist.component.scss']
})
export class ProdutoslistComponent {

  lista: Produto[] = [];

  produtoSelecionadoParaEdicao: Produto = new Produto();
  indiceDoProdutoSelecionadoParaEdicao!: number;

  modalService = inject(NgbModal);
  produtoService = inject(ProdutosService);
  constructor() {
    this.listAll();
   }

   listAll() {
      
    this.produtoService.listAll().subscribe({
      next: lista => { // QUANDO DÁ CERTO
        this.lista = lista;
      },
      error: erro => { // QUANDO DÁ ERRO
        alert('Exemplo de tratamento de erro/exception! Observe o erro no console!');
        console.error(erro);
      }
    });

  }

  adicionar(modal: any) {
    this.produtoSelecionadoParaEdicao = new Produto();
    this.modalService.open(modal, { size: 'lg' });

}

editar(modal: any, produto: Produto, indice: number) {
  this.produtoSelecionadoParaEdicao = Object.assign({}, produto);
  this.indiceDoProdutoSelecionadoParaEdicao = indice;

  this.modalService.open(modal, { size: 'sm' });
}

excluir(produto: Produto) {
  if (confirm('Deseja realmente excluir o carro ' + produto.produtoitem + '?')) {
    this.produtoService.delete(produto.id).subscribe({
      next: () => {
        this.listAll();
      },
      error: erro => {
        alert('Erro ao excluir livro! Observe o erro no console!');
        console.error(erro);
      }
    });
  } 
} 

addOuEditarProduto(produto: Produto) {
  this.listAll();

  this.modalService.dismissAll();
}




        
}
