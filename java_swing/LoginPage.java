package java_swing;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.color.*;

public class LoginPage extends JFrame {
    public static void main(String[] args) {

        LoginPage Lp = new LoginPage();
        Lp.setVisible(true);
        Lp.setSize(400, 400);
        Lp.setTitle("Login Page");

    }

    JLabel luser, lpassword;
    JTextField tuser,tpass;
    JButton login,reseat;
//    Font f = null;
    public LoginPage(){
        setLayout(new FlowLayout());
//        f = new Font("TimenewRoman",Font.ITALIC,20);
        luser = new JLabel("enter the username");
        System.out.println(" ");
        tuser = new JTextField(10);
        System.out.println(" ");
        lpassword = new JLabel("enter the password");
        System.out.println(" ");
        tpass = new JTextField(10);

        add(luser);
        add(lpassword);
        add(tuser);
        add(tpass);

        login = new JButton("Login");
        reseat = new JButton("reset");

        add(login);
        add(reseat);

    }

}