package Lab_Sheet1;

import java.util.Scanner;

interface CalculatorInterface {
    int calculateSum(int a, int b, int c);

    double calculateAverage(int a, int b, int c);

    int calculateProduct(int a, int b, int c);
}

abstract class CalculatorAbstract implements CalculatorInterface {
    public abstract int findLargest(int a, int b, int c);

    public abstract int findSmallest(int a, int b, int c);
}

public class MainCalculator extends CalculatorAbstract {

    @Override
    public int calculateSum(int a, int b, int c) {
        return a + b + c;
    }

    @Override
    public double calculateAverage(int a, int b, int c) {
        return (a + b + c) / 3.0;
    }

    @Override
    public int calculateProduct(int a, int b, int c) {
        return a * b * c;
    }

    @Override
    public int findLargest(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    @Override
    public int findSmallest(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainCalculator calculator = new MainCalculator();

        System.out.print("Enter the first integer: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the second integer: ");
        int num2 = scanner.nextInt();
        System.out.print("Enter the third integer: ");
        int num3 = scanner.nextInt();

        int sum = calculator.calculateSum(num1, num2, num3);
        double average = calculator.calculateAverage(num1, num2, num3);
        int product = calculator.calculateProduct(num1, num2, num3);
        int largest = calculator.findLargest(num1, num2, num3);
        int smallest = calculator.findSmallest(num1, num2, num3);

        System.out.println("\nResults:");
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Product: " + product);
        System.out.println("Largest: " + largest);
        System.out.println("Smallest: " + smallest);

    }
}

