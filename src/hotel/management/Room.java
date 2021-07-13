package hotel.management;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;
public class Room extends JFrame  implements ActionListener{
	JTable t1 ;
	JButton b1 ,b2;
	JLabel l1,l2,l3,l4,l5;
	Room(){
		

		b1 = new JButton("Load");
		b1.setBounds(160,440,120,20);
		b1.setBackground(Color.black);
		b1.addActionListener(this);
		b1.setForeground(Color.WHITE);
		add(b1);
		
		t1 = new JTable();
		t1.setBounds(0,40,700,400);
		add(t1);
		
		b2 = new JButton("Back");
		b2.setBounds(350,440,120,20);
		b2.setBackground(Color.black);
		b2.addActionListener(this);
		b2.setForeground(Color.WHITE);
		add(b2);
		
		l1 = new JLabel("Room No.");
		l1.setBounds(0,20,120,20);
		add(l1);
		
		l2 = new JLabel("Status");
		l2.setBounds(150,20,120,20);
		add(l2);
		
		l3 = new JLabel("Cleaned status");
		l3.setBounds(300,20,120,20);
		add(l3);
		
		l4 = new JLabel("Price");
		l4.setBounds(450,20,120,20);
		add(l4);
		
		l5 = new JLabel("Bed Size");
		l5.setBounds(580,20,120,20);
		add(l5);
		
		
		setLayout(null);
		setBounds(300,50,700,500);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {
				conn c = new conn();
				String str = "select * from addroom";
				ResultSet rs = c.s.executeQuery(str);
				
				t1.setModel(DbUtils.resultSetToTableModel(rs));
			}
			catch(Exception e) {
				
			}
		}
		
		else if(ae.getSource()==b2) {
			new Reception();
			this.setVisible(false);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     new Room();
	}

	

}
