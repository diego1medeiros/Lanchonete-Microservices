# Lanchonete-Microserviços

# 🍔 Sistema de Gestão para Lanchonete - Arquitetura de Microserviços

> Transformação de um sistema monolítico em uma arquitetura de microserviços utilizando o ecossistema Spring.

## 📖 Sobre o Projeto

Este projeto nasceu como uma aplicação monolítica para gerenciamento de uma lanchonete. Durante sua evolução, foi totalmente refatorado para uma arquitetura de **Microserviços**, aplicando conceitos modernos de desenvolvimento distribuído, escalabilidade e alta disponibilidade.

Cada domínio da aplicação tornou-se um serviço independente, possuindo seu próprio banco de dados e podendo ser desenvolvido, implantado e escalado separadamente.

---

## 🏗 Arquitetura

O sistema foi dividido nos seguintes microserviços:

* 👤 Cliente Service
* 👨‍💼 Funcionário Service
* 🚚 Fornecedor Service
* 📦 Produto Service
* 💰 Venda Service

Cada serviço possui:

* Banco de dados PostgreSQL próprio
* API REST independente
* Camadas Controller, Service e Repository
* DTOs
* Validações
* Tratamento global de exceções
* Documentação Swagger/OpenAPI





## 👨‍💻 Desenvolvedor

**Diego Medeiros Jesus**

Desenvolvedor Java Backend | Full Stack

### Tecnologias

Java • Spring Boot • Spring Cloud • Spring Security • PostgreSQL • Docker • RabbitMQ • JSF • PrimeFaces • Git • GitHub

---

⭐ Este projeto representa minha evolução de uma aplicação monolítica para uma arquitetura moderna baseada em Microserviços, aplicando tecnologias amplamente utilizadas em sistemas corporativos e ambientes de produção.

# 🍔 Lanchonete Microservices - Evolução de Monolito para Arquitetura Distribuída 🚀

## 📌 Sobre o Projeto

Este projeto representa a **modernização de um sistema de gerenciamento de lanchonete**, onde uma aplicação inicialmente desenvolvida em arquitetura monolítica foi transformada em uma solução baseada em **microserviços independentes**, aplicando conceitos modernos de desenvolvimento de software, escalabilidade e alta disponibilidade.

A aplicação foi dividida em serviços independentes, permitindo que cada domínio possua seu próprio ciclo de evolução, banco de dados e responsabilidade dentro da arquitetura.

A transformação trouxe maior flexibilidade, facilidade de manutenção e preparação para ambientes modernos de produção utilizando **Spring Cloud, Docker e mensageria assíncrona**.

---

# 🏗️ Arquitetura do Projeto

A aplicação foi estruturada seguindo o conceito de **Arquitetura de Microserviços**, onde cada contexto de negócio possui seu próprio serviço:


---

# 🚀 Evolução Arquitetural

## Antes - Arquitetura Monolítica

Inicialmente o sistema possuía:

- Uma única aplicação responsável por todos os módulos;
- Banco de dados centralizado;
- Forte acoplamento entre funcionalidades;
- Maior dificuldade de manutenção e evolução.

---

## Depois - Arquitetura baseada em Microserviços

O sistema foi dividido em serviços independentes:

✅ Cliente  
✅ Funcionário  
✅ Fornecedor  
✅ Produto  
✅ Venda  

Cada serviço possui:

- Código independente;
- Banco de dados próprio;
- Responsabilidade única;
- Possibilidade de evolução individual;
- Maior isolamento de falhas.

---

# 🧩 Tecnologias Utilizadas

## Backend

- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- Spring Cloud
- Spring Cloud Gateway
- Spring Cloud Config
- Spring Security
- Maven

---

# 🔎 Service Discovery com Eureka

Foi utilizado o **Netflix Eureka Server** para registro e descoberta automática dos serviços.

Benefícios:

✔ Localização dinâmica dos serviços  
✔ Comunicação desacoplada  
✔ Escalabilidade horizontal  
✔ Gerenciamento centralizado dos serviços disponíveis  

Fluxo:

Microserviço
|
|
↓
Eureka Server
|
|
API Gateway
---

# ⚙️ Configuração Centralizada com Config Server

O projeto utiliza **Spring Cloud Config Server** para centralizar configurações da aplicação.

