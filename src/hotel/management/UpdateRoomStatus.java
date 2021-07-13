package hotel.management;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.sql.*;
public class UpdateRoomStatus extends JFrame implements ActionListener{

	Choice c1;
	JLabel l1,l2,l3,l4,l5;
	JButton b1,b2,b3;
	JTextField t1,t2,t3;
	ImageIcon i1 ;
	
	UpdateRoomStatus(){
		setBounds(250,100,700,450);
		
		l1 = new JLabel("Update Room Status");
		l1.setBounds(20,40,180,30);
		l1.setFont(new Font("serif",Font.PLAIN,18));
		l1.setForeground(Color.RED);
		add(l1);
		
		l2 = new JLabel("Guest Id");
		l2.setBounds(20,100,100,20);
		add(l2);
		
		l3 = new JLabel("Room");
		l3.setBounds(20,160,180,20);
		add(l3);
		
		l4= new JLabel("Availablity");
		l4.setBounds(20,220,180,20);
		add(l4);
		
		l5 = new JLabel("status");
		l5.setBounds(20,280,180,20);
		add(l5);
		
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
		c1.setBounds(120,100,120,20);
		add(c1);
		
		t1 = new JTextField();
		t1.setBounds(120,160,120,20);
		add(t1);
		
		t2 = new JTextField();
		t2.setBounds(120,220,120,20);
		add(t2);
		
		t3 = new JTextField();
		t3.setBounds(120,280,120,20);
		add(t3);
		
		
		b1 = new JButton("Check");
		b1.setBounds(100,320,120,20);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Update");
		b2.setBounds(30,380,120,20);
		b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton("Cancel");
		b3.setBounds(180,380,120,20);
		b3.addActionListener(this);
		add(b3);
		
		
		i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/eight.jpg"));
		Image kk = i1.getImage().getScaledInstance(290,290,Image.SCALE_DEFAULT);
		ImageIcon lk = new ImageIcon(kk);
		JLabel l6 = new JLabel(lk);
		l6.setBounds(340,50,250,250);
		add(l6);
		
		getContentPane().setBackground(Color.WHITE);
		
		
        setLayout(null);
		setVisible(true);
			}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1) {
			String sr =c1.getSelectedItem();
//     		String room = null;
			
			try {
				conn c = new conn();
				
				ResultSet rs = c.s.executeQuery("select * from addcustomer where number = '"+sr+"'");
				while(rs.next()) {
					t1.setText(rs.getString("allocatedroom"));
//            		room = rs.getString("allocatedroom");
					
					
				}
				
	            String room = t1.getText();
				ResultSet rs1 = c.s.executeQuery("select * from addroom where roomnumber = '"+room+"'");
				
				while(rs1.next()) {
					t2.setText(rs1.getString("availablity"));
					t3.setText(rs1.getString("cleaningstatus"));
					
				}
				
			}
			catch(Exception e) {
				System.out.println(e);
			
			}
			
			
			
		}
		else if(ae.getSource()==b2) {
			try {
				String available = t2.getText();
				String Status = t3.getText();
				String room = t1.getText();
				
				conn c = new conn();
				String str = "Update addroom set availablity = '"+available+"', cleaningstatus ='"+Status+"' where roomnumber = '"+room+"' ";
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "Room status updated successfully");
				this.setVisible(false);
				
			}
			catch(Exception e) {
				
			}
			
			
		}
		else if(ae.getSource()==b3) {
			new Reception();
			this .setVisible(false);
			
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new UpdateRoomStatus();

	}




	

}
