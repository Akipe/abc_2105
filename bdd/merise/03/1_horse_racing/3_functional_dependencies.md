Horse racing - functional dependencies
========

### Simple

**race_id**         -> race_name, race_start

**bet_id**          -> bet_amount, *#race_id*

**horse_name**

### Compound functional dependencies

**race_id**         -> race_name, race_start, *#bet_id*, *#horse_name*, race_horse_number, race_horse_rank

**horse_name**      -> *race_horse_number*, *race_horse_rank*, *#race_id*, *bet_horse_placement*, *#bet_id*

**bet_id**          -> *bet_horse_placement*, *#horse_name*
