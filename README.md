
# 📘 Spring Boot Student Management System

A clean, modular, and RESTful **Student Management System** built with **Java** and **Spring Boot**, structured using the **MVC architecture** and powered by **Maven**, **Swagger**, and **Spring Data JPA**.

---

## 🚀 Features

- 🧱 **Layered MVC Architecture** – Separation of `Controller`, `Service`, `Repository`, and `Entity` for maintainability
- 🔄 **CRUD Operations** – Create, Read, Update, Delete functionality for managing student data
- ⚙️ **Custom Exception Handling** – Graceful error handling with centralized `ExceptionHandler`
- 🌐 **RESTful APIs** – Proper HTTP methods and clean endpoint mappings
- 📊 **Swagger UI Integration** – Visualize and test APIs in an interactive UI
- 🛠️ **Maven-Based** – Simple build and dependency management via `pom.xml`
- 🧪 **Spring Boot Testing** – Ready for expansion with JUnit and integration testing support

---

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com.ashutosh.sms/
│   │       ├── controller/          # REST API endpoints
│   │       ├── entity/              # Student entity model
│   │       ├── exception/           # Custom exceptions and handlers
│   │       ├── repository/          # JPA repository interface
│   │       └── service/             # Business logic
│   └── resources/
│       ├── application.properties   # Server configuration
├── test/                            # (Ready for future tests)
```

---

## 📦 Dependencies

Main dependencies in `pom.xml` include:

- `spring-boot-starter-web`
- `spring-boot-starter-data-jpa`
- `spring-boot-devtools`
- `h2` (or compatible JDBC DB)
- `swagger-ui` & `springfox-swagger2` for Swagger

---

## 🔗 API Documentation

- Run the application and access the Swagger UI at:  
  📍 [`http://localhost:1200/swagger-ui/index.html`](http://localhost:1200/swagger-ui/index.html)

---

## ✅ How to Run

```bash
# Clone the repository
git clone https://github.com/AshutoshMitraJi/sms.git
cd sms

# Open in your IDE and run the main Spring Boot application class
# OR use command line (if using Maven)
mvn spring-boot:run
```

---

## 📌 Author

**Ashutosh Mitra**  
Aspiring Software Developer
