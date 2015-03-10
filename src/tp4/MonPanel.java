package tp4;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MonPanel extends JPanel { 

	public void paintComponent(Graphics g) { 
		super.paintComponent(g); 
		g.drawOval(10,10,50,50); 
	} 
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		//f.setContentPane(new MonPanel());
		f.setContentPane(new ArdoiseMagique());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(200,200);
		f.setVisible(true);
		
	}
}