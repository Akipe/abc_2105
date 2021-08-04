Library - functional dependencies
=========

customers_id    -> customers_first_name, customers_last_name, customers_address, customers_deposit
books_id        -> books_title, books_editor, books_date_purchase, books_borrow_date, books_condition, customers_id
writers_id      -> writers_first_name, writers_last_name
