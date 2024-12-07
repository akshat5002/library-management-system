package library;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class Addbook extends Layout{
    public void addbook() {
    
        Layout layout=new Layout();
        JFrame frame = (JFrame)layout.Layout();

    JLabel call = new JLabel("Call No:");
    call.setBounds(145, 150, 150, 30);
    frame.add(call);
    JTextField Call = new JTextField();
    Call.setBounds(295, 150, 200, 30);
    frame.add(Call);

    JLabel name = new JLabel("Name:");
    name.setBounds(145, 200, 150, 30);
    frame.add(name);
    JTextField Name = new JTextField();
    Name.setBounds(295, 200, 200, 30);
    frame.add(Name);

    JLabel author = new JLabel("Author");
    author.setBounds(145, 250, 150, 30);
    frame.add(author);
    JTextField Author = new JTextField();
    Author.setBounds(295, 250, 200, 30);
    frame.add(Author);

    JLabel publ = new JLabel("Semester:");
    publ.setBounds(145, 300, 150, 30);
    frame.add(publ);
    JTextField Publ = new JTextField();
    Publ.setBounds(295, 300, 200, 30);
    frame.add(Publ);

    JLabel quan = new JLabel(" Quantity.");
    quan.setBounds(145, 350, 150, 30);
    frame.add(quan);
    JTextField Quantity = new JTextField();
    Quantity.setBounds(295, 350, 200, 30);
    frame.add(Quantity);

    JButton login=new JButton("Add Book");
    login.setBounds(225, 400, 250, 30);
    frame.add(login);
    login.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Connection con=AddLibrarian.con();
                Statement st=con.createStatement();
                String query="insert into book (Coll_No,book_name,author,semester,Quantity,issued) values ('"+Call.getText()+"','"+Name.getText()+"','"+Author.getText()+"','"+Publ.getText()+"','"+Quantity.getText()+"','"+0+"')";
                int i=st.executeUpdate(query);
                if (i>0) {
                    JOptionPane.showMessageDialog(null,"Book Add Successfull");
                            frame.dispose();
                     Libsec l=new Libsec();
                            l.libsec();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Book Add Failled");
                }
            } catch (Exception e1) {
                System.out.println(e1);
            }
            }
        
    });
    
    JButton back=new JButton("Back");
    back.setBounds(225, 450, 250, 30);
    frame.add(back);
    back.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                frame.dispose();
                Libsec l=new Libsec();
                l.libsec();

            } catch (Exception e1) {
                System.out.println(e1);
            }
            }
        
    });
    
    frame.setVisible(true);
    }

    public void student() {

        Layout layout=new Layout();
        JFrame frame = (JFrame)layout.Layout();

    JLabel call = new JLabel("Semester:");
    call.setBounds(145, 150, 150, 30);
    frame.add(call);
    JTextField Call = new JTextField();
    Call.setBounds(295, 150, 200, 30);
    frame.add(Call);

    JLabel name = new JLabel("Student Name:");
    name.setBounds(145, 200, 150, 30);
    frame.add(name);
    JTextField Name = new JTextField();
    Name.setBounds(295, 200, 200, 30);
    frame.add(Name);

    JLabel author = new JLabel("Contact Number:");
    author.setBounds(145, 250, 150, 30);
    frame.add(author);
    JTextField Author = new JTextField();
    Author.setBounds(295, 250, 200, 30);
    frame.add(Author);

    JButton login=new JButton("Add Student");
    login.setBounds(225, 300, 250, 30);
    frame.add(login);
    login.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Connection con=AddLibrarian.con();
                Statement st=con.createStatement();
                String query="insert into Student (semester,name,contact) values ('"+Call.getText()+"','"+Name.getText()+"','"+Author.getText()+"')";
                int i=st.executeUpdate(query);
                if (i>0) {
                    JOptionPane.showMessageDialog(null,"Student Add Successfull");
                            frame.dispose();
                     Libsec l=new Libsec();
                            l.libsec();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Student Add Failled");
                }
            } catch (Exception e1) {
                System.out.println(e1);
            }
            }
        
    });
    
    JButton back=new JButton("Back");
    back.setBounds(225, 350, 250, 30);
    frame.add(back);
    back.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                frame.dispose();
                Libsec l=new Libsec();
                l.libsec();

            } catch (Exception e1) {
                System.out.println(e1);
            }
            }
        
    });

    frame.setVisible(true);

    }
}
