DROP TABLE IF EXISTS countries;
DROP TABLE IF EXISTS continents;
DROP TABLE IF EXISTS persons;


CREATE TABLE continent
(
    code VARCHAR(2)   NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE country
(
    code           VARCHAR(2)   NOT NULL PRIMARY KEY,
    name           VARCHAR(100) NOT NULL,
    phone          INTEGER      NOT NULL,
    symbol         VARCHAR(10),
    capital        VARCHAR(80),
    currency       VARCHAR(3),
    continent_code VARCHAR(2),
    alpha_3        VARCHAR(3),
    updated_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (continent_code) REFERENCES continent (code) ON DELETE SET NULL
);

CREATE TABLE person
(
    id           BIGSERIAL PRIMARY KEY,
    last_name    VARCHAR(100),
    first_name   VARCHAR(100) NOT NULL,
    country_code VARCHAR(2),
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (country_code) REFERENCES country (code) ON DELETE SET NULL
);

CREATE INDEX idx_person_country_code ON person (country_code);


