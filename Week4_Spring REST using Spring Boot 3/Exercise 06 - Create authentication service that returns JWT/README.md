# 🔐 JWT Authentication Service - Spring Boot

This project is a simple Spring Boot application that demonstrates how to implement JWT (JSON Web Token) based authentication using **Basic Auth** credentials and the **Auth0 Java JWT** library.

---

## 🚀 Features

- Basic authentication using `curl` (`-u user:pwd`)
- Generates JWT on successful authentication
- Token includes:
    - Subject (username)
    - Issue time
    - Expiry time (10 minutes)
- No database or user persistence — credentials are hardcoded or configured via `application.properties`

---

## 🛠 Technologies Used

- Spring Boot 3.5.3
- Spring Security 6.x
- Java 21
- Auth0 `java-jwt` (v4.4.0)
- IntelliJ IDEA Ultimate
- Maven

---

## 📁 Folder Structure

```bash
src/main/java/com/cognizant/jwt_auth
│
├── config/
│ └── SecurityConfig.java # Spring Security configuration
│
├── controller/
│ └── AuthController.java # REST controller for /authenticate
│
├── util/
│ └── JwtUtil.java # JWT generation logic
│
└── JwtAuthApplication.java # Spring Boot main class
```


---

## 🔑 Authentication Flow

1. **Client** sends request with basic credentials:
```bash
   curl -u user:pwd http://localhost:8090/authenticate
```

2. **Server** decodes Authorization header and verifies credentials.

3. On success, a JWT is returned:
```bash
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}

```




## 🧪 Test the Endpoint

**🟢Used Git Bash / CMD**

```bash
curl -u user:pwd http://localhost:8090/authenticate
```

### Screenshot 

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week4_Spring%20REST%20using%20Spring%20Boot%203/Exercise%2006%20-%20Create%20authentication%20service%20that%20returns%20JWT/Output_Screenshot/Output.png?raw=true)
