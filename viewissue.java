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

public class viewissue extends Layout{

    public void viewissue() {

        Layout layout=new Layout();
        JFrame frame = (JFrame)layout.Layout();

    JButton librarian = new JButton("Back");
    librarian.setBounds(500, 25, 100, 30);
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
            JLabel label=new JLabel("View IssueBook Pannel");
            label.setBounds(200, 120, 300, 25);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setFont(new Font("Monospaced", Font.BOLD, 20));
            frame.add(label);

        DefaultTableModel model = new DefaultTableModel();

        JTable table=new JTable(model);
		model = (DefaultTableModel)table.getModel();
		model.addColumn("id");
		model.addColumn("bookcallno");
		model.addColumn("studentid");
		model.addColumn("studentclass");
        model.addColumn("studentname");
        model.addColumn("studentcontact");
                model.addColumn("status");
        model.addColumn("issue_date");
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
		
		
        JScrollPane sc = new JScrollPane(table);
		sc.setBounds(0, 150, 700, 200);
		frame.add(sc);

        try {
            Connection con=AddLibrarian.con();
            Statement st=con.createStatement();
            String query="select * from issuebook";
            ResultSet rs=st.executeQuery(query);
            int i=0;
            while (rs.next()) {
                
            model.addRow(new Object[0]);
			model.setValueAt(rs.getInt("id"), i, 0);
            model.setValueAt(rs.getString("bookcallno"), i, 1);
            model.setValueAt(rs.getString("studentid"), i, 2);
            model.setValueAt(rs.getString("studentclass"), i, 3);
            model.setValueAt(rs.getString("Studentname"), i, 4);
            model.setValueAt(rs.getString("Studentcontact"), i, 5);
            model.setValueAt(rs.getString("status"), i, 6);
            model.setValueAt(rs.getString("issue_date"), i, 7);
           
			
	        i++;
		}
		//-----------------------------------------------------
		
		frame.setVisible(true);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
