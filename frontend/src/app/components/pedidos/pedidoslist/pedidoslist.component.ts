import { Component, inject, OnInit } from '@angular/core';
import { Pedido } from 'src/app/models/pedido';
import { PedidoService } from 'src/app/services/pedidos.services';
import { Produto } from 'src/app/models/produto';
import { ProdutosService } from 'src/app/services/produtos.services';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ClienteService } from 'src/app/services/clientes.services';
import { Cliente } from 'src/app/models/cliente';

@Component({
  selector: 'app-pedidoslist',
  templateUrl: './pedidoslist.component.html',
  styleUrls: ['./pedidoslist.component.scss']
})
export class PedidoslistComponent implements OnInit {

  produtos: Produto[] = [];
  clientes: { [key: number]: Cliente } = {};


  lista: Pedido[] = [];
  pedidoSelecionadoParaEdicao: Pedido = new Pedido();
  indiceDoPedidoSelecionadoParaEdicao!: number;

  modalService = inject(NgbModal);
  pedidoService = inject(PedidoService);

  constructor(
    private produtosService: ProdutosService,
    private clienteService: ClienteService
  ) {
    this.listAll();
  }

  ngOnInit() {
    this.produtosService.listAll().subscribe((lista: Produto[]) => {
      this.produtos = lista;
    });

    this.clienteService.listAll().subscribe((clientes: Cliente[]) => {
      clientes.forEach((cliente: Cliente) => {
        this.clientes[cliente.id] = cliente;
      });
    });
  }

  listAll() {
    this.pedidoService.listAll().subscribe({
      next: (lista: Pedido[]) => {
        this.lista = lista;
      },
      error: (erro: any) => {
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
