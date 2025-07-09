# Spring Boot – Hello World RESTful Web Service

This project demonstrates a simple RESTful web service built with Spring Boot. It exposes a GET endpoint at `/hello` that returns the text "Hello World!!" using Spring Web Framework.

---

## 🧩 Use Case

A web application needs a simple REST endpoint to verify that the server is running and responding correctly. This assignment demonstrates how to:

- Create a REST controller using Spring Boot.
- Handle a GET request at `/hello`.
- Return a hardcoded response "Hello World!!".
- Log the start and end of the request processing.

---

## 🏗️ Project Structure

```bash
HelloWorld_RESTfulWebService/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── cognizant/
│   │   │           └── springlearn/
│   │   │               ├── controller/
│   │   │               │   └── HelloController.java
│   │   │               └── SpringLearnApplication.java
│   │   └── resources/
│   │       └── application.properties
├── pom.xml
```

---

## Codes

### pom.xml 

```xml

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.5.3</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.cognizant.springlearn</groupId>
	<artifactId>HelloWorld_RESTfulWebService</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>Hello World RESTful Web Service</name>
	<description>Demo project for Spring REST</description>
	<url/>
	<licenses>
		<license/>
	</licenses>
	<developers>
		<developer/>
	</developers>
	<scm>
		<connection/>
		<developerConnection/>
		<tag/>
		<url/>
	</scm>
	<properties>
		<java.version>21</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>


```

### application.properties

```properties

spring.application.name=Hello World RESTful Web Service
server.port=8083
```

### HelloController.java – REST Controller

```java
package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @GetMapping
    public String sayHello() {
        LOGGER.info("Start of sayHello method");
        String response = "Hello World!!";
        LOGGER.info("End of sayHello method");
        return response;
    }
}
```

---

## Output

- **Firefox**: 

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week4_Spring%20REST%20using%20Spring%20Boot%203/Exercise%2003%20-%20Hello%20World%20RESTful%20Web%20Service/Output_Screenshots/output%20at%20browser.png?raw=true)


- **Console** :

