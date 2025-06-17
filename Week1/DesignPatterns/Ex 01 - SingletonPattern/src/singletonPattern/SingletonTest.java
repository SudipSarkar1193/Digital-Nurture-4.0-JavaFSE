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
