CREATE TABLE IF NOT EXISTS words
(
    id   bigint PRIMARY KEY,
    word varchar(255) not null unique
);