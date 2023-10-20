import { Injectable, inject } from "@angular/core";
import { HttpClient, HttpParams } from "@angular/common/http";
import { Observable } from "rxjs";
import { Funcionario } from "../models/funcionario";

@Injectable({
    providedIn: 'root'
})

export class FuncionarioService{
    API: string = 'http://localhost:8080/api/funcionario';
    http = inject(HttpClient);
   
    constructor(){}

    listAll(): Observable<Funcionario[]>{
        return this.http.get<Funcionario[]>(this.API);
    }

    save(funcionario: Funcionario): Observable<Funcionario>{
        return this.http.post<Funcionario>(this.API, Funcionario);
    }

    byId(id: number): Observable<Funcionario>{
        const url = `${this.API}/${id}`;
        return this.http.get<Funcionario>(url);
    }
//  explicar para o lucas que neste caso o erro estava acontecendo pq o observable estava sendo direcinado para o FUNCIONARIO como um lista Json sendo que na API o delete é simplesmente retornado
//uma mensagem de texto simples oq na hora da comparação ppedia um retorno Json no Front e o Back retornava um text como response
//após explicar mudar em todas as services para funcionamento do codigo
//também tera de alterar no funcionariodetails.component.ts adicionando o metodo de excluir

    delete(id: number): Observable<string> {
        const url = `${this.API}/${id}`;
        return this.http.delete(url, { responseType: 'text' });
      }
      

    update(id: number, funcionario: Funcionario): Observable<Funcionario>{
        const url = `${this.API}/${id}`;
        return this.http.put<Funcionario>(url, funcionario);
    }

}

