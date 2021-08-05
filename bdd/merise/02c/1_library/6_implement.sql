DROP DATABASE IF EXISTS library;

CREATE DATABASE IF NOT EXISTS library;

CREATE TABLE customers
(
    customers_id INT PRIMARY KEY,
    customers_first_name VARCHAR(64) NOT NULL,
    customers_last_name VARCHAR(64) NOT NULL,
    customers_address VARCHAR(64) NOT NULL,
    customers_deposit TINYINT NULL
);

CREATE TABLE books
();

CREATE TABLE write
();

CREATE TABLE writers
();