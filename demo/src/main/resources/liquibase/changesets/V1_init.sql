CREATE TABLE IF NOT EXISTS words (
    id   BIGSERIAL PRIMARY KEY,
    word VARCHAR(255) NOT NULL
    );

TRUNCATE TABLE words;

COPY words (word)
    FROM 'D:\russian.txt'
    WITH (
    FORMAT TEXT,
    ENCODING 'UTF8'
    );