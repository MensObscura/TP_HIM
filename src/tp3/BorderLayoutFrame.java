package tp3;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutFrame {

	private static JFrame fenetre;

	private static BorderLayout borderLayout;

	private static JButton boutonUn;
	private static JButton boutonDeux;
	private static JButton boutonTrois;
	private static JButton boutonQuatre;
	private static JButton boutonCinq;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		fenetre = new JFrame();

		borderLayout = new BorderLayout();

		boutonUn = new JButton("Nord");
		boutonDeux = new JButton("Centre");
		boutonTrois = new JButton("Ouest");
		boutonQuatre = new JButton("Est");
		boutonCinq = new JButton("Sud");

		fenetre.getContentPane().setLayout(borderLayout);

		fenetre.add(boutonUn,BorderLayout.PAGE_START);
		fenetre.add(boutonDeux, BorderLayout.CENTER);
		fenetre.add(boutonTrois, BorderLayout.LINE_START);
		fenetre.add(boutonQuatre, BorderLayout.LINE_END);
		fenetre.add(boutonCinq, BorderLayout.PAGE_END);

		fenetre.setVisible(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.pack();
	}
}