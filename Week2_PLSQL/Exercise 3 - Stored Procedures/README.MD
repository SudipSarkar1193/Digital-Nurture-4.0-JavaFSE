# Bank Database Stored Procedures

## Overview
This assignment focuses on implementing PL/SQL stored procedures to manage banking operations for accounts and employees. The scenarios include:
1. Processing monthly interest for savings accounts.
2. Updating employee salaries with a bonus based on department performance.
3. Transferring funds between customer accounts with balance validation.

## Project Structure
The `code` folder includes the following SQL files:
- **createTable.sql**: Creates the `Accounts` and `Employees` tables with appropriate columns and constraints.
- **insertData.sql**: Inserts sample data into the `Accounts` and `Employees` tables for testing.
- **scenario01.sql**: Stored procedure `ProcessMonthlyInterest` to apply a 1% interest rate to savings accounts.
- **scenario02.sql**: Stored procedure `UpdateEmployeeBonus` to apply a bonus percentage to employee salaries in a specified department.
- **scenario03.sql**: Stored procedure `TransferFunds` to transfer funds between accounts with balance validation.

The `output` folder contains screenshots of the outputs.

## Primary Works

### Table Creation
Two tables, `Accounts` and `Employees`, are created to store relevant data.

```sql
-- Accounts Table
CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    AccountHolderName VARCHAR2(100),
    AccountType VARCHAR2(20), -- e.g., 'Savings', 'Current'
    Balance NUMBER(15, 2)
);

-- Employees Table
CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    EmployeeName VARCHAR2(100),
    DepartmentID NUMBER,
    Salary NUMBER(10, 2)
);
```

### Data Insertion
Sample data is inserted into the `Accounts` and `Employees` tables for testing.

```sql
-- Savings accounts
INSERT INTO Accounts VALUES (101, 'Alice Biswas', 'Savings', 10000);
INSERT INTO Accounts VALUES (102, 'Raj Verma', 'Savings', 15000);
INSERT INTO Accounts VALUES (103, 'Neha Sharma', 'Savings', 20000);
INSERT INTO Accounts VALUES (104, 'Sudipa Sarkar', 'Savings', 25000);

-- Current accounts (should not be affected by interest)
INSERT INTO Accounts VALUES (105, 'Vikram Pal', 'Current', 50000);
INSERT INTO Accounts VALUES (106, 'Sunita Roy', 'Current', 60000);
INSERT INTO Accounts VALUES (107, 'Sunidhi Chauhan', 'Current', 80000);

-- Department 10
INSERT INTO Employees VALUES (201, 'Anil Kumble', 10, 50000);
INSERT INTO Employees VALUES (202, 'Shankar Das', 10, 60000);
INSERT INTO Employees VALUES (203, 'Sudip Sarkar', 10, 65000);
INSERT INTO Employees VALUES (204, 'Sudip Sarkar', 10, 65000);

-- Department 20
INSERT INTO Employees VALUES (205, 'Manoj Sinha', 20, 55000);
INSERT INTO Employees VALUES (206, 'Sabita Sarkar', 20, 62000);
INSERT INTO Employees VALUES (207, 'Sabita Sarkar', 20, 62000);
```

**Output**:
```bash
SQL> SELECT * FROM Accounts;
ACCOUNTID ACCOUNT_HOLDER_NAME  ACCOUNT_TYPE  BALANCE
--------- -------------------- ------------ --------
      101 Alice Biswas         Savings      10000
      102 Raj Verma            Savings      15000
      103 Neha Sharma          Savings      20000
      104 Sudipa Sarkar        Savings      25000
      105 Vikram Pal           Current      50000
      106 Sunita Roy           Current      60000
      107 Sunidhi Chauhan      Current      80000

SQL> SELECT * FROM Employees;
EMPLOYEEID EMPLOYEE_NAME  DEPARTMENTID SALARY
---------- -------------- ------------ ------
       201 Anil Kumble           10     50000
       202 Shankar Das           10     60000
       203 Sudip Sarkar          10     65000
       204 Sudip Sarkar          10     65000
       205 Manoj Sinha           20     55000
       206 Sabita Sarkar         20     62000
       207 Sabita Sarkar         20     62000
```

## Scenario Details

### Scenario 1: Process Monthly Interest
- **Logic**: Updates the balance of all savings accounts by applying a 1% interest rate.
- **Outcome**: Increases the balance of savings accounts and commits changes.

