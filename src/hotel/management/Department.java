package hotel.management;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Department extends JFrame implements ActionListener {
	
	  JTable t1 ;
	  JButton b1 ,b2;
	  JLabel l1,l2;
	  
	   Department(){
		

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
		
		l1 = new JLabel("Department");
		l1.setBounds(0,20,120,20);
		add(l1);
		
		l2 = new JLabel("Budget");
		l2.setBounds(350,20,120,20);
		add(l2);
		
		
		

		
		
		
		setLayout(null);
		setBounds(300,50,700,500);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
		
		
			try {
				conn c = new conn();
				String str = "select * from department";
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
     new  Department();
	}
}



