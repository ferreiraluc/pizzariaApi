# API de Pizzaria 🍕

Este projeto fornece uma API RESTful para gerenciar pedidos, produtos e funcionários de uma pizzaria.

## Índice

- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Configuração e Instalação](#configuração-e-instalação)
- [Endpoints da API](#endpoints-da-api)
- [Contribuição](#contribuição)
- [Licença](#licença)

## Funcionalidades

- CRUD completo para pedidos, produtos e funcionários.
- Filtro de pedidos por status.
- Registro e atualização de informações do cliente.
  
## Tecnologias Utilizadas

- Java
- Spring Boot
- JPA/Hibernate
- Lombok
- PostgreSQL

## Configuração e Instalação

1. **Clone o Repositório**

   ```bash
   git clone https://github.com/ferreiraluc/pizzariaApi
   cd pizzariaApi
   ```

2. **Configurar Banco de Dados**

   Certifique-se de ter o PostgreSQL instalado e crie um banco de dados chamado `pizzaria`. Atualize o arquivo `application.properties` com suas credenciais do banco de dados.

3. **Construir e Rodar a Aplicação**

   ```bash
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```

   A API estará rodando em `http://localhost:8080`.

## Endpoints da API

- **Pedidos**:
  - `GET /api/pedido`: Retorna todos os pedidos.
  - `GET /api/pedido/{id}`: Retorna os detalhes de um pedido específico.
  - `POST /api/pedido`: Cria um novo pedido.
  - `PUT /api/pedido/{id}`: Atualiza um pedido existente.
  - `DELETE /api/pedido/{id}`: Deleta um pedido.

- **Funcionários**:
  - ## Falta

- **Produtos**:
  - ## Falta

## Contribuição

1. Faça o Fork do projeto.
2. Crie sua Feature Branch: `git checkout -b feature/NovaFuncionalidade`.
3. Faça o commit de suas mudanças: `git commit -m 'Adiciona alguma NovaFuncionalidade'`.
4. Faça o Push da branch: `git push origin feature/NovaFuncionalidade`.
5. Abra um Pull Request.

## Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo `LICENSE.md` para mais detalhes.

