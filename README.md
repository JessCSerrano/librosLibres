## 💡 Introduction

This project manages a bookstore. It allows you to create, edit, and delete books and their associated authors.  
The project is built using a microservices architecture with Spring Boot to handle these operations.


## ✨ Main Features

- Complete book management using CRUD.
- Documented RESTful API.
- Hexagonal architecture.
- Use microservices with Spring Boot.


## 🛠️ Technologies

- **Backend:** Java, Spring Boot
- **Architecture:** Hexagonal
- **Database:** PostgreSQL
- **API documentation:** Swagger
- **Version control:** GitHub
- **Dependency management and build:** Maven
- **Containers:** Docker

## 📂 File Structure
```
├── 📄 .gitignore
├── 📄 README.md
├── 📄 pom.xml
└── 📁 src
    └── 📁 main
        ├── 📁 java
        │   └── 📁 com
        │       └── 📁 jessCSerrano
        │           └── 📁 librosLibres
        │               ├── 📄 LibrosLibresApplication.java
        │               ├── 📁 adapters
        │               ├── 📁 application
        │               └── 📁 domain
        └── 📁 resources
            └── 📄 application.yml
```

## 🔌 Installation


### 1️⃣ Clone the repository

```bash
https://github.com/JessCSerrano/librosLibres.git
cd librosLibres
```
### 2️⃣ Prerequisites

- Java JDK 17+
- Maven (or use the included wrapper `./mvnw`)
- Docker (to run PostgreSQL)

### 3️⃣ Run Docker

Start the PostgreSQL container: 
```bash
docker-compose up -d
```
### 4️⃣ Run the application

```bash
./mvnw clean install
./mvnw spring-boot:run
```

## 👩🏽‍💻 Author
```
🙋🏽‍♀️ Jessica Katherine Castillo Serrano
✉️ jess.cserrano@gmail.com
🐱 https://github.com/JessCSerrano
```