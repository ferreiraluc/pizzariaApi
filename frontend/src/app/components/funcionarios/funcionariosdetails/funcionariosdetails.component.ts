import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, EventEmitter, Input, Output, inject } from '@angular/core';
import { Funcionario } from 'src/app/models/funcionario';
import { FuncionarioService } from 'src/app/services/funcionarios.services';

@Component({
  selector: 'app-funcionariosdetails',
  templateUrl: './funcionariosdetails.component.html',
  styleUrls: ['./funcionariosdetails.component.scss']
})
export class FuncionariosdetailsComponent {

  @Input() funcionario: Funcionario = new Funcionario();
  @Output() retorno = new EventEmitter<Funcionario>();

  funcionarioService = inject(FuncionarioService);

  constructor(private http: HttpClient) { }

  getFuncionarios() {
    this.funcionarioService.listAll().subscribe((data: any) => {
      this.funcionario = data;
    });
  }

  addFuncionario() {
    const jsonData = JSON.stringify(this.funcionario);
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    this.http.post('http://localhost:8080/api/funcionario', jsonData, { headers: headers })
      .subscribe(
        response => {
          console.log('Dados enviados com sucesso:', response);
          window.location.reload();
        },
        error => {
          console.error('Erro ao enviar os dados para a API:', error);
        }
      );
  }
  
  deleteFuncionario(id: number) {
    this.funcionarioService.delete(id).subscribe(
      response => {
        console.log('Funcionário excluído com sucesso:', response);
        window.location.reload();
      },
      error => {
        console.error('Erro ao excluir o funcionário:', error);
      }
    );
  }

}
