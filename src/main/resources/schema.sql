DROP TABLE IF EXISTS people;

CREATE TABLE people
(
    id INT AUTO_INCREMENT primary key,
    name VARCHAR(255) not null,
    surname VARCHAR(255) not null,
    email VARCHAR (255) not null
);



