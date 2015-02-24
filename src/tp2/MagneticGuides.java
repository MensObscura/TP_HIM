package tp2;

import fr.lri.swingstates.canvas.Canvas;
import fr.lri.swingstates.canvas.CShape;
import fr.lri.swingstates.canvas.CRectangle;
import fr.lri.swingstates.canvas.CExtensionalTag;
import fr.lri.swingstates.canvas.CStateMachine;
import fr.lri.swingstates.canvas.transitions.EnterOnTag;
import fr.lri.swingstates.canvas.transitions.PressOnTag;
import fr.lri.swingstates.canvas.transitions.LeaveOnTag;
import fr.lri.swingstates.sm.transitions.Press;
import fr.lri.swingstates.debug.StateMachineVisualization;
import fr.lri.swingstates.sm.State;
import fr.lri.swingstates.sm.Transition;
import fr.lri.swingstates.sm.transitions.Drag;
import fr.lri.swingstates.canvas.transitions.EventOnTag;
import fr.lri.swingstates.canvas.transitions.MoveOnTag;
import fr.lri.swingstates.sm.transitions.Release;
import fr.lri.swingstates.canvas.transitions.ReleaseOnTag;
import fr.lri.swingstates.canvas.CSegment ;
import fr.lri.swingstates.canvas.transitions.DragOnTag;
import fr.lri.swingstates.sm.transitions.Wheel;
import fr.lri.swingstates.sm.jtransitions.ReleaseOnJTag;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

/**
 * @author Nicolas Roussel (roussel@lri.fr)
 * 
 */
public class MagneticGuides extends JFrame {

	private Canvas canvas;
	private CExtensionalTag oTag;
	private CExtensionalTag sTag;
	private CExtensionalTag hTag;
	private CExtensionalTag vTag;
	private List<CShape> guides;

