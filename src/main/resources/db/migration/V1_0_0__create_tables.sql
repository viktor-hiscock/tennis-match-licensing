DROP TABLE IF EXISTS tennis_tournament_license;
DROP TABLE IF EXISTS tennis_match_license;
DROP TABLE IF EXISTS tennis_match;
DROP TABLE IF EXISTS tennis_tournament;
DROP TABLE IF EXISTS tennis_player;
DROP TABLE IF EXISTS customer;

CREATE TABLE tennis_player (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE tennis_tournament (
    id INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id)
);

CREATE TABLE tennis_match (
    id INT NOT NULL AUTO_INCREMENT,
    tennis_tournament_id INT,
    start_date DATETIME NOT NULL,
    zone_id VARCHAR(100) NOT NULL,
    tennis_player_a_id INT NOT NULL,
    tennis_player_b_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (tennis_player_a_id) REFERENCES TENNIS_PLAYER(id),
    FOREIGN KEY (tennis_player_b_id) REFERENCES TENNIS_PLAYER(id),
    FOREIGN KEY (tennis_tournament_id) REFERENCES tennis_tournament(id)
);

CREATE TABLE tennis_match_license (
    id INT NOT NULL AUTO_INCREMENT,
    tennis_match_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (tennis_match_id) REFERENCES TENNIS_MATCH(id)
);

CREATE TABLE tennis_tournament_license (
    id INT NOT NULL AUTO_INCREMENT,
    tennis_tournament_license_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (tennis_tournament_license_id) REFERENCES TENNIS_TOURNAMENT(id)
);

CREATE TABLE customer (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    date_of_birth DATETIME NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    PRIMARY KEY (id)
);

CREATE TABLE customer_tennis_match_license (
    customer_id INT NOT NULL,
    tennis_match_license_id INT NOT NULL,
    PRIMARY KEY (customer_id, tennis_match_license_id),
    FOREIGN KEY (customer_id) REFERENCES CUSTOMER(id),
    FOREIGN KEY (tennis_match_license_id) REFERENCES TENNIS_MATCH_LICENSE(id)
);