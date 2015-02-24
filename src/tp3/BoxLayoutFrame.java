package tp3;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BoxLayoutFrame {

	private static JFrame fenetre;

	private static BoxLayout boxLayout;

	private static JButton boutonUn;
	private static JButton boutonDeux;
	private static JButton boutonTrois;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		fenetre = new JFrame("JFrame");

		boxLayout = new BoxLayout(fenetre.getContentPane(),BoxLayout.Y_AXIS);

		boutonUn = new JButton("bouton1");
		boutonDeux = new JButton("bouton2");
		boutonTrois = new JButton("bouton3");

		Box.Filler glue = (Box.Filler) Box.createVerticalGlue();
		glue.changeShape(glue.getMinimumSize(), new Dimension(0, 30),glue.getMaximumSize());

		fenetre.getContentPane().setLayout(boxLayout);

		fenetre.add(boutonUn);
		fenetre.add(boutonDeux);
		fenetre.add(glue);
		fenetre.add(boutonTrois);

		fenetre.setSize(600, 400);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
		fenetre.pack();
	}
}