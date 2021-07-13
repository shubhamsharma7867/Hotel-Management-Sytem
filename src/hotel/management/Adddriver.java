package hotel.management;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class Adddriver extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4,t5;
	JComboBox c1,c2;
	JButton b1;
	Adddriver(){
		setBounds(350,180,575,400);
		
		ImageIcon k1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/baby.jpg"));
		Image ji = k1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		ImageIcon k2 = new ImageIcon(ji);
		JLabel k = new JLabel(k2);
		k.setBounds(280,50,270,300);
		add(k);
		getContentPane().setBackground(Color.WHITE);
		JLabel l8 = new JLabel("ADD DRIVER");
		l8.setBounds(100,20,80,50);
		add(l8);
		
		
		l1 = new JLabel("Name");
		l1.setBounds(40,30,90,70);
		l1.setFont(new Font("serif",Font.PLAIN,17));
		add(l1);
		
		t1 =  new JTextField();
		t1.setBounds(140,60,110,20);
		add(t1);
		
		l2 = new JLabel("Age");
		l2.setBounds(40,60,90,70);
		l2.setFont(new Font("serif",Font.PLAIN,17));
		add(l2);
		
		t2 = new JTextField();
		t2.setBounds(140,90,110,20);
		add(t2);
		
		l3 = new JLabel("Gender");
		l3.setFont(new Font("serif",Font.PLAIN,17));
		l3.setBounds(40,90,90,70);
		add(l3);
		
		String []str = {"Male","Female"};
		c1 = new JComboBox(str);
		c1.setBounds(140,120,110,20);
		c1.setBackground(Color.white);
		add(c1);
		
		l4 = new JLabel("Car Company");
		l4.setFont(new Font("serif",Font.PLAIN,17));
        l4.setBounds(40,120,110,70);
		add(l4);
		
		t3 = new JTextField();
		t3.setBounds(140,150,110,20);
		add(t3);
		
		l5 = new JLabel("Car Model");
		l5.setFont(new Font("serif",Font.PLAIN,17));
		l5.setBounds(40,150,90,70);
		add(l5);
		
		t4 = new JTextField();
		t4.setBounds(140,180,110,20);
		add(t4);
		
		l6 = new JLabel("Availabilty");
		l6.setFont(new Font("serif",Font.PLAIN,17));
		l6.setBounds(40,180,90,70);
		add(l6);
		
		String []str1 = {"Available","Not Available"};
		c2 = new JComboBox(str1);
		c2.setBounds(140,210,110,20);
		c2.setBackground(Color.WHITE);
		add(c2);
		
		
		l7 = new JLabel("Location");
		l7.setFont(new Font("serif",Font.PLAIN,17));
		l7.setBounds(40,210,90,70);
		add(l7);
		
		t5 = new JTextField();
		t5.setBounds(140,240,110,20);
		add(t5);
		
		b1 = new JButton("Submit");
		b1.setBounds(100,280,90,20);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		
		setLayout(null);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String name = t1.getText();
		String Age = t2.getText();
		String gender = (String) c1.getSelectedItem();
		String carcompany = t3.getText();
		String carmodel =t4.getText();
		String availability = (String) c2.getSelectedItem();
		String location = t5.getText();
		
		String str = "insert into adddriver values('"+name+"','"+Age+"','"+gender+"','"+carcompany+"','"+carmodel+"','"+availability+"','"+location+"')";
		conn c = new conn();
		try {
			c.s.executeUpdate(str);
			JOptionPane.showMessageDialog(null, "Driver added Successfully");
			this.setVisible(false);
		}
		catch(Exception e) {}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         new Adddriver();
	}

	

}
