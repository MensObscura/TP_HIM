package tp1 ;

import fr.lri.swingstates.canvas.CExtensionalTag;
import fr.lri.swingstates.canvas.CRectangle;
import fr.lri.swingstates.canvas.CStateMachine;
import fr.lri.swingstates.canvas.CTag;
import fr.lri.swingstates.canvas.Canvas ;
import fr.lri.swingstates.canvas.CShape ;
import fr.lri.swingstates.canvas.CText ;
import fr.lri.swingstates.canvas.transitions.ClickOnShape;
import fr.lri.swingstates.canvas.transitions.EnterOnShape;
import fr.lri.swingstates.canvas.transitions.LeaveOnShape;
import fr.lri.swingstates.canvas.transitions.PressOnShape;
import fr.lri.swingstates.canvas.transitions.ReleaseOnShape;
import fr.lri.swingstates.debug.StateMachineVisualization;
import fr.lri.swingstates.sm.State;
import fr.lri.swingstates.sm.Transition;
import fr.lri.swingstates.sm.transitions.Click;
import fr.lri.swingstates.sm.transitions.Press;
import fr.lri.swingstates.sm.transitions.Release;

import javax.swing.JFrame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font ;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;

/**
 * @author Nicolas Roussel (roussel@lri.fr)
 *
 */
public class SimpleButton {

	private CText label ;
	private CRectangle rectangle;
	private Canvas canvas;
	private CExtensionalTag selected;
	SimpleButton(Canvas can, String text) {
		this.canvas=can;
		this.label = canvas.newText(2, 2, text, new Font("verdana", Font.PLAIN, 12)) ;
		this.rectangle = canvas.newRectangle(0,0,label.getWidth()+4,label.getHeight()+4);

		this.rectangle.addChild(label);
		this.rectangle.below(label);
		this.rectangle.setFillPaint(Color.white);

		this.selected = new CExtensionalTag(canvas) { };

		
		
		CStateMachine sm = new CStateMachine() {
			boolean in = false;
			boolean pressed = false;
			public State start = new State() {
				Paint initColor = Color.white;
				Transition releaseOnShape = new ReleaseOnShape(BUTTON1) {
					public void action() {
						pressed = false;
						rectangle.setFillPaint(initColor);
						label.setFillPaint(Color.black);
					}
				};
				
				Transition releaseNotOnShape = new Release(BUTTON1) {
					public void action() {
						pressed = false;
						rectangle.setFillPaint(initColor);
				
						label.setFillPaint(Color.red);
					}
				};
				Transition clicRightOnShape = new ClickOnShape(BUTTON3) {
					public void action() {
								//do what you want
					}
				};
				Transition pressOnShape = new PressOnShape(BUTTON1) {
					public void action() {
						pressed= true;
						rectangle.setFillPaint(Color.yellow);
					}
				};

				Transition enterBox = new EnterOnShape(">> in") {
					public void action() {
						in = true;
						rectangle.setStroke((Stroke) (new BasicStroke(2)));
						if(pressed){
							rectangle.setFillPaint(Color.yellow);
						}
					}
				};
			
				Transition leaveBox = new LeaveOnShape(">> out") {
					public void action() {
						in = false;
						rectangle.setStroke((Stroke) (new BasicStroke(1)));
						if(pressed){
							rectangle.setFillPaint(initColor);
						}
					}
				};

			};
		};
		sm.attachTo(canvas);
		sm.armTimer(100,false);
		StateMachineVisualization smv = new StateMachineVisualization(sm);
		JFrame frame = new JFrame() ;
		frame.getContentPane().add(smv);
		frame.pack() ;
		frame.setVisible(true) ;

	}

	public void action() {
		System.out.println("ACTION!") ;
	}

	public CShape getShape() {
		return rectangle ;
	}

	static public void main(String[] args) {
		JFrame frame = new JFrame() ;
		Canvas canvas = new Canvas(400,400) ;
		frame.getContentPane().add(canvas) ;
		frame.pack() ;
		frame.setVisible(true) ;

		SimpleButton simple = new SimpleButton(canvas, "simple") ;

		simple.getShape().translateBy(100,100) ;
	}

}
