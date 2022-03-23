# Java passwordless with Spring Boot

This demo application shows how to create an HTTP REST API based on Spring Boot 2 and Java.

Reason behind this demo application is showing how to create a passwordless login for any use case.

## Important Notes

### Swagger Codegen

It is using swagger code generation for creating boilerplate code which helps a lot to sync documentation and code
because you have to change the swagger file to have the basic code (re-)generated before you can start or continue
coding. So in this case we chose the specification first approach and generate code from the specs.

API documentation can be found under ```src/main/resources/docs/api.yaml```

### Flyway

The application is relying on flyway to bring the database to the desired state. Usage of ddl-auto in hibernate is
highly discouraged for production systems, and we highly recommend using a migration tool like flyway in every
application instead of relying on hibernate ddl-auto. The only correct setting for this is "validate".


## Infrastructure

### Docker

The application is using PostgreSQL as database which can be started with the added docker-compose.yml file for local
development. WARNING: Stored data in the defined container won't survive recreation of the container because it doesn't
define any data container nor a path to persist data.

## Getting started

We assume you have Java 11, Docker and docker-compose already set up.

```bash
git clone git@github.com:rilindnuka/java-passwordless.git
cd java-passwordless
docker-compose up -d
mvn clean package
```

Database is required for tests.
