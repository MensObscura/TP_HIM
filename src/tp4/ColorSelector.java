package tp4;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorSelector extends JFrame{

	private JPanel[] p;
	private JSlider[] sl;
	private JTextField[] txt;
	private JDialog jj ;

	public ColorSelector(){
		super("ColorSelector");

		this.initPanel();
		this.initSlider();
		this.initText();
		
		 jj = new JDialog();

		this.p[0].setLayout(new GridLayout(3,2));
		this.p[1].setLayout(new GridLayout(2,1));
		this.AddComponant();

		this.p[3].setLayout(new GridLayout(1,2));

		this.p[3].add(this.p[0]);
		this.p[3].add(this.p[1]);

		this.setContentPane(p[3]);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	public void initPanel(){

		this.p = new JPanel[4];
		for(int i =0 ; i <4 ; i++){
			p[i]=new JPanel();

		}
	}
	public void initText(){

		this.txt = new JTextField[4];
		for(int i =0 ; i <4; i++){
			final int index;
			this.txt[i]=new JTextField();
			index =i;
			if(i<3){
				txt[i].setText(sl[i].getValue()+"");

				txt[i].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String tmp = txt[index].getText();
						int last = sl[index].getValue();
						try{
							tmp.trim();
							sl[index].setValue(Integer.parseInt(tmp));
						}catch(NumberFormatException er){
							System.err.println(er);
							JOptionPane.showMessageDialog(jj,
								    "Entier décimal incorrect : "+tmp+"\nL'entier doit etre compris entre 0 et 255 inclus \net composé uniquement de chiffres","Integer error",
								    JOptionPane.ERROR_MESSAGE);
							txt[index].setText(""+last);
							sl[index].setValue(last);
						}
						
						getHexa();
						color();
					}
				});
			}else{

				txt[i].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String value=txt[index].getText();
						if(value.length()<7 || value.length()>7){
							JOptionPane.showMessageDialog(jj,
								    "Code hexadécimal incorrect : "+value+"\n Merci de respecter le format suivant : dRRGGBB","hexa error",
								    JOptionPane.ERROR_MESSAGE);
							txt[index].setText("d808080");
						}
						color();
						setHexa();
						
						
					}
				});


			}
		}
	}
	public void initSlider(){
		this.sl = new JSlider[3];

		for( int i=0 ; i <3 ; i++){
			final int index;
			this.sl[i]=new JSlider(JSlider.HORIZONTAL,0,255,128);
			index =i;

			this.sl[i].addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					txt[index].setText(sl[index].getValue()+"");
					getHexa();
					color();

				}
			});

		}
	}

	public void AddComponant(){

		for(int i =0 ; i <3 ; i++){
			this.p[0].add(sl[i]);
			this.p[0].add(txt[i]);
		}

		this.p[1].add(this.txt[3]);
		this.p[1].add(this.p[2]);
	}
	
	public void getHexa(){
		String tmp,hexa = "";
		
		hexa +="d";
		
		for( int i=0 ; i <3 ; i++){
		
		tmp = Integer.toHexString(this.sl[i].getValue());
		if(tmp.length() ==1)
			hexa+="0";
		hexa+=tmp;
		}
		txt[3].setText(hexa);
		
	}

	public void setHexa(){
		String hexa = "";
		
		hexa =txt[3].getText();
		
		for( int i=0 ; i <3 ; i++){
			
			this.sl[i].setValue(Integer.valueOf(hexa.substring((i*2)+1,(i*2)+3), 16));
		}
			
	}
	public void color(){

		String hexa = txt[3].getText();

		try{
			hexa.trim();
			Color c = Color.decode("0x"+hexa.substring(1));
			p[2].setBackground(c);
		}catch(NumberFormatException er){
			System.err.println(er);
			JOptionPane.showMessageDialog(jj,
				    "Code hexadécimal incorrect : "+hexa+"\nMerci de respecter le format suivant : dRRGGBB","hexa error",
				    JOptionPane.ERROR_MESSAGE);
			txt[3].setText("d808080");
		}

	}
	public static void main(String[] args) {
		ColorSelector frame = new ColorSelector();
		frame.getHexa();
		frame.color();
	}
}
