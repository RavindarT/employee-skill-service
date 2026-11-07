# Employee Skill Service

A Spring Boot REST API for tracking employee skills and proficiency. Use the employee UUID returned by Employee Service. The skill service stores those UUIDs as references and accepts them without calling Employee Service to verify them.

## Build and run

Use JDK 21 or later and Maven 3.6.3 or later.

```sh
mvn clean package
java -jar target/employee-skill-service-0.0.1-SNAPSHOT.jar
```

The API listens at `http://127.0.0.1:8081` so it can run alongside Employee Service on port 8080. It stores records in a local H2 database under `data/` and has no authentication.

## API

| Method | Path | Behavior |
| --- | --- | --- |
| GET | /api/employees/{employeeId}/skills | List skills for an employee |
| GET | /api/employees/{employeeId}/skills/{code} | Read a skill |
| PUT | /api/employees/{employeeId}/skills/{code} | Add or replace a skill |
| DELETE | /api/employees/{employeeId}/skills/{code} | Remove a skill |

For PUT, set `Content-Type: application/json` and send a body such as `{"name":"Spring Boot","proficiency":"ADVANCED"}`. Use a code such as `spring-boot`. Codes are case-insensitive and accept up to 60 letters, digits, and single separating hyphens. Proficiency is one of `BEGINNER`, `INTERMEDIATE`, `ADVANCED`, or `EXPERT`.

GET and PUT return 200. DELETE returns 204. Invalid inputs return 400, and reading or deleting a missing skill returns 404.

## Upload to GitHub

Extract the ZIP and upload its contents, including `.gitignore`, to the repository root.
