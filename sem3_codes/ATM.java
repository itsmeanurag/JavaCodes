package sem3_codes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ATM {
    private static HashMap<String, Account> accounts = new HashMap<>();
    private static String currentUser = null;

    public static void main(String[] args) {
        // Populate with an example admin and a sample user account
        accounts.put("admin", new Account("admin", "admin123", 0.0, true));
        accounts.put("user1", new Account("user1", "password", 1000.0, false));

        // Show login screen
        showLoginScreen();
    }

    public static void showLoginScreen() {
        JFrame frame = new JFrame("ATM Login");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeLoginComponents(panel);
        frame.setVisible(true);
    }

    private static void placeLoginComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                if (authenticate(username, password)) {
                    panel.getTopLevelAncestor().setVisible(false);
                    if (accounts.get(username).isAdmin()) {
                        showAdminScreen();
                    } else {
                        showUserScreen();
                    }
                } else {
                    JOptionPane.showMessageDialog(panel, "Invalid credentials. Try again.");
                }
            }
        });
    }

    private static boolean authenticate(String username, String password) {
        if (accounts.containsKey(username) && accounts.get(username).getPassword().equals(password)) {
            currentUser = username;
            return true;
        }
        return false;
    }

    private static void showUserScreen() {
        JFrame frame = new JFrame("User Dashboard");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeUserComponents(panel);
        frame.setVisible(true);
    }

    private static void placeUserComponents(JPanel panel) {
        panel.setLayout(new GridLayout(4, 1));

        JButton checkBalanceButton = new JButton("Check Balance");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");

        panel.add(checkBalanceButton);
        panel.add(depositButton);
        panel.add(withdrawButton);

        checkBalanceButton.addActionListener(e -> {
            Account account = accounts.get(currentUser);
            JOptionPane.showMessageDialog(panel, "Your Balance: $" + account.getBalance());
        });

        depositButton.addActionListener(e -> {
            Account account = accounts.get(currentUser);
            String input = JOptionPane.showInputDialog("Enter amount to deposit:");
            double amount = Double.parseDouble(input);
            account.deposit(amount);
            JOptionPane.showMessageDialog(panel, "Deposited $" + amount);
        });

        withdrawButton.addActionListener(e -> {
            Account account = accounts.get(currentUser);
            String input = JOptionPane.showInputDialog("Enter amount to withdraw:");
            double amount = Double.parseDouble(input);
            if (account.withdraw(amount)) {
                JOptionPane.showMessageDialog(panel, "Withdrew $" + amount);
            } else {
                JOptionPane.showMessageDialog(panel, "Insufficient balance!");
            }
        });
    }

    private static void showAdminScreen() {
        JFrame frame = new JFrame("Admin Dashboard");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeAdminComponents(panel);
        frame.setVisible(true);
    }

    private static void placeAdminComponents(JPanel panel) {
        panel.setLayout(new GridLayout(3, 1));

        JButton addAccountButton = new JButton("Add Account");
        JButton deleteAccountButton = new JButton("Delete Account");
        JButton viewAccountsButton = new JButton("View Accounts");

        panel.add(addAccountButton);
        panel.add(deleteAccountButton);
        panel.add(viewAccountsButton);

        addAccountButton.addActionListener(e -> {
            String username = JOptionPane.showInputDialog("Enter new username:");
            String password = JOptionPane.showInputDialog("Enter new password:");
            double initialBalance = Double.parseDouble(JOptionPane.showInputDialog("Enter initial balance:"));
            accounts.put(username, new Account(username, password, initialBalance, false));
            JOptionPane.showMessageDialog(panel, "Account created for " + username);
        });

        deleteAccountButton.addActionListener(e -> {
            String username = JOptionPane.showInputDialog("Enter username to delete:");
            if (accounts.remove(username) != null) {
                JOptionPane.showMessageDialog(panel, "Account deleted for " + username);
            } else {
                JOptionPane.showMessageDialog(panel, "Account not found!");
            }
        });

        viewAccountsButton.addActionListener(e -> {
            StringBuilder accountsList = new StringBuilder("Accounts:\n");
            for (String username : accounts.keySet()) {
                accountsList.append(username).append("\n");
            }
            JOptionPane.showMessageDialog(panel, accountsList.toString());
        });
    }
}

class Account {
    private String username;
    private String password;
    private double balance;
    private boolean isAdmin;

    public Account(String username, String password, double balance, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.isAdmin = isAdmin;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

