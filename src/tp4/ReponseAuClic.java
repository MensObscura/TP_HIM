package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class ReponseAuClic implements ActionListener{
	
	private JLabel lab;

	public ReponseAuClic(JLabel lab){
		
		this.lab=lab;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		lab.setText(""+(Integer.parseInt(lab.getText())+1));
		
	}

}
