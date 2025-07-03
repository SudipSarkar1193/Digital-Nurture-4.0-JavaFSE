# ORM Learn — Spring Data JPA Quick Example (Oracle Version)

This is a demo project that showcases how to use **Spring Boot**, **Spring Data JPA**, and **Hibernate** with an **Oracle Database**.  
It is adapted from a Cognizant hands-on guide originally designed for MySQL.

**I took the liberty to use `Oracle Database` instead of MySQL**

---

## 📦 Project Details

- **Group**: `com.cognizant`
- **Artifact**: `orm-learn`
- **Spring Boot Version**: 3.5.3
- **Database**: Oracle 21c (or any compatible version)
- **Tools Used**:
  - IntelliJ IDEA Ultimate
  - Maven 3.6+
  - Oracle Database (Instead of MySQL)
  - DataGrip (Instead of MySQL workbench)
  - Java 21

---

## 🚀 Getting Started

### 1. Clone or Download the Project

Unzip or clone the Spring Initializr-generated project.

### 2. Set Up the Oracle Database

Use DataGrip or SQL\*Plus to run:

```sql
CREATE TABLE country (
    code VARCHAR2(2) PRIMARY KEY,
    name VARCHAR2(50)
);

INSERT INTO country VALUES ('IN', 'India');
INSERT INTO country VALUES ('US', 'United States of America');
COMMIT;
```

#### Screenshot (From DataGrip)

![Screenshot](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week3_Spring%20Core%20and%20Maven/Spring%20Data%20JPA%20-%20Quick%20Example%20%20-%20ORM%20Learn/output_Screenshots/SQL_output_01.png?raw=true)

### 3. Configure application.properties

```text
spring.application.name=orm-learn

# Logging
logging.level.org.springframework=info
logging.level.com.cognizant=debug
logging.level.org.hibernate.SQL=trace
logging.level.org.hibernate.type.descriptor.sql=trace

# Oracle DB config
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
spring.datasource.url=jdbc:oracle:thin:@localhost:1521/XEPDB1
spring.datasource.username=ormlearn
spring.datasource.password=ormlearn

# Hibernate config
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.OracleDialect

```

### 4. Add Oracle JDBC Driver in pom.xml

```xml
<dependency>
	<groupId>com.oracle.database.jdbc</groupId>
    <artifactId>ojdbc17</artifactId>
	<version>21.5.0.0</version>
	<scope>runtime</scope>
</dependency>
```
This declaration tells Maven:
- *“This project needs ojdbc17 during runtime, go find it in the local or remote repository.”*

### 5.Added JDBC Driver manually  

**Since Oracle doesn’t publish their drivers on public repositories like Maven Central, we manually install the .jar into our local Maven repository:**

```bash
C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week3_Spring Core and Maven\Spring Data JPA - Quick Example  - ORM Learn>mvn install:install-file -Dfile="C:\oracle driver\ojdbc17.jar" -DgroupId=com.oracle.database.jdbc -DartifactId=ojdbc17 -Dversion=21.5.0.0 -Dpackaging=jar
[INFO] Scanning for projects...
[INFO]
[INFO] ----------------------< com.cognizant:orm-learn >-----------------------
[INFO] Building orm-learn 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- install:3.1.4:install-file (default-cli) @ orm-learn ---
[INFO] pom.xml not found in ojdbc17.jar
[INFO] Installing C:\oracle driver\ojdbc17.jar to C:\Users\DESKTOP\.m2\repository\com\oracle\database\jdbc\ojdbc17\21.5.0.0\ojdbc17-21.5.0.0.jar
[INFO] Installing C:\Users\DESKTOP\AppData\Local\Temp\mvninstall13647472238731136599.pom to C:\Users\DESKTOP\.m2\repository\com\oracle\database\jdbc\ojdbc17\21.5.0.0\ojdbc17-21.5.0.0.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.502 s
[INFO] Finished at: 2025-07-03T21:16:29+05:30
[INFO] ------------------------------------------------------------------------

C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week3_Spring Core and Maven\Spring Data JPA - Quick Example  - ORM Learn>
```
---

## Project Structure 

```bash
src
├── main
│   ├── java
│   │   └── com.cognizant.ormlearn
│   │       ├── model
│   │       │   └── Country.java
│   │       ├── repository
│   │       │   └── CountryRepository.java
│   │       ├── service
│   │       │   └── CountryService.java
│   │       └── OrmLearnApplication.java
│   └── resources
│       └── application.properties
```

## 🧩 Core Concepts
### 🔸 @Entity, @Table, @Id, @Column
Used in Country entity class to map to country table in Oracle.

### 🔸 JpaRepository
Used in CountryRepository for basic CRUD without custom SQL.

### 🔸 @Service with @Transactional
Used in CountryService to auto-wire repository and perform operations.

## Output :

```bash
2025-07-03T21:38:21.945+05:30 DEBUG 13596 --- [orm-learn] [  restartedMain] org.hibernate.SQL                        : select c1_0.code,c1_0.name from country c1_0
2025-07-03T21:38:22.041+05:30 DEBUG 13596 --- [orm-learn] [  restartedMain] c.c.orm_learn.OrmLearnApplication        : countries=[Country{code='IN', name='India'}, Country{code='US', name='United States of America'}]
```

### Screenshot :

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week3_Spring%20Core%20and%20Maven/Spring%20Data%20JPA%20-%20Quick%20Example%20%20-%20ORM%20Learn/output_Screenshots/output.png?raw=true)


---

## Codes :

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
	<groupId>com.cognizant</groupId>
	<artifactId>orm-learn</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>orm-learn</name>
	<description>Demo project for Spring Data JPA and Hibernate</description>
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
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>

		<dependency>
			<groupId>com.oracle.database.jdbc</groupId>
			<artifactId>ojdbc17</artifactId>
			<version>21.5.0.0</version>
			<scope>runtime</scope>
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
### com.cognizant.orm_learn.model.Country
```java
package com.cognizant.orm_learn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

    // Getters and Setters

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

```
### com.cognizant.orm_learn.repository.CountryRepository
```java
package com.cognizant.orm_learn.repository;

import com.cognizant.orm_learn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
}

```
### com.cognizant.orm_learn.service.CountryService
```java
package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}

```

### com.cognizant.orm_learn.OrmLearnApplication
```java
package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);

		testGetAllCountries();
	}

	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}
}

```

---

## Output :

```bash
2025-07-03T21:38:21.945+05:30 DEBUG 13596 --- [orm-learn] [  restartedMain] org.hibernate.SQL                        : select c1_0.code,c1_0.name from country c1_0
2025-07-03T21:38:22.041+05:30 DEBUG 13596 --- [orm-learn] [  restartedMain] c.c.orm_learn.OrmLearnApplication        : countries=[Country{code='IN', name='India'}, Country{code='US', name='United States of America'}]
```

### Screenshot :

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week3_Spring%20Core%20and%20Maven/Spring%20Data%20JPA%20-%20Quick%20Example%20%20-%20ORM%20Learn/output_Screenshots/output.png?raw=true)
