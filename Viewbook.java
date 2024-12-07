package library;

import java.awt.Font;
import java.awt.event.*;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Viewbook extends Layout{
    public void viewbook(){
        // JFrame show=new JFrame();
        // JLabel id=new JLabel("ID");
        // id.setBounds(20,20,100,30);
        // show.add(id);

        // JLabel name=new JLabel("Call no");
        // name.setBounds(20,20,100,30);
        // show.add(name);

        // JLabel pass=new JLabel("Name");
        // pass.setBounds(20,20,100,30);
        // show.add(pass);

        // JLabel email=new JLabel("Author");
        // email.setBounds(20,20,100,30);
        // show.add(email);

        // JLabel city=new JLabel("Publisher");
        // city.setBounds(20,20,100,30);
        // show.add(city);

        // JLabel mob=new JLabel("Quantity");
        // mob.setBounds(20,20,100,30);
        // show.add(mob);

        // JLabel mob=new JLabel("Issued");
        // mob.setBounds(20,20,100,30);
        // show.add(mob);

        // JLabel mob=new JLabel("Added date");
        // mob.setBounds(20,20,100,30);
        // show.add(mob);




        // show.setTitle("Librarian Login");
        // show.setSize(500, 500);
        // show.setLayout(null);
        // show.setVisible(true);
        Layout layout=new Layout();
        JFrame frame = (JFrame)layout.Layout();

    JButton librarian = new JButton("Back");
    librarian.setBounds(500, 20, 100, 30);
    frame.add(librarian);
    librarian.addActionListener(new ActionListener() {

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
    JLabel label=new JLabel("View Book Pannel");
    label.setBounds(200, 130, 300, 25);
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setFont(new Font("Monospaced", Font.BOLD, 20));
    frame.add(label);

        DefaultTableModel model = new DefaultTableModel();

        JTable table=new JTable(){
			public boolean isCellEditable(int row,int column){
					return false;
			}
		};
		model = (DefaultTableModel)table.getModel();
		model.addColumn("ID");
		model.addColumn("Call no");
		model.addColumn("Name");
		model.addColumn("Author");
        model.addColumn("Semester");
        model.addColumn("Quantity");
        model.addColumn("Issued");
        model.addColumn("Added date");
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(40);
		table.getColumnModel().getColumn(6).setPreferredWidth(40);
		table.getColumnModel().getColumn(7).setPreferredWidth(150);
		
        JScrollPane sc = new JScrollPane(table);
		sc.setBounds(0, 160, 700, 200);
		frame.add(sc);

        try {
            Connection con=AddLibrarian.con();
            Statement st=con.createStatement();
            String query="select * from book";
            ResultSet rs=st.executeQuery(query);
            int i=0;
            while (rs.next()) {
                
            model.addRow(new Object[0]);
			model.setValueAt(rs.getInt("id"), i, 0);
            model.setValueAt(rs.getString("coll_No"), i, 1);
            model.setValueAt(rs.getString("book_name"), i, 2);
            model.setValueAt(rs.getString("author"), i, 3);
            model.setValueAt(rs.getString("semester"), i, 4);
            model.setValueAt(rs.getString("quantity"), i, 5);
            model.setValueAt(rs.getString("issued"), i, 6);
            model.setValueAt(rs.getString("added_date"), i, 7);
			
	        i++;
		}
		//-----------------------------------------------------
		
		frame.setVisible(true);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
