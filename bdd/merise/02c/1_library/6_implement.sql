DROP DATABASE IF EXISTS library_db;

CREATE DATABASE IF NOT EXISTS library_db;

USE library_db;

CREATE TABLE customers
(
    customers_id INT PRIMARY KEY AUTO_INCREMENT,
    customers_first_name VARCHAR(64) NOT NULL,
    customers_last_name VARCHAR(64) NOT NULL,
    customers_address VARCHAR(64) NOT NULL,
    customers_deposit TINYINT NULL
);

CREATE TABLE books
(
    books_id INT PRIMARY KEY,
    books_title VARCHAR(256) NOT NULL,
    books_editor VARCHAR(256) NOT NULL,
    books_date_purchase DATE NOT NULL,
    books_borrow_date DATE NULL,
    books_condition VARCHAR(512),
    customers_id INT,
    FOREIGN KEY (customers_id) REFERENCES customers(customers_id)
);

CREATE TABLE writers
(
    writers_id INT PRIMARY KEY,
    writers_first_name VARCHAR(64) NOT NULL,
    writers_last_name VARCHAR(64) NOT NULL
);

CREATE TABLE draft
(
    books_id INT NOT NULL,
    writers_id INT NOT NULL,
    FOREIGN KEY (books_id) REFERENCES books(books_id),
    FOREIGN KEY (writers_id) REFERENCES writers(writers_id)
);
