package Lab_Sheet3;

public class InheritanceDemo {
    public static void main(String[] args) {

        Cone cone = new Cone(5, 12, 13);

        cone.calcArea();
        cone.calcVolume();

        System.out.println("Cone Details:");
        cone.dispArea();
        cone.dispVolume();
    }
}

