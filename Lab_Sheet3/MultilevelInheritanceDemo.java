package Lab_Sheet3;

public class MultilevelInheritanceDemo {
    public static void main(String[] args) {

        Z zObject = new Z(10, 5);

        int sum = zObject.sum();
        int product = zObject.findProduct();
        int difference = zObject.findDifference();

        System.out.println("Results:");
        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
        System.out.println("Difference: " + difference);
    }
}

