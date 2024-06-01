# MediaWave CRUD API

This project is a CRUD (Create, Read, Update, Delete) API for managing student records in the MediaWave application. It provides endpoints for creating, retrieving, updating, and deleting student records.

## Technologies Used

- Java
- Spring Boot
- Google Cloud Firestore
- Postman (for testing APIs)

## Project Structure

The project is structured as follows:

- `src/main/java/com/mediawave/mediawave/controller`: Contains the controller classes defining API endpoints.
- `src/main/java/com/mediawave/mediawave/model`: Contains the model classes representing the data structure.
- `src/main/java/com/mediawave/mediawave/service`: Contains the service classes implementing the business logic.

## API Endpoints

- `POST /`: Create a new student record.
- `GET /student?id={id}`: Retrieve a student record by ID.
- `GET /`: Retrieve all student records.
- `PUT /update`: Update an existing student record.
- `DELETE /delete?id={id}`: Delete a student record by ID.

## How to Run

1. Clone the repository: `git clone <repository-url>`
2. Navigate to the project directory: `cd mediawave`
3. Build the project: `mvn clean install`
4. Run the application: `mvn spring-boot:run`

The application will start on port 8080 by default.

## Testing the API

You can use tools like Postman to test the API endpoints. Here's how to test each endpoint:

1. **Create a new student record**:
   - Endpoint: `POST http://localhost:8080/`
   - Request body: JSON object representing the student data.

2. **Retrieve a student record by ID**:
   - Endpoint: `GET http://localhost:8080/student?id={id}`
   - Replace `{id}` with the ID of the student you want to retrieve.

3. **Retrieve all student records**:
   - Endpoint: `GET http://localhost:8080/`

4. **Update an existing student record**:
   - Endpoint: `PUT http://localhost:8080/update`
   - Request body: JSON object representing the updated student data.

5. **Delete a student record by ID**:
   - Endpoint: `DELETE http://localhost:8080/delete?id={id}`
   - Replace `{id}` with the ID of the student you want to delete.

Make sure to replace `localhost:8080` with the appropriate host and port if the application is running on a different server.

