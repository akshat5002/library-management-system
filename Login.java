package library;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Login extends Layout {

    public void login() {

    Layout layout=new Layout();
    JFrame frame = (JFrame)layout.Layout();
    JLabel label=new JLabel("HOME PANNEL");
    label.setBounds(250, 110, 200, 25);
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setFont(new Font("Monospaced", Font.BOLD, 20));
    frame.add(label);
    
    JButton admin = new JButton("Admin Login");
    admin.setBounds(275, 200, 150, 30);
    frame.add(admin);
    admin.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                frame.dispose();
                 //Main m=new Main();
                 //m.admin();
            } catch (Exception e1) {
                System.out.println(e1);
            }
           }
        
    });

    JButton librarian = new JButton("Librarian Login");
    librarian.setBounds(275, 250, 150, 30);
    frame.add(librarian);
    librarian.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                 frame.dispose();
               // Main m=new Main();
              //  m.librarian();
            } catch (Exception e1) {
                System.out.println(e1);
            }
           }
        
    });

    frame.setVisible(true);
    }
    public static void main(String[] args) {
        Login lg = new Login();
        lg.login();
    }

}