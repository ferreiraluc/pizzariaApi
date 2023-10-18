import { Produto } from "./Produto";
import { Cliente } from "./cliente";
import { Funcionario } from "./funcionario";

export class Pedido{
    produtoid!: Produto[];
    clienteid!: Cliente[];
    funcionarioid!: Funcionario[];
    observacao!: string;
    status!: string;
    entrega!: boolean;   
}