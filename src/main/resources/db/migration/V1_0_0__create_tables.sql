CREATE TABLE customer (
    id INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id)
);

CREATE TABLE tennis_player (
    id INT NOT NULL AUTO_INCREMENT,
    tennis_player_id VARCHAR(100) UNIQUE NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE tennis_match (
    id INT NOT NULL AUTO_INCREMENT,
    match_id VARCHAR(100) UNIQUE NOT NULL,
    start_date DATETIME NOT NULL,
    zone_id VARCHAR(100) NOT NULL,
    tennis_player_a_id INT NOT NULL,
    tennis_player_b_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (tennis_player_a_id) REFERENCES TENNIS_PLAYER(id),
    FOREIGN KEY (tennis_player_b_id) REFERENCES TENNIS_PLAYER(id)
);

CREATE TABLE tennis_match_license (
    id INT NOT NULL AUTO_INCREMENT,
    customer_id INT NOT NULL,
    tennis_match_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES CUSTOMER(id),
    FOREIGN KEY (tennis_match_id) REFERENCES TENNIS_MATCH(id)
);
