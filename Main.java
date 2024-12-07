package library;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Main extends Layout{
   
    public void admin(){

     Layout layout=new Layout();
 JFrame frame = (JFrame)layout.Layout();

 JLabel label=new JLabel("Admin Login Pannel");
    label.setBounds(200, 110, 300, 25);
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setFont(new Font("Monospaced", Font.BOLD, 20));
    frame.add(label);

    JLabel Username = new JLabel("Username");
    Username.setBounds(145, 170, 150, 30);
    frame.add(Username);
    JTextField username = new JTextField();
    username.setBounds(295, 170, 200, 30);
    frame.add(username);

    JLabel password = new JLabel("Password");
    password.setBounds(145, 220, 150, 30);
    frame.add(password);
    JTextField Password = new JTextField();
    Password.setBounds(295, 220, 200, 30);
    frame.add(Password);

    JButton login=new JButton("Login");
    login.setBounds(250, 270, 200, 30);
    frame.add(login);

    login.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Connection con =AddLibrarian.con();
                Statement st=con.createStatement();
                String query="select * from admin where username='"+username.getText()+"' and password='"+Password.getText()+"'";
                ResultSet rs=st.executeQuery(query);
                if (rs.next()) {
                    System.out.println(rs.getString("username"));
                    frame.dispose();
                    adminsec n=new adminsec();
                    n.section();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please check your username or password");
                }
            } catch (Exception e1) {
                System.out.println( e1);
            }
           }
        
    });

    JButton back=new JButton("Back");
    back.setBounds(250, 320, 200, 30);
    frame.add(back);
    back.addActionListener(new ActionListener() {

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
    
    frame.setTitle("Admin Login");
    frame.setVisible(true);
    }

    public void librarian() {
    
        Layout layout=new Layout();
        JFrame frame = (JFrame)layout.Layout();
    JLabel label=new JLabel("Librarian Login Pannel");
    label.setBounds(200, 110, 300, 25);
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setFont(new Font("Monospaced", Font.BOLD, 20));
    frame.add(label);

    JLabel Username = new JLabel("Username");
    Username.setBounds(145, 170, 150, 30);
    frame.add(Username);
    JTextField username = new JTextField();
    username.setBounds(295, 170, 200, 30);
    frame.add(username);

    JLabel password = new JLabel("Password");
    password.setBounds(145, 220, 150, 30);
    frame.add(password);
    JTextField Password = new JTextField();
    Password.setBounds(295, 220, 200, 30);
    frame.add(Password);

    JButton login=new JButton("Login");
    login.setBounds(250, 270, 200, 30);
    frame.add(login);
    login.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
             try {
                Connection con=AddLibrarian.con();
                Statement st = con.createStatement();
                String query = "select * from librarian where Email_Id='"+username.getText()+"' and Password='"+Password.getText()+"'";
                ResultSet rs= st.executeQuery(query);
                if(rs.next()) {
                           frame.dispose();
                    Libsec u = new Libsec();
                           u.libsec();
                 }
            else
            {
                JOptionPane.showMessageDialog(null,"Please check your username or password");
            }
            } catch (Exception e1) {
                System.out.println(e1);
            }
            }
        
    });

    JButton back=new JButton("Back");
    back.setBounds(250, 320, 200, 30);
    frame.add(back);

    back.addActionListener(new ActionListener() {

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

    frame.setTitle("Librarian Login");
    frame.setVisible(true);
    }
}
