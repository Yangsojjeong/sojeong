package event;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import indepEvent.MyActionListener;

public class AnonyClassListener extends JFrame{
	public AnonyClassListener() {
		setTitle("Anony Class Listener");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setBackground(Color.yellow);
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("기말고사");
		btn.setBackground(Color.green);
		btn.setForeground(Color.black);
		btn.addActionListener(new MyActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				if(b.getText().equals("방학 시작")) {
					b.setText("기말고사");
				}else {
					b.setText("방학 시작");
				}
				setTitle(b.getText());
			}
		});
		
		c.add(btn);
		
		setSize(450,200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new AnonyClassListener();
	}

}
