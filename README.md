# Olympics and Athletes Management

Welcome to the **Olympics and Athletes Management** project! This project is a **Spring Boot** application that manages records of Olympic Games and their associated athletes using a **many-to-many** relationship in a MySQL database.

## Project Overview

This application allows you to:

- **Create** and manage records of Olympic Games.
- **Add** athletes to the Olympic Games.
- **Retrieve** information about the Olympic Games, including the athletes participating.
- **Update** and **delete** records as needed.

### Key Features

- **Many-to-Many Relationship**: Each Olympic Games event can have multiple athletes, and each athlete can participate in multiple Olympic Games.
- **DTOs and Conversion**: Data Transfer Objects (DTOs) are used to transfer data between the service and the controller layers, ensuring a clean separation of concerns.
- **Custom Converters**: Custom converters are implemented to handle the conversion between entities and DTOs, especially for the many-to-many relationship.

## Database Schema

The database schema includes two main entities: **Olympics** and **Athletes**. The many-to-many relationship between them is managed by an intermediate table, `athlete_olympics`, which stores the associations.

### `athlete_olympics` Table Structure

| olympics_id | athlete_id |
|-------------|------------|
| 1           | 1          |
| 1           | 2          |
| 2           | 1          |
| 2           | 3          |

This table links the `Olympics` and `Athletes` tables, allowing you to track which athletes participated in which Olympic Games.

## Endpoints

### Olympics Endpoints

- `GET /olympics`: Retrieve a list of all Olympic Games.
- `GET /olympics/{id}`: Retrieve details of a specific Olympic Games, including participating athletes.
- `POST /olympics`: Create a new Olympic Games record.
- `PUT /olympics/{id}`: Update an existing Olympic Games record.
- `DELETE /olympics/{id}`: Delete an Olympic Games record.

### Athletes Endpoints

- `GET /athletes`: Retrieve a list of all athletes.
- `GET /athletes/{id}`: Retrieve details of a specific athlete, including their Olympic Games.
- `POST /athletes`: Create a new athlete record.
- `PUT /athletes/{id}`: Update an existing athlete record.
- `DELETE /athletes/{id}`: Delete an athlete record.

## Getting Started

### Prerequisites

- **Java 17** or later
- **Spring Boot 3.x**
- **Spring Data JPA**
- **MySQL** for database management
- **Maven** for dependency management

