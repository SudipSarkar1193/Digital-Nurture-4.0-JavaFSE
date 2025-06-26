# JUnit Testing Assignment: Interaction Verification

## Overview
This project is an exercise to demonstrate verifying method interactions using **Mockito** and **JUnit 5**. The goal is to ensure that the `fetchData` method in the `MyService` class calls the `getData` method of the `ExternalApi` interface with specific arguments (`"Sudip"`, `5`). I used the Mockito JUnit 5 Extension to simplify the test setup.

This project is built with IntelliJ IDEA Ultimate as part of my learning journey in Java unit testing.

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
│       └── com
│           ├── external
│           │      └── ExternalApi.java
│           └── sudip
│                └──MyService.java
├── test
│   └── java
│       └── com.example
│           └── MyServiceTest.java
pom.xml
README.md
```

## Setup

### Maven
Added the following to `pom.xml` to include JUnit 5 and Mockito dependencies:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                             http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.sudip</groupId>
    <artifactId>Mockito_VerifyingInteractions</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <junit.jupiter.version>5.10.2</junit.jupiter.version>
        <mockito.version>5.12.0</mockito.version>
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

### Source Code
1. In `src/main/java/com/external`, created an interface named `ExternalApi`:
```java
package com.sudip;

public interface ExternalApi {
    void getData(String id, int count);
}
```

2. In `src/main/java/com/sudip`, created a class named `MyService`:
```java
package com.sudip;

import com.external.ExternalApi;

public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public void fetchData() {
        externalApi.getData("Sudip", 5);
    }
}
```

3. In `src/test/java/com/sudip`, created a class named `MyServiceTest`:
```java
package com.sudip;

import com.external.ExternalApi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

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
    public void testVerifyInteraction() {
        service.fetchData();

        // HERE we VERIFY: was mockApi.getData called with these arguments?
        verify(mockApi, times(1)).getData("Sudip", 5);
    }
}
```

## Exercise Descriptions: Interaction Verification
The `MyServiceTest` class demonstrates verifying method interactions using Mockito and the JUnit 5 Extension:
- **Setup**: Uses `@ExtendWith(MockitoExtension.class)` to enable Mockito integration and `@Mock` to create a mock of `ExternalApi`. The `@BeforeEach` method initializes `MyService` with the mock.
- **Test**:
  - `testVerifyInteraction`: Calls `fetchData` and verifies that `getData("Sudip", 5)` is called exactly once using `verify(mockApi, times(1)).getData("Sudip", 5)`.
- **Mockito Features**:
  - Uses `verify` to check method interactions with specific arguments.
  - Leverages the Mockito JUnit 5 Extension for simplified mock management.


## What I Learned
- How to use the Mockito JUnit 5 Extension to simplify test setup with `@Mock` and `@BeforeEach`.
- Verifying method calls with specific arguments using `verify(mock, times(1))`.
- Setting up a Maven project in IntelliJ and managing dependencies.
- Running and debugging unit tests in IntelliJ IDEA Ultimate.

# Output 

![Output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week2_TDD%20using%20JUnit5%20and%20Mockito/Mockito%20Exercise%202%20-%20Verifying%20Interactions/output/Verifying%20Interactions.png?raw=true)