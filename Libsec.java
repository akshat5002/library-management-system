package library;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class Libsec extends Layout{
    public void libsec() {
         
        Layout layout=new Layout();
        JFrame frame = (JFrame)layout.Layout();
        JLabel label=new JLabel("Librarian Dashboard Pannel");
        label.setBounds(175, 110, 350, 25);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Monospaced", Font.BOLD, 20));
        frame.add(label);

    JButton add = new JButton("Add Books");
    add.setBounds(225, 160, 250, 40);
    frame.add(add);
    add.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                frame.dispose();
                Addbook a=new Addbook();
                a.addbook();
            } catch (Exception e1) {
               System.out.println(e1);
            }
          }
        
    });

    JButton viewbook = new JButton("View Books");
    viewbook.setBounds(225, 210, 250, 40);
    frame.add(viewbook);
    viewbook.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                frame.dispose();
                Viewbook a=new Viewbook();
                a.viewbook();
            } catch (Exception e1) {
               System.out.println(e1);
            }
          }
        
    });



    JButton issuebook = new JButton("Issue Book");
    issuebook.setBounds(225, 260, 250, 40);
    frame.add(issuebook);
    issuebook.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                frame.dispose();
                IssueBook i=new IssueBook();
                i.issuebook();
            } catch (Exception e1) {
                System.out.println(e1);
            }
           }
        
    });

    JButton viewissuebook = new JButton("View Issued Books");
    viewissuebook.setBounds(225, 310, 250, 40);
    frame.add(viewissuebook);
    viewissuebook.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            viewissue v=new viewissue();
            v.viewissue();
           }
        
    });

    JButton returnbook = new JButton("Return Book");
    returnbook.setBounds(225, 360, 250, 40);
    frame.add(returnbook);
    returnbook.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                frame.dispose();
                IssueBook i=new IssueBook();
                i.Return();
            } catch (Exception e1) {
                System.out.println(e1);
            }
            }
        
    });

    JButton student = new JButton("Add Student");
    student.setBounds(225, 410, 250, 40);
    frame.add(student);
    student.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                frame.dispose();
                Addbook i=new Addbook();
                i.student();
            } catch (Exception e1) {
                System.out.println(e1);
            }
            }
        
    });

    JButton Student = new JButton("View Student");
    Student.setBounds(225, 460, 250, 40);
    frame.add(Student);
    Student.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                frame.dispose();
                IssueBook i=new IssueBook();
                i.viewStudent();
            } catch (Exception e1) {
                System.out.println(e1);
            }
            }
        
    });

    JButton logout = new JButton("Logout");
    logout.setBounds(225, 510, 250, 40);
    frame.add(logout);
    logout.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                frame.dispose();
                Login n=new Login();
                n.login();
            } catch (Exception e1) {
               System.out.println(e1);
            }
          }
        
    });

    frame.setVisible(true);
    }
}
