# 🔐 Sistema de Login e Autenticação – API REST (Java & Spring Boot)

API REST desenvolvida com **Java e Spring Boot**, responsável pelo **cadastro, autenticação e controle de acesso de usuários**, utilizando **JWT (JSON Web Token)** e **Spring Security** para garantir segurança, escalabilidade e comunicação stateless, seguindo boas práticas de desenvolvimento back-end.

---

## 🚀 Tecnologias Utilizadas

- Java 17  
- Spring Boot  
- Spring Web  
- Spring Security  
- Spring Data JPA  
- JWT (JSON Web Token)  
- PostgreSQL  
- Hibernate  
- Lombok  
- Jakarta Validation  
- Maven  

---

## 🧱 Arquitetura do Projeto

Arquitetura baseada em **camadas bem definidas**, seguindo os princípios de **responsabilidade única** e **separação de interesses**:

- **Controller**: Exposição dos endpoints REST e recepção das requisições  
- **Service**: Regras de negócio e validações  
- **Repository**: Comunicação com o banco de dados via Spring Data JPA  
- **Security**: Configurações do Spring Security, filtros JWT e controle de acesso  
- **DTOs**: Objetos de transferência de dados  
- **Exception Handling**: Tratamento global de exceções com respostas padronizadas  

---

## 🔑 Funcionalidades

- Cadastro de usuários com **criptografia de senha**
- Login de usuários autenticados
- Geração e validação de **JWT**
- Controle de acesso a **rotas protegidas**
- Usuário administrador com credenciais pré-definidas
- Validação de dados de entrada
- Respostas padronizadas da API
- Tratamento global de exceções

---

## 🔐 Segurança

- Autenticação baseada em **JWT**
- Senhas armazenadas com **BCrypt**
- API **stateless** (sem uso de sessão)
- Proteção de endpoints com **Spring Security**

---

## ⚙️ Configuração do Projeto

### Pré-requisitos

- Java 17+
- Maven  
- PostgreSQL  

### Banco de Dados

Crie um banco de dados no PostgreSQL e configure as credenciais no arquivo `application.properties`.

Exemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/system_login
spring.datasource.username=postgres
spring.datasource.password=senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.secret=chave_secreta
jwt.expiration=86400000
