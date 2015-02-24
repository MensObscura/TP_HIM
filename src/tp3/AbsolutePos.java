package tp3;


import javax.swing.JButton;
import javax.swing.JFrame;

public class AbsolutePos {
	
	private static JFrame fenetre;

	private static JButton boutonUn;
	private static JButton boutonDeux;
	private static JButton boutonTrois;
	private static JButton boutonQuatre;
	private static JButton boutonCinq;
	private static JButton boutonSix;
	private static JButton boutonSept;
	private static JButton boutonHuit;
	private static JButton boutonNeuf;
	
	public static void main(String[] args) {

		fenetre = new JFrame("JFrame");


		boutonUn = new JButton("bouton1");
		boutonUn.setBounds(10,10,100,20);
		
		boutonDeux = new JButton("bouton2");
		boutonDeux.setBounds(60,40,100,20);
		
		boutonTrois = new JButton("bouton3");
		boutonTrois.setBounds(110,70,100,20);
		
		boutonQuatre = new JButton("bouton4");
		boutonQuatre.setBounds(160,100,100,20);
		
		boutonCinq = new JButton("bouton5");
		boutonCinq.setBounds(210,130,100,20);
		
		boutonSix = new JButton("bouton6");
		boutonSix.setBounds(260,160,100,20);
		
		boutonSept =new JButton("bouton7");
		boutonSept.setBounds(310,190,100,20);
		
		boutonHuit =new JButton("bouton8");
		boutonHuit.setBounds(360,220,100,20);
		
		boutonNeuf =new JButton("bouton9");
		boutonNeuf.setBounds(410,250,100,20);
		
		fenetre.setLayout(null);

		fenetre.add(boutonUn);
		fenetre.add(boutonDeux);
		fenetre.add(boutonTrois);
		fenetre.add(boutonQuatre);
		fenetre.add(boutonCinq);
		fenetre.add(boutonSix);
		fenetre.add(boutonSept);
		fenetre.add(boutonHuit);
		fenetre.add(boutonNeuf);
		fenetre.repaint();
		
		fenetre.setSize(550, 350);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
	}

}
