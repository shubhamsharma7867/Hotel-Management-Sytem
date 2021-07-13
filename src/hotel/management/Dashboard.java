package hotel.management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
public class Dashboard extends JFrame implements ActionListener {
	JMenuBar b1;
	JMenu m1,m2;
	JMenuItem i1,i2,i3,i4;
	Dashboard(){
		setBounds(0,0,1930,800);
		b1 = new JMenuBar();
		b1.setBounds(0,0,1930,30);
		add(b1);
		m1 = new JMenu("Hotel Management");
		m1.setForeground(Color.RED);
		b1.add(m1);
		ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/third.jpg"));
		Image img = im.getImage().getScaledInstance(1930, 800, Image.SCALE_DEFAULT);
		ImageIcon lala = new ImageIcon(img);
		JLabel l1 = new JLabel(lala);
		l1.setBounds(0,0,1930,800);
		add(l1);
		
		JLabel na = new JLabel("hotel SS welcomes you");
		na.setBounds(460,30,450,200);
		na.setForeground(Color.BLACK);
		na.setFont(new Font("serif",Font.PLAIN,45));
		l1.add(na);
		
		m2  = new JMenu("Admin");
		m2.setForeground(Color.BLUE);
		b1.add(m2);
		
		i1 = new JMenuItem("Reception");
		i1.addActionListener(this);
		m1.add(i1);
		i2 = new JMenuItem("Add Employee");
		i2.addActionListener(this);
		m2.add(i2);
		i3 = new JMenuItem("Add Driver");
		i3.addActionListener(this);
		m2.add(i3);
		i4 = new JMenuItem("Add Room");
		i4.addActionListener(this);
		m2.add(i4);
		
		setLayout(null);
		setVisible(true);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getActionCommand().equals("Reception")) {
			new Reception();
		}
		else if(ae.getActionCommand().equals("Add Employee")) {
			new Addemployee();
		}
		else if(ae.getActionCommand().equals("Add Room")) {
			new Addroom().setVisible(true);
		}
		else if(ae.getActionCommand().equals("Add Driver")) {
			new Adddriver();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      new Dashboard().setVisible(true);
      }

	

}
