import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class MainMenu extends JFrame {
    public MainMenu() {
        JButton bookFlightBtn = new JButton("Book a Flight");
        JButton viewReservationsBtn = new JButton("View Reservations");

        bookFlightBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FlightSearchWindow(); // Open Flight Search Window
            }
        });

        viewReservationsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ReservationViewWindow(); // Open Reservations Window
            }
        });

        // Layout setup
        setLayout(new FlowLayout());
        add(bookFlightBtn);
        add(viewReservationsBtn);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}

// Flight class to store flight details
class Flight {
    String flightNumber;
    String destination;
    String departure;
    String date;
    int availableSeats;

    public Flight(String flightNumber, String destination, String departure, String date, int availableSeats) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departure = departure;
        this.date = date;
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return flightNumber + " to " + destination + " on " + date + " (Seats: " + availableSeats + ")";
    }
}

// Reservation class to store booking details
class Reservation {
    String passengerName;
    Flight flight;

    public Reservation(String passengerName, Flight flight) {
        this.passengerName = passengerName;
        this.flight = flight;
    }
}

// Window for searching and booking flights
class FlightSearchWindow extends JFrame {
    private static List<Flight> availableFlights = new ArrayList<>();
    private static List<Reservation> reservations = new ArrayList<>();

    static {
        // Predefined flights to New Delhi and Mumbai
        availableFlights.add(new Flight("FL001", "New Delhi", "Mumbai", "2023-12-01", 10));
        availableFlights.add(new Flight("FL002", "New Delhi", "Mumbai", "2023-12-02", 8));
        availableFlights.add(new Flight("FL003", "Mumbai", "New Delhi", "2023-12-03", 5));
        availableFlights.add(new Flight("FL004", "Mumbai", "New Delhi", "2023-12-04", 12));
    }

    public FlightSearchWindow() {
        setTitle("Search Flights");

        JLabel destinationLabel = new JLabel("Destination:");
        JTextField destinationField = new JTextField(10);
        JLabel dateLabel = new JLabel("Date:");
        JTextField dateField = new JTextField(10);

        JButton searchButton = new JButton("Search");

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String destination = destinationField.getText();
                String date = dateField.getText();
                List<Flight> matchedFlights = new ArrayList<>();

                for (Flight flight : availableFlights) {
                    if (flight.destination.equalsIgnoreCase(destination) && flight.date.equals(date)) {
                        matchedFlights.add(flight);
                    }
                }

                if (matchedFlights.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No flights found for " + destination + " on " + date);
                } else {
                    new FlightBookingWindow(matchedFlights); // Open booking window with matched flights
                }
            }
        });

        setLayout(new FlowLayout());
        add(destinationLabel);
        add(destinationField);
        add(dateLabel);
        add(dateField);
        add(searchButton);

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static List<Reservation> getReservations() {
        return reservations;
    }
}

// Window for booking flights from the search results
class FlightBookingWindow extends JFrame {
    public FlightBookingWindow(List<Flight> flights) {
        setTitle("Available Flights");

        DefaultListModel<Flight> listModel = new DefaultListModel<>();
        for (Flight flight : flights) {
            listModel.addElement(flight);
        }

        JList<Flight> flightList = new JList<>(listModel);
        flightList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(flightList);

        JLabel nameLabel = new JLabel("Passenger Name:");
        JTextField nameField = new JTextField(10);
        JButton bookButton = new JButton("Book Flight");

        bookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Flight selectedFlight = flightList.getSelectedValue();
                String passengerName = nameField.getText();

                if (selectedFlight != null && !passengerName.isEmpty()) {
                    if (selectedFlight.availableSeats > 0) {
                        selectedFlight.availableSeats--; // Reduce seat count
                        FlightSearchWindow.getReservations().add(new Reservation(passengerName, selectedFlight));
                        JOptionPane.showMessageDialog(null, "Flight booked for " + passengerName);
                    } else {
                        JOptionPane.showMessageDialog(null, "No available seats on this flight.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a flight and enter your name.");
                }
            }
        });

        setLayout(new FlowLayout());
        add(scrollPane);
        add(nameLabel);
        add(nameField);
        add(bookButton);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}

// Window for viewing reservations
class ReservationViewWindow extends JFrame {
    public ReservationViewWindow() {
        setTitle("View Reservations");

        List<Reservation> reservations = FlightSearchWindow.getReservations();
        String[] columnNames = {"Passenger Name", "Flight Number", "Destination", "Date"};
        Object[][] data = new Object[reservations.size()][4];

        for (int i = 0; i < reservations.size(); i++) {
            Reservation reservation = reservations.get(i);
            data[i][0] = reservation.passengerName;
            data[i][1] = reservation.flight.flightNumber;
            data[i][2] = reservation.flight.destination;
            data[i][3] = reservation.flight.date;
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);

        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
