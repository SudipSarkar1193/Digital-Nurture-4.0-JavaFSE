-- Scenario 2: The bank wants to implement a bonus scheme for employees based on their performance.

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    dept_id IN NUMBER,
    bonus_percent IN NUMBER
) IS
BEGIN
    -- Update salary by adding a bonus percentage
    UPDATE Employees
    SET Salary = Salary + (Salary * bonus_percent / 100)
    WHERE DepartmentID = dept_id;
    
    DBMS_OUTPUT.PUT_LINE(bonus_percent || '% bonus for department ID: ' || dept_id);
END;
/
