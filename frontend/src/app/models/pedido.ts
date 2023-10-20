import { Produto } from "./produto";
import { Cliente } from "./cliente";
import { Funcionario } from "./funcionario";

export class Pedido{
    id!: number;
    produtoid!: Produto[];
    clienteid!: Cliente[];
    funcionarioid!: Funcionario[];
    observacao!: string;
    status!: string;
    entrega!: boolean;   
}