As propriedades dos serviços são armazenadas em um repositório Git, permitindo:

- Controle de versão;
- Alteração de configurações sem modificar código;
- Padronização entre ambientes.

Exemplo:

config-server
|
|
↓
Git Repository
|
|
↓
Microserviços


---

# 🌐 API Gateway

O Gateway funciona como porta de entrada única para todas as requisições da aplicação.

Responsabilidades:

✔ Roteamento das chamadas  
✔ Comunicação com microserviços  
✔ Centralização de acesso  
✔ Preparação para autenticação e autorização  

Exemplo:
Cliente

|
|
↓

API Gateway

|
|--------- Cliente MS
|
|--------- Produto MS
|
|--------- Venda MS


---

# 🐰 Comunicação Assíncrona com RabbitMQ

Foi implementada comunicação orientada a eventos utilizando RabbitMQ.

Benefícios:

- Comunicação desacoplada;
- Maior resiliência;
- Processamento assíncrono;
- Melhor escalabilidade.

Exemplo:
Venda realizada

  |
  ↓

RabbitMQ

  |
  ↓

Atualização de estoque


---

# 🐳 Docker e Containerização

Todos os serviços foram preparados para execução utilizando containers Docker.

Cada microserviço possui sua própria imagem.

A execução completa da aplicação pode ser realizada através do:

docker-compose.yml


Benefícios:

✔ Ambiente padronizado  
✔ Facilidade de implantação  
✔ Isolamento dos serviços  
✔ Escalabilidade  

Arquitetura Docker:

Docker Compose

|
|---- Config Server
|
|---- Eureka
|
|---- Gateway
|
|---- Cliente MS
|
|---- Funcionário MS
|
|---- Produto MS
|
|---- Fornecedor MS
|
|---- Venda MS


---

# 🗄️ Banco de Dados

Cada microserviço possui seu próprio banco PostgreSQL seguindo o conceito:

## Database per Service Pattern

Exemplo:


cliente-ms
|
└── cliente_database

produto-ms
|
└── produto_database

vendas-ms
|
└── venda_database


Vantagens:

- Independência entre serviços;
- Menor acoplamento;
- Melhor escalabilidade;
- Evolução independente dos modelos.

---

# 💻 Frontend

Interface desenvolvida utilizando:

- Java Server Faces (JSF)
- PrimeFaces
- HTML5
- CSS3
- JavaScript

Responsável pela interação do usuário com o sistema.

---

# 🔄 CI/CD

Implementação de pipeline utilizando:

## GitHub Actions

Pipeline responsável por:

✔ Checkout do código  
✔ Build Maven  
✔ Execução dos testes  
✔ Validação automática  

Workflow:


Commit

↓

GitHub Actions

↓

Build Maven

↓

Testes

↓

Deploy


---

# 📚 Conceitos Aplicados

Durante o desenvolvimento foram aplicados:

✅ Arquitetura de Microserviços  
✅ Service Discovery  
✅ API Gateway Pattern  
✅ Config Server Pattern  
✅ Database per Service  
✅ Comunicação assíncrona  
✅ Containerização  
✅ Integração contínua  
✅ Separação de responsabilidades  
✅ Desenvolvimento orientado a domínio  

---

## 📚 Aprendizados

Durante o desenvolvimento deste projeto foram aplicados conceitos como:

* Arquitetura Distribuída
* Comunicação síncrona e assíncrona
* Spring Cloud
* Docker
* Mensageria
* APIs REST
* Design Patterns
* Clean Architecture
* Clean Code
* SOLID
* Banco de Dados por Serviço
* Integração entre Microserviços

---
# 🎯 Objetivos do Projeto

Este projeto demonstra conhecimentos em:

- Desenvolvimento Backend Java;
- Arquitetura distribuída;
- Spring Cloud;
- DevOps;
- Docker;
- Mensageria;
- Banco de dados;
- Boas práticas de engenharia de software.

---

# 👨‍💻 Autor

**Diego Medeiros**

Desenvolvedor Java Backend / Full Stack Júnior

Tecnologias:

Java | Spring Boot | Microserviços | Docker | PostgreSQL | RabbitMQ | Spring Cloud

GitHub:

https://github.com/diego1medeiros

---

⭐ Se este projeto foi útil ou interessante, deixe uma estrela no repositório!




