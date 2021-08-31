DROP DATABASE IF EXISTS db_horse_bet;

CRETAE DATABASE IF NOT EXISTS db_horse_bet;

USE db_horse_bet;

CREATE TABLE races (
    race_id INT PRIMARY KEY AUTO_INCREMENT,
    race_name VARCHAR(256) NOT NULL,
    race_start DATETIME NOT NUL
);

CREATE TABLE horses (
    horse_name VARCHAR(64) PRIMARY KEY
);

CREATE TABLE bets (
    bet_id INT PRIMARY KEY AUTO_INCREMENT,
    bet_amount SMALLINT NOT NULL,
    race_id INT NOT NULL,
    FOREIGN KEY (race_id) REFERENCES races(race_id)
);

CREATE TABLE run (
    race_id INT NOT NULL,
    horse_name VARCHAR(64) NOT NULL,
    race_horse_number TINYINT NOT NULL,
    race_horse_rank TINYINT NOT NULL,
    FOREIGN KEY (race_id) REFERENCES races(race_id),
    FOREIGN KEY (horse_name) REFERENCES horses(horse_name)
);

CREATE TABLE selected (
    bet_id INT NOT NULL,
    horse_name VARCHAR(64) NOT NULL,
    bet_horse_placement TINYINT NOT NULL,
    FOREIGN KEY (bet_id) REFERENCES bets(bet_id),
    FOREIGN KEY (horse_name) REFERENCES horses(horse_name)
);

