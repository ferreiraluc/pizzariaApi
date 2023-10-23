import { Tamanho } from "./tamanho"

export class Produto{
    id!: number;
    sabor!: string;
    produto_item!: string;
    produto_preco!: number;
    tamanho!: Tamanho[];
    
}