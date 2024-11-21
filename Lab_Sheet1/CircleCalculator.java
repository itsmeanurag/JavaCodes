package Lab_Sheet1;

import java.util.Scanner;

public class CircleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the radius of the circle (integer): ");
        int radius = scanner.nextInt();

        double pi = 3.14159265359;

        int diameter = 2 * radius;
        double circumference = 2 * pi * radius;
        double area = pi * radius * radius;

        System.out.println("\nResults:");
        System.out.println("Diameter of the circle: " + diameter);
        System.out.println("Circumference of the circle: " + circumference);
        System.out.println("Area of the circle: " + area);

    }
}

