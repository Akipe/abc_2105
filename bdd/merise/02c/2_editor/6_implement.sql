DROP DATABASE IF EXISTS db_editor;

CREATE DATABASE IF NOT EXISTS db_editor;

USE db_editor;

CREATE TABLE books (
    book_isbn CHAR(10) PRIMARY KEY,
    book_title VARCHAR(128) NOT NULL,
    book_price SMALLINT UNSIGNED NOT NULL,
    book_price_currency CHAR(3) NOT NULL DEFAULT 'EUR',
    book_award_winning VARCHAR(256)
);

CREATE TABLE writers (
    writer_id INT PRIMARY KEY AUTO_INCREMENT,
    writer_firstname VARCHAR(64) NOT NULL,
    writer_lastname VARCHAR(64) NOT NULL,
    writer_nickname VARCHAR(64)
);

CREATE TABLE draft (
    book_isbn CHAR(10) NOT NULL,
    writer_id INT NOT NULL,
    FOREIGN KEY (book_isbn) REFERENCES books(book_isbn),
    FOREIGN KEY (writer_id) REFERENCES writers(writer_id)
);

CREATE TABLE editions (
    edition_id INT PRIMARY KEY AUTO_INCREMENT,
    edition_number TINYINT UNSIGNED NOT NULL,
    edition_release_date DATE NOT NULL,
    edition_stock INT UNSIGNED NOT NULL,
    edition_total_print INT UNSIGNED NOT NULL,
    book_isbn CHAR(10) NOT NULL,
    FOREIGN KEY (book_isbn) REFERENCES books(book_isbn)
);

CREATE TABLE bookstores (
    bookstore_name VARCHAR(128) PRIMARY KEY,
    bookstore_address_country VARCHAR(128) NOT NULL DEFAULT 'France',
    bookstore_address_city VARCHAR(128) NOT NULL,
    bookstore_address_postal_code CHAR(5) NOT NULL,
    bookstore_address_street VARCHAR(256) NOT NULL,
    bookstore_address_complement VARCHAR(256)
);

CREATE TABLE commands (
    command_id INT PRIMARY KEY, 
    command_date DATETIME NOT NULL,
    command_quantities INT NOT NULL,
    bookstore_name VARCHAR(128) NOT NULL,
    FOREIGN KEY (bookstore_name) REFERENCES bookstores(bookstore_name)
);

CREATE TABLE contains (
    edition_id INT NOT NULL,
    command_id INT NOT NULL,
    FOREIGN KEY (edition_id) REFERENCES editions(edition_id),
    FOREIGN KEY (command_id) REFERENCES commands(command_id)
);