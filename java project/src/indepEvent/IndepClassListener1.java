package indepEvent;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IndepClassListener1 extends JFrame{
	public IndepClassListener1() {
		setTitle("Indep. Listener 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setBackground(Color.WHITE);
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("기말고사");
		btn.setBackground(Color.red);
		btn.setForeground(Color.white);
		btn.addActionListener(new MyActionListener());
		c.add(btn);
		
		setSize(350,150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new IndepClassListener1();
	

	}

}
