package sem3_codes;

// Base class
class Vehicle {
    private String make;
    private String model;
    private int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void displayInfo() {
        System.out.println("Vehicle Info: " + year + " " + make + " " + model);
    }

    public void start() {
        System.out.println(make + " " + model + " is starting.");
    }

    public void stop() {
        System.out.println(make + " " + model + " is stopping.");
    }
}

// Subclass for Car
class Car extends Vehicle {
    private int numDoors;

    public Car(String make, String model, int year, int numDoors) {
        super(make, model, year);
        this.numDoors = numDoors;
    }

    public void honk() {
        System.out.println("Car horn: Beep! Beep!");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Doors: " + numDoors);
    }
}

// Subclass for Bicycle
class Bicycle extends Vehicle {
    private int gearCount;

    public Bicycle(String make, String model, int year, int gearCount) {
        super(make, model, year);
        this.gearCount = gearCount;
    }

    public void ringBell() {
        System.out.println("Bicycle bell: Ring! Ring!");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Gears: " + gearCount);
    }
}

// Subclass for Scooter
class Scooter extends Vehicle {
    private boolean electric;

    public Scooter(String make, String model, int year, boolean electric) {
        super(make, model, year);
        this.electric = electric;
    }

    public void kickStart() {
        if (!electric) {
            System.out.println("Scooter kick-started!");
        } else {
            System.out.println("Electric scooter does not require kick-start.");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Electric: " + (electric ? "Yes" : "No"));
    }
}

// Main class to demonstrate functionality
public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 2022, 4);
        Bicycle bicycle = new Bicycle("Giant", "Escape 3", 2021, 21);
        Scooter scooter = new Scooter("Vespa", "LX125", 2020, false);

        car.displayInfo();
        car.start();
        car.honk();
        car.stop();

        System.out.println();

        bicycle.displayInfo();
        bicycle.start();
        bicycle.ringBell();
        bicycle.stop();

        System.out.println();

        scooter.displayInfo();
        scooter.start();
        scooter.kickStart();
        scooter.stop();
    }
}

