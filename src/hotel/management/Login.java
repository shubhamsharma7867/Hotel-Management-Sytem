package hotel.management;

import java.awt.Color;

import java.awt.Image;

import javax.swing.*;

import java.sql.*;

import java.awt.event.*;
public class Login extends JFrame implements ActionListener {
	JLabel l1,l2,l3;
	JTextField t1,t2;
	JButton b1,b2;
//	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/first02.jpg"));
	
	
	Login(){
	l1 =  new JLabel("UserName : ");
	l1.setBounds(30,110,100,50);
	add(l1);
	setLayout(null);
	
	l2 = new JLabel("Password :");
	l2.setBounds(30, 150, 100, 50);
	add(l2);
	
	t1 =  new JTextField();
	t1.setBounds(100, 120, 100, 30);
	add(t1);
	
	
	t2 = new JPasswordField();
	t2.setBounds(100, 160, 100, 30);
	add(t2);
	
	b1 = new JButton("Login");
    b1.setBounds (90, 200, 80, 30);
    b1.setForeground(Color.WHITE);
    b1.setBackground(Color.BLACK);
    b1.addActionListener(this);
    add(b1);
    
    b2 = new JButton("Cancel");
    b2.setBounds(180, 200, 80, 30);
    b2.setBackground(Color.WHITE);
    b2.setForeground(Color.black);
    b2.addActionListener(this);
    add(b2);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/second.jpg"));
    Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    
    ImageIcon i3 = new ImageIcon(i2);
     l3 = new JLabel(i3);
     l3.setBounds(300,20,200,250);
     add(l3);
      getContentPane().setBackground(Color.WHITE);
      
    
	setBounds(425,220,500,350);
	setVisible(true);
	
	
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1) {
			String username = t1.getText();
			String password = t2.getText();
			conn c = new conn();
			String str = "select * from Login where username = '"+ username + "' and password = '" +password+"'";
			try {
				ResultSet sc = c.s.executeQuery(str);
				if(sc.next()) {
					
                   new Dashboard().setVisible(true);
                   this.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null,"useranme and password is incorrect");
				}
			}
			catch (Exception e) {
				
			}
			
		}
		else if(ae.getSource()==b2) {
			
			 System.exit(0);
	}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Login();
	}
	

}
