package tp4;

/**
 * ArdoiseMagique.java
 *
 * @author <a href="mailto:gery.casiez@lifl.fr">Gery Casiez</a>
 * @version
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Point {
	public Integer x,y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}
}

class Curve {
	public ArrayList<Point> points;

	Curve() {
		points = new ArrayList<Point>();
	}

	public void addPoint(Point P) {
		points.add(P);
	}

	public void clear() {
		points.clear();
	}
}

public class ArdoiseMagique extends JPanel implements MouseListener ,MouseMotionListener{
	private ArrayList<Curve> curves;
	
	public ArdoiseMagique(){
		curves = new ArrayList<Curve>();
		curves.add(new Curve());
		setBackground(Color.white);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	public void addPoint(Integer x, Integer y) {
		curves.get(curves.size()-1).addPoint(new Point(x,y));
		repaint();
	}

	public void newCurve() {
		curves.add(new Curve());
	}

	public void clear() {
		curves.clear();
		curves.add(new Curve());
		repaint();
	}

	public void paintComponent(Graphics g) {
		Point Pprev, Pcurrent;
		super.paintComponent(g);

		Iterator<Curve> itcurve = curves.iterator();

		Pprev = new Point();

		// Pour chaque courbe
		while (itcurve.hasNext()) {
			Iterator<Point> it = itcurve.next().points.iterator();

			if (it.hasNext()) {
				Pprev = it.next();
			}

			// Dessine les points d'une courbe
			while (it.hasNext()) {
				Pcurrent = it.next();
				g.drawLine(Pprev.x,Pprev.y, Pcurrent.x, Pcurrent.y);
				Pprev = Pcurrent;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if((arg0.getModifiers() & InputEvent.BUTTON3_MASK)
			== InputEvent.BUTTON3_MASK){
			
			this.clear();
		}
		
		if((arg0.getModifiers() & InputEvent.BUTTON1_MASK)
				== InputEvent.BUTTON1_MASK){
				this.newCurve();
			
				
			}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
	
		
			
			this.addPoint(arg0.getXOnScreen(),arg0.getYOnScreen()-60);
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		
		
	}
}