import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// Main menu for Hotel Management System
public class MainMenu2 extends JFrame {
    public MainMenu2() {
        setTitle("Hotel Management System");

        JButton bookRoomBtn = new JButton("Book a Room");
        JButton checkAvailabilityBtn = new JButton("Check Room Availability");
        JButton generateBillBtn = new JButton("Generate Bill");

        bookRoomBtn.addActionListener(e -> new RoomBookingWindow());
        checkAvailabilityBtn.addActionListener(e -> new RoomAvailabilityWindow());
        generateBillBtn.addActionListener(e -> new BillingWindow());

        setLayout(new FlowLayout());
        add(bookRoomBtn);
        add(checkAvailabilityBtn);
        add(generateBillBtn);

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainMenu2();
    }
}

// Room class for storing room details
class Room {
    String roomNumber;
    String type;
    double price;
    boolean isAvailable;

    public Room(String roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.isAvailable = true;
    }
}

// Customer class for storing customer details
class Customer {
    String name;
    String contact;
    Room room;
    String checkInDate;
    String checkOutDate;

    public Customer(String name, String contact, Room room, String checkInDate, String checkOutDate) {
        this.name = name;
        this.contact = contact;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
}

// RoomBookingWindow for booking rooms
class RoomBookingWindow extends JFrame {
    private static List<Room> rooms = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();

    static {
        // Predefined rooms in the hotel
        rooms.add(new Room("101", "Single", 100.0));
        rooms.add(new Room("102", "Single", 100.0));
        rooms.add(new Room("201", "Double", 150.0));
        rooms.add(new Room("202", "Double", 150.0));
        rooms.add(new Room("301", "Suite", 300.0));
    }

    public RoomBookingWindow() {
        setTitle("Room Booking");

        JLabel nameLabel = new JLabel("Customer Name:");
        JTextField nameField = new JTextField(10);
        JLabel contactLabel = new JLabel("Contact:");
        JTextField contactField = new JTextField(10);
        JLabel roomTypeLabel = new JLabel("Room Type:");
        JComboBox<String> roomTypeBox = new JComboBox<>(new String[]{"Single", "Double", "Suite"});
        JLabel checkInLabel = new JLabel("Check-in Date:");
        JTextField checkInField = new JTextField(10);
        JLabel checkOutLabel = new JLabel("Check-out Date:");
        JTextField checkOutField = new JTextField(10);

        JButton bookButton = new JButton("Book Room");

        bookButton.addActionListener(e -> {
            String name = nameField.getText();
            String contact = contactField.getText();
            String roomType = (String) roomTypeBox.getSelectedItem();
            String checkInDate = checkInField.getText();
            String checkOutDate = checkOutField.getText();

            Room availableRoom = null;
            for (Room room : rooms) {
                if (room.type.equals(roomType) && room.isAvailable) {
                    availableRoom = room;
                    room.isAvailable = false; // Mark room as booked
                    break;
                }
            }

            if (availableRoom != null) {
                Customer customer = new Customer(name, contact, availableRoom, checkInDate, checkOutDate);
                customers.add(customer);
                JOptionPane.showMessageDialog(null, "Room booked successfully for " + name);
            } else {
                JOptionPane.showMessageDialog(null, "No available rooms of selected type.");
            }
        });

        setLayout(new FlowLayout());
        add(nameLabel);
        add(nameField);
        add(contactLabel);
        add(contactField);
        add(roomTypeLabel);
        add(roomTypeBox);
        add(checkInLabel);
        add(checkInField);
        add(checkOutLabel);
        add(checkOutField);
        add(bookButton);

        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static List<Room> getRooms() {
        return rooms;
    }

    public static List<Customer> getCustomers() {
        return customers;
    }
}

// RoomAvailabilityWindow for viewing room availability
class RoomAvailabilityWindow extends JFrame {
    public RoomAvailabilityWindow() {
        setTitle("Room Availability");

        String[] columnNames = {"Room Number", "Type", "Price", "Availability"};
        Object[][] data = new Object[RoomBookingWindow.getRooms().size()][4];

        for (int i = 0; i < RoomBookingWindow.getRooms().size(); i++) {
            Room room = RoomBookingWindow.getRooms().get(i);
            data[i][0] = room.roomNumber;
            data[i][1] = room.type;
            data[i][2] = room.price;
            data[i][3] = room.isAvailable ? "Available" : "Booked";
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}

// BillingWindow for generating bills
class BillingWindow extends JFrame {
    public BillingWindow() {
        setTitle("Generate Bill");

        JLabel customerNameLabel = new JLabel("Customer Name:");
        JTextField customerNameField = new JTextField(10);
        JButton generateBillButton = new JButton("Generate Bill");

        generateBillButton.addActionListener(e -> {
            String customerName = customerNameField.getText();
            Customer customer = RoomBookingWindow.getCustomers().stream()
                    .filter(c -> c.name.equalsIgnoreCase(customerName))
                    .findFirst()
                    .orElse(null);

            if (customer != null) {
                double totalCost = customer.room.price; // Here, you can add logic for multiple days
                JOptionPane.showMessageDialog(null, "Bill for " + customer.name + "\nRoom Type: " + customer.room.type + "\nTotal: $" + totalCost);
            } else {
                JOptionPane.showMessageDialog(null, "Customer not found.");
            }
        });

        setLayout(new FlowLayout());
        add(customerNameLabel);
        add(customerNameField);
        add(generateBillButton);

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
