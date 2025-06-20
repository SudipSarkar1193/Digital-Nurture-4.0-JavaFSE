# Logger Singleton Implementation

This document describes the implementation of the **Singleton Design Pattern** in Java for a `Logger` class, ensuring a single instance for consistent logging throughout the application.



- **bin/**: Contains compiled `.class` files.
- **output/**: Contains a screenshot of the program output (`SingletonPattern.png`).
- **src/**: Contains source `.java` files.
  - `Main/Main.java`: Entry point for testing the Singleton.
  - `singletonPattern/Logger.java`: Singleton class for logging.
  - `singletonPattern/SingletonTest.java`: Test class to verify Singleton behavior.


## Code Description

### Logger Class (`src/singletonPattern/Logger.java`)

Below is the implementation of the `Logger` class, which follows the Singleton pattern:

```java
package singletonPattern;

public class Logger {
    // Private static instance of the class
    private static Logger logger = null;
    
    private Logger() {
        // Private constructor to prevent instantiation from outside
    }
    
    // Public static getInstance method to get the single instance
    public static Logger getLoggerInstance() {
        if (logger == null) {
            logger = new Logger();
        }  
        return logger;
    }
    
    // Sample logging method
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
```

#### Key Features:
- **Private Static Instance**: `private static Logger logger = null` holds the single instance.
- **Private Constructor**: `private Logger()` prevents external instantiation.
- **Static Access Method**: `getLoggerInstance()` checks if `logger` is null and creates a new instance only if necessary, then returns the instance.
- **Logging Method**: `log(String message)` outputs messages to the console, prefixed with "Log: ".


## Testing the Singleton

The `SingletonTest.java` class (assumed to exist in `src/singletonPattern/`) likely tests the Singleton by:
- Obtaining two instances via `Logger.getLoggerInstance()`.
- Calling `log()` on both to demonstrate functionality.
- Comparing them to confirm they are the same object.


Test code :
```java
package singletonPattern;

public class SingletonTest {
    public static void test() {
       
        Logger logger1 = Logger.getLoggerInstance();
        Logger logger2 = Logger.getLoggerInstance();
        
        System.out.println(); 
        System.out.println();


        logger1.log("This is logger1");
        logger2.log("This is logger2");

        System.out.println();

        // Testing if both logger1 & logger2 point to the same instance or not
        System.out.println("Are logger1 and logger2 the same instance?? " + (logger1 == logger2));

        System.out.println();
        System.out.println();
        
    }
}

```


## Conclusion
This `Logger` class demonstrates a basic Singleton pattern suitable for single-threaded applications. 