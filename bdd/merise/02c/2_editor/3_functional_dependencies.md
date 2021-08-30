Editor - functional dependencies
===========

**book_isbn**           -> book_title, book_price, book_price_currency, book_award_winning

**writer_id**           -> writer_firstname, writer_lastname, writer_nickname

**edition_id**          -> edition_number, edition_release_date, edition_stock, edition_total_print, *#book_isbn*

**bookstore_name**      -> bookstore_address_country, bookstore_address_city, bookstore_address_postal_code, bookstore_address_street, bookstore_address_complement

**command_id**            -> command_quantities, command_date, *#bookstore_name*