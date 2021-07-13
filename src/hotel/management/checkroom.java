package hotel.management;


import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.*;

public class checkroom extends JFrame implements ActionListener {
	JTable t1 ;
	JButton b1 ,b2;
	JLabel l1,l2,l3,l4,l5,l6;
	JComboBox c1;
	JCheckBox c2;
	checkroom(){
		

		b1 = new JButton("Load");
		b1.setBounds(160,440,120,20);
		b1.setBackground(Color.black);
		b1.addActionListener(this);
		b1.setForeground(Color.WHITE);
		add(b1);
		
		t1 = new JTable();
		t1.setBounds(0,40,700,200);
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
		
		l6 = new JLabel("Bed Type");
		l6.setFont(new Font("serif",Font.BOLD,17));
		l6.setBounds(0, 300,120,20);
		add(l6);
		
		
		c2 = new JCheckBox("only the Empty");
		c2.setBounds(250,300,120,20);
		add(c2);
		
		String []str = {"King Size","Single Bed"};
		c1 = new JComboBox(str);
		c1.setBounds(80,300,120,20);
		add(c1);
		
		
		setLayout(null);
		setBounds(300,50,700,500);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
		String bed =(String)c1.getSelectedItem();
		
			try {
				conn c = new conn();
				String str = "select * from addroom where bedtype ='"+bed+"'";
				String str2 = "select * from addroom where availablity = 'Empty' AND bedtype ='"+bed+"'";
				
				if(c2.isSelected()) {
					ResultSet rs1 = c.s.executeQuery(str2);
					t1.setModel(DbUtils.resultSetToTableModel(rs1));
				}
				else {
					ResultSet rs = c.s.executeQuery(str);
					t1.setModel(DbUtils.resultSetToTableModel(rs));
				}
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
     new checkroom();
	}
}

	
