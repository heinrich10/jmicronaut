DROP TABLE IF EXISTS countries;
DROP TABLE IF EXISTS continents;
DROP TABLE IF EXISTS persons;


create table continents
(
    code VARCHAR(2)   not null
        primary key,
    name VARCHAR(100) not null
);

create table countries
(
    code           VARCHAR(2)   not null
        primary key,
    name           VARCHAR(100) not null,
    phone          INTEGER      not null,
    symbol         VARCHAR(10),
    capital        VARCHAR(80),
    currency       VARCHAR(3),
    continent_code VARCHAR(2)
        references continents,
    alpha_3        VARCHAR(3)
);

create table persons
(
    id           INTEGER      not null
        primary key auto_increment,
    last_name    VARCHAR(100),
    first_name   VARCHAR(100) not null,
    country_code VARCHAR(2)
        references countries
);


