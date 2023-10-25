import { Produto } from "./produto";
import { Cliente } from "./cliente";
import { Funcionario } from "./funcionario";

export class Pedido{
    id!: number;
    nomepizza!: string;
    produtoid!: Produto[];
    clienteid!: Cliente[];
    funcionarioid!: Funcionario[];
    observacao!: string;
    status!: string;
    entrega!: boolean;   

    getNomeDoCliente(cliente: Cliente): string {
        return cliente.nome;
    }
}