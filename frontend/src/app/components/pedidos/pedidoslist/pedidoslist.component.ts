import { Component, inject } from '@angular/core';
import { Pedido } from 'src/app/models/pedido';
import { PedidoService } from 'src/app/services/pedidos.services';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-pedidoslist',
  templateUrl: './pedidoslist.component.html',
  styleUrls: ['./pedidoslist.component.scss']
})
export class PedidoslistComponent {


  lista: Pedido[] = [];

  pedidoSelecionadoParaEdicao: Pedido = new Pedido();
  indiceDoPedidoSelecionadoParaEdicao!: number;

  modalService = inject(NgbModal);
  pedidoService = inject(PedidoService);
  constructor() {
    this.listAll();
   }

   listAll() {
      
    this.pedidoService.listAll().subscribe({
      next: (lista: Pedido[]) => { // QUANDO DÁ CERTO
        this.lista = lista;
      },
      error: (erro: any) => { // QUANDO DÁ ERRO
        alert('Exemplo de tratamento de erro/exception! Observe o erro no console!');
        console.error(erro);
      }
    });

  }

  adicionar(modal: any) {
    this.pedidoSelecionadoParaEdicao = new Pedido();
    this.modalService.open(modal, { size: 'lg' });

  }

  editar(modal: any, pedido: Pedido, indice: number) {
    this.pedidoSelecionadoParaEdicao = Object.assign({}, pedido);
    this.indiceDoPedidoSelecionadoParaEdicao = indice;

    this.modalService.open(modal, { size: 'sm' });
    
  }

  excluir(pedido: Pedido) {
    if (confirm('Deseja realmente excluir o pedido ' + pedido.id + '?')) {
      this.pedidoService.delete(pedido.id).subscribe({
        next: () => {
          this.listAll();
        },
        error: erro => {
          alert('Erro ao excluir Pedido! Observe o erro no console!');
          console.error(erro);
        }
      });
    }
  }

  addOuEditarPedido(pedido: Pedido) {
    this.listAll();

    this.modalService.dismissAll();
  }



}