# Summary
Microservice to create and manage tennis match licenses and tennis tournament licenses.

There are separate resources to manage
1. Tennis players
2. Tennis matches
3. Tennis Tournaments
4. Tennis match licenses
5. Tennis tournament licenses
6. Customers

- Each tennis match is played between two tennis players.
- Each tennis tournament comprises zero or more tennis matches.
- Each tennis match license is associated with exactly one tennis match.
- Each tennis tournament license is associated with exactly one tennis tournament.

## Build project
```
mvn clean install
```
This will generate the deployable jar artifact in /target.

## Run project locally
```
mvn spring-boot:run -Dspring.profiles.active=local
```
This will start the application on port 8080 against an in-memory H2 database.

## Run project with docker
Todo: Start up web server and MySQL instance in same docker network via docker-compose file.

## Run tests
```
mvn test
```
This will run all unit tests and integration tests. The project is currently missing
significant test coverage.
Todo: Full test coverage. Given the current lack of test coverage there will definitely be some bugs in the 
project's current state.

## Swagger UI
Todo: Add api documentation