# JUnit Testing Assignment: SLF4J Logging

## Overview
This project is an exercise to demonstrate logging error messages and warning levels using **SLF4J** with **Logback** as the logging implementation. The goal is to create a simple Java application that logs an error message and a warning message to the console. I implemented this using the SLF4J API and Logback, as part of my learning journey in Java logging.

This project is built with IntelliJ IDEA Ultimate.

## Prerequisites
- **Java**: JDK 21.
- **IDE**: IntelliJ IDEA Ultimate.
- **Build Tool**: Maven.
- **Logging Framework**: SLF4J with Logback.

## Project Structure
```
src
├── main
│   └── java
│       └── org.sudip.logging
│           └── Logging.java
pom.xml
README.md
```

## Setup

### Maven
used the following as `pom.xml` to include SLF4J and Logback dependencies:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.sudip</groupId>
    <artifactId>Logging_ErrMsgs_n_WarningLevels</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- https://mvnrepository.com/artifact/org.slf4j/slf4j-api -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>2.0.17</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/ch.qos.logback/logback-classic -->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.5.18</version>
        </dependency>
    </dependencies>
    
</project>
```
### Source Code
1. In `src/main/java/org/sudip/logging`, created a class named `Logging`:
```java
package org.sudip.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logging {
    private static final Logger logger = LoggerFactory.getLogger(Logging.class);

    public static void main(String[] args) {
        logger.error("This is an error message");
        logger.warn("This is a warning message");
    }
}
```

## Exercise Descriptions: Logging Error Messages and Warning Levels
The `Logging` class demonstrates logging error and warning messages using SLF4J with Logback:
- **Setup**: Uses `LoggerFactory.getLogger(Logging.class)` to create a logger instance for the `Logging` class.
- **Main Method**:
  - Logs an error message: `"This is an error message"` using `logger.error`.
  - Logs a warning message: `"This is a warning message"` using `logger.warn`.
- **SLF4J Features**:
  - Uses SLF4J as the logging facade, with Logback as the backend to output logs to the console.
  - Demonstrates two logging levels: `ERROR` and `WARN`.


## What I Learned
- How to set up SLF4J with Logback in a Maven project to log messages.
- Using `LoggerFactory.getLogger` to create a logger for a specific class.
- Logging different levels (`ERROR` and `WARN`) using SLF4J’s `logger.error` and `logger.warn` methods.
- Configuring a Maven project in IntelliJ and running a Java application.

# Output

```bash
"C:\Program Files\Java\jdk-21\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2025.1.2\lib\idea_rt.jar=51440" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week2_SLF4J logging framework\Exercise 1 - Logging Err msgs And Warning Levels\target\classes;C:\Users\DESKTOP\.m2\repository\org\slf4j\slf4j-api\2.0.17\slf4j-api-2.0.17.jar;C:\Users\DESKTOP\.m2\repository\ch\qos\logback\logback-classic\1.5.18\logback-classic-1.5.18.jar;C:\Users\DESKTOP\.m2\repository\ch\qos\logback\logback-core\1.5.18\logback-core-1.5.18.jar" org.sudip.logging.Logging
02:42:26.621 [main] ERROR org.sudip.logging.Logging -- This is an error message
02:42:26.628 [main] WARN org.sudip.logging.Logging -- This is a warning message

Process finished with exit code 0

```
## Screenshot 

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week2_SLF4J%20logging%20framework/Exercise%201%20-%20Logging%20Err%20msgs%20And%20Warning%20Levels/output/LoggingFrameWork.png?raw=true)