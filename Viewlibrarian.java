package library;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Viewlibrarian extends Layout {
    public void ViewLibrarian() {
		/*String data[][]=null;
		String column[]=null;
		try{
			Connection con=AddLibrarian.con();
			PreparedStatement ps=con.prepareStatement("select * from librarian",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=ps.executeQuery();
			
			ResultSetMetaData rsmd=rs.getMetaData();
			int cols=rsmd.getColumnCount();
			column=new String[cols];
			for(int i=1;i<=cols;i++){
				column[i-1]=rsmd.getColumnName(i);
			}
			
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();

			data=new String[rows][cols];
			int count=0;
			while(rs.next()){
				for(int i=1;i<=cols;i++){
					data[count][i-1]=rs.getString(i);
				}
				count++;
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		
		JTable table = new JTable(data,column);
		JScrollPane sp=new JScrollPane(table);
		*/
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
                adminsec l=new adminsec();
                l.section();
				
            } catch (Exception e1) {
                System.out.println(e1);
            }
           }
        
    });
	JLabel label=new JLabel("View Librarian Pannel");
    label.setBounds(200, 120, 300, 25);
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setFont(new Font("Monospaced", Font.BOLD, 20));
    frame.add(label);


        DefaultTableModel model = new DefaultTableModel();

        JTable table=new JTable(model){
			// public boolean isCellEditable(int row,int column){
			// 		return false;
			// }
		};
		model = (DefaultTableModel)table.getModel();
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Password");
		model.addColumn("Email ID");
        model.addColumn("City");
        model.addColumn("Contact Number");
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		
        JScrollPane sc = new JScrollPane(table);
		sc.setBounds(10, 150, 670, 200);
		frame.add(sc);

        try {
            Connection con=AddLibrarian.con();
            Statement st=con.createStatement();
            String query="select * from librarian";
            ResultSet rs=st.executeQuery(query);
            int i=0;
            while (rs.next()) {
                
            model.addRow(new Object[0]);
			model.setValueAt(rs.getInt("ID"), i, 0);
            model.setValueAt(rs.getString("Name"), i, 1);
            model.setValueAt(rs.getString("Password"), i, 2);
            model.setValueAt(rs.getString("Email_Id"), i, 3);
            model.setValueAt(rs.getString("City"), i, 4);
            model.setValueAt(rs.getString("Mobile_Number"), i, 5);
			
	        i++;
		}
		//-----------------------------------------------------
		
		frame.setVisible(true);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

