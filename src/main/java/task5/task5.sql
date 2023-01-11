CREATE DATABASE MyShop;

CREATE TABLE IF NOT EXISTS Categories
(
    CategoryID   serial PRIMARY KEY,
    CategoryName VARCHAR(256) NOT NULL,
    Description  TEXT         NOT NULL
);

CREATE TABLE IF NOT EXISTS Suppliers
(
    SupplierID   serial PRIMARY KEY,
    SupplierName VARCHAR(256) NOT NULL,
    City         VARCHAR(128) NOT NULL,
    Country      VARCHAR(128) NOT NULL
);

CREATE TABLE IF NOT EXISTS Products
(
    ProductID   serial PRIMARY KEY,
    ProductName VARCHAR(256)   NOT NULL,
    SupplierID  INT            NOT NULL,
    CategoryID  INT            NOT NULL,
    Price       NUMERIC(10, 2) NOT NULL,

    FOREIGN KEY (SupplierID)
        REFERENCES Suppliers (SupplierID)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,

    FOREIGN KEY (CategoryID)
        REFERENCES Categories (CategoryID)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

INSERT INTO Categories
VALUES (DEFAULT, 'Beverages', 'Soft drinks, coffees, teas, beers, and ales'),
       (DEFAULT, 'Condiments', 'Sweet and savory sauces, relishes, spreads, and seasonings'),
       (DEFAULT, 'Confections', 'Desserts, candies, and sweet breads'),
       (DEFAULT, 'Dairy Products', 'Cheeses'),
       (DEFAULT, 'Grains/Cereals', 'Breads, crackers, pasta, and cereal');

INSERT INTO Suppliers
VALUES (DEFAULT, 'Exotic Liquid', 'London', 'UK'),
       (DEFAULT, 'New Orleans Cajun Delights', 'New Orleans', 'USA'),
       (DEFAULT, 'Grandma Kelly’s Homestead', 'Ann Arbor', 'USA'),
       (DEFAULT, 'Tokyo Traders', 'Tokyo', 'Japan'),
       (DEFAULT, 'Cooperativa de Quesos ‘Las Cabras’', 'Oviedo', 'Spain');

INSERT INTO Products
VALUES (DEFAULT, 'Chais', 1, 1, 18.00),
       (DEFAULT, 'Chang', 1, 1, 19.00),
       (DEFAULT, 'Aniseed Syrup', 1, 2, 10.00),
       (DEFAULT, 'Chef Anton’s Cajun Seasoning', 2, 2, 22.00),
       (DEFAULT, 'Chef Anton’s Gumbo Mix', 2, 2, 21.35);


-- Select product with product name that begins with ‘C’.
SELECT *
FROM Products
WHERE ProductName LIKE 'C%';

-- Select product with the smallest price.
SELECT *
FROM Products
WHERE Price = (SELECT MIN(Price) FROM Products);

-- Select cost of all products from the USA.
SELECT SUM(Price)
FROM Products p
         INNER JOIN Suppliers s ON p.SupplierID = s.SupplierID
WHERE country = 'USA';

-- Select suppliers that supply Condiments.
SELECT DISTINCT s.SupplierID,
                SupplierName,
                City,
                Country
FROM Suppliers s
         INNER JOIN Products p ON s.SupplierID = p.SupplierID
         INNER JOIN Categories c ON p.CategoryID = c.CategoryID
WHERE CategoryName = 'Condiments';

-- Add to database new supplier with name: ‘Norske Meierier’, city: ‘Lviv’, country: ‘Ukraine’ which
-- will supply new product with name: ‘Green tea’, price: 10, and related to category with name:
-- ‘Beverages’.
INSERT INTO Suppliers
VALUES (DEFAULT, 'Norske Meierier', 'Lviv', 'Ukraine');
INSERT INTO Products
VALUES (DEFAULT, 'Green tea',
        (SELECT SupplierID FROM Suppliers WHERE SupplierName = 'Norske Meierier'),
        (SELECT CategoryID FROM Categories WHERE CategoryName = 'Beverages'),
        10.00);
