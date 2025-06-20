import forecast.FinancialForecast;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        // Taking user input
        System.out.print("Enter the initial investment value (Rs.): ");
        double initialValue = scanner.nextDouble();

        System.out.print("Enter the annual growth rate (%): ");
        double growthRate = scanner.nextDouble();

        System.out.print("Enter the number of years to forecast: ");
        int forecastYears = scanner.nextInt();

        // Call the recursive method
        double futureValue = FinancialForecast.forecastValue(initialValue, growthRate, forecastYears);
        
        System.out.println();
        // result
        System.out.printf("Future value after %d years: Rs. %.2f\n", forecastYears, futureValue);
        System.out.println();

        scanner.close(); 
    }
}
