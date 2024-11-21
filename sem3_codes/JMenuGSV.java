package sem3_codes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

class OpenFrameDemo extends JFrame {
    public OpenFrameDemo(File F1) {
        setTitle("Opened File");
        setLayout(new BorderLayout());
        setSize(500, 500);
        setVisible(true);

        JTextArea jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(jta);
        add(jsp, BorderLayout.CENTER);

        jta.setText("File Path: " + F1.getAbsolutePath() + "\n");
        try (BufferedReader br = new BufferedReader(new FileReader(F1))) {
            String line;
            while ((line = br.readLine()) != null) {
                jta.append(line + "\n");
            }
        } catch (IOException e) {
            jta.setText("Error reading file: " + e.getMessage());
        }
    }
}

public class JMenuGSV extends JFrame implements ActionListener {
    public static void main(String[] args) {
        JMenuGSV jmg = new JMenuGSV();
        jmg.setTitle("Note");
        jmg.setSize(500, 500);
        jmg.setVisible(true);
    }

    JMenuBar menu;
    JMenu file, edit, view, font;
    JMenuItem open, save, save_as, print, cut, copy, paste, tm, arial;
    JCheckBoxMenuItem password;
    JTextArea textArea;
    File currentFile;

    public JMenuGSV() {
        menu = new JMenuBar();

        file = new JMenu("FILE");
        edit = new JMenu("EDIT");
        view = new JMenu("VIEW");
        font = new JMenu("FONT");

        menu.add(file);
        menu.add(edit);
        menu.add(view);
        menu.add(font);

        open = new JMenuItem("OPEN");
        save = new JMenuItem("SAVE");
        save_as = new JMenuItem("SAVE_AS");
        print = new JMenuItem("PRINT");
        cut = new JMenuItem("CUT");
        copy = new JMenuItem("COPY");
        paste = new JMenuItem("PASTE");
        tm = new JMenuItem("TimesNewRoman");
        arial = new JMenuItem("Arial");
        password = new JCheckBoxMenuItem("password");

        font.add(tm);
        font.add(arial);
        file.add(open);
        file.add(save);
        file.add(save_as);
        file.add(print);
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(password);

        add(menu, BorderLayout.NORTH);

        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        open.addActionListener(this);
        save.addActionListener(this);
        save_as.addActionListener(this);
        tm.addActionListener(this);
        arial.addActionListener(this);
        password.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == open) {
            JFileChooser jfc = new JFileChooser();
            int openStatus = jfc.showOpenDialog(this);
            if (openStatus == JFileChooser.APPROVE_OPTION) {
                currentFile = jfc.getSelectedFile();
                try (BufferedReader br = new BufferedReader(new FileReader(currentFile))) {
                    textArea.setText("");
                    String line;
                    while ((line = br.readLine()) != null) {
                        textArea.append(line + "\n");
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error reading file: " + ex.getMessage());
                }
            }
        } else if (e.getSource() == save) {
            if (currentFile != null) {
                saveFile(currentFile);
            } else {
                saveAs();
            }
        } else if (e.getSource() == save_as) {
            saveAs();
        } else if (e.getSource() == tm) {
            textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        } else if (e.getSource() == arial) {
            textArea.setFont(new Font("Arial", Font.PLAIN, 14));
//        } else if (e.getSource() == password) {
//            if (password.isSelected()) {
//                textArea.setEchoChar('*'); // Hides the text
//            } else {
//                textArea.setEchoChar((char) 0); // Shows the text
//            }
        } else if (e.getSource() == cut) {
            textArea.cut();
        } else if (e.getSource() == copy) {
            textArea.copy();
        } else if (e.getSource() == paste) {
            textArea.paste();
        }
    }

    private void saveAs() {
        JFileChooser jfc = new JFileChooser();
        int saveStatus = jfc.showSaveDialog(this);
        if (saveStatus == JFileChooser.APPROVE_OPTION) {
            currentFile = jfc.getSelectedFile();
            saveFile(currentFile);
        }
    }

    private void saveFile(File file) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(textArea.getText());
            JOptionPane.showMessageDialog(this, "File saved successfully!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
        }
    }
}