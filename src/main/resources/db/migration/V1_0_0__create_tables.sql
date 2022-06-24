CREATE TABLE customer (
    id BINARY(16) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE tennis_player (
    id BINARY(16) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE tennis_match (
    id BINARY(16) NOT NULL,
    start_date DATETIME NOT NULL,
    tennis_player_a_id BINARY(16) NOT NULL,
    tennis_player_b_id BINARY(16) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (tennis_player_a_id) REFERENCES TENNIS_PLAYER(id),
    FOREIGN KEY (tennis_player_b_id) REFERENCES TENNIS_PLAYER(id)
);

CREATE TABLE tennis_match_license (
    id BINARY(16) NOT NULL,
    customer_id BINARY(16) NOT NULL,
    tennis_match_id BINARY(16) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES CUSTOMER(id),
    FOREIGN KEY (tennis_match_id) REFERENCES TENNIS_MATCH(id)
);
