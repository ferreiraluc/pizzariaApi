import { Injectable, inject} from "@angular/core";
import { HttpClient, Http} from "@angular/common/http";
import { Observable } from "rxjs";
import { Cliente } from "../models/cliente";

@Injectable({
    providedIn: 'root'
})

export class ClienteService{
    API: string = 'http://localhost:8080/api/cliente';
    http = inject(HttpClient);
}



