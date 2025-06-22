-- Apply 1% Interest Discount for Senior Citizens 


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
