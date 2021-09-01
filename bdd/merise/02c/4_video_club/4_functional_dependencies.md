Video club - functional dependencies
==========

# Simple

**store_id**                -> store_name, store_address_city, store_address_postal_code, store_address_street, store_address_complement

**customer_id**             -> customer_firstname, customer_lastname, customer_caution, customer_address_country, customer_address_city, customer_address_postal_code, customer_address_street, customer_address_complement

**cassette_id**             -> cassette_start_date, cassette_number_borrow, cassette_condition

**film_genre_name**         -> film_genre_type_public

**film_worker_id**          -> film_worker_firstname, film_worker_lastname

**film_operating_license**  -> film_duration_minutes, film_title, film_director

# Complex