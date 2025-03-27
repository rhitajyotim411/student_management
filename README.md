# Student Management REST API

This is a simple REST API to perform CRUD operations on student records. The project highlights the basics of building a REST API using the Spring Framework in Java and uses PostgreSQL as the database.

## Features
- Retrieve student details
- Save new student records
- Update student details
- Delete existing student records

## Technologies Used
- **Java** (Spring Boot)
- **Spring Framework** (Spring Web, Spring Data JPA, Lombok)
- **PostgreSQL** (Database)
- **Maven** (Build tool)

## API Endpoints
| Method | Endpoint             | Description              |
| ------ | -------------------- | ------------------------ |
| GET    | `/api/students`      | Retrieve all students    |
| GET    | `/api/students/{id}` | Retrieve a student by ID |
| POST   | `/api/students`      | Save a new student       |
| PUT    | `/api/students`      | Update a student details |
| DELETE | `/api/students/{id}` | Delete a student by ID   |
