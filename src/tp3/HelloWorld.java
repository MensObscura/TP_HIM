package tp3;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.WindowConstants;

public class HelloWorld {
	
	private static JFrame fenetre;
	private static JLabel etiquette;
	private static JDialog dialog;
	
	public static void main(String[] args) {
		
		fenetre = new JFrame();
		etiquette = new JLabel("Hello World!");
		
		dialog = new JDialog(new JFrame(),
				"JDialog",
				true);
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.getContentPane().add(etiquette);
		fenetre.setVisible(true);
		fenetre.setSize(600, 400);
		fenetre.setResizable(false);
		fenetre.pack();
		
		dialog.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		dialog.setSize(150,150);
		dialog.setModal(true);
		dialog.setVisible(true);
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		fenetre.setLocationRelativeTo(null);
	}
}
