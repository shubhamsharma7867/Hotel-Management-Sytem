package hotel.management;

import java.awt.Color;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;


import net.proteanit.sql.DbUtils;

public class customerinfo  extends JFrame implements ActionListener {

	  JTable t1;
	  JButton b1, b2;
	  JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	  customerinfo(){
		t1 = new JTable();
     	t1.setBounds(0,40,1100,500);
     	add(t1);
		
     	l1 = new JLabel("ID");
     	l1.setBounds(0,20,180,20);
     	add(l1);
     	
     	l2 = new JLabel("Mobile Number");
     	l2.setBounds(150,20,180,20);
     	add(l2);
     	
     	l3 = new JLabel("Name");
     	l3.setBounds(300,20,180,20);
     	add(l3);
     	
     	l4 = new JLabel("Gender");
     	l4.setBounds(450,20,180,20);
     	add(l4);
     	
     	l5 = new JLabel("Country");
     	l5.setBounds(575,20,180,20);
     	add(l5);
     	
     	l6 = new JLabel("AllocatedRoom");
     	l6.setBounds(690,20,180,20);
     	add(l6);
     	
     	l7 = new JLabel("CheckedIn");
     	l7.setBounds(845,20,180,20);
     	add(l7);
     	
     	l8 = new JLabel("Deposit");
     	l8.setBounds(1000,20,180,20);
     	add(l8);
		
     	b1 = new JButton("Load");
     	b1.setBounds(200,550,180,20);
     	b1.setBackground(Color.BLACK);
     	b1.setForeground(Color.WHITE);
     	b1.addActionListener(this);
     	add(b1);
     	
     	b2 = new JButton("Cancel");
     	b2.setBackground(Color.BLACK);
     	b2.setForeground(Color.WHITE);
     	b2.addActionListener(this);
     	b2.setBounds(550,550,180,20);
     	add(b2);
     	
     	
		setBounds(250,50,1100,650);
		setLayout(null);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			try {
				conn c = new conn();
				String str = "select * from addcustomer";
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
       new customerinfo();
	}

}
