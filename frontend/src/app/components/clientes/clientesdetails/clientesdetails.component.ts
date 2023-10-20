import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, EventEmitter, Input, Output, inject } from '@angular/core';
import { Cliente } from 'src/app/models/cliente';
import { ClienteService } from 'src/app/services/clientes.services';

@Component({
  selector: 'app-clientesdetails',
  templateUrl: './clientesdetails.component.html',
  styleUrls: ['./clientesdetails.component.scss']
})
export class ClientesdetailsComponent {

  @Input() cliente: Cliente = new Cliente();
  @Output() retorno = new EventEmitter<Cliente>();

  clienteService = inject(ClienteService);

  constructor(private http: HttpClient){}

  getClientes(){
    this.clienteService.listAll().subscribe((data: any) => {
      this.cliente = data;
    });
  }

  addCliente(){
    const jsonData = JSON.stringify(this.cliente);
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
  
    this.http.post('http://localhost:8080/api/cliente', jsonData, { headers: headers})
    .subscribe(
      response => {
        console.log('Dados cadastrado com sucesso:', response);
        window.location.reload();
      },
      error => {
        console.error('Erro ao enviar os dados para a API:', error);
      }
    );
  }

  deleteCliente(id: number){
    this.clienteService.delete(id).subscribe(
      response => {
        console.log('Cliente excluído com sucesso', response);
        window.location.reload();
      },
      error => {
        console.error('Erro ao excluir o cliente:', error);
  });
  }
}
