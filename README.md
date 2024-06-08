# Spring Boot Rest API with multiple DB connections

Unit testing with Junit 5, Integration tests, Maven

## What You Need
- IDE
- Java 17 or later
- Maven 3.9.5

You can also import the code straight into your IDE:
- IntelliJ IDEA

Download and unzip the source repository or clone it using Git:

```
git clone https://github.com/dmaberlin1/compar-demo.git
```

## Test the Application
Using the Maven plugin open project and from README click:

```shell
mvn clean install 
```

```shell
mvn spring-boot:run -pl compar-src
```

OR

run `compar-src/src/main/java/com/dmadev/ComparSrcApplication.java` from IntelliJ IDEA

### Retrieving Data

To retrieve user data, a single REST endpoint is used:

**URL**: http://localhost:8080/api/v1/users

This endpoint returns a list of users from all databases. The first two records in the list are retrieved from one database, and the next two from another.

```
[{
"id": "1",
"username": "username",
"name": "Demo",
"surname": "DemoSurname"
},{
"id": "2",
"username": "username2",
"name": "Demo2",
"surname": "DemoSurname2"
},{
"id": "3",
"username": "username3",
"name": "Demo3",
"surname": "DemoSurname3"
},
]
```

You can filter and sort users by id, username, name, surname:
using the `/api/v1/users` endpoint:

Example Requests:

- **Filtering by ID**: [http://localhost:8080/api/v1/users?id=1](http://localhost:8080/api/v1/users?id=1)
- **Filtering by username**: [http://localhost:8080/api/v1/users?username=b](http://localhost:8080/api/v1/users?username=b)

- **Sorting by username in descending order**: [http://localhost:8080/api/v1/users?sort=username&order=desc](http://localhost:8080/api/v1/users?sort=username&order=desc)


- **URL**:  [http://localhost:8080/api/v1/users?id=1](http://localhost:8080/api/v1/users?id=1)
-  **URL**: [http://localhost:8080/api/v1/users?username=b](http://localhost:8080/api/v1/users?username=b)

Also sorting is available by username, name, and surname:
-  **URL**: [http://localhost:8080/api/v1/users?sort=username&order=desc](http://localhost:8080/api/v1/users?sort=username&order=desc)
-  **URL**: [http://localhost:8080/api/v1/users?sort=username&order=asc](http://localhost:8080/api/v1/users?sort=username&order=asc)

### Searching Users

You can search for users based on various criteria using the `/api/v1/users` endpoint:

- **Parameters**:
  - `id`: User identifier for search (optional).
  - `username`: User name for search (optional).
  - `sort`: Parameter for sorting the search results (optional). Specify the field by which to sort (e.g., 'username', 'name', 'surname').
  - `order`: Parameter for specifying the sorting order (`asc` or `desc`) (optional). Defaults to `asc` if not provided.

## H2 in memory DB console
- **URL**: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- **JDBC URL**: `jdbc:h2:mem:compar`
- **User Name**: demo
- **Password**: demo

- **JDBC URL**: `jdbc:h2:mem:compar2`
- **User Name**: demo
- **Password**: demo

- **JDBC URL**: `jdbc:h2:mem:compar3`
- **User Name**: demo
- **Password**: demo

## Swagger 3 UI (with OpenAPI 3)

- **URL**: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- **OpenAPI Specification**: [http://localhost:8080/openapi.yaml](http://localhost:8080/openapi.yaml)
