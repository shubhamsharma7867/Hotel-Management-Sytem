package hotel.management;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;
public class Addemployee extends JFrame implements ActionListener {
	JTextField t1,t2,t3,t4,t5,t6;
	JRadioButton b1,b2;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JComboBox b3;
	JButton e1;
	Addemployee(){
		
		setBounds(300,80,730,450);
		l1 = new JLabel("Name");
		l1.setBounds(20,25,50,100);
		add(l1);
		
		l2 = new JLabel("Age");
		l2.setBounds(20,55,50,100);
		add(l2);
		
		l3 = new JLabel("Gender");
		l3.setBounds(20,85,50,100);
		add(l3);
		
		l4 = new JLabel("Job");
		l4.setBounds(20,115,50,100);
		add(l4);
		
		l5 = new JLabel("Salary");
		l5.setBounds(20,145,50,100);
		add(l5);
		
		l6 = new JLabel("Phone");
		l6.setBounds(20,175,50,100);
		add(l6);
		
		l7 = new JLabel("Aadhar");
		l7.setBounds(20,205,50,100);
		add(l7);
		
		l8 = new JLabel("Email");
		l8.setBounds(20,235,50,100);
		add(l8);
		
		t1 = new JTextField();
		t1.setBounds(100,65,110,20);
		add(t1);
		
		t2 = new JTextField();
		t2.setBounds(100,95,110,20);
		add(t2);
		
		b1 = new JRadioButton("Male");
		b1.setBounds(100,125,70,30);
		b1.setBackground(Color.white);
		add(b1);
		
		b2 = new JRadioButton("Female");
		b2.setBounds(165,125,70,30);
		b2.setBackground(Color.white);
		add(b2);;
		
		String []str = {"worker","driver","manager","room service","waiter","gardener","cheff","valet","light men"};
		b3 =  new JComboBox(str);
		b3.setBounds(100,155,80,20);
		b3.setBackground(Color.WHITE);
		add(b3);
		
		
		t3 = new JTextField();
		t3.setBounds(100,185,110,20);
		add(t3);
		
		t4 = new JTextField();
		t4.setBounds(100,215,110,20);
		add(t4);
		
		t5 = new JTextField();
      	t5.setBounds(100,245,110,20);
		add(t5);

    	t6 = new JTextField();
		t6.setBounds(100,275,110,20);
		add(t6);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/tenth.jpg"));
		Image kk = img.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
		ImageIcon lala = new ImageIcon(kk);
		JLabel img1 = new JLabel(lala);
		img1.setBounds(300,30,355,350);
		add(img1);
		getContentPane().setBackground(Color.white);
		
		JLabel ji = new JLabel("Add Employee Details");
		ji.setBounds(50,250,340,140);
		ji.setForeground(Color.red);
		ji.setFont(new Font("serif",Font.PLAIN,27));
		e1 = new JButton("Submit");
		e1.setForeground(Color.white);
		e1.setBackground(Color.BLACK);
		e1.setBounds(100,300,80,20);
		e1.addActionListener(this);
		add(e1);
		img1.add(ji);
		setLayout(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = t1.getText();
		String age = t2.getText();
		String salary = t3.getText();
		String phone = t4.getText();
		String email= t5.getText();
		String aadhar = t6.getText();
		String gender = null;
		if(b1.isSelected()) {
			gender = "Male";
		}
		else if(b2.isSelected()) {
			gender = "Female";
		}
        String job = (String) b3.getSelectedItem();
        conn c = new conn();
        String str = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"')";
         try {
        	 c.s.executeUpdate(str);
        	 JOptionPane.showMessageDialog(null, "Employee added succesfully");
        	 this.setVisible(false);
         }catch(Exception ae) {
     	 System.out.print(ae);
         }
         
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Addemployee().setVisible(true);;

	}

	
	
}
