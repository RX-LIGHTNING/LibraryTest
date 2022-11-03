CREATE TABLE authors (
    ID int NOT NULL AUTO_INCREMENT,
    name varchar(255),
    PRIMARY KEY (id)

);
CREATE TABLE publishers (
    id int NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    PRIMARY KEY (id)
);
CREATE TABLE printed_products (
    id int NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    publishDate DATE,
    type_id int,
        PRIMARY KEY (id)
);
CREATE TABLE product_author(
    id int NOT NULL AUTO_INCREMENT,
    author_id int,
    PRINTED_PRODUCT int,
    FOREIGN KEY (author_id) REFERENCES authors ON DELETE CASCADE,
    FOREIGN KEY (PRINTED_PRODUCT) REFERENCES printed_products ON DELETE CASCADE,
    PRIMARY KEY (id)
);
CREATE TABLE product_publisher(
    id int NOT NULL AUTO_INCREMENT,
    publisher_id int,
    PRINTED_PRODUCT int,
    FOREIGN KEY (publisher_id) REFERENCES publishers ON DELETE CASCADE,
    FOREIGN KEY (PRINTED_PRODUCT) REFERENCES printed_products ON DELETE CASCADE,
    PRIMARY KEY (id)
);
CREATE TABLE PRODUCT_TYPE(
    id int NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    primary key(id)
);
alter table printed_products
    ADD FOREIGN KEY (type_id) REFERENCES PRODUCT_TYPE(id)
    ON DELETE CASCADE;