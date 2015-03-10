package tp4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreIncrementer extends JFrame {

	private JLabel lab;
	private JButton bout;
	private JPanel pan;
	private BoxLayout lay;
	public FenetreIncrementer(){
		super("Incrementator");
		
	
		this.pan = new JPanel();
		this.lab = new JLabel("0");
		this.bout = new JButton("Clic");
		
		this.addWindowListener(new FermetureFenetre());
		
//		Anonyme class from far the best way in many case !!
//		this.bout.addActionListener(new ActionListener() {
//   
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				lab.setText(""+(Integer.parseInt(lab.getText())+1));
//				
//			}
//        });
		
//Class extern		
		this.bout.addActionListener(new ReponseAuClic(lab));

		
		
		this.lay = new BoxLayout(pan, BoxLayout.Y_AXIS);
		
		this.pan.setLayout(lay);
		this.pan.add(lab, BorderLayout.CENTER);
		this.pan.add(bout);
		this.setContentPane(pan);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
//	private class  ReponseAuClic implements ActionListener{
//		
//	
//
//		public ReponseAuClic(){
//			
//			lab=lab;
//			
//		}
//		
//		@Override
//		public void actionPerformed(ActionEvent arg0) {
//			lab.setText(""+(Integer.parseInt(lab.getText())+1));
//			
//		}
//
//	}

	
	
	public static void main(String args[]){
		
		JFrame toto = new FenetreIncrementer();
	}
}
