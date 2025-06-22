-- Insert Sample Customers
INSERT INTO Customers (CustomerID, Name, Age, Balance, InterestRate)
VALUES (101, 'Amit Sharma', 65, 15000.00, 8.5);

INSERT INTO Customers (CustomerID, Name, Age, Balance, InterestRate)
VALUES (102, 'Priya Verma', 58, 9500.00, 9.0);


INSERT INTO Customers (CustomerID, Name, Age, Balance, InterestRate)
VALUES (103, 'Rahul Gupta', 70, 12000.00, 7.8);

INSERT INTO Customers (CustomerID, Name, Age, Balance, InterestRate)
VALUES (104, 'Sneha Roy', 40, 11000.00, 10.0);

INSERT INTO Customers (CustomerID, Name, Age, Balance, InterestRate)
VALUES (105, 'Kiran Mehta', 61, 5000.00, 9.5);

-- Insert Sample Loans
INSERT INTO Loans (LoanID, CustomerID, DueDate)
VALUES (201, 101, SYSDATE + 10);  -- Due in 10 days

INSERT INTO Loans (LoanID, CustomerID, DueDate)
VALUES (202, 102, SYSDATE + 35);  

INSERT INTO Loans (LoanID, CustomerID, DueDate)
VALUES (203, 103, SYSDATE + 5);   

INSERT INTO Loans (LoanID, CustomerID, DueDate)
VALUES (204, 104, SYSDATE + 28);  

INSERT INTO Loans (LoanID, CustomerID, DueDate)
VALUES (205, 105, SYSDATE + 60);  
