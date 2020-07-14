CREATE TABLE Item  (
    sku integer NOT NULL PRIMARY KEY,
    name varchar(20),
    description varchar(20),
    longDescription varchar(80),
    category varchar(20),
    price integer,
    authorizedForSale varchar(20),
    dateImported date
);

CREATE TABLE MerchandiseHierarchy (
    division varchar(20) NOT NULL PRIMARY KEY,
    merchandiseGroup varchar(20),
    department varchar(20),
    category varchar(20),
    merchandiseClass varchar(20),
    dateImported date
)
