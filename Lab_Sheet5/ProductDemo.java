package Lab_Sheet5;

class Product {
    private String productId;
    private String name;
    private String categoryId;
    private double unitPrice;

    public Product(String productId, String name, String categoryId, double unitPrice) {
        this.productId = productId;
        this.name = name;
        this.categoryId = categoryId;
        this.unitPrice = unitPrice;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Category ID: " + categoryId);
        System.out.println("Unit Price: $" + unitPrice);
    }
}

class ElectricalProduct extends Product {
    private String voltageRange;
    private int wattage;

    public ElectricalProduct(String productId, String name, String categoryId, double unitPrice, String voltageRange, int wattage) {
        super(productId, name, categoryId, unitPrice);
        this.voltageRange = voltageRange;
        this.wattage = wattage;
    }

    public String getVoltageRange() {
        return voltageRange;
    }

    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }

    public void updateDetails(int newWattage, double newPrice) {
        setWattage(newWattage);
        setUnitPrice(newPrice);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Voltage Range: " + voltageRange);
        System.out.println("Wattage: " + wattage + " W");
    }
}

public class ProductDemo {
    public static void main(String[] args) {

        ElectricalProduct ep = new ElectricalProduct("E101", "Electric Kettle", "C1001", 29.99, "220-240V", 1500);

        System.out.println("Initial Electrical Product Details:");
        ep.displayDetails();

        ep.updateDetails(1800, 34.99);

        System.out.println("\nUpdated Electrical Product Details:");
        ep.displayDetails();
    }
}
