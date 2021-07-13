package hotel.management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


import javax.swing.*;
public class UpdatecheckStatus extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2,b3;
	Choice c1;
	
	UpdatecheckStatus(){
	
		l1 = new JLabel("UpdateCheckStatus");
		l1.setFont(new Font("serif",Font.BOLD,17));
		l1.setForeground(Color.red);
		l1.setBounds(10,20,180,20);
		add(l1);
		
		l2 = new JLabel("Customer Id");
		l2.setFont(new Font("serif",Font.BOLD,16));
		l2.setBounds(10,60,170,20);
		add(l2);
		
		l3 = new JLabel("Room Number");
		l3.setFont(new Font("serif",Font.BOLD,16));
		l3.setBounds(10,100,180,20);
		add(l3);
		
		l4 = new JLabel("Name");
		l4.setFont(new Font("serif",Font.BOLD,17));
		l4.setBounds(10,140,180,20);
		add(l4);
		
		l5 = new JLabel("Check In");
		l5.setFont(new Font("serif",Font.BOLD,17));
		l5.setBounds(10,180,180,20);
		add(l5);
		
		l6 = new JLabel("Amount Paid");
		l6.setFont(new Font("serif",Font.BOLD,17));
		l6.setBounds(10,220,180,20);
        add(l6);
        
        
        l7 = new JLabel("Pending Amount");
		l7.setBounds(10,260,180,20);
		l7.setFont(new Font("serif",Font.BOLD,17));
		add(l7);
		
		
	    c1 = new Choice();
	    try {
	    	c1.getSelectedItem();
	    	conn c = new conn();
	    	String str = "select * from addcustomer";
	    	ResultSet rs = c.s.executeQuery(str);
	    	while(rs.next()) {
	    	c1.add(rs.getString("number"));	
	    	}
	    	
	    }
	    catch(Exception e) {}
		
	    c1.setBounds(180,60,180,20);
	    add(c1);
	    
	    
	    t1= new JTextField();
	    t1.setBounds(180,100,180,20);
	    add(t1);
	    
	    t2= new JTextField();
	    t2.setBounds(180,140,180,20);
	    add(t2);
	    
	    t3= new JTextField();
	    t3.setBounds(180,180,180,20);
	    add(t3);
	    
	    t4= new JTextField();
	    t4.setBounds(180,220,180,20);
	    add(t4);
	    
	    t5= new JTextField();
	    t5.setBounds(180,260,180,20);
	    add(t5);
	    
	    
	    
	    b1 = new JButton("Check");
	    b1.setBounds(180,300,180,20);
	    b1.addActionListener(this);
	    add(b1);
	    
	    
	    b2 = new JButton("load");
	    b2.setBounds(100,350,150,20);
	    b1.addActionListener(this);
	    add(b2);
	    
	    b3 = new JButton("Cancel");
	    b3.setBounds(280,350,150,20);
	    b1.addActionListener(this);
	    add(b3);
	    
	    
		setLayout(null);
		setBounds(250,150,700,450);
		setVisible(true);
		
   }
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1) {
           String cusid = c1.getSelectedItem();
           try {
        	   conn c = new conn();
        	   ResultSet rs =  c.s.executeQuery("select * from addcustomer where number = '"+cusid+"' ");
        	   while(rs.next()) {
        		   t1.setText(rs.getString("allocatedroom"));
        		   t2.setText(rs.getString("name"));
        		   t3.setText(rs.getString("checkedin"));
        		   t4.setText(rs.getString("deposit"));
        		   
        	   }
        	   String deposit = t4.getText();
        	   String roomnumber = t1.getText();
        	  
        	   ResultSet rs1 = c.s.executeQuery("select * from addroom where roomnumber = '"+roomnumber+"'");
        	   while(rs1.next()) {
        		   String price = rs1.getString("price");
        		   int remain = Integer.parseInt(price) - Integer.parseInt(deposit);
        		   String money = Integer.toString(remain);
        		   t5.setText(money);
   				
   				
   			}
        	   
        	   
           }
           catch(Exception e) {
        	   System.out.println(e);
           }
			
		}
		
		else if(ae.getSource()==b2) {
			
			
			
		}
		else if(ae.getSource()==b3) {
			new Reception();
			this.setVisible(false);
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       new UpdatecheckStatus();
	}




}
