package sem3_codes;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class DemoBox3 extends JFrame
{
    public static void main(String[] args)
    {
        DemoBox3 db = new DemoBox3();
        db.setVisible(true);
        db.setSize(400,300);
        db.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    JCheckBox cb1,cb2;
    JRadioButton rb1,rb2;
    ButtonGroup bg;
    JTextArea jta;
    Container c = null;
    public DemoBox3(){
        setLayout(new FlowLayout());
        cb1 = new JCheckBox("Abhishek");
        cb2 = new JCheckBox("Sambhav");
        rb1 = new JRadioButton("coding");
        rb2 = new JRadioButton("studing");
        bg = new ButtonGroup();
        bg.add(cb1);
        bg.add(cb2);
        bg.add(rb1);
        bg.add(rb2);

        jta = new JTextArea(10,20);
        jta.setBackground(Color.cyan);

        c = getContentPane();
        c.add(cb1);
        c.add(cb2);
        c.add(rb1);
        c.add(rb2);
        c.add(jta);

//        cb1.addActionListener(this);
    }

}
