# Library Management System

A simple Spring Boot Library Management application created for the Spring Boot Framework Part 1 activity.

## Technology Stack

- Java 21
- Spring Boot
- Maven
- Spring Web
- Spring Data JPA
- H2 In-Memory Database
- JUnit / Mockito

No external APIs, API keys, React frontend, or external database are required.

## Architecture

Client -> Controller -> Service -> Repository -> H2 Database

## Domain Classes

1. Book
2. Member
3. Loan

## Business Rules

1. A book cannot be borrowed when it is already borrowed.
2. A member cannot borrow more than 3 active books.
3. A returned loan cannot be returned again.

## Run

Open a terminal in the project folder:

```powershell
mvn spring-boot:run
```

The application runs at:

http://localhost:8080

## REST Endpoints

### Get all books

GET http://localhost:8080/api/books

### Add book

POST http://localhost:8080/api/books

Body:

```json
{
  "title": "The Alchemist",
  "author": "Paulo Coelho"
}
```

### Get members

GET http://localhost:8080/api/members

### Add member

POST http://localhost:8080/api/members

Body:

```json
{
  "name": "Pragya",
  "email": "pragya@example.com"
}
```

### Borrow book

POST:

http://localhost:8080/api/borrow?bookId=1&memberId=1

### Return book

POST:

http://localhost:8080/api/return?loanId=1

## Run Tests

```powershell
mvn test
```

## H2 Console

http://localhost:8080/h2-console

JDBC URL:

jdbc:h2:mem:librarydb

Username:

sa

Password:

leave blank
