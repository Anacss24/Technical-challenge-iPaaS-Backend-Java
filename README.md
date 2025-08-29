# Task Management ✅
API de gerenciamento de tarefas.
## 🚀 Tecnologias utilizadas
## 🏃‍♂️ Execução
## 🐋 Execução com Docker
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
