package singletonPattern ;

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