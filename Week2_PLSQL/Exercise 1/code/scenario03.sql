-- Loan Due Reminder in Next 30 Days


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
