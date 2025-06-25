# JUnit Assertions Assignment

## Overview

This project demonstrates the use of various JUnit 5 assertions to validate test results in a Java application. The `AssertionsTest` class contains individual test methods, each showcasing a different JUnit assertion (`assertEquals`, `assertTrue`, `assertFalse`, `assertNull`, `assertNotNull`, `assertSame`, `assertNotSame`, `assertArrayEquals`, and `assertThrows`). The project is configured to run in IntelliJ IDEA Ultimate with Maven .

## Project Structure

```
src
├── main
│   └── java
│       └── (empty, as this is a test-only project)
├── test
│   └── java
│       └── com.example
│           └── AssertionsTest.java
├── output (Contains screenshot of the output)
pom.xml
README.md
```

## Setup

#### Maven

Added the following to `pom.xml`:

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.11.0</version>
    <scope>test</scope>
</dependency>
```

Then, sync the project by clicking the "Reload All Maven Projects" icon.

### 3. Added the Test Class

1. In `src/test/java`, create a package (e.g., `com.example`).
2. Created a new Java class named `AssertionsTest`.

```java
package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    public void testAssertEquals() {
        assertEquals(5, 2 + 3, "2 + 3 should equal 5");
    }

    @Test
    public void testAssertTrue() {
        assertTrue(5 > 3, "5 should be greater than 3");
    }

    @Test
    public void testAssertFalse() {
        assertFalse(5 < 3, "5 should not be less than 3");
    }

    @Test
    public void testAssertNull() {
        assertNull(null, "Object should be null");
    }

    @Test
    public void testAssertNotNull() {
        assertNotNull(new Object(), "Object should not be null");
    }

    @Test
    public void testAssertSame() {
        String str = "Hello";
        assertSame(str, str, "Should be the same object");
    }

    @Test
    public void testAssertNotSame() {
        assertNotSame(new String("Hello"), new String("Hello"), "Should be different objects");
    }

    @Test
    public void testAssertArrayEquals() {
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertArrayEquals(expected, actual, "Arrays should be equal");
    }

    @Test
    public void testAssertThrows() {
        assertThrows(ArithmeticException.class, () -> {
            int result = 1 / 0;
        }, "Division by zero should throw ArithmeticException");
    }
}
```

## Test Descriptions

The `AssertionsTest` class includes the following test methods:

- `testAssertEquals`: Verifies that `2 + 3` equals `5`.
- `testAssertTrue`: Checks that `5 > 3` is true.
- `testAssertFalse`: Ensures `5 < 3` is false.
- `testAssertNull`: Confirms that `null` is null.
- `testAssertNotNull`: Verifies that a new `Object` is not null.
- `testAssertSame`: Checks that a string references the same object.
- `testAssertNotSame`: Ensures two new `String` objects are distinct.
- `testAssertArrayEquals`: Compares two identical integer arrays.
- `testAssertThrows`: Validates that division by zero throws an `ArithmeticException`.

# Output

![Output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week2_TDD%20using%20JUnit5%20and%20Mockito/Exercise%203%20-%20%20Assertions%20in%20JUnit/output/AssertionsTest.png?raw=true)
