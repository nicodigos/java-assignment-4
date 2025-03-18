# Assignment4 - Simple Student Management System

## Overview

This project is a simple **Student Management System** implemented using **Spring Boot**. The application allows you to perform basic CRUD operations (Create, Read, Update, Delete) on a list of students. The data is stored temporarily in memory, using a `List<Student>`. 

## Features
- Add a new student with validation (name, email, age).
- View a list of all students in a table.
- Delete a student by their ID.
- Export all students in **JSON** format.
- Basic validation to ensure:
  - Name is between 2 and 40 characters.
  - Email is valid.
  - Age is at least 18.
  
## Technologies Used
- **Spring Boot** - For building the application.
- **Thymeleaf** - For rendering HTML templates.
- **Spring Validation** - For input validation.
- **MockMvc** - For unit testing controller endpoints.
- **JUnit 5** - For writing unit tests.

## Project Setup

### Prerequisites
- **Java 17** or higher.
- **Gradle** (To manage dependencies and build the project).
- **IDE** (e.g., IntelliJ IDEA or Eclipse).

### How to Run the Project

1. **Clone the Repository**:
    ```bash
    git clone <repository-url>
    cd assignment4
    ```

2. **Build the Project** using Gradle:
    ```bash
    ./gradlew build
    ```

3. **Run the Application**:
    ```bash
    ./gradlew bootRun
    ```
    The application will start on `http://localhost:8080`.

### API Endpoints

1. **GET /students**  
   - Displays a list of all students in HTML format.
   
2. **GET /students/new**  
   - Displays a form to add a new student.

3. **POST /students/save**  
   - Submits the form to add a new student.
   - **Validation**: 
     - Ensures that the name, email, and age are valid.

4. **DELETE /students/delete/{id}**  
   - Deletes a student by their `id`.

5. **GET /students/json**  
   - Returns all students in **JSON** format.

### Unit Tests
The project includes unit tests for both the controller and the service layer. You can run the tests with the following command:

```bash
./gradlew test
