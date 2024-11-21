package Lab_Sheet1;
import java.util.Scanner;

class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double divide(int a, int b) {
        if (b != 0) {
            return (double) a / b;
        } else {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
    }
}


public class MainCal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.print("Enter the first integer: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second integer: ");
        int num2 = scanner.nextInt();

        System.out.println("\nCalculating results...");
        System.out.println("Sum: " + calculator.add(num1, num2));
        System.out.println("Product: " + calculator.multiply(num1, num2));
        System.out.println("Difference: " + calculator.subtract(num1, num2));

        try {
            System.out.println("Quotient: " + calculator.divide(num1, num2));
        } catch (ArithmeticException e) {
            System.out.println("Quotient: " + e.getMessage());
        }

        scanner.close();
    }
}
