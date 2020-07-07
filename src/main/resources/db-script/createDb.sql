DROP TABLE Item IF EXISTS;
DROP TABLE MerchandiseHierarchy IF EXISTS;

CREATE TABLE Item  (
    sku BIGINT IDENTITY NOT NULL PRIMARY KEY,
    name VARCHAR(20),
    description VARCHAR(20),
    longDescription VARCHAR(80),
    category VARCHAR(20),
    price BIGINT,
    authorizedForSale VARCHAR(20),
    dateImported DATE
);

CREATE TABLE MerchandiseHierarchy (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    division VARCHAR(20),
    group VARCHAR(20),
    department VARCHAR(20),
    category VARCHAR(20),
    class VARCHAR(20),
    dateImported DATE
)
