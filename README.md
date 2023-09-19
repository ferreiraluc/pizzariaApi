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
  - ```bash
    {
    "pedido_ID": 123,
    "produto_ID": 456,
    "cliente_ID": 789,
    "observacao": "Alguma observação aqui",
    "funcionario_ID": 101,
    "status": "Pendente",
    "entrega": true
    }
    ```
  - `PUT /api/pedido/{id}`: Atualiza um pedido existente.
  - `DELETE /api/pedido/{id}`: Deleta um pedido.

- **Funcionários**:
  - `GET /api/funcionario`: Retorna todos os funcionários.
  - `GET /api/funcionario/{id}`: Retorna os detalhes de um funcionário específico.
  - `POST /api/funcionario`: Adiciona um novo funcionário.
  - ```bash
    {
    "id": 123,
    "nome": "Nome do Funcionário",
    "telefone": "99999-9999",
    "endereco": "Endereço aqui"
    }
    ```
  - `PUT /api/funcionario/{id}`: Atualiza os detalhes de um funcionário existente.
  - `DELETE /api/funcionario/{id}`: Deleta um funcionário.
  - 
- **Clientes**:
  - `GET /api/cliente`: Retorna todos os clientes.
  - `GET /api/cliente/{id}`: Retorna os detalhes de um cliente específico.
  - `POST /api/cliente`: Adiciona um novo cliente.
  - ```bash
    {
    "id": 123,
    "nome": "Nome do Cliente",
    "telefone": "99999-9999",
    "endereco": "Endereço aqui"
    }
    ```
  - `PUT /api/cliente/{id}`: Atualiza os detalhes de um cliente existente.
  - `DELETE /api/cliente/{id}`: Deleta um cliente.

- **Balcão**:
  - `GET /api/balcao`: Retorna todos os pedidos.
  - `GET /api/balcao/todos-pedidos`: Retorna todos os pedidos.
  - `GET /api/balcao/pedidos-finalizados`: Retorna todos os pedidos que estão finalizados.
  - `GET /api/balcao/pedidos-pendentes`: Retorna todos os pedidos que estão pendentes.
  - `GET /api/balcao/pedidos-entregues`: Retorna todos os pedidos que foram entregues.
  - `GET /api/balcao/funcionarios`: Retorna todos os funcionários.
 
    
- **Produtos**:
  - `GET /api/produto`: Retorna todos os produtos. Caso não existam produtos, retorna uma mensagem de erro.
  - `GET /api/produto/{id}`: Retorna os detalhes de um produto específico com base em seu ID.
  - `POST /api/produto`: Adiciona um novo produto.
  - ```bash
    {
    "sabor" : "Marguerita",
    "produto_item" : "pizza",
    "tamanho" : "P"
    }
    ```
  - `DELETE /api/produto/{id}`: Deleta um produto com base em seu ID.


