package tp3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class InterfaceEditeurText extends JFrame {

	private JPanel pan;
	private JButton left, right, surlign;
	private JTextArea page;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;
	private JLabel search;
	private JTextField zone;
	private BorderLayout borderLayout;


	public InterfaceEditeurText(){
		super("Editeur de Textes");
	
		this.page = new JTextArea("TP3 IHM Universitée de Lille 1");
		this.page.setPreferredSize(new Dimension(350,350));
		page.setFont(new Font("Serif", Font.ITALIC, 12));
		
		
		this.left = new JButton();
		ImageIcon img = new ImageIcon("res/previous_motif.gif");
        this.left.setIcon(img);
        
        this.right = new JButton();
		img = new ImageIcon("res/next_motif.gif");
        this.right.setIcon(img);
        
        this.surlign = new JButton("Surligner tout");
        
        this.zone = new JTextField();
        this.zone.setPreferredSize(new Dimension(100,25));
        
        this.search = new JLabel("Rechercher");
        
        
		
		initPanel();
		
		setMenuBar();
			
		setComposantToFrame();
		
		setVisible(true);
		setMinimumSize(this.getPreferredSize());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}
	
	private void setMenuBar() {
		this.menuBar = new JMenuBar();
		
		//Build the first menu.
		this.menu = new JMenu("Fichier");
		this.menu.setMnemonic(KeyEvent.VK_A);
		this.menu.getAccessibleContext().setAccessibleDescription(
		        "The only menu in this program that has menu items");
		this.menuBar.add(menu);
		
		//a group of JMenuItems
		this.menuItem = new JMenuItem("Nouveau",KeyEvent.VK_1);
		this.menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		this.menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		this.menu.add(menuItem);

		this.menuItem = new JMenuItem("Ouvrir",KeyEvent.VK_2);
		this.menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		this.menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		this.menu.add(menuItem);
		
		this.menuItem = new JMenuItem("Enregister",KeyEvent.VK_3);
		this.menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		this.menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		this.menu.add(menuItem);
		
		this.menuItem = new JMenuItem("Enregister",KeyEvent.VK_4);
		this.menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.SHIFT_MASK + ActionEvent.CTRL_MASK));
		this.menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		this.menu.add(menuItem);
		
	
		menu.addSeparator();
		
		this.menuItem = new JMenuItem("Mise en page",KeyEvent.VK_5);
		this.menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		this.menu.add(menuItem);
		
		this.menuItem = new JMenuItem("Imprimer",KeyEvent.VK_6);
		this.menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		this.menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		this.menu.add(menuItem);
		
		menu.addSeparator();
		
		this.menuItem = new JMenuItem("Quitter",KeyEvent.VK_7);
		this.menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));
		this.menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		this.menu.add(menuItem);

		this.menu = new JMenu("Edition");
		this.menu.setMnemonic(KeyEvent.VK_Z);
		this.menuBar.add(menu);
		
		this.menu = new JMenu("Format");
		this.menu.setMnemonic(KeyEvent.VK_E);
		this.menuBar.add(menu);
		setJMenuBar(this.menuBar);
	}

	private void setComposantToFrame() {
		
		//getContentPane().setLayout(borderLayout);
		

		add(this.pan,BorderLayout.PAGE_END);
		add(this.page, BorderLayout.CENTER);
		
	}
	
	private void initPanel() {
		this.pan =  new JPanel();
		this.pan.add(this.search);
		this.pan.add(this.zone);
		this.pan.add(this.left);
		this.pan.add(this.right);
		this.pan.add(this.surlign);
		
		
	}
	public static void main(String args[]){
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

		InterfaceEditeurText fenetre = new InterfaceEditeurText();

//		JFrame f = new JFrame("toto");
//		//f.getContentPane().setLayout(borderLayout);
//		f.add(pan,BorderLayout.PAGE_END);
//		f.add(page, BorderLayout.CENTER);
//		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setSize(400,400);

	}

}
