package hotel.management;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Pickupservice extends JFrame implements ActionListener {
	JTable t1 ;
	JButton b1 ,b2;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	Choice c1;
	 Pickupservice(){
		

		b1 = new JButton("Load");
		b1.setBounds(160,440,120,20);
		b1.setBackground(Color.black);
		b1.addActionListener(this);
		b1.setForeground(Color.WHITE);
		add(b1);
		
		t1 = new JTable();
		t1.setBounds(0,40,1000,200);
		add(t1);
		
		b2 = new JButton("Back");
		b2.setBounds(350,440,120,20);
		b2.setBackground(Color.black);
		b2.addActionListener(this);
		b2.setForeground(Color.WHITE);
		add(b2);
		
		l1 = new JLabel("Name");
		l1.setBounds(0,20,120,20);
		add(l1);
		
		l2 = new JLabel("Age");
		l2.setBounds(150,20,120,20);
		add(l2);
		
		l3 = new JLabel("Gender");
		l3.setBounds(300,20,120,20);
		add(l3);
		
		l4 = new JLabel("Company");
		l4.setBounds(450,20,120,20);
		add(l4);
		
		l5 = new JLabel("Brand");
		l5.setBounds(580,20,120,20);
		add(l5);
		
		l6 = new JLabel("Availabiliy");
		
		l6.setBounds(720, 20,120,20);
		add(l6);
		

		l7 = new JLabel("Location");
		l7.setFont(new Font("serif",Font.BOLD,17));
		l7.setBounds(880, 20,120,20);
		add(l7);
		
		
		c1 = new Choice();
		try {
			conn c = new conn();
			String str = "select * from adddriver";
			ResultSet rs = c.s.executeQuery(str);
			while(rs.next()) {
				c1.add(rs.getString("carmodel"));
			}
		}
		catch(Exception e) {}
		c1.setBounds(130,300,120,20);
		add(c1);
		
		
		l8 = new JLabel("CarModel");
		l8.setFont(new Font("serif",Font.BOLD,17));
		l8.setBounds(0, 300,120,20);
		add(l8);
		
		
		
		setLayout(null);
		setBounds(300,50,1000,500);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
		String bed =(String)c1.getSelectedItem();
		
			try {
				conn c = new conn();
				String str = "select * from adddriver";
				ResultSet rs = c.s.executeQuery(str);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
				}
			
			catch(Exception e) {
				System.out.println(e);
				
			}
		}
		
		else if(ae.getSource()==b2) {
			new Reception();
			this.setVisible(false);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     new  Pickupservice();
	}
}
