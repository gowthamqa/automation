SQL stands for Structured Query Language
SQL lets you access and manipulate databases
RDBMS stands for Relational Database Management System.
RDBMS is the basis for SQL, and for all modern database systems such as MS SQL Server, IBM DB2, Oracle, MySQL, and Microsoft Access.
The data in RDBMS is stored in database objects called tables. A table is a collection of related data entries and it consists of columns and rows.
SQL keywords are NOT case sensitive
====================
====================
SELECT * FROM table_name; --The SELECT statement is used to select data from a database. The data returned is stored in a result table, called the result-set.
SELECT CustomerName, City FROM Customers;
SELECT * FROM Customers;
====================
SELECT DISTINCT column1, column2, ...
FROM table_name; --is used to return only distinct (different) values.
SELECT DISTINCT Country FROM Customers;
SELECT COUNT(DISTINCT Country) FROM Customers;
====================
SELECT column1, column2, ...
FROM table_name WHERE condition;
SELECT * FROM Customers WHERE Country='Mexico';
SELECT * FROM Customers WHERE CustomerID=1;
--Operators in The WHERE Clause
Operator	Description
=	Equal
<>	Not equal. Note: In some versions of SQL this operator may be written as !=
>	Greater than
<	Less than
>=	Greater than or equal
<=	Less than or equal
BETWEEN	Between an inclusive range
LIKE	Search for a pattern
IN	To specify multiple possible values for a column
====================
SELECT * FROM Customers WHERE Country='Germany' AND City='Berlin';
SELECT * FROM Customers WHERE City='Berlin' OR City='München';
SELECT * FROM Customers WHERE NOT Country='Germany';
SELECT * FROM Customers WHERE Country='Germany' AND (City='Berlin' OR City='München');
SELECT * FROM Customers WHERE NOT Country='Germany' AND NOT Country='USA';
====================
SELECT column1, column2, ...
FROM table_name
ORDER BY column1, column2, ... ASC|DESC;--is used to sort the result-set in ascending or descending order
--ORDER BY keyword sorts the records in ascending order by default.
SELECT * FROM Customers ORDER BY Country;
SELECT * FROM Customers ORDER BY Country DESC;
SELECT * FROM Customers ORDER BY Country, CustomerName;
SELECT * FROM Customers ORDER BY Country ASC, CustomerName DESC;
====================
INSERT INTO table_name (column1, column2, column3, ...)
VALUES (value1, value2, value3, ...);
INSERT INTO table_name
VALUES (value1, value2, value3, ...);-- all values should be provided
INSERT INTO Customers (CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES ('Cardinal', 'Tom B. Erichsen', 'Skagen 21', 'Stavanger', '4006', 'Norway');
INSERT INTO Customers (CustomerName, City, Country) VALUES ('Cardinal', 'Stavanger', 'Norway'); --Insert Data Only in Specified Columns
====================
--A field with a NULL value is a field with no value.
SELECT LastName, FirstName, Address FROM Persons WHERE Address IS NULL;
SELECT LastName, FirstName, Address FROM Persons WHERE Address IS NOT NULL;
====================
UPDATE table_name
SET column1 = value1, column2 = value2, ...
WHERE condition;
UPDATE Customers SET ContactName = 'Alfred Schmidt', City= 'Frankfurt' WHERE CustomerID = 1;
UPDATE Customers SET ContactName='Juan' WHERE Country='Mexico';
UPDATE Customers SET ContactName='Juan';-- applies for all rows in table
====================
DELETE FROM table_name
WHERE condition;
DELETE FROM Customers WHERE CustomerName='Alfreds Futterkiste';
DELETE FROM table_name; or DELETE * FROM table_name; 
--It is possible to delete all rows in a table without deleting the table. This means that the table structure, attributes, and indexes will be intact:
====================
SELECT TOP number|percent column_name(s) FROM table_name WHERE condition;
SELECT TOP 3 * FROM Customers;
SELECT TOP 50 PERCENT * FROM Customers;
SELECT TOP 3 * FROM Customers WHERE Country='Germany';
====================
SELECT MIN(column_name) FROM table_name WHERE condition;
SELECT MAX(column_name) FROM table_name WHERE condition;
SELECT MIN(Price) AS SmallestPrice FROM Products;
SELECT MAX(Price) AS LargestPrice FROM Products;
====================
SELECT COUNT(column_name) FROM table_name WHERE condition;
SELECT AVG(column_name) FROM table_name WHERE condition;
SELECT SUM(column_name) FROM table_name WHERE condition;
SELECT COUNT(ProductID) FROM Products;
SELECT AVG(Price) FROM Products;
SELECT SUM(Quantity) FROM OrderDetails;
====================
%    - The percent sign represents zero, one, or multiple characters
_    - The underscore represents a single character

SELECT column1, column2, ...
FROM table_name WHERE columnN LIKE pattern;

LIKE Operator	Description
WHERE CustomerName LIKE 'a%'	        Finds any values that start with "a"
WHERE CustomerName LIKE '%a'	        Finds any values that end with "a"
WHERE CustomerName LIKE '%or%'	      Finds any values that have "or" in any position
WHERE CustomerName LIKE '_r%'					Finds any values that have "r" in the second position
WHERE CustomerName LIKE 'a_%_%'				Finds any values that start with "a" and are at least 3 characters in length
WHERE ContactName LIKE 'a%o'					Finds any values that start with "a" and ends with "o"

SELECT * FROM Customers WHERE CustomerName LIKE 'a%'; --selects all customers with a CustomerName starting with "a"
SELECT * FROM Customers WHERE CustomerName LIKE '%a'; --selects all customers with a CustomerName ending with "a"
SELECT * FROM Customers WHERE CustomerName LIKE '%or%'; --selects all customers with a CustomerName that have "or" in any position
SELECT * FROM Customers WHERE CustomerName LIKE '_r%'; --selects all customers with a CustomerName that have "r" in the second position
SELECT * FROM Customers WHERE CustomerName LIKE 'a_%_%'; --selects all customers with a CustomerName that starts with "a" and are at least 3 characters in length
SELECT * FROM Customers WHERE ContactName LIKE 'a%o'; --selects all customers with a ContactName that starts with "a" and ends with "o"
SELECT * FROM Customers WHERE CustomerName NOT LIKE 'a%'; --selects all customers with a CustomerName that does NOT start with "a"
SELECT * FROM Customers WHERE City LIKE '[bsp]%'; --selects all customers with a City starting with "b", "s", or "p"
SELECT * FROM Customers WHERE City LIKE '[a-c]%'; --selects all customers with a City starting with "a", "b", or "c"
SELECT * FROM Customers WHERE City LIKE '[!bsp]%'; --select all customers with a City NOT starting with "b", "s", or "p"
SELECT * FROM Customers WHERE City NOT LIKE '[bsp]%'; --select all customers with a City NOT starting with "b", "s", or "p"
====================
SELECT column_name(s)
FROM table_name WHERE column_name IN (value1, value2, ...);
SELECT column_name(s)
FROM table_name WHERE column_name IN (SELECT STATEMENT);
SELECT * FROM Customers WHERE Country IN ('Germany', 'France', 'UK');
SELECT * FROM Customers WHERE Country NOT IN ('Germany', 'France', 'UK');
SELECT * FROM Customers WHERE Country IN (SELECT Country FROM Suppliers);
====================
SELECT column_name(s)
FROM table_name WHERE column_name BETWEEN value1 AND value2;
SELECT * FROM Products WHERE Price BETWEEN 10 AND 20; --selects all products with a price BETWEEN 10 and 20
SELECT * FROM Products WHERE Price NOT BETWEEN 10 AND 20;
SELECT * FROM Products WHERE (Price BETWEEN 10 AND 20) AND NOT CategoryID IN (1,2,3); --BETWEEN with IN Example
SELECT * FROM Products WHERE ProductName BETWEEN 'Carnarvon Tigers' AND 'Mozzarella di Giovanni' ORDER BY ProductName;
SELECT * FROM Orders WHERE OrderDate BETWEEN #07/04/1996# AND #07/09/1996#;
--selects all orders with an OrderDate BETWEEN '04-July-1996' and '09-July-1996'
====================
SELECT column_name AS alias_name FROM table_name;
SELECT column_name(s) FROM table_name AS alias_name;
SELECT CustomerID as ID, CustomerName AS Customer FROM Customers;
SELECT CustomerName AS Customer, ContactName AS [Contact Person] FROM Customers;
--It requires double quotation marks or square brackets if the alias name contains spaces
SELECT CustomerName, Address + ', ' + PostalCode + ' ' + City + ', ' + Country AS Address FROM Customers;
output:
CustomerName	Address
Alfreds Futterkiste 	Obere Str. 57, 12209 Berlin, Germany 

SELECT o.OrderID, o.OrderDate, c.CustomerName FROM Customers AS c, Orders AS o
WHERE c.CustomerName="Around the Horn" AND c.CustomerID=o.CustomerID;
====================
SELECT City FROM Customers UNION
SELECT City FROM Suppliers ORDER BY City; -- selects all the different cities (only distinct values) from "Customers" and "Suppliers"

SELECT City FROM Customers UNION ALL
SELECT City FROM Suppliers ORDER BY City; -- selects all cities (duplicate values also) from "Customers" and "Suppliers"
====================
/*GROUP BY statement is often used with aggregate functions (COUNT, MAX, MIN, SUM, AVG) to group the result-set by one or more columns. */
SELECT COUNT(CustomerID), Country FROM Customers GROUP BY Country; /*lists the number of customers in each country*/
SELECT COUNT(CustomerID), Country FROM Customers GROUP BY Country ORDER BY COUNT(CustomerID) DESC; /*lists the number of customers in each country, sorted high to low*/
SELECT Shippers.ShipperName, COUNT(Orders.OrderID) AS NumberOfOrders FROM Orders
LEFT JOIN Shippers ON Orders.ShipperID = Shippers.ShipperID GROUP BY ShipperName;
/*lists the number of orders sent by each shipper*/
====================
/*HAVING clause was added to SQL because the WHERE keyword could not be used with aggregate functions*/
SELECT column_name(s) FROM table_name
WHERE condition GROUP BY column_name(s)
HAVING condition ORDER BY column_name(s);

SELECT COUNT(CustomerID), Country FROM Customers GROUP BY Country HAVING COUNT(CustomerID) > 5;
/*lists the number of customers in each country. Only include countries with more than 5 customers*/

SELECT COUNT(CustomerID), Country FROM Customers GROUP BY Country HAVING COUNT(CustomerID) > 5 ORDER BY COUNT(CustomerID) DESC;
/*lists the number of customers in each country, sorted high to low (Only include countries with more than 5 customers)*/

SELECT Employees.LastName, COUNT(Orders.OrderID) AS NumberOfOrders FROM 
(Orders INNER JOIN Employees ON Orders.EmployeeID = Employees.EmployeeID)
GROUP BY LastName HAVING COUNT(Orders.OrderID) > 10;
/*lists the employees that have registered more than 10 orders*/

SELECT Employees.LastName, COUNT(Orders.OrderID) AS NumberOfOrders FROM Orders
INNER JOIN Employees ON Orders.EmployeeID = Employees.EmployeeID
WHERE LastName = 'Davolio' OR LastName = 'Fuller' GROUP BY LastName
HAVING COUNT(Orders.OrderID) > 25; /*lists if the employees "Davolio" or "Fuller" have registered more than 25 orders*/
====================
/*EXISTS operator is used to test for the existence of any record in a subquery
EXISTS operator returns true if the subquery returns one or more records */
SELECT column_name(s)FROM table_name WHERE EXISTS
(SELECT column_name FROM table_name WHERE condition);

SELECT SupplierName FROM Suppliers
WHERE EXISTS (SELECT ProductName FROM Products WHERE SupplierId = Suppliers.supplierId AND Price < 20);
/*returns TRUE and lists the suppliers with a product price less than 20*/

SELECT SupplierName FROM Suppliers
WHERE EXISTS (SELECT ProductName FROM Products WHERE SupplierId = Suppliers.supplierId AND Price = 22);
/*returns TRUE and lists the suppliers with a product price equal to 22*/
====================
/*ANY and ALL operators are used with a WHERE or HAVING clause
ANY operator returns true if any of the subquery values meet the condition
ALL operator returns true if all of the subquery values meet the condition*/

SELECT column_name(s) FROM table_name WHERE column_name operator ANY
(SELECT column_name FROM table_name WHERE condition);

SELECT column_name(s) FROM table_name WHERE column_name operator ALL
(SELECT column_name FROM table_name WHERE condition);

SELECT ProductName FROM Products
WHERE ProductID = ANY (SELECT ProductID FROM OrderDetails WHERE Quantity = 10);
/*returns TRUE if any of the subquery values meet the condition
returns TRUE and lists the productnames if it finds ANY records in the OrderDetails table that quantity = 10 */

SELECT ProductName FROM Products
WHERE ProductID = ANY (SELECT ProductID FROM OrderDetails WHERE Quantity > 99);
/*returns TRUE and lists the productnames if it finds ANY records in the OrderDetails table that quantity > 99 */

SELECT ProductName FROM Products
WHERE ProductID = ALL (SELECT ProductID FROM OrderDetails WHERE Quantity = 10);
/*TRUE if all of the subquery values meet the condition
returns TRUE and lists the productnames if ALL the records in the OrderDetails table has quantity = 10 */
====================
/*SELECT INTO statement copies data from one table into a new table*/
SELECT * INTO newtable [IN externaldb] FROM oldtable WHERE condition; --Copy all columns into a new table
SELECT column1, column2, column3, ...
INTO newtable [IN externaldb] FROM oldtable WHERE condition; --Copy only some columns into a new table

SELECT * INTO CustomersBackup2017 FROM Customers; /*creates a backup copy of Customers*/
====================
INSERT INTO table2 SELECT * FROM table1 WHERE condition; /* Copy all columns from one table to another table */

INSERT INTO table2 (column1, column2, column3, ...) SELECT column1, column2, column3, ...
FROM table1 WHERE condition; --Copy only some columns from one table into another table

INSERT INTO Customers (CustomerName, City, Country) SELECT SupplierName, City, Country FROM Suppliers;
/*copies "Suppliers" into "Customers" (the columns that are not filled with data, will contain NULL)*/


INSERT INTO Customers (CustomerName, ContactName, Address, City, PostalCode, Country)
SELECT SupplierName, ContactName, Address, City, PostalCode, Country FROM Suppliers;
/*copies "Suppliers" into "Customers" (fill all columns)*/


INSERT INTO Customers (CustomerName, City, Country) SELECT SupplierName, City, Country FROM Suppliers
WHERE Country='Germany'; /*copies only the German suppliers into "Customers"*/
====================
SELECT Orders.OrderID, Customers.CustomerName FROM Orders
INNER JOIN Customers ON Orders.CustomerID = Customers.CustomerID;

SELECT Orders.OrderID, Customers.CustomerName, Shippers.ShipperName FROM (
(Orders INNER JOIN Customers ON Orders.CustomerID = Customers.CustomerID)
INNER JOIN Shippers ON Orders.ShipperID = Shippers.ShipperID); -- 3 tables join

SELECT Customers.CustomerName, Orders.OrderID FROM Customers
LEFT JOIN Orders ON Customers.CustomerID = Orders.CustomerID ORDER BY Customers.CustomerName; -- left circle

SELECT Orders.OrderID, Employees.LastName, Employees.FirstName FROM Orders
RIGHT JOIN Employees ON Orders.EmployeeID = Employees.EmployeeID ORDER BY Orders.OrderID; -- right cicle

SELECT Customers.CustomerName, Orders.OrderID FROM Customers
FULL OUTER JOIN Orders ON Customers.CustomerID=Orders.CustomerID ORDER BY Customers.CustomerName; -- both circles

SELECT A.CustomerName AS CustomerName1, B.CustomerName AS CustomerName2, A.City
FROM Customers A, Customers B WHERE A.CustomerID <> B.CustomerID AND A.City = B.City ORDER BY A.City; -- self join












