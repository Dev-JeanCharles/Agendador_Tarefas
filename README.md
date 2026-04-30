## 🔧 Agendador de Tarefas

Este repositório contém o **ecossistema de microserviços** do Agendador de Tarefas, composto por quatro aplicações independentes com CI/CD próprio.

Cada serviço possui responsabilidades específicas, comunicação via HTTP, uso de Cron para notificações por e-mail e padronização com Java + Spring Boot.

---

## 🧩 Arquitetura Geral

O sistema é formado por quatro serviços principais:

| Serviço | Repositório | Descrição |
|--------|-------------|-----------|
| **Agendador_Tarefas** | https://github.com/Dev-JeanCharles/Agendador_Tarefas | Gerencia tarefas e execuções |
| **BFF-AgendadorTarefas** | https://github.com/Dev-JeanCharles/Bff-AgendadorTarefas | Camada de orquestração |
| **Usuario** | https://github.com/Dev-JeanCharles/Usuario | Autenticação e usuários |
| **Notificacao** | https://github.com/Dev-JeanCharles/Notificacao | Envio de e-mails |

---

## 🛠️ Tecnologias

- Java 17+
- Spring Boot 3+
- PostgreSQL
- MongoDB
- Docker / Docker Compose
- Swagger

---

## 🚀 Como rodar o projeto com Docker

### 📦 1. Clonar os repositórios

```bash
git clone https://github.com/Dev-JeanCharles/bff-agendador-tarefas
git clone https://github.com/Dev-JeanCharles/usuario
git clone https://github.com/Dev-JeanCharles/agendador-tarefas
git clone https://github.com/Dev-JeanCharles/notificacao
```

### ⚙️ 2. Criar arquivo .env
Crie o arquivo .env dentro da pasta:

```bash
bff-agendador-tarefas/docker/.env

# PORTAS
BFF_PORT=8083
USUARIO_PORT=8080
AGENDADOR_PORT=8081
NOTIFICACAO_PORT=8084
POSTGRES_PORT=5433
MONGO_PORT=27017

# POSTGRES
POSTGRES_DB=db_usuario
POSTGRES_USER=admin
POSTGRES_PASSWORD=admin

# MONGO
MONGO_DB=db_agendador

# URLs
USUARIO_URL=http://usuario:8080
AGENDADOR_TAREFAS_URL=http://agendador-tarefas:8081
NOTIFICACAO_URL=http://notificacao:8084
```

### 🐳 3. Build das imagens manualmente (IMPORTANTE)
Como o Dockerfile está dentro da pasta ```docker/```, execute:

```bash
cd bff-agendador-tarefas

docker build -t jeancharles12/bff-agendador-tarefas:latest -f docker/Dockerfile .

cd ../usuario
docker build -t jeancharles12/usuario:latest -f docker/Dockerfile .

cd ../agendador-tarefas
docker build -t jeancharles12/agendador-tarefas:latest -f docker/Dockerfile .

cd ../notificacao
docker build -t jeancharles12/notificacao:latest -f docker/Dockerfile .
```

### ▶️ 4. Subir os containers
Volte para o projeto do BFF:

```cd ../bff-agendador-tarefas```

Execute:

```docker compose -f docker/docker-compose.yml up --build```

Ou em background:

```docker compose -f docker/docker-compose.yml up -d --build```

### 🔗 Acessos

| Serviço     | URL                                            |
| ----------- | ---------------------------------------------- |
| BFF         | [http://localhost:8083](http://localhost:8083) |
| Usuario     | [http://localhost:8080](http://localhost:8080) |
| Agendador   | [http://localhost:8081](http://localhost:8081) |
| Notificação | [http://localhost:8084](http://localhost:8084) |

## ⚠️ Problemas comuns
### ❌ Erro: Dockerfile não encontrado

➡ Rode o comando a partir da raiz do projeto

### ❌ Erro: gradlew não encontrado

➡ Verifique se o context está correto no docker-compose

### ❌ Porta em uso

➡ Altere no .env

## 👨‍💻 Autor
Jean Charles Duarte

GitHub: https://github.com/Dev-JeanCharles
