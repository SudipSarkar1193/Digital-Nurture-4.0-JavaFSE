package forecast ;

public class FinancialForecast {

    // Recursive method to calculate future value
    public static double forecastValue(double currentValue, double rate, int years) {
        if (years == 0) return currentValue;
        return forecastValue(currentValue, rate, years - 1) * (1 + rate / 100);
    }
}