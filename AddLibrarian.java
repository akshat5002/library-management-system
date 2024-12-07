package library;

import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddLibrarian extends Layout {

   public static Connection con() {
    Connection con = null;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/library", "root", "1234");
    } catch (Exception e) {
      System.out.println(e);

    }
    return con;
  }
     public void AddLibrarian() {

          Layout layout=new Layout();
          JFrame frame = (JFrame)layout.Layout();
     JLabel label=new JLabel("Add Librarian Pannel");
    label.setBounds(200, 110, 300, 25);
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setFont(new Font("Monospaced", Font.BOLD, 20));
    frame.add(label);
    JLabel Username = new JLabel("Name");
    Username.setBounds(145, 150, 150, 30);
    frame.add(Username);
    JTextField username = new JTextField();
    username.setBounds(295, 150, 200, 30);
    frame.add(username);

    JLabel password = new JLabel("Password");
    password.setBounds(145, 200, 150, 30);
    frame.add(password);
    JTextField Password = new JTextField();
    Password.setBounds(295, 200, 200, 30);
    frame.add(Password);

    JLabel email = new JLabel("Email ID");
    email.setBounds(145, 250, 150, 30);
    frame.add(email);
    JTextField Email = new JTextField();
    Email.setBounds(295, 250, 200, 30);
    frame.add(Email);

    JLabel city = new JLabel("City");
    city.setBounds(145, 300, 150, 30);
    frame.add(city);
    JTextField City = new JTextField();
    City.setBounds(295, 300, 200, 30);
    frame.add(City);

    JLabel Mob = new JLabel("Mobile no.");
    Mob.setBounds(145, 350, 150, 30);
    frame.add(Mob);
    JTextField mob = new JTextField();
    mob.setBounds(295, 350, 200, 30);
    frame.add(mob);
    mob.addKeyListener(new KeyListener() {

     @Override
     public void keyTyped(KeyEvent e) {
          try {
               int length=mob.getText().length();
               if (length==10) {
                    mob.disable();
               }
          } catch (Exception e1) {
               System.out.println(e1);
          }
         }

     @Override
     public void keyPressed(KeyEvent e) {

     }

     @Override
     public void keyReleased(KeyEvent e) {
         }
     
    });

    JButton login=new JButton("Add Librarian");
    login.setBounds(250, 400, 200, 30);
    frame.add(login);
    login.addActionListener(new ActionListener() {

     @Override
     public void actionPerformed(ActionEvent e) {
          try {
               Connection con=con();
               Statement st=con.createStatement();
               String query="insert into Librarian(Name,Password,Email_Id,City,Mobile_Number) values ('"+username.getText()+"','"+Password.getText()+"','"+Email.getText()+"','"+City.getText()+"','"+mob.getText()+"')";
               int i=st.executeUpdate(query);
               if (i > 0) {
                    frame.dispose();
                    adminsec n=new adminsec();
                    n.section();
                    System.out.println("Add Librarian Successfull");
                    JOptionPane.showMessageDialog(null,"Add Librarian Successfull");
               }
               else{
                    JOptionPane.showMessageDialog(null,"Add Librarian Failled");
               }
          } catch (Exception e1) {
              System.out.println(e1);
              JOptionPane.showMessageDialog(null,"This Email is already exist");
          }
          }
     
    });
    
    JButton back=new JButton("Back");
    back.setBounds(250, 450, 200, 30);
    frame.add(back);
    back.addActionListener(new ActionListener() {

     @Override
     public void actionPerformed(ActionEvent e) {
         try {
                frame.dispose();
                adminsec n=new adminsec();
                    n.section();
             
         } catch (Exception e1) {
            System.out.println(e1);
         }
         }
     
 });

    frame.setTitle("Add Librarian");
    frame.setVisible(true);
    
    }

    public void Delete() {

              Layout layout=new Layout();
          JFrame frame = (JFrame)layout.Layout();

    JLabel label=new JLabel("Delete Librarian Pannel");
    label.setBounds(200, 110, 300, 25);
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setFont(new Font("Monospaced", Font.BOLD, 20));
    frame.add(label);

         JLabel ent=new JLabel("Enter Email");
         ent.setBounds(145,150,150,30);
         frame.add(ent);
         JTextField Ent=new JTextField();
         Ent.setBounds(295,150,200,30);
         frame.add(Ent);

         JButton del=new JButton("Delete");
         del.setBounds(225,200,250,30);
         frame.add(del);

         del.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
               try {
               Connection con=AddLibrarian.con();
             Statement st=con.createStatement();
             String query="delete from librarian where Email_Id='"+Ent.getText()+"'";
             int i=st.executeUpdate(query);
             if (i>0) {
               JOptionPane.showMessageDialog(null,"Ligrarian Delete Successfull");
               frame.dispose();
               adminsec a=new adminsec();
                        a.section();
             }
             else{
               JOptionPane.showMessageDialog(null,"Ligrarian Delete Failled");
             }
               } catch (Exception e1) {
                    System.out.println(e1);
               }
               }
          
         });

    JButton back=new JButton("Back");
    back.setBounds(225, 250, 250, 30);
    frame.add(back);
    back.addActionListener(new ActionListener() {

     @Override
     public void actionPerformed(ActionEvent e) {
         try {
                frame.dispose();
                adminsec n=new adminsec();
                    n.section();
             
         } catch (Exception e1) {
            System.out.println(e1);
         }
         }
     
 });

    frame.setTitle("Delete Librarian");
    frame.setVisible(true);
    }
}
