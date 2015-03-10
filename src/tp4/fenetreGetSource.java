package IHM;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class fenetreGetSource extends JFrame {


	private JLabel lab;
	private JButton[] bouts;
	private JPanel pan;
	private BoxLayout lay;
	public fenetreGetSource(){
		super("GetSourciste");


		this.pan = new JPanel();
		this.lab = new JLabel("0");
		this.bouts = new JButton[3];



		this.addWindowListener(new FermetureFenetre());
		

		this.lay = new BoxLayout(pan, BoxLayout.Y_AXIS);

		this.pan.setLayout(lay);
		this.pan.add(lab);
		
		
		for(int i = 0; i< 3; i++){
			this.bouts[i]= new JButton("bouton"+(i+1));
			this.bouts[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					lab.setText(((JButton) arg0.getSource()).getText());

				}
			});
			this.pan.add(this.bouts[i]);
		}




		this.setContentPane(pan);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}




	public static void main(String args[]){

		JFrame toto = new fenetreGetSource();
	}
}

