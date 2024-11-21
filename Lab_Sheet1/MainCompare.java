package Lab_Sheet1;

import java.util.Scanner;

public class MainCompare {

    public void compareNumbers(int num1, int num2) {
        if (num1 > num2) {
            System.out.println(num1 + " is larger.");
        } else if (num2 > num1) {
            System.out.println(num2 + " is larger.");
        } else {
            System.out.println("The numbers are equal.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainCompare comparator = new MainCompare();

        System.out.print("Enter the first integer: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second integer: ");
        int num2 = scanner.nextInt();

        comparator.compareNumbers(num1, num2);

    }
}

