package sem3_codes;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginDemo extends JFrame implements ActionListener {

    private JLabel Iuser;
    private JLabel Ipass;
    private JTextField tuser;
    private JPasswordField tpass;
    private JButton Login;

    public static void main(String[] args) {
        LoginDemo id = new LoginDemo();
        id.setVisible(true);
        id.setSize(500, 500);
        id.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public LoginDemo() {
        setLayout(null);

        // Initialize components
        Iuser = new JLabel("UserName");
        Ipass = new JLabel("Password");
        tuser = new JTextField();
        tpass = new JPasswordField();
        Login = new JButton("Login");

        // Set component bounds
        Iuser.setBounds(100, 100, 100, 20);
        tuser.setBounds(200, 100, 100, 20);
        Ipass.setBounds(100, 200, 100, 20);
        tpass.setBounds(200, 200, 100, 20);
        Login.setBounds(200, 300, 100, 20);

        // Add components to the frame
        add(Iuser);
        add(Ipass);
        add(tuser);
        add(tpass);
        add(Login);

        // Add action listener to the button
        Login.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = tuser.getText();
        String password = new String(tpass.getPassword());


        if ("Anurag".equals(username) &&"Anurag05".equals(password)) {
            JOptionPane.showMessageDialog(this, "Login successful!");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.");
        }
    }
}
