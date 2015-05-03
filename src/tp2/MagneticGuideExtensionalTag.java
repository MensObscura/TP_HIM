
package tp2;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;

import fr.lri.swingstates.canvas.CExtensionalTag;
import fr.lri.swingstates.canvas.CSegment;
import fr.lri.swingstates.canvas.Canvas;
public class MagneticGuideExtensionalTag extends CExtensionalTag {
	private CSegment segment;
	
	
	
	public MagneticGuideExtensionalTag(Canvas c, CSegment segment) {
		super(c);
		this.segment = segment;
		this.segment.addTag(this);
		this.segment.setOutlinePaint(Color.gray);
		this.segment.setPickable(true);
		float dash[] = { 5.0f };
		this.segment.setStroke((Stroke) new BasicStroke(1.5f, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
		this.segment.belowAll();
	}

	
	public void setSegment(CSegment segment){
		segment.setOutlinePaint(Color.gray);
		segment.setPickable(true);
		float dash[] = { 5.0f };
		segment.setStroke((Stroke) new BasicStroke(1.5f, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
		segment.belowAll();
		this.segment = segment;
	}
	
	public CSegment getSegment() {
		return this.segment;
	}
	

}
