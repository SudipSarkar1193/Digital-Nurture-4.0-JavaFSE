# Financial Forecasting Tool

This project implements a financial forecasting tool using a recursive algorithm to predict future values based on past growth rates. It is developed in Java as part of the **Digital Nurture 4.0 Java FSE** exercise.

## 📁 Repository Structure

```
├── root/
    ├── bin/
    │   └── output/
    ├── src/
        ├── forecast/
        │   └── FinancialForecast.java
        └── Main.java
```


- **bin/**: Contains compiled `.class` files.
- **output/**: Contains a screenshot of the program output.
- **src/**: Contains source `.java` files.
  - `Main.java`: Entry point.
  - `forecast/FinancialForecast.java`: FinancialForecast class containing forecastValue method .


## 📝 Project Description

The tool calculates the future value of an investment based on an initial value, annual growth rate, and the number of years using a recursive approach. The program takes user input for these parameters and outputs the predicted future value.

### ⚙️ Setup: Recursive Future Value Method
We want to forecast the future financial value recursively, assuming:

Initial value V0

Annual growth rate r (as a percentage)

Number of years n :

🔧 Formula:
Future Value after n years:

![Recursive Formula](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week1_Data%20Structure%20%26%20Algorithm/Exercise%207%20-%20%20Financial%20Forecasting/imagesForREADME/CodeCogsEqn.png?raw=true)


### Key Features
- **Recursive Algorithm**: Computes future value using recursion, simplifying the problem by breaking it down into smaller subproblems.
- **User Input**: Accepts initial investment, growth rate, and forecast duration via console.
- **Formatted Output**: Displays the calculated future value with two decimal places.


## 🧠 Recursion Explanation

**Recursion** is a process where a method calls itself to solve a smaller instance of the same problem. In this project, the `forecastValue` method recursively calculates the future value by:
- Reducing the number of years by 1 in each recursive call.
- Multiplying the result by `(1 + rate/100)` to account for the growth rate.
- Using a base case (`years == 0`) to return the current value, terminating the recursion.

This approach simplifies the problem by breaking it into smaller, manageable subproblems.

## ⏰ Time Complexity Analysis

- **Time Complexity**: O(n), where `n` is the number of years. Each recursive call reduces the years by 1, resulting in `n` calls.
- **Space Complexity**: O(n), due to the recursive call stack storing `n` frames.


### ⚠️ Problem with Recursion:
- Deep recursion can lead to stack overflow if n is very large.

- Repeated calculations in some recursive patterns can be inefficient.

✅ Ideal for small-scale predictions or when recursion depth is within safe limits.

## 📄 Code Overview

### `FinancialForecast.java`
```java
package forecast;

public class FinancialForecast {
    public static double forecastValue(double currentValue, double rate, int years) {
        if (years == 0) return currentValue;
        return forecastValue(currentValue, rate, years - 1) * (1 + rate / 100);
    }
}
```

### `Main.java`
```java
import forecast.FinancialForecast;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter the initial investment value (Rs.): ");
        double initialValue = scanner.nextDouble();

        System.out.print("Enter the annual growth rate (%): ");
        double growthRate = scanner.nextDouble();

        System.out.print("Enter the number of years to forecast: ");
        int forecastYears = scanner.nextInt();

        double futureValue = FinancialForecast.forecastValue(initialValue, growthRate, forecastYears);
        
        System.out.println();
        System.out.printf("Future value after %d years: Rs. %.2f\n", forecastYears, futureValue);
        System.out.println();

        scanner.close();
    }
}
```

## Output 

```bash

PS C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week1\Data Structure & Algorithm\Exercise 7 -  Financial Forecasting> javac -d bin .\src\Main.java .\src\forecast\FinancialForecast.java
PS C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week1\Data Structure & Algorithm\Exercise 7 -  Financial Forecasting> java -cp bin Main

Enter the initial investment value (Rs.): 154795
Enter the annual growth rate (%): 12
Enter the number of years to forecast: 10

Future value after 10 years: Rs. 480769.77

PS C:\Users\DESKTOP\Desktop\01__Digital_Narture_4.0\Week1\Data Structure & Algorithm\Exercise 7 -  Financial Forecasting>

```

## 📚 Learnings
We are completing this hands-on exercise as part of the Digital_Nurture_4.0_Java_FSE program. In this assignment, we learned:

- How recursion is useful in such cases.
- Analyzing the time and space complexity of recursive algorithms.
- Handling user input and output formatting in Java.
