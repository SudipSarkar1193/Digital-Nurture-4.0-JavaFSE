# 🌍 Spring Boot REST API - Get Country by Code

This is a simple Spring Boot REST application that returns a country's details (code and name) based on the provided country code. The country data is stored in an XML file and loaded at application startup using JAXB.

---

## 📁 Project Structure

```bash
src
├── main
│ ├── java
│ │ └── com.cognizant.spring_learn
│ │ ├── SpringLearnApplication.java
│ │ ├── controller
│ │ │ └── CountryController.java
│ │ ├── model
│ │ │ └── Country.java
│ │ ├── service
│ │ │ └── CountryService.java
│ │ └── wrapper
│ │ └── CountryList.java
│ └── resources
│ ├── application.properties
│ └── country.xml
```


---

## 🧪 Sample API Usage

### ✅ GET Country by Code (Case Insensitive)

**Request**

GET http://localhost:8080/countries/in


**Response**
```json
{
  "code": "IN",
  "name": "India"
}
```

## Output Screenshot

![output](?raw=true)

## 📝 Features

- Country details fetched from an XML file (country.xml)

- `@RestController` using `@GetMapping`

- `@PostConstruct` to load XML on app startup

- Case-insensitive search

- Clean separation: Controller ↔ Service ↔ Model

- Error handling for not found country

### ⚙️ How It Works

- CountryService reads `country.xml` and unmarshals it into a list of Country objects using `JAXB`.

- CountryController exposes a GET API that accepts the country code.

- The code is matched case-insensitively, and if found, returns the corresponding country.

- If no country is found, a custom exception is thrown.


### 📦 Dependencies
**pom.xml:**

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
	<groupId>om.cognizant.spring-learn</groupId>
	<artifactId>spring-learn</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>spring-learn</name>
	<description>Demo project for Spring Boot</description>
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
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>


		<!-- https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api -->
		<dependency>
			<groupId>javax.xml.bind</groupId>
			<artifactId>jaxb-api</artifactId>
			<version>2.3.1</version>
		</dependency>

		<dependency>
			<groupId>org.glassfish.jaxb</groupId>
			<artifactId>jaxb-runtime</artifactId>
			<version>2.3.5</version>
		</dependency>



		<dependency>
			<groupId>jakarta.annotation</groupId>
			<artifactId>jakarta.annotation-api</artifactId>
			<version>2.1.1</version>
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






