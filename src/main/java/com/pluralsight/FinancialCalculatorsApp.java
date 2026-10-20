package com.pluralsight;

import java.util.Scanner;

public class FinancialCalculatorsApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input Menu
        String menu = """
        ==========================================
                Welcome to Financial Calculators
        ==========================================
        Please choose a calculator:
          1) Mortgage Calculator
          2) CD Future Value Calculator
        ==========================================
        """;

        System.out.print(menu);
        System.out.print("Enter your choice (1-2): "); // User selects
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> mortgageCalculator(scanner);
            case 2 -> cdFutureValueCalculator(scanner);
            default -> System.out.println("Invalid choice.");
        }

    }


    // Double input method
    public static double askDouble(Scanner scanner, String question) {
        System.out.print(question);
        double number = scanner.nextDouble();
        return number;
    }


    // Calculation Methods
    public static void mortgageCalculator(Scanner scanner) {
        System.out.println("\n--- Mortgage Calculator ---");

        // Inputs
        double principalAmount = askDouble(scanner, "Please enter the principal: ");
        double interestRatePercentage = askDouble(scanner, "Please enter the interest rate as a percentage: ");
        double years = askDouble(scanner, "Please enter the years: ");

        // Formula pieces
        double r = interestRatePercentage / 100.0;   // annual rate as a decimal
        double i = r / 12;                           // monthly interest rate
        double n = 12 * years;                       // number of monthly payments

        // M = P × (i × (1 + i)^n) / ((1 + i)^n − 1)
        double growthFactor = Math.pow(1 + i, n);    // (1 + i)^n, used twice
        double top = i * growthFactor;
        double bottom = growthFactor - 1;
        double monthlyPayment = principalAmount * (top / bottom);

        // Total Interest = (M × n) − P
        double totalInterest = (monthlyPayment * n) - principalAmount;

        // Output
        System.out.printf("Monthly payment: $%,.2f%n", monthlyPayment);
        System.out.printf("Total interest:  $%,.2f%n", totalInterest);
    }

    public static void cdFutureValueCalculator(Scanner scanner) {
        System.out.println("\n--- CD Future Value Calculator ---");

        // Inputs
        double depositAmount = askDouble(scanner, "Please enter the deposit amount: ");
        double interestRatePercentage = askDouble(scanner, "Please enter the interest rate as a percentage: ");
        double years = askDouble(scanner, "Please enter the number of years: ");

        // Formula pieces
        double r = interestRatePercentage / 100.0;   // annual rate as a decimal
        double d = 365;                              // days per year (daily compounding)
        double n = d * years;                        // total number of days

        // FV = P × (1 + r/d)^n
        double growthFactor = Math.pow(1 + (r / d), n);
        double futureValue = depositAmount * growthFactor;

        // Interest Earned = FV − P
        double interestEarned = futureValue - depositAmount;

        // Output
        System.out.printf("Future Value : $%,.2f%n", futureValue);
        System.out.printf("Interest Earned:  $%,.2f%n", interestEarned);
    }


}
