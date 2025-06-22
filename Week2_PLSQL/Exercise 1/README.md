# Digital Nurture 4.0 Java FSE - PL/SQL Exercise 01

## Overview
This assignment focuses on implementing PL/SQL control structures to solve three banking scenarios:
1. Applying a 1% discount to loan interest rates for customers above 60 years old.
2. Promoting customers to VIP status based on a balance exceeding $10,000.
3. Sending reminders for loans due within the next 30 days.

## Project Structure
The `code` folder includes the following SQL files:
- **createTable.sql**: Creates the `Customers` and `Loans` tables with appropriate columns and constraints.
- **insertData.sql**: Inserts sample data into the `Customers` and `Loans` tables for testing.
- **scenario01.sql**: PL/SQL block to apply a 1% interest rate discount for customers over 60.
- **scenario02.sql**: PL/SQL block to set `IsVIP` to `TRUE` for customers with balances over $10,000.
- **scenario03.sql**: PL/SQL block to print reminders for loans due within 30 days.

The `output` folder contains screenshots of the outputs


## Primary works :

### First we created two tables `Customers` & `Loans` 

```sql

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


```
### Then we inserted data into these tables 

```sql
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


```

**Output :**

```bash

SQL> SELECT * FROM Customers;

CUSTOMERID NAME                  AGE   BALANCE INTERESTRATE ISVIP
---------- -------------------- ---- --------- ------------ -----
       101 Amit Sharma            65  15000.00         8.50 FALSE
       102 Priya Verma            58   9500.00         9.00 FALSE
       103 Rahul Gupta            70  12000.00         7.80 FALSE
       104 Sneha Roy              40  11000.00        10.00 FALSE
       105 Kiran Mehta            61   5000.00         9.50 FALSE

SQL> SELECT * FROM Loans;

    LOANID CUSTOMERID DUEDATE
---------- ---------- ---------
       202        102 27-JUL-25
       203        103 27-JUN-25
       204        104 20-JUL-25
       205        105 21-AUG-25

```


## Scenario Details
### Scenario 1: Interest Rate Discount
- **Logic**: Loops through all customers, checks if age > 60, and reduces `InterestRate` by 1%.
- **Outcome**: Updates `Customers` table for eligible customers and commits changes.

- **code :**

```sql

BEGIN
    FOR customer_rec IN (SELECT CustomerID, InterestRate, Age FROM Customers) LOOP
        IF customer_rec.Age > 60 THEN
            UPDATE Customers
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = customer_rec.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/

```

- **output :**


```bash

SQL> BEGIN
  2      FOR customer_rec IN (SELECT CustomerID, InterestRate, Age FROM Customers) LOOP
  3          IF customer_rec.Age > 60 THEN
  4              UPDATE Customers
  5              SET InterestRate = InterestRate - 1
  6              WHERE CustomerID = customer_rec.CustomerID;
  7          END IF;
  8      END LOOP;
  9      COMMIT;
 10  END;
 11  /
SQL>
SQL> SELECT * FROM Customers;

CUSTOMERID NAME                  AGE   BALANCE INTERESTRATE ISVIP
---------- -------------------- ---- --------- ------------ -----
       101 Amit Sharma            65  15000.00         7.50 FALSE
       102 Priya Verma            58   9500.00         9.00 FALSE
       103 Rahul Gupta            70  12000.00         6.80 FALSE
       104 Sneha Roy              40  11000.00        10.00 FALSE
       105 Kiran Mehta            61   5000.00         8.50 FALSE
SQL>

```

### Scenario 2: VIP Promotion
- **Logic**: Iterates through customers, sets `IsVIP` to `TRUE` if `Balance` > 10,000.
- **Outcome**: Updates `IsVIP` column in `Customers` table and commits changes.

- **code :**

```sql
BEGIN
    FOR customer_rec IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF customer_rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = customer_rec.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/
```

**Output :**

```bash
SQL> BEGIN
  2      FOR customer_rec IN (SELECT CustomerID, Balance FROM Customers) LOOP
  3          IF customer_rec.Balance > 10000 THEN
  4              UPDATE Customers
  5              SET IsVIP = 'TRUE'
  6              WHERE CustomerID = customer_rec.CustomerID;
  7          END IF;
  8      END LOOP;
  9      COMMIT;
 10  END;
 11  /
SQL>
SQL>
SQL> SELECT * FROM Customers;

CUSTOMERID NAME                  AGE   BALANCE INTERESTRATE ISVIP
---------- -------------------- ---- --------- ------------ -----
       101 Amit Sharma            65  15000.00         7.50 TRUE
       102 Priya Verma            58   9500.00         9.00 FALSE
       103 Rahul Gupta            70  12000.00         6.80 TRUE
       104 Sneha Roy              40  11000.00        10.00 TRUE
       105 Kiran Mehta            61   5000.00         8.50 FALSE
SQL>
```

### Scenario 3: Loan Due Reminders
- **Logic**: Fetches loans with `DueDate` within the next 30 days and prints reminders using `DBMS_OUTPUT`.
- **Outcome**: Displays formatted messages for each loan, including `LoanID`, `CustomerID`, and `DueDate`.

- **code :** 

```sql

SET SERVEROUTPUT ON;

DECLARE
    due_date DATE := SYSDATE + 30;
BEGIN
    FOR loan_rec IN (
        SELECT CustomerID, LoanID, DueDate 
        FROM Loans 
        WHERE DueDate <= due_date AND DueDate >= SYSDATE
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || loan_rec.LoanID || 
                             ' for Customer ID ' || loan_rec.CustomerID || 
                             ' is due on ' || TO_CHAR(loan_rec.DueDate, 'DD-MON-YYYY'));
    END LOOP;
END;
/
```
**Output :**

```bash
SQL> SET SERVEROUTPUT ON;
SQL>
SQL> DECLARE
  2      due_date DATE := SYSDATE + 30;
  3  BEGIN
  4      FOR loan_rec IN (
  5          SELECT CustomerID, LoanID, DueDate
  6          FROM Loans
  7          WHERE DueDate <= due_date AND DueDate >= SYSDATE
  8      ) LOOP
  9          DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || loan_rec.LoanID ||
 10                               ' for Customer ID ' || loan_rec.CustomerID ||
 11                               ' is due on ' || TO_CHAR(loan_rec.DueDate, 'DD-MON-YYYY'));
 12      END LOOP;
 13  END;
 14  /
Reminder: Loan ID 203 for Customer ID 103 is due on 27-JUN-2025
Reminder: Loan ID 204 for Customer ID 104 is due on 20-JUL-2025
SQL>
```


---
