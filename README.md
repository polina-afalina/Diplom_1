# Stellar Burgers Unit Testing Project

## Overview

This project was created as part of Yandex Practicum QA automation course and focuses on writing automated unit tests for the core components of the [Stellar Burgers](https://stellarburgers.nomoreparties.site/) web application.

The goal of the project was to practice unit testing principles, validate application logic, work with test data, and analyze test coverage using Java testing tools.

## Tested Components

The test suite covers the core business logic of a Java burger-building application, ensuring correctness of object behavior and interactions.

Key areas include:

- Burger construction logic (bun assignment, ingredient management, and price calculation)
- Domain models (Bun and Ingredient data integrity)
- Receipt generation and formatting
- Ingredient type classification and validation
- Core edge cases such as invalid enum usage and list operations

## Testing Approach

The test suite includes:

- Unit tests for individual classes and methods
- Parameterized tests for testing multiple input scenarios
- Assertions to verify expected application behavior
- Mocking support for isolated component testing
- Code coverage analysis

## Technologies Used

- **Java 11** — core language for application logic and unit testing  
- **Maven** — build automation and dependency management  
- **JUnit 4** — unit testing framework  
- **Mockito** — mocking framework for isolated unit tests  
- **JaCoCo** — code coverage reporting and analysis

## Requirements

Before running the project, make sure you have installed:

- Java JDK 11 or higher
- Apache Maven

Check installation:

```bash
java -version
mvn -version
```

## Running Tests

Clone the repository:

```bash
git clone <repository-url>
```

Navigate to the project folder:

```bash
cd <project-folder>
```

Run tests:

```bash
mvn clean test
```

## Generating Test Coverage Report

Run:

```bash
mvn clean verify
```

After execution, open the generated report:

```
target/site/jacoco/index.html
```

The report contains information about executed tests and code coverage.
