

# ContentService

The `ContentService` is a microservice of the Agripulse project,
designed to manage and handle the creation, retrieval, update, and deletion of posts and comments 
related to agricultural products and services.

## Overview

`ContentService` handles the CRUD operations for posts and comments in the Agripulse project. This service allows farmers to post their products for sale, rent, or lease, and manage related comments. It provides an API to interact with these posts and comments, integrating with other microservices to support a seamless experience for users.

## Features

- **Post Management**: Allows users to create, retrieve, update, and delete posts related to agricultural products and services.
- **Comment Management**: Supports CRUD operations for comments on posts.
- **Pagination**: Provides pagination for retrieving posts to handle large data sets efficiently.

## Technologies Used

- **Java**: The primary programming language for developing the service.
- **Spring Boot**: Framework for building and running the microservice.
- **Spring Data JPA**: Handles data persistence with MySQL.
- **MySQL**: Database for storing posts and comments.
- **JUnit**: Framework for writing unit tests.
- **Mockito**: Library for creating mock objects in tests.
- **Maven**: Build automation tool used for project management.
- **IntelliJ IDEA**: Integrated Development Environment (IDE) used for development.
- **Postman**: Tool for testing API endpoints.

## Installation and Setup

### Prerequisites

- **Java 17 or later**: Ensure Java is installed and configured.
- **Maven**: Install Maven for building and running the application.
- **MySQL**: Install and set up a MySQL database.

### Steps to Set Up

1. **Clone the Repository:**
    ```sh
    git clone https://github.com/d2j1/agripulse-content-service.git
    cd agripulse-content-service
    ```

2. **Configure Database:**

    Edit the `src/main/resources/application.properties` file to configure your MySQL database connection.
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/agripulse_db
    spring.datasource.username=[your_username]
    spring.datasource.password=[your_password]
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
    ```
    Replace `[your_username]` and `[your_password]` with your MySQL credentials.

3. **Build and Run the Application:**
    ```sh
    mvn clean install
    mvn spring-boot:run
    ```

4. **Use Postman or a similar tool to interact with the API endpoints.**

## API Endpoints

### Post Endpoints

- **Get All Posts**
  - `GET /posts/`
  - Retrieves a paginated list of all posts.

- **Get Post by ID**
  - `GET /posts/{id}`
  - Retrieves details of a specific post by its ID.

- **Create Post**
  - `POST /posts/create`
  - Creates a new post with the provided details.

- **Update Post**
  - `PUT /posts/update/{id}`
  - Updates an existing post with the given ID.

- **Delete Post**
  - `DELETE /posts/{id}`
  - Deletes a post with the specified ID.

### Comment Endpoints

- **Get All Comments**
  - `GET /comments/`
  - Retrieves a list of all comments.

- **Get Comment by ID**
  - `GET /comments/{id}`
  - Retrieves details of a specific comment by its ID.

- **Create Comment**
  - `POST /comments/create`
  - Creates a new comment with the provided details.

- **Update Comment**
  - `PUT /comments/{id}`
  - Updates an existing comment with the specified ID.

- **Delete Comment**
  - `DELETE /comments/{id}`
  - Deletes a comment with the given ID.


## Integration with Other Services

`ContentService` integrates with the `UserService` to manage posts and comments related to users.
It ensures that only authorized users can perform certain operations based on their roles.

## Testing
Use Postman or a similar tool to interact with the API endpoints.

## Contributing
We'd like to hear from you about contributions to improve Agripulse. Please fork the repositories and submit pull requests with detailed explanations of your changes.

## Contact
For any questions or suggestions, please open an issue in the respective repositories or contact me at [dhananjayjadhav2151@gmail.com].

Thank You!
