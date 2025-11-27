## 🔧 Agendador de Tarefas

Este repositório contém o **desenvolvimento do ecossistema** de microserviços do Agendador de Tarefas, composto por quatro aplicações independentes com CI/CD próprio.  

Cada serviço possui responsabilidades específicas, comunicação clara via HTTP, uso do Cron para notificações de tarefas via Email e padronização tecnológica baseada em Java, Spring Boot e APIs REST.

---

## 🧩 Arquitetura Geral

O sistema é formado por quatro serviços principais:

| Serviço | Repositório | Descrição |
|--------|-------------|-----------|
| **Agendador_Tarefas** | https://github.com/Dev-JeanCharles/Agendador_Tarefas | Gerencia tarefas, agendas, execuções e status. |
| **BFF-AgendadorTarefas** | https://github.com/Dev-JeanCharles/Bff-AgendadorTarefas | Camada BFF que abstrai a comunicação entre frontend e os microserviços. |
| **Usuario** | https://github.com/Dev-JeanCharles/Usuario | Controle de usuários, autenticação, perfis e permissões. |
| **Notificacao** | https://github.com/Dev-JeanCharles/Notificacao | Serviço de envio de notificações e-mail. |


![Untitled Diagram drawio](https://github.com/user-attachments/assets/041452cf-5c4d-4364-86ee-b1c8557e4da5)

---
## 🛠️ Tecnologias Utilizadas

### Backend (todos os microserviços)
- **Java 17+**
- **Spring Boot 3+**
- **Spring Web / Spring Security**
- **JPA / Hibernate**
- **PostgreSQL**
- **Docker / Docker Compose**
- **Cron**
- **Swagger/OpenAPI**

---

## 🚀 Objetivo do Ecossistema

O objetivo do ecossistema é fornecer:

- Agendamento automatizado de tarefas
- Gerenciamento de rotinas, execuções e lembretes
- Autenticação robusta e escalável
- Notificações inteligentes baseadas em eventos
- Facilidade de integração via BFF

---

## 👨‍💻 Autor

**Jean Charles Duarte**  
Desenvolvedor Back-End Java
GitHub: https://github.com/Dev-JeanCharles  
LinkedIn: *https://www.linkedin.com/in/dev-jeancharles/*

---
