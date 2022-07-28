package customerinformation2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CustomerInformation extends JFrame implements ActionListener {

    private Container c;
    private JLabel L, L1, L2, L3, L4, L5, L6, L7, L8;
    private JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9;
    private JButton addButton, cancelButton;
    private Font font1, font2, font3, font4, font5, font6;
    private JTextArea ta, ta1;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JRadioButton rb1, rb2;
    JScrollPane scroll;

    private String dates[]
            = {"1", "2", "3", "4", "5",
                "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25",
                "26", "27", "28", "29", "30",
                "31"};
    private String months[]
            = {"Jan", "feb", "Mar", "Apr",
                "May", "Jun", "July", "Aug",
                "Sup", "Oct", "Nov", "Dec"};
    private String years[]
            = {"2001", "2002",
                "2003", "2004", "2005", "2006",
                "2007", "2008", "2009", "2010",
                "2011", "2012", "2013", "2014",
                "2015", "2016", "2017", "2018",
                "2019", "2020", "2021", "2022",
                "2023", "2024", "2025"};

    CustomerInformation() {
        initComponents();
    }

    public void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setBounds(100, 90, 1450, 850);
        this.setTitle("Customer Table");

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.CYAN);

        font1 = new Font("Times New Roman", Font.ITALIC + Font.PLAIN, 60);
        font2 = new Font("Times New Roman", Font.ITALIC, 30);
        font3 = new Font("Times New Roman", Font.PLAIN, 22);
        font4 = new Font("Times New Roman", Font.ITALIC + Font.BOLD, 20);

        L = new JLabel();
        L.setText("Customer Information :");
        L.setBounds(45, 45, 600, 65);
        L.setFont(font1);
        c.add(L);

        L1 = new JLabel("Customer ID :");
        L1.setBounds(45, 140, 205, 40);
        L1.setFont(font2);
        c.add(L1);

        tf1 = new JTextField();
        tf1.setBounds(282, 140, 350, 40);
        tf1.setFont(font3);
        c.add(tf1);

        L2 = new JLabel("Customer Type :");
        L2.setBounds(45, 200, 205, 40);
        L2.setFont(font2);
        c.add(L2);

        rb1 = new JRadioButton("Guarantee");
        rb1.setBounds(282, 200, 162, 40);;
        rb1.setFont(font4);

        rb2 = new JRadioButton("Warranty");
        rb2.setBounds(468, 200, 162, 40);
        rb2.setFont(font4);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        c.add(rb1);
        c.add(rb2);

        L3 = new JLabel("Name :");
        L3.setBounds(45, 260, 205, 40);
        L3.setFont(font2);
        c.add(L3);

        tf3 = new JTextField();
        tf3.setBounds(280, 260, 350, 40);
        tf3.setFont(font3);
        c.add(tf3);

        L4 = new JLabel("Address :");
        L4.setBounds(45, 320, 205, 40);
        L4.setFont(font2);
        c.add(L4);

        tf4 = new JTextField();
        tf4.setBounds(280, 320, 350, 40);
        tf4.setFont(font3);
        c.add(tf4);

        L5 = new JLabel("Mobile No:");
        L5.setBounds(45, 380, 205, 40);
        L5.setFont(font2);
        c.add(L5);

        tf5 = new JTextField();
        tf5.setBounds(280, 380, 350, 40);
        tf5.setFont(font3);
        c.add(tf5);

        L6 = new JLabel("Date of Joining:");
        L6.setBounds(45, 440, 205, 40);
        L6.setFont(font2);
        c.add(L6);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setBounds(280, 440, 116, 40);
        c.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setBounds(397, 440, 116, 40);
        c.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setBounds(514, 440, 116, 40);
        c.add(year);

        L7 = new JLabel("E-mail ID:");
        L7.setBounds(45, 500, 205, 40);
        L7.setFont(font2);
        c.add(L7);

        tf7 = new JTextField();
        tf7.setBounds(280, 500, 350, 40);
        tf7.setFont(font3);
        c.add(tf7);

        L8 = new JLabel("Description:");
        L8.setBounds(45, 560, 205, 40);
        L8.setFont(font2);
        c.add(L8);

        tf8 = new JTextField();
        tf8.setBounds(280, 560, 350, 70);
        tf8.setFont(font3);
        c.add(tf8);

        ta = new JTextArea();
        ta.setBounds(680, 140, 70, 580);
        ta.setFont(font2);
        ta.setEditable(false);
        c.add(ta);

        addButton = new JButton("ADD");
        addButton.setBounds(280, 660, 150, 40);
        addButton.setFont(font4);
        c.add(addButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(480, 660, 150, 40);
        cancelButton.setFont(font4);
        c.add(cancelButton);

        addButton.addActionListener(this);
        cancelButton.addActionListener(this);

        scroll = new JScrollPane(ta);
        scroll.setBounds(680, 140, 700, 580);
        c.add(scroll);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {

            tf1.getText();
            tf3.getText();
            tf4.getText();
            tf5.getText();
            tf7.getText();
            tf8.getText();

            File dir = new File("file");
            dir.mkdir();
            String path = dir.getAbsolutePath();
            File f1 = new File(path + "/customer.txt");

            try {

                String id = tf1.getText();
                String name = tf3.getText();
                String addr = tf4.getText();
                String mb = tf5.getText();
                String dd = (String) date.getSelectedItem();
                String mm = (String) month.getSelectedItem();
                String yy = (String) year.getSelectedItem();
                String email = tf7.getText();
                String des = tf8.getText();

                FileWriter myWriter = new FileWriter(f1, true);
                myWriter.write("Customer ID : " + tf1.getText() + "\n");

                ta.append("\n\n          ******* Customer Information *******");
                ta.append("\n\n Customer ID          :  " + id);

                if (rb1.isSelected()) {
                    String s = "Guarantee";

                    myWriter.write("Customer Type : " + s + "\n");
                    ta.append("\n Customer Type       :  " + s);

                } else {
                    String s2 = "Warranty";
                    myWriter.write("Customer Type : " + s2 + "\n");

                    ta.append("\n Customer Type       :  " + s2);
                }
                myWriter.write("Name : " + tf3.getText() + "\n" + "Address : " + tf4.getText() + "\n" + "Mobile No : " + tf5.getText() + "\n" + "Dete of Joining : " + dd + "/" + mm + "/" + yy + "\n" + "E-mail : " + email + "\n" + "Description : " + des + "\n\n");
                myWriter.close();

                ta.append("\n Name \t         :  " + name + "\n Address \t         :  " + addr + "\n Mobile No\t         :  " + mb);
                ta.append("\n Dete of Joining       : " + dd + "/" + mm + "/" + yy);
                ta.append("\n E-mail ID \t         :  " + email + "\n Description \t         :  " + des);
                ta.append("\n\n\t\t   Thank you");
            } catch (FileNotFoundException ex) {

                System.out.println(ex);
            } catch (IOException ex) {
                Logger.getLogger(CustomerInformation.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == cancelButton) {

            tf1.setText("");
            tf3.setText("");
            tf4.setText("");
            tf5.setText("");
            tf7.setText("");
            tf8.setText("");
        }
    }

    public static void main(String[] args) {

        CustomerInformation frame = new CustomerInformation();
        frame.setVisible(true);

    }
}
