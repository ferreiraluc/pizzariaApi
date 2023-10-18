import { Tamanho } from "./tamanho"

export class Produto{
    id!: number;
    sabor!: string;
    produtoitem!: string;
    produtopreco!: number;
    tamanho!: Tamanho[];
    
}