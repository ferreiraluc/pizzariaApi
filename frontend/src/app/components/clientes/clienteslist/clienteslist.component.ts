import { Component, inject } from '@angular/core';
import { Cliente } from 'src/app/models/cliente';
import { ClienteService } from 'src/app/services/clientes.services';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-clienteslist',
  templateUrl: './clienteslist.component.html',
  styleUrls: ['./clienteslist.component.scss']
})
export class ClienteslistComponent {
  
    lista: Cliente[] = [];

    clienteSelecionadoParaEdicao: Cliente = new Cliente();
    indiceDoFuncionarioSelecionadoParaEdicao!: number;

    modalService = inject(NgbModal);
    clientesService = inject(ClienteService);

    constructor(){
      this.listAll();
    }

    listAll() {
      this.clientesService.listAll().subscribe({
        next: (lista: Cliente[]) => { // QUANDO DÁ CERTO
          this.lista = lista; // Atualiza a variável lista com a lista de funcionários
        },
        error: (erro: any) => { // QUANDO DÁ ERRO
          alert('Exemplo de tratamento de erro/exception! Observe o erro no console!');
          console.error(erro);
        }
      });
    }

    adicionar(modal: any){
      this.clienteSelecionadoParaEdicao = new Cliente();
      this.modalService.open(modal, { size: 'lg' });
    }

    editar(modal: any, cliente: Cliente, indice: number){
      this.clienteSelecionadoParaEdicao = Object.assign({}, cliente);
      this.indiceDoFuncionarioSelecionadoParaEdicao = indice;

      this.modalService.open(modal, {size: 'sm'});
    }

    excluir(cliente: Cliente){
      if(confirm('Deseja realmente excluir o cliente ' + cliente.nome + '?')){
        this.clientesService.delete(cliente.id).subscribe({
          next: () => {
            this.listAll();
          },
          error: erro => {
            alert('Erro ao exlcluir Cliente! Observe o Console');
            console.error(erro);
          }
        });
      }
    }

    addOuEditarCliente(cliente: Cliente){
      this.listAll();
      this.modalService.dismissAll();
    }
}
