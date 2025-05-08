CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    status VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

--Didn't write this sql manually, but implemented with the help of Spring data jpa(spring.jpa.hibernate.ddl-auto=create)