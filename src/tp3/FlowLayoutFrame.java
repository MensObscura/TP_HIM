package tp3;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutFrame {

	private static JFrame fenetre;

	private static FlowLayout flowLayout;

	private static JButton boutonUn;
	private static JButton boutonDeux;
	private static JButton boutonTrois;
	private static JButton boutonQuatre;
	private static JButton boutonCinq;
	private static JButton boutonSix;
	private static JButton boutonSept;
	private static JButton boutonHuit;
	private static JButton boutonNeuf;
	private static JButton boutonDix;
	private static JButton boutonOnze;
	private static JButton boutonDouze;
	private static JButton boutonTreize;
	private static JButton boutonQuatorze;
	private static JButton boutonQuinze;
	private static JButton boutonSeize;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		fenetre = new JFrame("JFrame");

		flowLayout = new FlowLayout();

		boutonUn = new JButton("bouton1");
		boutonDeux = new JButton("bouton2");
		boutonTrois = new JButton("bouton3");
		boutonQuatre = new JButton("bouton4");
		boutonCinq = new JButton("bouton5");
		boutonSix = new JButton("bouton6");
		boutonSept =new JButton("bouton7");
		boutonHuit =new JButton("bouton8");
		boutonNeuf =new JButton("bouton9");
		boutonDix = new JButton("bouton10");
		boutonOnze = new JButton("bouton11");
		boutonDouze = new JButton("bouton12");
		boutonTreize = new JButton("bouton13");
		boutonQuatorze = new JButton("bouton14");
		boutonQuinze = new JButton("bouton15");
		boutonSeize = new JButton("bouton16");

		fenetre.getContentPane().setLayout(flowLayout);

		fenetre.add(boutonUn);
		fenetre.add(boutonDeux);
		fenetre.add(boutonTrois);
		fenetre.add(boutonQuatre);
		fenetre.add(boutonCinq);
		fenetre.add(boutonSix);
		fenetre.add(boutonSept);
		fenetre.add(boutonHuit);
		fenetre.add(boutonNeuf);
		fenetre.add(boutonDix);
		fenetre.add(boutonOnze);
		fenetre.add(boutonDouze);
		fenetre.add(boutonTreize);
		fenetre.add(boutonQuatorze);
		fenetre.add(boutonQuinze);
		fenetre.add(boutonSeize);

		fenetre.setSize(600, 400);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);

	}
}
