# JUnit Testing Assignment

## Overview
This project contains exercises demonstrating Mocking and stubbing an external API using Mockito.

The project is built with IntelliJ IDEA Ultimate .

## Prerequisites
- **Java**: JDK 21.
- **IDE**: IntelliJ IDEA Ultimate.
- **Build Tool**: Maven.
- **Testing Framework**: JUnit 5 (Jupiter).
- **Mocking Library**: Mockito.

## Project Structure
```
src
├── main
│   └── java
│       └── com.sudip
│           ├── Calculator.java
│           ├── ExternalApi.java
│           └── MyService.java
├── test
│   └── java
│       └── com.sudip
│           ├── AssertionsTest.java
│           ├── CalculatorTest.java
│           └── MyServiceTest.java
pom.xml 
README.md
```

## Setup 


#### Maven
Added the following to `pom.xml`:
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                             http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.sudip</groupId>
    <artifactId>Mocking_and_Stubbing</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <junit.jupiter.version>5.9.3</junit.jupiter.version>
        <mockito.version>5.7.0</mockito.version>
    </properties>

    <repositories>
        <repository>
            <id>central</id>
            <url>https://repo.maven.apache.org/maven2</url>
        </repository>
    </repositories>

    <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>${junit.jupiter.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>${mockito.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-junit-jupiter</artifactId>
            <version>${mockito.version}</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.11.0</version>
                <configuration>
                    <source>${maven.compiler.source}</source>
                    <target>${maven.compiler.target}</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M9</version>
            </plugin>
        </plugins>
    </build>
</project>

```




### Mocking and Stubbing

1. In `src/main/java/com.sudip`, created an interface named `ExternalApi`:
```java
package com.sudip;

public interface ExternalApi {
    String getData();
}
```

2. In `src/main/java/com.sudip`, created a class named `MyService`:
```java
package com.sudip;

public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        try {
            String data = externalApi.getData();
            if (data == null) {
                return "No data available";
            }
            return data;
        } catch (RuntimeException e) {
            throw e;
        }
    }
}
```

3. In `src/test/java/com.sudip`, created a class named `MyServiceTest`:

```java

package com.sudip;

import com.external.ExternalApi;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.* ;

@ExtendWith(MockitoExtension.class)
public class MyServiceTest {

    @Mock
    private ExternalApi mockApi;

    private MyService service;

    @BeforeEach
    public void setUp() {
        service = new MyService(mockApi);
    }

    @Test
    public void testFetchDataSuccess() {
        when(mockApi.getData()).thenReturn("Mock Data");

        String result = service.fetchData();

        assertEquals("Mock Data", result, "Should return mocked data");

        // Verify: Ensure getData was called ONLY ONCE
        verify(mockApi, times(1)).getData();
    }

    @Test
    public void testFetchDataNullResponse() {
        when(mockApi.getData()).thenReturn(null);

        String result = service.fetchData();

        assertEquals("No data available", result, "Should handle null response");

        verify(mockApi, times(1)).getData();
    }

    @Test
    void testFetchDataThrowsRuntimeException() {
        RuntimeException exception = new RuntimeException("API failure");
        when(mockApi.getData()).thenThrow(exception);

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            service.fetchData();
        });

        assertSame(exception, thrown, "Should throw the same RuntimeException object");
        assertEquals("API failure", thrown.getMessage());
        verify(mockApi, times(1)).getData();
    }
}

```

## Exercise Descriptions : Mocking and Stubbing
The `MyServiceTest` class demonstrates mocking and stubbing an `ExternalApi` using Mockito:
- **Setup**: Uses `@ExtendWith(MockitoExtension.class)` and `@Mock` to create a mock of `ExternalApi`.
- **Tests**:
    - `testFetchDataSuccess`: Stubs `getData` to return "Mock Data" and verifies the service returns it.
    - `testFetchDataNullResponse`: Stubs `getData` to return `null` and checks the service returns "No data available".
    - `testFetchDataException`: Stubs `getData` to throw a `RuntimeException` and verifies the service handles it.
- **Mockito Features**:
    - Stubbing with `when(...).thenReturn(...)` and `when(...).thenThrow(...)`.
    - Verifying interactions with `verify(mock, times(1))`.


# Output

![Output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week2_TDD%20using%20JUnit5%20and%20Mockito/Mockito%20Exercise%201%20-%20Mocking%20and%20Stubbing/output/Mocking%20%26%20Stubbing.png?raw=true)