```bash

"C:\Program Files\Java\jdk-21\bin\java.exe" -XX:TieredStopAtLevel=1 -Dspring.output.ansi.enabled=always -Dcom.sun.management.jmxremote -Dspring.jmx.enabled=true -Dspring.liveBeansView.mbeanDomain -Dspring.application.admin.enabled=true "-Dmanagement.endpoints.jmx.exposure.include=*" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2025.1.2\lib\idea_rt.jar=52334" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week4_Spring REST using Spring Boot 3\Exercise 03 - Hello World RESTful Web Service\target\classes;C:\Users\DESKTOP\.m2\repository\org\springframework\boot\spring-boot-starter-web\3.5.3\spring-boot-starter-web-3.5.3.jar;C:\Users\DESKTOP\.m2\repository\org\springframework\boot\spring-boot-starter\3.5.3\spring-boot-starter-3.5.3.jar;C:\Users\DESKTOP\.m2\repository\org\springframework\boot\spring-boot\3.5.3\spring-boot-3.5.3.jar;C:\Users\DESKTOP\.m2\repository\org\springframework\boot\spring-boot-autoconfigure\3.5.3\spring-boot-autoconfigure-3.5.3.jar;C:\Users\DESKTOP\.m2\repository\org\springframework\boot\spring-boot-starter-logging\3.5.3\spring-boot-starter-logging-3.5.3.jar;C:\Users\DESKTOP\.m2\repository\ch\qos\logback\logback-classic\1.5.18\logback-classic-1.5.18.jar;C:\Users\DESKTOP\.m2\repository\ch\qos\logback\logback-core\1.5.18\logback-core-1.5.18.jar;C:\Users\DESKTOP\.m2\repository\org\apache\logging\log4j\log4j-to-slf4j\2.24.3\log4j-to-slf4j-2.24.3.jar;C:\Users\DESKTOP\.m2\repository\org\apache\logging\log4j\log4j-api\2.24.3\log4j-api-2.24.3.jar;C:\Users\DESKTOP\.m2\repository\org\slf4j\jul-to-slf4j\2.0.17\jul-to-slf4j-2.0.17.jar;C:\Users\DESKTOP\.m2\repository\jakarta\annotation\jakarta.annotation-api\2.1.1\jakarta.annotation-api-2.1.1.jar;C:\Users\DESKTOP\.m2\repository\org\yaml\snakeyaml\2.4\snakeyaml-2.4.jar;C:\Users\DESKTOP\.m2\repository\org\springframework\boot\spring-boot-starter-json\3.5.3\spring-boot-starter-json-3.5.3.jar;C:\Users\DESKTOP\.m2\repository\com\fasterxml\jackson\core\jackson-databind\2.19.1\jackson-databind-2.19.1.jar;C:\Users\DESKTOP\.m2\repository\com\fasterxml\jackson\core\jackson-annotations\2.19.1\jackson-annotations-2.19.1.jar;C:\Users\DESKTOP\.m2\repository\com\fasterxml\jackson\core\jackson-core\2.19.1\jackson-core-2.19.1.jar;C:\Users\DESKTOP\.m2\repository\com\fasterxml\jackson\datatype\jackson-datatype-jdk8\2.19.1\jackson-datatype-jdk8-2.19.1.jar;C:\Users\DESKTOP\.m2\repository\com\fasterxml\jackson\datatype\jackson-datatype-jsr310\2.19.1\jackson-datatype-jsr310-2.19.1.jar;C:\Users\DESKTOP\.m2\repository\com\fasterxml\jackson\module\jackson-module-parameter-names\2.19.1\jackson-module-parameter-names-2.19.1.jar;C:\Users\DESKTOP\.m2\repository\org\springframework\boot\spring-boot-starter-tomcat\3.5.3\spring-boot-starter-tomcat-3.5.3.jar;C:\Users\DESKTOP\.m2\repository\org\apache\tomcat\embed\tomcat-embed-core\10.1.42\tomcat-embed-core-10.1.42.jar;C:\Users\DESKTOP\.m2\repository\org\apache\tomcat\embed\tomcat-embed-el\10.1.42\tomcat-embed-el-10.1.42.jar;C:\Users\DESKTOP\.m2\repository\org\apache\tomcat\embed\tomcat-embed-websocket\10.1.42\tomcat-embed-websocket-10.1.42.jar;C:\Users\DESKTOP\.m2\repository\org\springframework\spring-web\6.2.8\spring-web-6.2.8.jar;C:\Users\DESKTOP\.m2\repository\org\springframework\spring-beans\6.2.8\spring-beans-6.2.8.jar;C:\Users\DESKTOP\.m2\repository\io\micrometer\micrometer-observation\1.15.1\micrometer-observation-1.15.1.jar;C:\Users\DESKTOP\.m2\repository\io\micrometer\micrometer-commons\1.15.1\micrometer-commons-1.15.1.jar;C:\Users\DESKTOP\.m2\repository\org\springframework\spring-webmvc\6.2.8\spring-webmvc-6.2.8.jar;C:\Users\DESKTOP\.m2\repository\org\springframework\spring-aop\6.2.8\spring-aop-6.2.8.jar;C:\Users\DESKTOP\.m2\repository\org\springframework\spring-context\6.2.8\spring-context-6.2.8.jar;C:\Users\DESKTOP\.m2\repository\org\springframework\spring-expression\6.2.8\spring-expression-6.2.8.jar;C:\Users\DESKTOP\.m2\repository\org\slf4j\slf4j-api\2.0.17\slf4j-api-2.0.17.jar;C:\Users\DESKTOP\.m2\repository\org\springframework\spring-core\6.2.8\spring-core-6.2.8.jar;C:\Users\DESKTOP\.m2\repository\org\springframework\spring-jcl\6.2.8\spring-jcl-6.2.8.jar" com.cognizant.springlearn.HelloWorldResTfulWebServiceApplication

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.5.3)

2025-07-09T18:26:32.313+05:30  INFO 13484 --- [Hello World RESTful Web Service] [           main] s.HelloWorldResTfulWebServiceApplication : Starting HelloWorldResTfulWebServiceApplication using Java 21 with PID 13484 (C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week4_Spring REST using Spring Boot 3\Exercise 03 - Hello World RESTful Web Service\target\classes started by DESKTOP in C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week4_Spring REST using Spring Boot 3\Exercise 03 - Hello World RESTful Web Service)
2025-07-09T18:26:32.319+05:30  INFO 13484 --- [Hello World RESTful Web Service] [           main] s.HelloWorldResTfulWebServiceApplication : No active profile set, falling back to 1 default profile: "default"
2025-07-09T18:26:34.200+05:30  INFO 13484 --- [Hello World RESTful Web Service] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8083 (http)
2025-07-09T18:26:34.229+05:30  INFO 13484 --- [Hello World RESTful Web Service] [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2025-07-09T18:26:34.229+05:30  INFO 13484 --- [Hello World RESTful Web Service] [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.42]
2025-07-09T18:26:34.328+05:30  INFO 13484 --- [Hello World RESTful Web Service] [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2025-07-09T18:26:34.328+05:30  INFO 13484 --- [Hello World RESTful Web Service] [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1858 ms
2025-07-09T18:26:35.243+05:30  INFO 13484 --- [Hello World RESTful Web Service] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8083 (http) with context path '/'
2025-07-09T18:26:35.257+05:30  INFO 13484 --- [Hello World RESTful Web Service] [           main] s.HelloWorldResTfulWebServiceApplication : Started HelloWorldResTfulWebServiceApplication in 4.42 seconds (process running for 7.609)
2025-07-09T18:26:55.640+05:30  INFO 13484 --- [Hello World RESTful Web Service] [nio-8083-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2025-07-09T18:26:55.643+05:30  INFO 13484 --- [Hello World RESTful Web Service] [nio-8083-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2025-07-09T18:26:55.645+05:30  INFO 13484 --- [Hello World RESTful Web Service] [nio-8083-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 2 ms
2025-07-09T18:26:55.700+05:30  INFO 13484 --- [Hello World RESTful Web Service] [nio-8083-exec-1] c.c.s.controller.HelloController         : Start of sayHello method
2025-07-09T18:26:55.700+05:30  INFO 13484 --- [Hello World RESTful Web Service] [nio-8083-exec-1] c.c.s.controller.HelloController         : End of sayHello method

```

- **Screenshot**

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week4_Spring%20REST%20using%20Spring%20Boot%203/Exercise%2003%20-%20Hello%20World%20RESTful%20Web%20Service/Output_Screenshots/Output%20at%20IDE.png?raw=true)

