# Employee-Management-System-Java

A Spring Boot web application for managing employee records with basic CRUD operations and search functionality.

## Features

- **Employee Management**
  - View all employees
  - Add new employees
  - Update existing employee details
  - Delete individual employees
  - Delete all employees with confirmation

- **Search Functionality**
  - Search employees by name (case-insensitive)
  - Real-time search results
  - Clear search functionality

- **User Interface**
  - Clean and responsive design using Bootstrap
  - Intuitive navigation
  - Confirmation dialogs for delete operations
  - User-friendly forms for data entry

## Technology Stack

- **Backend**
  - Java 11
  - Spring Boot 2.7.0
  - Spring Data JPA
  - MySQL Database

- **Frontend**
  - Thymeleaf template engine
  - Bootstrap 4.5.2
  - HTML5
  - JavaScript

## Database Configuration

The application uses MySQL database. To configure the database connection:

1. Open `src/main/resources/application.properties`
2. Update the following properties:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/employee_management?useSSL=false
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

## Running the Application

1. **Prerequisites**
   - Java 11 or higher
   - Maven
   - MySQL

2. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd employee-management
   ```

3. **Create the database**
   ```sql
   CREATE DATABASE employee_management;
   ```

4. **Build and run**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

5. **Access the application**
   - Open a web browser
   - Navigate to `http://localhost:8080`

## API Endpoints

- `GET /` - View all employees and search
- `GET /showNewEmployeeForm` - Display form to add new employee
- `POST /saveEmployee` - Save new or updated employee
- `GET /showFormForUpdate/{id}` - Display form to update employee
- `GET /deleteEmployee/{id}` - Delete specific employee
- `GET /deleteAll` - Delete all employees

## Database Schema

The Employee table contains the following fields:
- id (Primary Key)
- name
- email
- phone
- address
- department

## Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a new Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.
