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
          3) Annuity Present Value Calculator
        ==========================================
        """;

        System.out.print(menu);
        System.out.print("Enter your choice (1-3): "); // User selects
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> mortgageCalculator(scanner);
            case 2 -> cdFutureValueCalculator(scanner);
            case 3 -> annuityPresentValueCalculator(scanner);
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

    public static double cdFutureValueCalculator(Scanner scanner) {
        return askDouble(scanner, "Please enter the principal: ");
    }

    public static double annuityPresentValueCalculator(Scanner scanner) {
        return askDouble(scanner, "Please enter the principal: ");
    }
}
