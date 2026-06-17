# Sistema de Vendas API

API REST para gerenciamento de produtos, clientes, pedidos e itens de pedidos desenvolvida com Java e Spring Boot.

## 📖 Sobre o Projeto

Este projeto foi desenvolvido com o objetivo de praticar conceitos de desenvolvimento backend utilizando Java, Spring Boot e banco de dados relacional.

A aplicação permite realizar operações de cadastro, consulta, atualização e remoção de produtos, clientes, pedidos e itens de pedido. Além disso, implementa regras de negócio como controle de estoque e cálculo automático do valor total dos pedidos.

## 💻 Tecnologias Utilizadas

* Java 21
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* Lombok
* Hibernate
* Git
* GitHub

## 🚀 Funcionalidades

### Produtos

* Cadastro de produtos
* Listagem de produtos
* Busca por ID
* Atualização de produtos
* Remoção de produtos

### Clientes

* Cadastro de clientes
* Listagem de clientes
* Busca por ID
* Atualização de clientes
* Remoção de clientes

### Pedidos

* Cadastro de pedidos
* Listagem de pedidos
* Busca por ID
* Atualização de pedidos
* Remoção de pedidos

### Itens do Pedido

* Cadastro de itens em um pedido
* Associação entre pedido e produto
* Atualização de itens
* Remoção de itens

## ⚙️ Regras de Negócio Implementadas

* Controle automático de estoque
* Validação de estoque insuficiente
* Atualização do estoque após a venda
* Cálculo automático do subtotal do item
* Atualização automática do valor total do pedido
* Relacionamento entre Cliente, Pedido, Produto e ItemPedido

## 🗄️ Modelagem do Sistema

### Cliente

* id
* nome
* email
* telefone

### Produto

* id
* nome
* descricao
* preco
* estoque

### Pedido

* id
* dataPedido
* valorTotal
* cliente

### ItemPedido

* id
* quantidade
* precoUnitario
* produto
* pedido

## 📁 Estrutura do Projeto

```text
src
└── main
    └── java
        └── com.ryanteles.sistemas_vendas
            ├── controller
            ├── entity
            ├── repository
            └── service
```

## ⚙️ Como Executar o Projeto

### Pré-requisitos

* Java 21 ou superior
* Maven
* MySQL
* Git

### Clonar o repositório

```bash
git clone https://github.com/RyanTelesEngSoft/sistemas_vendas.git
```

### Acessar a pasta do projeto

```bash
cd sistema-vendas-api
```

### Configurar o banco de dados

Crie um banco de dados MySQL:

```sql
CREATE DATABASE sistema_vendas;
```

Configure as credenciais no arquivo:

```properties
application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sistema_vendas
spring.datasource.username=root
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Executar a aplicação

```bash
mvn spring-boot:run
```

A API ficará disponível em:

```text
http://localhost:8080
```

## 📍 Principais Endpoints

### Produtos

```http
GET /produtos
POST /produtos
GET /produtos/{id}
PUT /produtos/{id}
DELETE /produtos/{id}
```

### Clientes

```http
GET /clientes
POST /clientes
GET /clientes/{id}
PUT /clientes/{id}
DELETE /clientes/{id}
```

### Pedidos

```http
GET /pedidos
POST /pedidos
GET /pedidos/{id}
PUT /pedidos/{id}
DELETE /pedidos/{id}
```

### Itens do Pedido

```http
GET /itempedido
POST /itempedido
GET /itempedido/{id}
PUT /itempedido/{id}
DELETE /itempedido/{id}
```

## 🎯 Conceitos Aplicados

* Programação Orientada a Objetos (POO)
* APIs REST
* Spring Boot
* Spring Data JPA
* Hibernate
* Relacionamentos JPA

  * @OneToMany
  * @ManyToOne
* Injeção de Dependência
* Arquitetura em Camadas
* Persistência de Dados
* Banco de Dados Relacional
* Regras de Negócio
* Versionamento com Git

## 🔮 Próximas Melhorias

* DTOs para entrada e saída de dados
* Bean Validation
* Tratamento global de exceções
* @Transactional
* Documentação com Swagger/OpenAPI
* Testes unitários
* Spring Security
* Autenticação JWT
* Docker

## 👨‍💻 Autor

Ryan Teles

