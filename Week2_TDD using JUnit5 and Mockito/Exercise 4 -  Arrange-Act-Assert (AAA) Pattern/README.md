# JUnit Testing Assignment : AAA Pattern

## Overview
This Assignment contains exercises demonstrating JUnit 5 testing concepts in a Java application. It includes: Organizing tests with the `Arrange-Act-Assert (AAA) pattern` and using setup/teardown methods with `@BeforeEach` and `@AfterEach`.

The Assignment is configured to run in IntelliJ IDEA Ultimate with Maven.

## AAA Pattern
  - **Arrange**: Sets up inputs and expected results.
  - **Act**: Calls the method under test.
  - **Assert**: Verifies the result with assertions.



## Project Structure
```
src
├── main
│   └── java
│       └── Calculator.java
│           
├── test
│   └── java
│       └── CalculatorTest.java
│           
pom.xml 
README.md
```

## Setup 

#### For Maven
Added the following to `pom.xml`:
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.11.0</version>
    <scope>test</scope>
</dependency>
```


### 3. Exercise : AAA Pattern and Setup/Teardown

#### Calculator.java
1. In `src/main/java/com.example`, created a Java class named `Calculator`.


```java
package com.example;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
}
```

3. In `src/test/java/com.example`, create a Java class named `CalculatorTest`.

```java
package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void testAdd() {
        // Arrange
        int a = 5;
        int b = 3;
        int expected = 8;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(expected, result, "Adding " + a + " and " + b + " should equal " + expected);
    }

    @Test
    public void testSubtract() {
        // Arrange
        int a = 5;
        int b = 3;
        int expected = 2;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(expected, result, "Subtracting " + b + " from " + a + " should equal " + expected);
    }

    @Test
    public void testDivide() {
        // Arrange
        double a = 6.0;
        double b = 2.0;
        double expected = 3.0;

        // Act
        double result = calculator.divide(a, b);

        // Assert
        assertEquals(expected, result, 0.0001, "Dividing " + a + " by " + b + " should equal " + expected);
    }

    @Test
    public void testDivideByZero() {
        // Arrange
        double a = 5.0;
        double b = 0.0;

        // Act & Assert
        assertThrows(ArithmeticException.class, () -> calculator.divide(a, b), 
            "Dividing " + a + " by " + b + " should throw ArithmeticException");
    }
}
```

## Exercise Descriptions

The `CalculatorTest` class tests a `Calculator` class using the Arrange-Act-Assert (AAA) pattern and setup/teardown methods:
- **Setup (`@BeforeEach`)**: Initializes a `Calculator` instance before each test.
- **Teardown (`@AfterEach`)**: Sets the `Calculator` to `null` after each test.
- **Tests**:
  - `testAdd`: Verifies `5 + 3 = 8`.
  - `testSubtract`: Verifies `5 - 3 = 2`.
  - `testDivide`: Verifies `6.0 / 2.0 = 3.0`.
  - `testDivideByZero`: Ensures division by zero throws an `ArithmeticException`.
- **AAA Pattern**:
  - **Arrange**: Sets up inputs and expected results.
  - **Act**: Calls the method under test.
  - **Assert**: Verifies the result with assertions.

# Output 

![Output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week2_TDD%20using%20JUnit5%20and%20Mockito/Exercise%204%20-%20%20Arrange-Act-Assert%20(AAA)%20Pattern/output/AAA_Pattern.png?raw=true)


