# 🎯 To-Do-List API

API RESTful para gerenciamento de tarefas (To-Do) e subtarefas, desenvolvida em **Java** com **Spring Boot**.
Permite criar, listar, atualizar e excluir tarefas, gerenciar subtarefas, aplicar filtros, autenticar usuários e controlar permissões via roles.

---

## 📑 Índice

1. [Descrição](#descrição)
2. [Funcionalidades](#funcionalidades)
3. [Arquitetura](#arquitetura)
4. [Tecnologias Utilizadas](#tecnologias-utilizadas)
5. [Requisitos](#requisitos)
6. [Instalação](#instalação)
7. [Configuração](#configuração)
8. [Execução do Projeto](#execução-do-projeto)
9. [Endpoints](#endpoints)
10. [Camada de Serviço (Service)](#camada-de-serviço-service)
11. [Camada de Repositório (Repository)](#camada-de-repositório-repository)
12. [Tratamento de Exceções (Exception Handler)](#tratamento-de-exceções-exception-handler)
13. [Testes Unitários](#testes-unitários)
14. [Segurança e Autenticação](#segurança-e-autenticação)
15. [Autorização e Roles](#autorização-e-roles)
16. [Boas Práticas e Observações](#boas-práticas-e-observações)
17. [Licença](#licença)
18. [Contato](#contato)

---

## 📖 Descrição

A **To-Do API** é uma solução para gerenciamento de tarefas e subtarefas com foco em **segurança**, **organização** e **produtividade**.
Oferece autenticação e autorização baseada em *roles*, impedindo alterações não autorizadas e garantindo integridade das informações.
Ideal para estudos, projetos internos e integração com sistemas maiores.

---

## 🚀 Funcionalidades

- **CRUD** de tarefas (criar, listar, atualizar, excluir)
- **Gerenciamento de subtarefas** vinculadas a tarefas principais
- Filtros por **status**, **prioridade** e **prazo**
- **Autenticação** via **Basic Auth** ou formulário customizado
- **Autorização** baseada em roles (`USER` e `ADMIN`)
- Bloqueio de conclusão de tarefas com subtarefas pendentes

---

## 🏗 Arquitetura

A API segue a arquitetura **Camadas + Padrão MVC**:

- **Controller** → Recebe requisições HTTP e retorna respostas para o cliente.
- **Service** → Contém as regras de negócio.
- **Repository** → Comunicação com o banco de dados via **Spring Data JPA**.
- **Entity** → Mapeamento das tabelas do banco.
- **Exception Handler** → Centraliza o tratamento de erros.
- **Testes Unitários** → Garantem que funcionalidades principais funcionem conforme esperado.

---

## 🛠 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot** (Web, Data JPA, Security)
- **Maven**
- **Git**
- **PostgreSQL**


---

## 📋 Requisitos

- **Java 17** ou superior
- **Maven 3.8+**
- **Git** instalado
- IDE compatível (IntelliJ IDEA, Eclipse, VS Code com extensões Java)

---

## 📥 Instalação

- Clonar o repositório
- Entrar no diretório do projeto
- Compilar e instalar dependências com Maven

---

## ⚙ Configuração

O projeto já vem configurado para usar o **banco H2** em memória.
Para usar outro banco (MySQL, PostgreSQL, etc.), altere o arquivo `application.properties`:
---

## ▶ Execução do Projeto

Executar o projeto via Maven ou diretamente pela IDE escolhida.
O sistema será iniciado em **http://localhost:8080**.

---

## 📡 Endpoints

### **Tarefas**
- `POST /api/todos` → Criar tarefa
- `GET /api/todos` → Listar todas
- `GET /api/todos/{id}` → Buscar por ID
- `PUT /api/todos/{id}` → Atualizar
- `DELETE /api/todos/{id}` → Excluir

### **Subtarefas**
- `POST /api/todos/{id}/subtasks` → Criar subtarefa
- `PUT /api/subtasks/{id}` → Atualizar subtarefa
- `DELETE /api/subtasks/{id}` → Excluir subtarefa

---

## 🧩 Camada de Serviço (Service)

A camada **Service** concentra as regras de negócio, garantindo que toda lógica de manipulação de dados e validação seja executada antes de interagir com o banco.

Exemplos de responsabilidades:
- Validação de status e prioridade de tarefas
- Impedir exclusão de tarefas com subtarefas pendentes
- Garantir integridade no vínculo entre tarefas e subtarefas
- Aplicar regras de autorização baseadas no usuário logado

---

## 📂 Camada de Repositório (Repository)

A camada **Repository** utiliza **Spring Data JPA** para abstrair a comunicação com o banco de dados.
Os repositórios são interfaces que estendem `JpaRepository` e permitem:
- Consultas automáticas via *query methods*
- Uso de anotações `@Query` para consultas personalizadas
- Integração transparente com diferentes bancos

---

## ⚠ Tratamento de Exceções (Exception Handler)

A API possui uma classe central de tratamento de erros usando `@ControllerAdvice` e `@ExceptionHandler`, que garante respostas consistentes em caso de falhas.

Principais exceções tratadas:
- **ResourceNotFoundException** → Registro não encontrado
- **BadRequestException** → Erro de validação ou parâmetros inválidos
- **AccessDeniedException** → Acesso negado por falta de permissões
- **Exception genérica** → Erros não previstos, retornando HTTP 500

As respostas incluem:
- Código HTTP
- Mensagem de erro
- Timestamp
- Detalhes adicionais (se aplicável)

---

## 🧪 Testes Unitários

O projeto conta com um arquivo `Test_config` responsável por garantir que as principais funcionalidades da API funcionem corretamente.

**O que é testado no `Test_config`:**
- Criação e listagem de tarefas
- Atualização de tarefas existentes
- Exclusão de tarefas
- Criação e associação de subtarefas
- Comportamento esperado em casos de erro

Esses testes permitem validar se as regras de negócio estão funcionando corretamente e ajudam a evitar regressões durante futuras alterações no código.

---

## 🔐 Segurança e Autenticação

O sistema usa **Spring Security** com **Basic Auth** e login via formulário.
Para acessar os endpoints, envie credenciais válidas no cabeçalho da requisição.

---

## 👥 Autorização e Roles

- `USER` → Pode criar, listar e atualizar suas próprias tarefas
- `ADMIN` → Pode gerenciar todas as tarefas e usuários

---

## 📌 Boas Práticas e Observações

- Validar dados de entrada antes de enviar à API
- Usar roles corretas para evitar erros de autorização
- Configurar backups se estiver usando banco persistente
- Em produção, usar HTTPS e configurar CORS adequadamente

---