	public MagneticGuides(String title, int width, int height) {
		super(title);
		canvas = new Canvas(width, height);
		canvas.setAntialiased(true);
		getContentPane().add(canvas);

		oTag = new CExtensionalTag(canvas) {
		};
		sTag = new CExtensionalTag(canvas) {
		};

		vTag = new CExtensionalTag(canvas) {
		};
		hTag = new CExtensionalTag(canvas) {
		};
		
		guides = new ArrayList<CShape>();
		CStateMachine sm = new CStateMachine() {

			private Point2D p;
			private CShape draggedShape;
			private CSegment seg;
			public State start = new State() {
				Transition pressOnObject = new PressOnTag(oTag, BUTTON1,
						">> oDrag") {
					public void action() {
						p = getPoint();
						draggedShape = getShape();
					}
				};
				
				Transition wheel = new Wheel() {
					public void action() {
						System.out.println(canvas.hasTag(sTag));
						canvas.removeShapes(sTag);
					}
				};
				
				Transition pressWheel = new Press(BUTTON2) {
					public void action() {
						sTag = new CExtensionalTag(canvas) {
						};
						for(CShape s:guides){
							
							canvas.addShape(s);
							s.addTag(sTag);
							s.belowAll();
							
						}
					}
				};
				
				
				Transition pressOnSObject = new PressOnTag(sTag, BUTTON1,
							">> sDrag") {
						public void action() {
							p = getPoint();
							draggedShape = getShape();
						}
					};
					
					
				
				Transition enterBox = new EnterOnTag(sTag) {
					public void action() {
						draggedShape = getShape();
							float dash[] = { 5.0f };
							draggedShape.setStroke((Stroke) new BasicStroke(2.5f, BasicStroke.CAP_BUTT,
									BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
					}
				};

				Transition outOfBox = new LeaveOnTag(sTag) {
					public void action() {
						draggedShape = getShape();
							float dash[] = { 5.0f };
							draggedShape.setStroke((Stroke) new BasicStroke(1.5f, BasicStroke.CAP_BUTT,
									BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
					}
				};

				Transition traceLigneHorzontale = new Press (BUTTON1, ">> lignes") {
					public void action() {
						p = getPoint();
					}
				};

				Transition traceLigneVerticale = new Press (BUTTON3, ">> lignes") {
					public void action() {
						p = getPoint();
					}
				};
			};

			public State oDrag = new State() {
				Transition drag = new Drag(BUTTON1) {
					public void action() {

						Point2D q = getPoint();
						draggedShape.translateBy(q.getX() - p.getX(), q.getY()
								- p.getY());
						p = q;
					}
				};
				
				
				
				Transition releaseOnJTag = new ReleaseOnJTag("sTag",BUTTON1, ">> start") {
				
						public void action(){
							CShape guide = (CShape)getShape();
							guide.addChild(draggedShape);
							
						}
				};
				
				Transition release = new Release(BUTTON1, ">> start") {

				};
			};
			
			public State sDrag = new State() {
				Transition dragSeg = new Drag(BUTTON1) {
					public void action() {
						Point2D q = getPoint();
						
						if(draggedShape.getTags().contains(hTag))
							draggedShape.translateBy(0, q.getY() - p.getY());
						
						if(draggedShape.getTags().contains(vTag))
							draggedShape.translateBy(q.getX() - p.getX(), 0);
						p = q;
					}
					
				};
				
				
				Transition release = new Release(BUTTON1, ">> start") {

				};
			};

			public State lignes = new State() {


				Transition releaseHorizontal = new Release(BUTTON1, ">> start") {

					public void action(){

						Point2D debut = this.getPoint();
						debut.setLocation(0, p.getY());
						Point2D fin = this.getPoint();
						fin.setLocation(600, p.getY());
						seg=canvas.newSegment(debut, fin);
						seg.setOutlinePaint(Color.gray);
						seg.addTag(hTag);
						seg.addTag(sTag);
						float dash[] = { 5.0f };
						seg.setStroke((Stroke) new BasicStroke(1.5f, BasicStroke.CAP_BUTT,
								BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
						seg.belowAll();
						guides.add(seg);
					}
				};

				Transition releaseVerticale = new Release(BUTTON3, ">> start") {

					public void action(){
						Point2D debut = this.getPoint();
						debut.setLocation(p.getX(),0);
						Point2D fin = this.getPoint();
						fin.setLocation(p.getX(),600);
						seg=canvas.newSegment(debut, fin);
						seg.setOutlinePaint(Color.gray);
						seg.setPickable(true);
						seg.addTag(vTag);
						seg.addTag(sTag);
						float dash[] = { 5.0f };
						seg.setStroke((Stroke) new BasicStroke(1.5f, BasicStroke.CAP_BUTT,
								BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
						seg.belowAll();
						guides.add(seg);

					}
				};
			};
		};
		sm.attachTo(canvas);

		StateMachineVisualization smv = new StateMachineVisualization(sm);
		JFrame frame = new JFrame();
		frame.getContentPane().add(smv);
		frame.pack();
		frame.setVisible(true);
		pack();
		setVisible(true);
		canvas.requestFocusInWindow();
	}

	public void populate() {
		int width = canvas.getWidth();
		int height = canvas.getHeight();

		double s = (Math.random() / 2.0 + 0.5) * 30.0;
		double x = s + Math.random() * (width - 2 * s);
		double y = s + Math.random() * (height - 2 * s);

		int red = (int) ((0.8 + Math.random() * 0.2) * 255);
		int green = (int) ((0.8 + Math.random() * 0.2) * 255);
		int blue = (int) ((0.8 + Math.random() * 0.2) * 255);

		CRectangle r = canvas.newRectangle(x, y, s, s);
		r.setFillPaint(new Color(red, green, blue));
		r.addTag(oTag);
	}

	public static void main(String[] args) {
		MagneticGuides guides = new MagneticGuides("Magnetic guides", 600, 600);
		for (int i = 0; i < 20; ++i)
			guides.populate();
		guides.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
