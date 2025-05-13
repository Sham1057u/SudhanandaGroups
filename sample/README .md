Description:A simple Spring Boot REST API for managing users using PostgreSQL.

pre-requsites:
First i  downloaded the springboot project with necessary dependency like spring web, spring data jpa,dev tools, postgresql driver from spring initializer
then connected the application with database with the help of database url,name and password.

Tech stacks are:
  Spring Boot(framework)
  PostgreSQL(Database)
  Spring Data JPA(ORM)
  Maven(Build tool)
  
  
Database related configuration in application.properties file:

spring.datasource.url=jdbc:postgresql://localhost:5432/UserManagement
spring.datasource.username=postgres
spring.datasource.password=Sdmd8197
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true


Database schema files:present inn resources folder with name data.sql and schema.sql


ENDPOINTS:


HTTP			 Method							Endpoint	Description
GET				/api/check						Check if the API is working
GET				/api/users/{user_id}			Get user details by user ID
POST			/api/users						Add a new user
DELETE			/api/users/{user_id}			Delete a user by ID
GET				/api/users						Get a list of all users
PUT				/api/users/{user_id}			Update user details by ID
GET			 /api/findbyusername/{username}		Get user details by username
GET				/api/findbystatus/{status}		Get user details by status

Also, implemented the validation with the help of @Valid at controller and @NotBlank and @Email in the UserDTO class so that if a request came with invalid data the controller reach the GlobalException  class and sends the error message to the user.
pushed the project to the git with url:https://github.com/Sham1057u/SudhanandaGroups


