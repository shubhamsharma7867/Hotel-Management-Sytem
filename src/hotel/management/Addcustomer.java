package hotel.management;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Addcustomer extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JTextField t1,t2,t3,t4,t5;
	JRadioButton b1,b2;
	JComboBox k1;
	Choice c1;
	JButton v1,v2;
	
	Addcustomer(){
		setBounds(300,20,800,700);
		
		l1 = new JLabel("Id");
		l1.setBounds(40,30,120,20);
		l1.setFont(new Font("serif",Font.BOLD,17));
		add(l1);
		
		l2 = new JLabel("Number");
		l2.setBounds(40,100,120,20);
		l2.setFont(new Font("serif",Font.BOLD,17));
		add(l2);
		
		l3 = new JLabel("Name");
		l3.setFont(new Font("serif",Font.BOLD,17));
		l3.setBounds(40,170,120,30);
		add(l3);
		
		
		l4 = new JLabel("Gender");
		l4.setFont(new Font("serif",Font.BOLD,17));
		l4.setBounds(40,240,120,30);
		add(l4);
		
		l5 = new JLabel("Country");
		l5.setFont(new Font("serif",Font.BOLD,17));
		l5.setBounds(40,310,120,30);
		add(l5);
		
		l6 = new JLabel("AllocatedRoom");
		l6.setFont(new Font("serif",Font.BOLD,17));
		l6.setBounds(40,380,140,30);
		add(l6);
		
		l7 = new JLabel("CheckedIn");
		l7.setFont(new Font("serif",Font.BOLD,17));
		l7.setBounds(40,450,120,30);
		add(l7);
		
		l8 = new JLabel("Deposit");
		l8.setFont(new Font("serif",Font.BOLD,17));
		l8.setBounds(40,520,120,30);
		add(l8);
		
		
		l9 = new JLabel("CUSTOMER FORM");
		l9.setBounds(350,100,300,20);
		l9.setFont(new Font("serif",Font.BOLD,27));
		l9.setForeground(Color.BLUE);
		add(l9);
		
		t1 = new JTextField();
		t1.setBounds(140,105,120,20);
		add(t1);
		
		String []str = {"Passport","Driving License","Aaadhar"};
		k1 = new JComboBox(str);
		k1.setBounds(140,30,120,20);
		add(k1);
		
		t2 = new JTextField();
		t2.setBounds(140,180,120,20);
		add(t2);
		
		b1 = new JRadioButton("Male");
		b1.setBounds(130,240,70,30);
		add(b1);
		
		b2 =  new JRadioButton("Female");
		b2.setBounds(200,240,80,30);
		add(b2);
		
		
		t3 = new JTextField();
		t3.setBounds(140,320,120,20);
		add(t3);
		
		t5 = new JTextField();
		t5.setBounds(140,525,120,20);
		add(t5);
		
		t4 = new JTextField();
		t4.setBounds(140,460,120,20);
		add(t4);
		
     	c1 = new Choice();
     	try {
     		conn c = new conn();
     		String str1 = "select * from addroom";
     		ResultSet rs = c.s.executeQuery(str1);
     		while(rs.next()) {
     			c1.add(rs.getString("roomnumber"));
     			}
     		
     		
     		
     	}
     	catch(Exception e) {}
     	c1.setBounds(180,390,120,20);
     	add(c1);
     	
        v1 = new JButton("ADD");	
		v1.setBounds(180,600,120,20);
		v1.addActionListener(this);
		add(v1);
		
		v2 = new JButton("Cancel");
		v2.setBounds(350,600,120,20);
		v2.addActionListener(this);
		add(v2);
		
		
		
		setLayout(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
	
		
		 String number = t1.getText();
		 String name = t2.getText();
		 String country= t3.getText();
		 String checkedin= t4.getText();
		 String deposit = t5.getText();
		 String roomno = c1.getSelectedItem();
	     String gender = null;
	     if(b1.isSelected()) {
	    	 gender = "male";
	     }
	     else if(b2.isSelected()) {
	    	 gender = "female";
	     }
	     String id  = (String) k1.getSelectedItem(); 
    
		 conn c = new conn();
		 String rts = "insert into addcustomer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+roomno+"','"+checkedin+"','"+deposit+"')";
		 if(ae.getSource()==v1) {
		 try {
			 c.s.executeUpdate(rts);
		 JOptionPane.showMessageDialog(null, "customer added succesfully");
		 this.setVisible(false);
		 }
		 catch(Exception e) {
			 
		 }
      }
	     
	     else if(ae.getSource()==v2) {
	    	 new Reception();
	    	 this.setVisible(false);
	     }
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		
		new Addcustomer();
	}

	

}
