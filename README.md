# Backend-java
This is a set of services for user management in our Cloud storage application.
We include services: 
- authentication
- password update
- add user
- delete user

backend is based on SprintBoot and Maven, as technologies to make a simple both construction and deployment.

## Requirements

-Install java jdk. To chech this part run java --version into a terminal, and use at least Java 17.
-Install Apache Maven. To chech this part run mvn --version into a terminal, and use at least Maven 3.6.3.
-[Optional] If you are using VisualStudio Code, install the Java Extension Pack extension.

## How to use

Create a first, could be empty, file with users information using next data structure:
```
[
    {
        "id": 1,
        "name": "John",
        "username": "john123",
        "password": "john_pass",
        "language": "english",
        "location": "USA",
        "age": 34,
    },
    {
        "id": 2,
        "name": "Jane",
        "username": "jane123",
        "password": "jane_pass",
        "language": "french",
        "location": "France",
        "age": 28
    }
]
```
The file must be placed into next path: `src/main/resources/data/users.json`.

Once you had all requirements:

- go to the root address of the proyect
- runs `$ mvn install`
- runs `$ mvn clean package`
- runs `$ mvn springboot:run`
