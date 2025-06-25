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


## Code
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

# Output 

![Output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week2_TDD%20using%20JUnit5%20and%20Mockito/Exercise%201%20-%20%20Setting%20Up%20JUnit/output/Setting%20up%20JUnit%20with%20Maven.png?raw=true)