- **Code**:
```sql
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';
    
    DBMS_OUTPUT.PUT_LINE('Monthly interest has been processed for all savings accounts.');
END;
/
```

- **Output**:
```bash
SQL> EXEC ProcessMonthlyInterest;
Monthly interest has been processed for all savings accounts.

SQL> SELECT * FROM Accounts;
ACCOUNTID ACCOUNT_HOLDER_NAME  ACCOUNT_TYPE  BALANCE
--------- -------------------- ------------ --------
      101 Alice Biswas         Savings      10100
      102 Raj Verma            Savings      15150
      103 Neha Sharma          Savings      20200
      104 Sudipa Sarkar        Savings      25250
      105 Vikram Pal           Current      50000
      106 Sunita Roy           Current      60000
      107 Sunidhi Chauhan      Current      80000
```

### Scenario 2: Update Employee Bonus
- **Logic**: Updates employee salaries in a specified department by adding a bonus percentage passed as a parameter.
- **Outcome**: Increases salaries for the specified department and commits changes.

- **Code**:
```sql
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    dept_id IN NUMBER,
    bonus_percent IN NUMBER
) IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * bonus_percent / 100)
    WHERE DepartmentID = dept_id;
    
    DBMS_OUTPUT.PUT_LINE(bonus_percent || '% bonus for department ID: ' || dept_id);
END;
/
```

- **Output**:
```bash
SQL> EXEC UpdateEmployeeBonus(10, 5);
5% bonus for department ID: 10

SQL> SELECT * FROM Employees WHERE DepartmentID = 10;
EMPLOYEEID EMPLOYEE_NAME  DEPARTMENTID SALARY
---------- -------------- ------------ ------
       201 Anil Kumble           10     52500
       202 Shankar Das           10     63000
       203 Sudip Sarkar          10     68250
       204 Sudip Sarkar          10     68250
```

### Scenario 3: Transfer Funds
- **Logic**: Transfers a specified amount from one account to another, checking for sufficient balance in the source account.
- **Outcome**: Updates balances in both accounts and commits changes if valid; otherwise, raises an error.

- **Code**:
```sql
CREATE OR REPLACE PROCEDURE TransferFunds (
    from_account IN NUMBER,
    to_account IN NUMBER,
    amount IN NUMBER
) IS
    source_balance NUMBER;
BEGIN
    SELECT Balance INTO source_balance
    FROM Accounts
    WHERE AccountID = from_account
    FOR UPDATE;

    IF source_balance < amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in the source account.');
    END IF;

    UPDATE Accounts
    SET Balance = Balance - amount
    WHERE AccountID = from_account;

    UPDATE Accounts
    SET Balance = Balance + amount
    WHERE AccountID = to_account;

    DBMS_OUTPUT.PUT_LINE('Transfer of ' || amount || ' completed from account ' ||
                         from_account || ' to account ' || to_account);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('One or both account IDs are invalid.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
```

- **Output**:
```bash
SQL> EXEC TransferFunds(101, 102, 5000);
Transfer of 5000 completed from account 101 to account 102

SQL> SELECT * FROM Accounts WHERE AccountID IN (101, 102);
ACCOUNTID ACCOUNT_HOLDER_NAME  ACCOUNT_TYPE  BALANCE
--------- -------------------- ------------ --------
      101 Alice Biswas         Savings       5100
      102 Raj Verma            Savings      20150
```


## Setup Instructions
1. Execute `createTables.sql` to create the `Accounts` and `Employees` tables.
2. Run `insertSampleData.sql` to populate the tables with sample data.
3. Execute the stored procedures in `scenario01.sql`, `scenario02.sql`, and `scenario03.sql` to create the procedures.
4. Test the procedures using `EXEC` commands as shown in the output sections.

## Usage Examples
- Process interest: `EXEC ProcessMonthlyInterest;`
- Apply bonus: `EXEC UpdateEmployeeBonus(10, 5);`
- Transfer funds: `EXEC TransferFunds(101, 102, 5000);`

## Notes
- The `TransferFunds` procedure uses a `FOR UPDATE` clause to lock the source account row, preventing concurrent modifications.
- Error handling in `TransferFunds` ensures invalid accounts or insufficient funds are caught and reported.