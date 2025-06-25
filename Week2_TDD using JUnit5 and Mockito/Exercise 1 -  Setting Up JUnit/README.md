# 📘 Assignment 1: Setting Up JUnit in a Java Project

## 📌 Objective
Set up a Java project using Maven and configure JUnit (version 4.13.2) for writing and running unit tests in IntelliJ IDEA Ultimate.

## 📁 Project Structure
```
Exercise1_JUnitSetup/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── Calculator.java
│   └── test/
│       └── java/
│           └── CalculatorTest.java
│── output (contains screenshot of the output)
└── target/ (ignored via .gitignore)
```

## ⚙️ Tools & Technologies
- **Java SDK**: 21
- **JUnit**: 4.13.2
- **Build Tool**: Maven
- **IDE**: IntelliJ IDEA Ultimate



## 🧪 Running Tests
1. Navigate to `src/test/java/CalculatorTest.java` in IntelliJ.
2. Right-click on `CalculatorTest.java` and select **Run 'CalculatorTest'**.
3. View the test results in the **JUnit panel** at the bottom of IntelliJ.
4. A green bar ✅ indicates all tests passed successfully.

## 🧪 Sample Code
### `Calculator.java`
```java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}
```

### `CalculatorTest.java`
```java
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(2, 3));
    }
}
```

## 🚫 .gitignore
```
# Maven target directory
target/

# IntelliJ project files
.idea/
*.iml
```

