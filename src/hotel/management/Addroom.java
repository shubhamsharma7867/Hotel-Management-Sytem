package hotel.management;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Addroom extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5,l6;
	JComboBox c1,c2,c3;
	JTextField t1,t2;
	JButton b1 ;
	Addroom(){
		setBounds(400,150,580,430);
		getContentPane().setBackground(Color.WHITE);
		
		l1 = new JLabel("Room Number");
		l1.setBounds(30,10,140,80);
		add(l1);
		
		t1 = new JTextField();
		t1.setBounds(150,40,100,20);
		add(t1);
		
		l2 = new JLabel("Availability");
		l2.setBounds(30,50,140,80);
		add(l2);
		
		String []str = {"Booked","Empty"}; 
		c1 = new JComboBox(str);
		c1.setBounds(150,80,100,20);
	    add(c1);
		
		l3 = new JLabel("Cleaning Status");
		l3.setBounds(30,90,140,80);
		String [] str1 = {"Cleaned","Not Cleaned"};
		c2 = new JComboBox(str1);
		c2.setBounds(150,120,100,20);
		add(c2);
		add(l3);
		
		l4 = new JLabel("Price");
		l4.setBounds(30,130,140,80);
		add(l4);
		
		t2 = new JTextField();
		t2.setBounds(150,160,100,20);
		add(t2);
		
		l5 = new JLabel("Bed Type");
		l5.setBounds(30,170,140,80);
		add(l5);
		
		String []str2 = {"King Size","Single Bed"};
		c3 = new JComboBox(str2);
		c3.setBounds(150,200,100,20);
		add(c3);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/eight.jpg"));
		Image k2 = i1.getImage().getScaledInstance(200, 250, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(k2);
		l6 = new JLabel(i2);
		l6.setBounds(300,30,250,250);
		add(l6);
		
		
		b1= new JButton("submit");
		b1.setForeground(Color.white);
		b1.setBackground(Color.black);
		b1.setBounds(90,260,100,20);
		b1.addActionListener(this);
		add(b1);
		setLayout(null);
		setVisible(true);
	}

	
	
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String roomno = t1.getText();
		String price = t2.getText();
		String availability = (String) c1.getSelectedItem();
		String cleaningstatus = (String) c2.getSelectedItem();
		String bedtype = (String) c3.getSelectedItem();
		String str ="insert into addroom values('"+roomno+"','"+availability+"','"+cleaningstatus+"','"+price+"','"+bedtype+"')"; 
		conn c = new conn();
		try {
			c.s.executeUpdate(str);
			JOptionPane.showMessageDialog(null,"Room Added Successfully");
			this.setVisible(false);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          
		  new Addroom();
	}

	
	

}
