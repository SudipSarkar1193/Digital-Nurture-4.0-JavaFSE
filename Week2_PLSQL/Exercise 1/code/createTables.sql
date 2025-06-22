-- Customers Table
CREATE TABLE Customers (
    CustomerID   NUMBER PRIMARY KEY,
    Name         VARCHAR2(50),
    Age          NUMBER,
    Balance      NUMBER(10, 2),
    InterestRate NUMBER(5, 2),
    IsVIP        VARCHAR2(5) DEFAULT 'FALSE'
);


-- Loans Table
CREATE TABLE Loans (
    LoanID     NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    DueDate    DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);


