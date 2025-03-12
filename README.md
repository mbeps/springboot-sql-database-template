This project is a RESTful API built with Spring Boot 3 and PostgreSQL. It provides a foundation for building relational database applications with full CRUD operations. The project includes a product management system with search capabilities.

# Requirements

To run this application, you need:
- Java 17 or higher
- PostgreSQL (running locally on port 5432)
- Gradle 8

# Stack

Our application uses these key technologies:

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) - The core programming language with modern features like records and improved switch expressions.
- [Spring Boot 3](https://spring.io/projects/spring-boot) - A framework that simplifies Java application development with convention over configuration.
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa) - Provides integration with SQL databases and implements the repository pattern.
- [PostgreSQL](https://www.postgresql.org/) - A powerful, open-source relational database system with strong reputation for reliability and data integrity.
- [Gradle](https://gradle.org/) - A build automation tool that manages dependencies and builds the application.
- [Lombok](https://projectlombok.org/) - A Java library that reduces boilerplate code with annotations.
- [Hibernate](https://hibernate.org/) - An object-relational mapping tool for Java that provides a framework for mapping object-oriented domain models to relational databases.

# Configuration

The application is configured through the `application.yaml` file:

```yaml
spring:
  application:
    name: my-spring-project
  
  datasource:
    url: jdbc:postgresql://localhost:5432/mydatabase
    username: dbuser
    password: dbpassword
    driver-class-name: org.postgresql.Driver
  
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        dialect: org.hibernate.dialect.PostgreSQLDialect
  
  logging:
    level:
      org.hibernate.SQL: DEBUG
      org.hibernate.type.descriptor.sql.BasicBinder: TRACE
      com.example.demo: DEBUG

server:
  port: 8080
  servlet:
    context-path: /api
```

Configuration fields:
- `spring.application.name`: The name of the application
- `spring.datasource.url`: JDBC URL for connecting to the PostgreSQL database
- `spring.datasource.username`: Database username
- `spring.datasource.password`: Database password
- `spring.datasource.driver-class-name`: JDBC driver class
- `spring.jpa.hibernate.ddl-auto`: Database schema generation strategy (create, update, validate, none)
- `spring.jpa.show-sql`: Whether to show SQL statements in logs
- `spring.jpa.properties.hibernate.format_sql`: Whether to format SQL statements for readability
- `spring.jpa.properties.hibernate.dialect`: SQL dialect for Hibernate
- `server.port`: Application server port
- `server.servlet.context-path`: Base path for all endpoints

# Usage

## Running the Application

1. Ensure PostgreSQL is running locally on port 5432 with the configured database
2. Start the application:
```bash
./gradlew bootRun
```

## Testing the API

Here are some curl commands to test the application:

### Create a product
```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Gaming Laptop","description":"High-performance gaming laptop with RGB keyboard","price":1299.99}'
```

### Get all products
```bash
curl http://localhost:8080/api/products
```

### Get product by ID
```bash
curl http://localhost:8080/api/products/1
```

### Update a product
```bash
curl -X PUT http://localhost:8080/api/products/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Gaming Laptop Pro","description":"Updated high-performance gaming laptop with RGB keyboard","price":1499.99}'
```

### Search products by name
```bash
curl "http://localhost:8080/api/products/search?name=laptop"
```

### Find products by price
```bash
curl "http://localhost:8080/api/products/price-less-than?price=500"
```

### Delete a product
```bash
curl -X DELETE http://localhost:8080/api/products/1
```

For more detailed information, please visit the wiki.
