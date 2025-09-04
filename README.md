# Task Management ✅
API de gerenciamento de tarefas.
## 🚀 Tecnologias utilizadas
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
  - `GET`  `http://localhost:8000/user/{id}` -> Busca um usuário por ID
  - `POST`  `http://localhost:8000/user` -> Cria um novo usuário
 ### Task
  - `GET`  `http://localhost:8000/task{id}` -> Busca uma tarefa por ID
  - `POST`  `http://localhost:8000/task` -> Cria uma nova tarefa para um usuário
  - `GET`  `http://localhost:8000/task?status=PENDENTE` -> Lista de tarefas filtradas por status
  - `PATCH`  `http://localhost:8000/task/{id}/status` -> Atualiza o status da tarefa

<p align="center">
Desenvolvido por <i>Ana Claudia Santana</i> :orange_heart:
</p>
