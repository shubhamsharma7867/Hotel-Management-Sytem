package hotel.management;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Reception extends JFrame  implements ActionListener{
	JButton b1 ,b2 ,b3 ,b4,b5 ,b6,b7,b8,b9,b10,b11,b12;
	Reception(){
		setBounds(400,80,785,600);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/fourth.jpg"));
		JLabel l1 = new JLabel(i1);
		l1.setBounds(250,100,500,400);
		add(l1);
		
		b1 = new JButton("New Customer Form");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		b1.setBounds(20,30,200,30);
		add(b1);
		
		b2 = new JButton("Room");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.white);
		b2.addActionListener(this);
		b2.setBounds(20,70,200,30);
		add(b2);
		
		b3 = new JButton("Department");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.white);
		b3.addActionListener(this);
		b3.setBounds(20,110,200,30);
		add(b3);
		
		b4 = new JButton("All Employee Info");
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.white);
		b4.addActionListener(this);
		b4.setBounds(20,150,200,30);
		add(b4);
		
		b5 = new JButton("Customer Info");
		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.white);
		b5.addActionListener(this);
		b5.setBounds(20,190,200,30);
		add(b5);
		
		b6 = new JButton("Manager Info");
		b6.setBackground(Color.BLACK);
		b6.setForeground(Color.white);
		b6.addActionListener(this);
		b6.setBounds(20,230,200,30);
		add(b6);
		
		b7 = new JButton("Check Out");
		b7.setBackground(Color.BLACK);
		b7.setForeground(Color.white);
		b7.setBounds(20,270,200,30);
		b7.addActionListener(this);
		add(b7);
		
		b8 = new JButton("Update Check status");
		b8.setBackground(Color.BLACK);
		b8.setForeground(Color.white);
		b8.setBounds(20,310,200,30);
		b8.addActionListener(this);
		add(b8);
		
		b9 = new JButton("Update Room Status");
		b9.setBackground(Color.BLACK);
		b9.setForeground(Color.white);
		b9.setBounds(20,350,200,30);
		b9.addActionListener(this);
		add(b9);
		
		b10 = new JButton("Pickup Service");
		b10.setBackground(Color.BLACK);
		b10.setForeground(Color.white);
		b10.setBounds(20,390,200,30);
		b10.addActionListener(this);
		add(b10);
		
		b11 = new JButton("Search Room");
		b11.setBackground(Color.BLACK);
		b11.setForeground(Color.white);
		b11.setBounds(20,430,200,30);
		b11.addActionListener(this);
		add(b11);
		
		
		b12 = new JButton("Logout");
		b12.setBackground(Color.BLACK);
		b12.setForeground(Color.white);
		b12.setBounds(20,470,200,30);
		b12.addActionListener(this);
		add(b12);
		
		
		
		
		setLayout(null);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
	       if(ae.getSource()==b1) {
	    	   new customerinfo();
	    	   this.setVisible(false);
	       }
	       else if(ae.getSource()==b2) {
	    	   new Room();
	    	   this.setVisible(false);
	       }
 else if(ae.getSource()==b3) {
	    	   new Department();
	    	   this.setVisible(false);
	       }
 else if(ae.getSource()==b4) {
	   new Allemployeeinfo();
	   this.setVisible(false);
 }
 else if(ae.getSource()==b5) {
	   new customerinfo();
	   this.setVisible(false);
 }
 else if(ae.getSource()==b6) {
	   new Managerinfo();
	   this.setVisible(false);
 }
 else if(ae.getSource()==b7) {
	   new Checkout();
	   this.setVisible(false);
 }
 else if(ae.getSource()==b8) {
	  new UpdatecheckStatus();
	  this.setVisible(false);
 }
 else if(ae.getSource()==b9) {
	    new UpdateRoomStatus();
	    this.setVisible(false);
 }
 else if(ae.getSource()==b10) {
	   new Pickupservice();
	   this.setVisible(false);
 }
 else if(ae.getSource()==b11) {
	   new checkroom();
	   this.setVisible(true);
 }
 else if(ae.getSource()==b12) {
	   System.exit(0);
 }
 
	       
	       
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      new Reception();
	}

	

}
