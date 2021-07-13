package hotel.management;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {
	HotelManagementSystem(){
		setBounds(45,25,1025,576);
//		setSize(400,400);
//		JLabel l1 = new JLabel();
//		l1.add(firstframe);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/first01.jpg"));
		JLabel l1 = new JLabel(i1);
		l1.setBounds(0, 0, 1024, 576);
		add(l1);
		JButton l2 = new JButton("Next");
		l2.setForeground(Color.BLACK);
		l2.setBackground(Color.WHITE);
		l2.setBounds(900, 475, 100, 35);
		l1.add(l2);
		l2.addActionListener(this);
		JLabel  l3 = new JLabel("HotelManagementSystem");
		l3.setForeground(Color.WHITE);
		l3.setBounds(14, 450, 1000, 90);
		l3.setFont(new Font("serif",Font.PLAIN,70));
	    l1.add(l3);
		
		setLayout(null);
		setVisible(true);
		while(true) {
			l3.setVisible(false);
			try {
				Thread.sleep(500);
			}catch(Exception  e) {}
			l3.setVisible(true);
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
		}
		
			
		}
	
	public void actionPerformed(ActionEvent aw) {
		new Login().setVisible(true);
	     this.setVisible(false);	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
             new HotelManagementSystem();
	}

}
