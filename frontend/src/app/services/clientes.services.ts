import { Injectable, inject} from "@angular/core";
import { HttpClient, HttpParams} from "@angular/common/http";
import { Observable } from "rxjs";
import { Cliente } from "../models/cliente";

@Injectable({
    providedIn: 'root'
})


export class ClienteService{
    API: string = 'http://localhost:8080/api/cliente';
    http = inject(HttpClient);


constructor(){}

    listAll(): Observable<Cliente[]>{
        return this.http.get<Cliente[]>(this.API);
    }

    save(cliente: Cliente): Observable<Cliente>{
        return this.http.post<Cliente>(this.API, Cliente);
    }

    byId(id: number): Observable<Cliente>{
        const url = `${this.API}/${id}`;
        return this.http.get<Cliente>(url);
    }

    delete(id: number): Observable<Cliente>{
        const url = `${this.API}/${id}`;
        return this.http.delete<Cliente>(url);
    }

    update(id: number, cliente: Cliente): Observable<Cliente>{
        const url = `${this.API}/${id}`;
        return this.http.put<Cliente>(url, cliente);
    }

}
