import { Injectable, inject } from "@angular/core";
import { HttpClient, HttpParams} from "@angular/common/http";
import { Observable } from "rxjs";
import { Produto } from '../models/produto';
import { Pedido } from "../models/pedido";

@Injectable({
    providedIn: 'root'
})

export class ProdutosService {
    API: string = 'http://localhost:8080/api/produto';
    http = inject(HttpClient);

    constructor(){}

    listAll(): Observable<Produto[]>{
        return this.http.get<Produto[]>(this.API);
    }

    save(produto: Produto): Observable<Produto>{
        return this.http.post<Produto>(this.API, Produto);
    }

    byId(id: number): Observable<Produto>{
        const url = `${this.API}/${id}`;
        return this.http.get<Produto>(url);
    }

    delete(id: number): Observable<Produto>{
        const url = `${this.API}/${id}`;
        return this.http.delete<Produto>(url);
    }

    update(id: number, produto: Produto): Observable<Produto>{
        const url = `${this.API}/${id}`;
        return this.http.put<Produto>(url, produto);
    }


}