# 🌱 Spring Boot Web Application - `spring-learn`

This is a basic Spring Boot web application created using [Spring Initializr](https://start.spring.io/) as part of a hands-on assignment.

---

## 📌 Project Details

- **Group ID:** `com.cognizant`
- **Artifact ID:** `spring-learn`
- **Spring Boot Version:** 3.5.3
- **Build Tool:** Maven
- **Java Version:** 21 

---

## 🚀 Features

- Spring Boot Starter Web
- Spring Boot DevTools for hot reload
- Maven build system
- Console logs on application start

---

## 📁 Folder Structure Overview

```bash
spring-learn/
├── src/
│   ├── main/
│   │   ├── java/com/cognizant/springlearn/
│   │   │   └── SpringLearnApplication.java  <-- Main Class
│   │   └── resources/
│   │       └── application.properties       <-- Configuration
│   └── test/
│       └── java/...                         <-- Test classes
├── pom.xml                                  <-- Maven Build File
└── README.md                                <-- This file
```

## Code Overview

### SpringLearnApplication.java
```java
package com.cognizant.spring_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnApplication {

	public static void main(String[] args) {
		System.out.println("LOGGING");
		System.out.println("Application Starting...");
		System.out.println();

		SpringApplication.run(SpringLearnApplication.class, args);

		System.out.println("LOGGING");
		System.out.println("Application Started Successfully.");
		System.out.println();
	}

}


```

## Output

- Built the project using the command :
```bash
mvn clean package "-Dhttp.proxyHost=proxy.cognizant.com" "-Dhttp.proxyPort=6050" "-Dhttps.proxyHost=proxy.cognizant.com" "-Dhttps.proxyPort=6050" "-Dhttp.proxyUser=123456"
```
- - **Output**
```bash

PS C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week4_Spring REST using Spring Boot 3\Exercise 01 - spring-learn> mvn clean package "-Dhttp.proxyHost=proxy.cognizant.com" "-Dhttp.proxyPort=6050" "-Dhttps.proxyHost=proxy.cognizant.com" "-Dhttps.proxyPort=6050" "-Dhttp.proxyUser=123456"
[INFO] Scanning for projects...
[INFO]
[INFO] ---------------------< com.cognizant:spring-learn >---------------------
[INFO] Building spring-learn 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- clean:3.4.1:clean (default-clean) @ spring-learn ---
[INFO] Deleting C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week4_Spring REST using Spring Boot 3\Exercise 01 - spring-learn\target
[INFO]
[INFO] --- resources:3.3.1:resources (default-resources) @ spring-learn ---
[INFO] Copying 1 resource from src\main\resources to target\classes
[INFO] Copying 0 resource from src\main\resources to target\classes
[INFO]
[INFO] --- compiler:3.14.0:compile (default-compile) @ spring-learn ---
[INFO] Recompiling the module because of changed source code.
[INFO] Compiling 1 source file with javac [debug parameters release 21] to target\classes
[INFO]
[INFO] --- resources:3.3.1:testResources (default-testResources) @ spring-learn ---
[INFO] skip non existing resourceDirectory C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week4_Spring REST using Spring Boot 3\Exercise 01 - spring-learn\src\test\resources
[INFO]
[INFO] --- compiler:3.14.0:testCompile (default-testCompile) @ spring-learn ---
[INFO] Recompiling the module because of changed dependency.
[INFO] Compiling 1 source file with javac [debug parameters release 21] to target\test-classes
[INFO]
[INFO] --- surefire:3.5.3:test (default-test) @ spring-learn ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.cognizant.spring_learn.SpringLearnApplicationTests
12:23:31.548 [main] INFO org.springframework.test.context.support.AnnotationConfigContextLoaderUtils -- Could not detect default configuration classes for test class [com.cognizant.spring_learn.SpringLearnApplicationTests]: SpringLearnApplicationTests does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
12:23:31.799 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper -- Found @SpringBootConfiguration com.cognizant.spring_learn.SpringLearnApplication for test class com.cognizant.spring_learn.SpringLearnApplicationTests
12:23:32.192 [main] INFO org.springframework.boot.devtools.restart.RestartApplicationListener -- Restart disabled due to context in which it is running

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.5.3)

2025-07-09T12:23:34.677+05:30  INFO 17128 --- [spring-learn] [           main] c.c.s.SpringLearnApplicationTests        : Starting SpringLearnApplicationTests using Java 21 with PID 17128 (started by DESKTOP in C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week4_Spring REST using Spring Boot 3\Exercise 01 - spring-learn)
2025-07-09T12:23:34.677+05:30  INFO 17128 --- [spring-learn] [           main] c.c.s.SpringLearnApplicationTests        : No active profile set, falling back to 1 default profile: "default"
2025-07-09T12:23:38.480+05:30  INFO 17128 --- [spring-learn] [           main] c.c.s.SpringLearnApplicationTests        : Started SpringLearnApplicationTests in 6.304 seconds (process running for 8.509)
Mockito is currently self-attaching to enable the inline-mock-maker. This will no longer work in future releases of the JDK. Please add Mockito as an agent to your build as described in Mockito's documentation: https://javadoc.io/doc/org.mockito/mockito-core/latest/org.mockito/org/mockito/Mockito.html#0.3
WARNING: A Java agent has been loaded dynamically (C:\Users\DESKTOP\.m2\repository\net\bytebuddy\byte-buddy-agent\1.17.6\byte-buddy-agent-1.17.6.jar)
WARNING: If a serviceability tool is in use, please run with -XX:+EnableDynamicAgentLoading to hide this warning
WARNING: If a serviceability tool is not in use, please run with -Djdk.instrument.traceUsage for more information
WARNING: Dynamic loading of agents will be disallowed by default in a future release
Java HotSpot(TM) 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 8.674 s -- in com.cognizant.spring_learn.SpringLearnApplicationTests
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- jar:3.4.2:jar (default-jar) @ spring-learn ---
[INFO] Building jar: C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week4_Spring REST using Spring Boot 3\Exercise 01 - spring-learn\target\spring-learn-0.0.1-SNAPSHOT.jar
[INFO]
[INFO] --- spring-boot:3.5.3:repackage (repackage) @ spring-learn ---
[INFO] Replacing main artifact C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week4_Spring REST using Spring Boot 3\Exercise 01 - spring-learn\target\spring-learn-0.0.1-SNAPSHOT.jar with repackaged archive, adding nested dependencies in BOOT-INF/.
[INFO] The original artifact has been renamed to C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week4_Spring REST using Spring Boot 3\Exercise 01 - spring-learn\target\spring-learn-0.0.1-SNAPSHOT.jar.original
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  22.526 s
[INFO] Finished at: 2025-07-09T12:23:45+05:30
[INFO] ------------------------------------------------------------------------
PS C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week4_Spring REST using Spring Boot 3\Exercise 01 - spring-learn>
PS C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week4_Spring REST using Spring Boot 3\Exercise 01 - spring-learn>
```
### Screenshots 
    ![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week4_Spring%20REST%20using%20Spring%20Boot%203/Exercise%2001%20-%20spring-learn/Output_Screenshots/mvn%20build%20part-01.png?raw=true)
    ![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week4_Spring%20REST%20using%20Spring%20Boot%203/Exercise%2001%20-%20spring-learn/Output_Screenshots/mvn%20build%20part-02.png?raw=true)

- Ran the app 

```bash

PS C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week4_Spring REST using Spring Boot 3\Exercise 01 - spring-learn> java -jar .\target\spring-learn-0.0.1-SNAPSHOT.jar

LOGGING
Application Starting...


  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.5.3)
 
2025-07-09T12:25:40.505+05:30  INFO 14084 --- [spring-learn] [           main] c.c.spring_learn.SpringLearnApplication  : Starting SpringLearnApplication v0.0.1-SNAPSHOT using Java 21 with PID 14084 (C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week4_Spring REST using Spring Boot 3\Exercise 01 - spring-learn\target\spring-learn-0.0.1-SNAPSHOT.jar started by DESKTOP in C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week4_Spring REST using Spring Boot 3\Exercise 01 - spring-learn)
2025-07-09T12:25:40.512+05:30  INFO 14084 --- [spring-learn] [           main] c.c.spring_learn.SpringLearnApplication  : No active profile set, falling back to 1 default profile: "default"
2025-07-09T12:25:44.776+05:30  INFO 14084 --- [spring-learn] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2025-07-09T12:25:44.818+05:30  INFO 14084 --- [spring-learn] [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2025-07-09T12:25:44.819+05:30  INFO 14084 --- [spring-learn] [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.42]
2025-07-09T12:25:44.915+05:30  INFO 14084 --- [spring-learn] [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2025-07-09T12:25:44.918+05:30  INFO 14084 --- [spring-learn] [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 4206 ms
2025-07-09T12:25:45.915+05:30  INFO 14084 --- [spring-learn] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2025-07-09T12:25:45.962+05:30  INFO 14084 --- [spring-learn] [           main] c.c.spring_learn.SpringLearnApplication  : Started SpringLearnApplication in 7.283 seconds (process running for 8.554)

LOGGING
Application Started Successfully.


```
### Screenshot 

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week4_Spring%20REST%20using%20Spring%20Boot%203/Exercise%2001%20-%20spring-learn/Output_Screenshots/Running%20the%20app.png?raw=true)
