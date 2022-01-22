# User API

![JAVA](https://img.shields.io/static/v1?label=JAVA&message=BACKEND&color=0091EA&style=flat&logo=JAVA)
![SPRING](https://img.shields.io/static/v1?label=Spring&message=FRAMEWORK&color=0091EA&style=flat&logo=Spring)

# Tools and technologies used:
- Java 17
- Spring Boot
- Spring Data JPA
- Bean Validation
- Lombok
- H2 Database
- IntelliJ IDEA
- Maven
- Swagger
- Tomcat

# Create new requests - Address
- GET - Get Address By ID: http://localhost:8080/address/1
- POST - Create Address: http://localhost:8080/address/create
- PUT - Update Address: http://localhost:8080/address/update/1

# Create new requests - User
- GET - Get All Users: http://localhost:8080/users
- GET - Get User By ID: http://localhost:8080/users/1
- POST - Create User: http://localhost:8080/users/create?address=1
- PUT - Update User: http://localhost:8080/users/update/1
- DELETE - Delete User: http://localhost:8080/users/delete/1

# Localhost - Swagger
- http://localhost:8080/swagger-ui.html