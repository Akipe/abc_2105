Editor - functional dependencies
===========

**book_isbn**           -> book_title, book_price, book_price_currency, book_award_winning

**author_id**           -> author_firstname, author_lastname, author_nickname

**edition_id**          -> edition_number, edition_release_date, edition_stock, edition_total_print, *#book_isbn*

**bookstore_name**      -> bookstore_address_country, bookstore_address_city, bookstore_address_postal_code, bookstore_address_street, bookstore_address_complement

**order_id**            -> order_quantities, order_date, *#bookstore_name*