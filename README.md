# Task Management ✅
Uma API para gerenciamento de tarefas internas, permitindo que usuários criem, atualizem e acompanhem suas tarefas e subtarefas.

## 🚀 Tecnologias utilizadas
### Back-end (Linguagem e Framework Principal)
 - Java 21: A linguagem de programação principal usada para escrever toda a lógica da aplicação.
 - Spring Boot: O framework principal que simplifica a criação de aplicações Java robustas e prontas para produção. Ele gerencia a injeção de dependências, configuração e servidores web.
 - Spring Web (MVC): Módulo do Spring Boot usado para construir os endpoints da API REST (@RestController, @GetMapping, etc.).
 - Spring Data JPA / Hibernate: Camada de persistência para facilitar a comunicação com o banco de dados, mapeando classes Java para tabelas do banco (ORM).

### Banco de Dados
- MySQL 8.0: O banco de dados relacional principal, rodando em um contêiner Docker, para armazenar os dados da aplicação de forma permanente.
 - H2 Database: Um banco de dados em memória, configurado no pom.xml para ser usado durante a fase de testes automatizados.

### API e Documentação
- API REST: A arquitetura utilizada para a comunicação entre clientes e o servidor.
- SpringDoc OpenAPI: A biblioteca que gera a documentação da sua API a partir do código.
- Swagger UI: A interface web, incluída pelo SpringDoc, que exibe a documentação de forma interativa, permitindo testar os endpoints diretamente no navegador.

### Containerização e Orquestração (DevOps)
- Docker: A plataforma para criar, empacotar e rodar a sua aplicação e o banco de dados em contêineres isolados.
- Docker Compose: A ferramenta para definir e gerenciar o ambiente multi-contêiner (aplicação + banco de dados), facilitando a execução de todo o sistema com um único comando.

### Build e Gerenciamento de Dependências
- Maven: A ferramenta de automação de build e gerenciamento de dependências do projeto. O arquivo pom.xml é o seu centro de controle.

### Versionamento de Código
- Git: O sistema de controle de versão para rastrear as mudanças no código.
- GitHub: A plataforma onde o código-fonte do projeto é hospedado
## 🏃‍♂️ Execução 
### Pré-requisitos:
- Apache Maven 3.9.9
- MySql 8.0
- Java 21
### Clonar o projeto
`https://github.com/Anacss24/Technical-challenge-iPaaS-Backend-Java.git`
### Entrar no diretório criado
`cd Technical-challenge-iPaaS-Backend-Java`
### Atualize as variáveis do Banco de Dados
#### Arquivo 
Technical-challenge-iPaaS-Backend-Java\src\main\resources\application.properties
```
spring.datasource.url={DB_URL}
spring.datasource.username={DB_USER}
spring.datasource.password={DB_PASSWORD}
```
### Executar o comando
`mvn spring-boot:run`

## 🐋 Execução com Docker
### Pré-requisitos:
- Docker instalado e em funcionamento. 
### Clonar o projeto
`https://github.com/Anacss24/Technical-challenge-iPaaS-Backend-Java.git`
### Entrar no diretório criado
`cd Technical-challenge-iPaaS-Backend-Java`
### Executar o comando
`docker-compose up --build`
## 📋 Endpoints
 ### User  
  - `POST`  `http://localhost:8000/user` -> Cria um novo usuário
    
    ```
     {
     "name": "Teste",
     "email": "teste@gmail.com"
     }
    ``` 
  - `GET`  `http://localhost:8000/user/{id}` -> Busca um usuário por ID
  - `GET`  `http://localhost:8000/user` -> Listar todos os usuários
 
 ### Task
  - `POST`  `http://localhost:8000/tasks` -> Cria uma nova tarefa para um usuário

     ```
     {
     "title": "Estudar Testes",
     "description": "Testes com Junit",
     "id_user": "f8c4786e-b5bf-49d0-bf02-a32f4e102012"
     }
    ``` 
  - `GET`  `http://localhost:8000/tasks/{id}` -> Busca uma tarefa por ID
  - `GET`  `http://localhost:8000/tasks?status=PENDENTE` -> Lista de tarefas filtradas por status
  - `PATCH`  `http://localhost:8000/tasks/{id}/status` -> Atualiza o status da tarefa
### SubTask
- `POST`  `http://localhost:8000/task/{taskId}/subtask` -> Cria uma sub tarefa
  
   ```
     {
     "titleSub": "Testes Unitários",
     "descriptionSub": "Testar a menor unidade de código possível"
     }
    ``` 
- `GET`  `http://localhost:8000/task/{taskId}/subtask` -> Buscar uma sub tarefa por ID
- `PATCH`  `http://localhost:8000/task/subtask/{id}/status` -> Atualiza o status da tarefa
  
<p align="center">
Desenvolvido por <i>Ana Claudia Santana</i> :orange_heart:
</p>
