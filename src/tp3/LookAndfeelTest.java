package tp3;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class LookAndfeelTest {
	private static JFrame fenetre;

	private static BorderLayout borderLayout;

	private static JButton boutonUnU;
	private static JButton boutonUnD;
	private static JButton boutonUnT;
	private static JButton boutonDeux;
	private static JButton boutonTrois;
	private static JButton boutonQuatre;
	private static JButton boutonCinq;
	
	private static JPanel pan;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}

		fenetre = new JFrame();

		borderLayout = new BorderLayout();
		
		pan = new JPanel();

		boutonUnU = new JButton("Bouton 1");
		boutonUnD = new JButton("Bouton 2");
		boutonUnT = new JButton("Bouton 3");
		boutonDeux = new JButton("Centre");
		boutonTrois = new JButton("Ouest");
		boutonQuatre = new JButton("Est");
		boutonCinq = new JButton("Sud");
		
		pan.add(boutonUnU);
		pan.add(boutonUnD);
		pan.add(boutonUnT);

		fenetre.getContentPane().setLayout(borderLayout);

		fenetre.add(pan,BorderLayout.PAGE_START);
		fenetre.add(boutonDeux, BorderLayout.CENTER);
		fenetre.add(boutonTrois, BorderLayout.LINE_START);
		fenetre.add(boutonQuatre, BorderLayout.LINE_END);
		fenetre.add(boutonCinq, BorderLayout.PAGE_END);

		fenetre.setVisible(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(500,500);
	}

}
