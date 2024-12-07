package library;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class adminsec extends Layout{

    public void section(){
    
        Layout layout=new Layout();
        JFrame frame = (JFrame)layout.Layout();
    JLabel label=new JLabel("Admin Dashbord Pannel");
    label.setBounds(200, 110, 300, 25);
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setFont(new Font("Monospaced", Font.BOLD, 20));
    frame.add(label);

    JButton add = new JButton("Add Librarian");
    add.setBounds(225, 170, 250, 50);
    frame.add(add);
    add.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                frame.dispose();
                AddLibrarian a=new AddLibrarian();
                a.AddLibrarian();
            } catch (Exception e1) {
               System.out.println(e1);
            }
          }
        
    });

    JButton view = new JButton("View Librarian");
    view.setBounds(225, 240, 250, 50);
    frame.add(view);
    view.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                frame.dispose();
                Viewlibrarian a=new Viewlibrarian();
                a.ViewLibrarian();
            } catch (Exception e1) {
               System.out.println(e1);
            }
            }
        
    });

    JButton delete = new JButton("Delete Librarian");
    delete.setBounds(225, 310, 250, 50);
    frame.add(delete);
    delete.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
           try {
            frame.dispose();
        AddLibrarian a=new AddLibrarian();
             a.Delete();
           } catch (Exception e1) {
            System.out.println(e1);
           }

          }
        
    });

    JButton logout = new JButton("Logout");
    logout.setBounds(225, 380, 250, 50);
    frame.add(logout);
    logout.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            Login n=new Login();
            n.login();
        }
        
    });

    frame.setTitle("Admin Section");
    frame.setVisible(true);
    }

}
