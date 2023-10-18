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

    delete(id: number): Observable<Funcionario>{
        const url = `${this.API}/${id}`;
        return this.http.delete<Funcionario>(url);
    }

    update(id: number, funcionario: Funcionario): Observable<Funcionario>{
        const url = `${this.API}/${id}`;
        return this.http.put<Funcionario>(url, funcionario);
    }

}

