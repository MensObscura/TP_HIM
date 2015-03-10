package IHM;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class FermetureFenetre extends  WindowAdapter 
{

	

	@Override
	public void windowClosing(WindowEvent e){
	
		JDialog jj = new JDialog();
		JOptionPane.showMessageDialog(jj,
			    "fenêtre en cours de fermeture.");
		System.exit(0);
	}

}
