package Lab_Sheet2;

public class Invoice {

    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        setQuantity(quantity);
        setPricePerItem(pricePerItem);
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = (quantity < 0) ? 0 : quantity; // Ensure non-negative quantity
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = (pricePerItem < 0.0) ? 0.0 : pricePerItem; // Ensure non-negative price
    }

    public double getInvoiceAmount() {
        return quantity * pricePerItem;
    }

    public void displayInvoice() {
        System.out.println("Invoice Details:");
        System.out.println("Part Number: " + partNumber);
        System.out.println("Part Description: " + partDescription);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price per Item: $" + pricePerItem);
        System.out.println("Total Amount: $" + getInvoiceAmount());
    }

    public static void main(String[] args) {

        Invoice invoice = new Invoice("1234", "Hammer", 5, 19.99);

        invoice.displayInvoice();

        invoice.setQuantity(10);
        invoice.setPricePerItem(24.99);

        System.out.println("\nUpdated Invoice:");
        invoice.displayInvoice();
    }
}
