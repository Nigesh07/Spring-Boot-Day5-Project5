# Bug Tracker Console App

A simple console-based bug tracker built in Java with JDBC and MySQL.

## Project Structure

- `src/main/java/com/day5/App.java` - Main entry point and console menu
- `src/main/java/com/day5/model/Bug.java` - Bug model object
- `src/main/java/com/day5/dao/BugDao.java` - DAO interface for CRUD operations
- `src/main/java/com/day5/dao/BugDaoImpl.java` - JDBC implementation of `BugDao`
- `src/main/java/com/day5/util/DatabaseUtil.java` - JDBC connection utility and database/table initialization
- `src/main/resources/db.properties` - Database connection configuration
- `create_bug_tracker_db.sql` - SQL script to create the `bugtracker` database and `bugs` table

## Prerequisites

- Java 8 or later
- Maven
- MySQL server

## Setup

1. Configure your database connection in `src/main/resources/db.properties`:

```properties
db.driver=com.mysql.jdbc.Driver
db.url=jdbc:mysql://localhost:3306/bugtracker?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
db.username=YOUR_DB_USER
db.password=YOUR_DB_PASSWORD
```

2. Optionally, create the database manually using `create_bug_tracker_db.sql`:

```sql
CREATE DATABASE IF NOT EXISTS bugtracker;
USE bugtracker;
CREATE TABLE IF NOT EXISTS bugs (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  description TEXT,
  status VARCHAR(50) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

3. Build the project:

```bash
mvn clean compile
```

## Run

Start the console app with Maven:

```bash
mvn exec:java
```

Then use the menu to:

1. Add Bug
2. View All Bugs
3. Update Bug Status
4. Delete Bug
5. Exit

## Notes

- The app automatically creates the `bugtracker` database and `bugs` table if they do not exist, provided the configured user has sufficient privileges.
- If you encounter `Access denied` or connection errors, double-check your MySQL credentials and ensure the MySQL server is running.
