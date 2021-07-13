package hotel.management;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
public class Checkout extends JFrame implements ActionListener {
	  JLabel l1,l2,l3;
	  JButton b1,b2,b3;
	  Choice c1 ;
	  JTextField t1;
	  
	   Checkout(){
        l1 = new JLabel("Checkout Status");
        l1.setFont(new Font("serif",Font.BOLD,17));
		l1.setBounds(10,0,180,20);
		add(l1);
		
		l1 = new JLabel("ID");
        l1.setFont(new Font("serif",Font.BOLD,17));
		l1.setBounds(10,80,80,20);
		add(l1);
		
		l1 = new JLabel("Room number");
        l1.setFont(new Font("serif",Font.BOLD,17));
		l1.setBounds(10,160,180,20);
		add(l1);
		
		
        c1= new Choice();
		
		try {
			
			conn  c = new conn();
			String str = "select * from addcustomer";
			ResultSet rs = c.s.executeQuery(str);
			while(rs.next()) {
			c1.add(rs.getString("number"));
			}
			
		}
		
		catch(Exception e)
		{
		System.out.println(e);	
		}
		c1.setBounds(130,80,150,20);
		add(c1);
		
		
		t1 = new JTextField();
		t1.setBounds(130,160,150,20);
		add(t1);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/tick.png"));
		Image k1 = i1.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(k1);
		
		b1 = new JButton(i2);
	    b1.setBounds(280,80,20,20);
	    b1.addActionListener(this);
	    add(b1);
		
	     b2 = new JButton("Checkout");
	     b2.setBounds(80,230,100,20);
	     b2.addActionListener(this);
	     add(b2);
	     
	     b3 =  new JButton("Back");
	     b3.setBounds(220,230,100,20);
	     b3.addActionListener(this);
	     add(b3);
	     
	    
		 setLayout(null);  
		 setBounds(300,150,600,300);
		 setVisible(true);
	   }

	   @Override
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
		 
			   if(ae.getSource()==b1) {
					String sr =c1.getSelectedItem();
//		     		String room = null;
					
					try {
						conn c = new conn();
						
						ResultSet rs = c.s.executeQuery("select * from addcustomer where number = '"+sr+"'");
						while(rs.next()) {
							t1.setText(rs.getString("allocatedroom"));
//		            		room = rs.getString("allocatedroom");
							
							
						}
					}
						catch (Exception e) {}
			   
		   
			   }
		   
	   
			
		             else if(ae.getSource()==b2) {
			          try {
			        	  conn c = new conn();
			        	  String id = c1.getSelectedItem();
			              String room = t1.getText();
			              String str = "delete from addcustomer where number = '"+id+"'";
			              String str1 = "update addroom set availablity = 'Empty' where roomnumber = '"+room+"'";
			              c.s.executeUpdate(str);
			              c.s.executeUpdate(str1);
			             JOptionPane.showMessageDialog(null, "customer checkedout");
			        	  
			        	  
			          }
			          catch(Exception e) {}
		         }
		   
		   else if(ae.getSource()==b3) {
			   new Reception();
			   this.setVisible(false);
		   }
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
               new Checkout();
	}

	
}
