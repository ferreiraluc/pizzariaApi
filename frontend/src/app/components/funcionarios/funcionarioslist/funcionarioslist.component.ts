import { Component, inject } from '@angular/core';
import { Funcionario } from 'src/app/models/funcionario';
import { FuncionarioService } from 'src/app/services/funcionarios.services';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';



@Component({
  selector: 'app-funcionarioslist',
  templateUrl: './funcionarioslist.component.html',
  styleUrls: ['./funcionarioslist.component.scss']
})
export class FuncionarioslistComponent {
  
    lista: Funcionario[] = [];

    funcionarioSelecionadoParaEdicao: Funcionario = new Funcionario();
    indiceDoFuncionarioSelecionadoParaEdicao!: number;

    modalService = inject(NgbModal);
    funcionariosService = inject(FuncionarioService);

    constructor(){
      this.listAll();
    }

    listAll() {
      this.funcionariosService.listAll().subscribe({
        next: (lista: Funcionario[]) => { // QUANDO DÁ CERTO
          this.lista = lista; // Atualiza a variável lista com a lista de funcionários
        },
        error: (erro: any) => { // QUANDO DÁ ERRO
          alert('Exemplo de tratamento de erro/exception! Observe o erro no console!');
          console.error(erro);
        }
      });
    }
    

    adicionar(modal: any) {
      this.funcionarioSelecionadoParaEdicao = new Funcionario();
      this.modalService.open(modal, { size: 'lg' });
  
  }

  editar(modal: any, funcionario: Funcionario, indice: number) {
    this.funcionarioSelecionadoParaEdicao = Object.assign({}, funcionario);
    this.indiceDoFuncionarioSelecionadoParaEdicao = indice;
  
    this.modalService.open(modal, { size: 'sm' });
  }
  
  excluir(funcionario: Funcionario) {
    if (confirm('Deseja realmente excluir o funcionario ' + funcionario.nome + '?')) {
      this.funcionariosService.delete(funcionario.id).subscribe({
        next: () => {
          this.listAll();
        },
        error: erro => {
          alert('Erro ao excluir Funcionario! Observe o erro no console!');
          console.error(erro);
        }
      });
    } 
  } 
  
  addOuEditarProduto(funcionario: Funcionario) {
    this.listAll();
  
    this.modalService.dismissAll();
  }
}