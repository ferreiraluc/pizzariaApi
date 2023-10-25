import { Injectable, inject } from "@angular/core";
import { HttpClient, HttpParams} from "@angular/common/http";
import { Observable } from "rxjs";
import { Pedido } from "../models/pedido";

@Injectable({
    providedIn: 'root'
})

export class PedidoService{
    API: string = 'http://localhost:8080/api/pedido';
    APIid: string = 'http://localhost:8080/api/pedido/{id}'
    http = inject(HttpClient);

    constructor(){}

    listAll(): Observable<Pedido[]>{
        return this.http.get<Pedido[]>(this.API);
    }

    save(pedido: Pedido): Observable<Pedido>{
        return this.http.post<Pedido>(this.API, Pedido);
    }

    byId(id: number): Observable<Pedido>{
        const url = `${this.API}/${id}`;
        return this.http.get<Pedido>(url);
    }

   
    delete(id: number): Observable<string>{
        const url = `${this.API}/${id}`;
        return this.http.delete(url, {responseType: 'text'});
    }

    update(id: number, pedido: Pedido): Observable<Pedido>{
        const url = `${this.API}/${id}`;
        return this.http.put<Pedido>(url, pedido);
    }
    
}


