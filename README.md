# User Service

## 🎯 Purpose
The **User Service** is responsible for managing user accounts, authentication data, roles, and tracking what media a user has watched (Viewing History). This service acts as the source of truth for all user-related data.

## 🧑‍💻 Developer Guidelines
1. **API Responses**: ALL endpoints MUST return responses wrapped in the `ApiResponse<T>` class located in `dto/ApiResponse.java`. Do not return raw entities or raw `ResponseEntity<T>` directly without wrapping it.
2. **Exceptions**: Throw `ResourceNotFoundException`, `BadRequestException`, or `DuplicateResourceException` when business rules are violated. The `GlobalExceptionHandler` will automatically catch these and return the correct HTTP status code and `ApiResponse` format.
3. **Database**: We are using PostgreSQL. The credentials and port (`5433`) are injected automatically via the Config Server. Do not hardcode credentials in your `application.yml`.
4. **Validation**: Use `spring-boot-starter-validation` annotations (`@NotBlank`, `@Email`, etc.) on your DTOs. The GlobalExceptionHandler already handles `MethodArgumentNotValidException`.

---

## 🏗️ Data Models (Entities & Enums)

You need to implement the following entities and enums. 

### 1. `Role` (Enum)
Defines the authorization level of a user.
* `USER`
* `ADMIN`

### 2. `User` (Entity)
Represents a platform user.
* `id` (UUID or Long, Primary Key)
* `username` (String, Unique, Not Null)
* `email` (String, Unique, Not Null, Valid Email format)
* `password` (String, Not Null)
* `role` (Role Enum, Default: `USER`)
* `createdAt` (LocalDateTime)
* `updatedAt` (LocalDateTime)

### 3. `ViewingHistory` (Entity)
Tracks what a user has watched and their progress. This will require Feign Client integration with `media-service` later.
* `id` (UUID or Long, Primary Key)
* `userId` (Foreign Key referencing User, Not Null)
* `mediaId` (Foreign Key referencing Media from `media-service`, Not Null)
* `watchDate` (LocalDateTime, Default: Now)
* `progress` (Integer, percentage 0-100)

---

## 🛣️ Required Endpoints (CRUD)
You must implement a Controller with the following standard operations:
* `POST /api/v1/users/register` - Register a new user
* `GET /api/v1/users/{id}` - Get user details by ID
* `GET /api/v1/users/email/{email}` - Get user details by Email
* `PUT /api/v1/users/{id}` - Update user details
* `DELETE /api/v1/users/{id}` - Delete a user
* `GET /api/v1/users/{id}/history` - Retrieve the viewing history for a user
* `POST /api/v1/users/{id}/history` - Add a new record to the viewing history
