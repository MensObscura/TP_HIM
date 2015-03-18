package tp5;

import java.awt.GridLayout;
import java.awt.event.InputEvent;

import javax.swing.Action;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

public class TransfereFrame extends JFrame {

	private JLabel label;
	private JFormattedTextField text,field;
	private JPanel panel;
	
	
	public TransfereFrame(){
		TransferHandler handler = new TransferHandler(getName());
		this.label = new JLabel("IHM");
		this.label.addMouseMotionListener(handler.exportAsDrag(label, new InputEvent(), 0));
		this.text = new JFormattedTextField();
		this.field = new JFormattedTextField();
		
		this.panel = new JPanel();
		
		this.panel.setLayout(new GridLayout(3,1));
		
		this.panel.add(this.label);
		this.panel.add(this.text);
		this.panel.add(this.field);
		
		this.add(this.panel);
		
		this.setVisible(true);
		this.setSize(200,100);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TransfereFrame t = new TransfereFrame();

	}

}
