package library;

import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class IssueBook extends Layout {
   static int a, b;
   JComboBox username=null;
   JTextField semester = null, Studentname = null, contact = null;
   static String bookcoll = "", stID = "";

   /*
    * <---------------------------Issue book ------------------------------------->
    */

   public void issuebook() {

      Layout layout = new Layout();
      JFrame frame = (JFrame) layout.Layout();

      JLabel call = new JLabel("Book CallNo:");
      call.setBounds(145, 150, 150, 30);
      frame.add(call);
      JComboBox Call = new JComboBox();
      Call.addItem("Select Book Collno");
      Call.setBounds(295, 150, 200, 30);
      frame.add(Call);
      try {
         Connection con = AddLibrarian.con();
         Statement st = con.createStatement();
         String query = "select coll_No from book";
         ResultSet rs = st.executeQuery(query);
         while (rs.next()) {
            Call.addItem(rs.getString("coll_No"));

         }

      } catch (Exception e) {
         System.out.println(e);
      }

      JLabel name = new JLabel("Student Id:");
      name.setBounds(145, 200, 150, 30);
      frame.add(name);
      JComboBox Name = new JComboBox();
      Name.addItem("Select Student Id");
      Name.setBounds(295, 200, 200, 30);
      frame.add(Name);
      try {
         Connection con = AddLibrarian.con();
         Statement st = con.createStatement();
         String query = "select id from student";
         ResultSet rs = st.executeQuery(query);
         while (rs.next()) {
            Name.addItem(rs.getString("id"));
         }
      } catch (Exception e) {
         System.out.println(e);
      }
      Name.addItemListener(new ItemListener() {

         @Override
         public void itemStateChanged(ItemEvent e) {
            try {
               Connection con = AddLibrarian.con();
               Statement st = con.createStatement();
               String query = "select * from student where id='" + Name.getSelectedItem() + "'";
               ResultSet rs = st.executeQuery(query);
               while (rs.next()) {
                  semester.setText(rs.getString("semester"));
                  Studentname.setText(rs.getString("name"));
                  contact.setText(rs.getString("contact"));
               }

            } catch (Exception e1) {
               System.out.println(e1);
            }
         }

      });

      JLabel author = new JLabel("Student Semester");
      author.setBounds(145, 250, 150, 30);
      frame.add(author);
      semester = new JTextField();
      semester.setBounds(295, 250, 200, 30);
      frame.add(semester);

      JLabel publ = new JLabel("Student Name:");
      publ.setBounds(145, 300, 150, 30);
      frame.add(publ);
      Studentname = new JTextField();
      Studentname.setBounds(295, 300, 200, 30);
      frame.add(Studentname);

      JLabel quan = new JLabel(" Student Contact");
      quan.setBounds(145, 350, 150, 30);
      frame.add(quan);
      contact = new JTextField();
      contact.setBounds(295, 350, 200, 30);
      frame.add(contact);

      JButton issue = new JButton("Issue Book");
      issue.setBounds(225, 400, 250, 30);
      frame.add(issue);
   /*<..........................  Issue Listener  .............................> */

      issue.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               Connection con = AddLibrarian.con();
               Statement st = con.createStatement();
               String query = "select bookcallno, studentid, status from issuebook where bookcallno='"+Call.getSelectedItem()+"' and studentid='"+Name.getSelectedItem()+"' and status='"+"Issued"+"' ";
               ResultSet rs = st.executeQuery(query);
               if (rs.next()) {
                  JOptionPane.showMessageDialog(null, "this book is already issue");
                  con.close();
               }else{
                  try {
               Connection com = AddLibrarian.con();
               Statement stt = com.createStatement();
               String logic = "select quantity, issued from book where coll_No='" + Call.getSelectedItem().toString()
                     + "'";
               ResultSet store = stt.executeQuery(logic);
               while (store.next()) {
                  a = Integer.parseInt(store.getString("quantity"));
                  b = Integer.parseInt(store.getString("issued"));
               }
               System.out.println(a + " " + b);
               if (a > b) {

                  String query1 = "insert into issuebook (bookcallno,studentid,studentclass,studentname,studentcontact,status) values('"
                        + Call.getSelectedItem().toString() + "','" + Name.getSelectedItem().toString() + "','"
                        + semester.getText() + "','" + Studentname.getText() + "','" + contact.getText() + "','"
                        + "Issued" + "')";
                  int i = st.executeUpdate(query1);
                  if (i > 0) {
                     try {
                        Connection conn = AddLibrarian.con();
                        Statement stm = conn.createStatement();
                        String Query = "update book set issued = issued+1  where coll_No='"
                              + Call.getSelectedItem().toString() + "'";
                        int j = stm.executeUpdate(Query);
                        if (j > 0) {
                           System.out.println("increment Successfull");
                        }

                     } catch (Exception e1) {
                        System.out.println(e1);
                     }
                     JOptionPane.showMessageDialog(null, "Book Issue Successfull");
                     frame.dispose();
                     Libsec a = new Libsec();
                     a.libsec();
                  } else {
                     JOptionPane.showMessageDialog(null, "Book Issue Failled");
                  }
               } else {
                  JOptionPane.showMessageDialog(null, "Books not available");
               }
            } catch (Exception e1) {
               System.out.println(e1);
            }


               }
            } catch (Exception e2) {
               System.out.println(e2);
            }

            
         }

      });

      JButton back = new JButton("Back");
      back.setBounds(225, 450, 250, 30);
      frame.add(back);
      back.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               frame.dispose();
               Libsec l = new Libsec();
               l.libsec();
            } catch (Exception e1) {
               System.out.println(e1);
            }
         }

      });

      frame.setTitle("Issue Book");
      frame.setVisible(true);
   }

   /*
    * <---------------------------Return book
    * ------------------------------------->
    */

   public void Return() {

      Layout layout = new Layout();
      JFrame frame = (JFrame) layout.Layout();
      JLabel Username = new JLabel("Book Collno:");
      Username.setBounds(50, 150, 150, 30);
      frame.add(Username);
      username = new JComboBox();
      username.addItem("Select Book Callno");
      username.setBounds(210, 150, 200, 30);
      frame.add(username);

      JLabel password = new JLabel("Student ID:");
      password.setBounds(50, 200, 150, 30);
      frame.add(password);
      JComboBox Password = new JComboBox();
      Password.addItem("Select Student ID");
      Password.setBounds(210, 200, 200, 30);
      frame.add(Password);
      try {
         Connection con=AddLibrarian.con();
         Statement st=con.createStatement();
         String query="select bookcallno,studentid from issuebook where status='"+"Issued"+"'";
         ResultSet rs=st.executeQuery(query);
         while (rs.next()) {
            username.addItem(rs.getString("bookcallno"));
            Password.addItem(rs.getString("studentid"));
         }

      } catch (Exception e) {
         System.out.println(e);
      }

      JButton login = new JButton("Return Book");
      login.setBounds(150, 250, 200, 30);
      frame.add(login);
      login.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               Connection con = AddLibrarian.con();
               Statement st = con.createStatement();
               String query = " update issuebook set status = '" + "Return" + "' where bookcallno='"
                     + username.getSelectedItem().toString() + "' and studentid='" + Password.getSelectedItem().toString() + "'";
               int i = st.executeUpdate(query);
               if (i > 0) {
                  try {
                     Connection conn = AddLibrarian.con();
                     Statement stm = conn.createStatement();
                     String Query = "update book set issued = issued-1  where coll_No='" + username.getSelectedItem().toString()
                           + "'and issued > 0";
                     int j = st.executeUpdate(Query);
                     if (j > 0) {
                        String Query1 = "update issuebook set status = issued-1  where coll_No='" + username.getSelectedItem().toString()
                              + "'and issued > 0";
                        System.out.println("decrement Successfull");
                     }

                  } catch (Exception e1) {
                     System.out.println(e1);
                  }
                  JOptionPane.showMessageDialog(null, "Book return Successfull");
                  frame.dispose();
                  Libsec u = new Libsec();
                  u.libsec();
               } else {
                  JOptionPane.showMessageDialog(null, "Please check Book Collno or Student ID");
               }
            } catch (Exception e1) {
               System.out.println(e1);
            }
         }

      });

      JButton back = new JButton("Back");
      back.setBounds(300, 300, 100, 30);
      frame.add(back);

      back.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               frame.dispose();
               Libsec u = new Libsec();
               u.libsec();
            } catch (Exception e1) {
               System.out.println(e1);
            }
         }

      });

      frame.setTitle("Librarian Login");
      frame.setVisible(true);
   }

   /*
    * <---------------------------view student logic------------------------------------->
    */

   public void viewStudent() {

      Layout layout = new Layout();
      JFrame frame = (JFrame) layout.Layout();

      JButton librarian = new JButton("Back");
      librarian.setBounds(500, 20, 100, 30);
      frame.add(librarian);
      librarian.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               frame.dispose();
               Libsec l = new Libsec();
               l.libsec();

            } catch (Exception e1) {
               System.out.println(e1);
            }
         }

      });
      JLabel label = new JLabel("View Student Pannel");
      label.setBounds(200, 120, 300, 25);
      label.setHorizontalAlignment(JLabel.CENTER);
      label.setFont(new Font("Monospaced", Font.BOLD, 20));
      frame.add(label);

      DefaultTableModel model = new DefaultTableModel();

      JTable table = new JTable(model) {

      };

      model = (DefaultTableModel) table.getModel();
      model.addColumn("id");
      model.addColumn("semester");
      model.addColumn("name");
      model.addColumn("contact");
      model.addColumn("reg_date");

      table.getColumnModel().getColumn(0).setPreferredWidth(25);
      table.getColumnModel().getColumn(1).setPreferredWidth(50);
      table.getColumnModel().getColumn(2).setPreferredWidth(150);
      table.getColumnModel().getColumn(3).setPreferredWidth(100);
      table.getColumnModel().getColumn(4).setPreferredWidth(100);

      JScrollPane sc = new JScrollPane(table);
      sc.setBounds(10, 150, 670, 200);
      frame.add(sc);

      try {
         Connection con = AddLibrarian.con();
         Statement st = con.createStatement();
         String query = "select * from student";
         ResultSet rs = st.executeQuery(query);
         int i = 0;
         while (rs.next()) {

            model.addRow(new Object[0]);
            model.setValueAt(rs.getInt("id"), i, 0);
            model.setValueAt(rs.getString("semester"), i, 1);
            model.setValueAt(rs.getString("name"), i, 2);
            model.setValueAt(rs.getString("contact"), i, 3);
            model.setValueAt(rs.getString("reg_date"), i, 4);

            i++;
         }

         frame.setVisible(true);

      } catch (Exception e) {
         System.out.println(e);
      }
   }

}
