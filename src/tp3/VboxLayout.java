package tp3;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;


public class VboxLayout implements LayoutManager {
	// espace vertical entre chaque compant
	private int vgap;
	// largeur et hauteur minimales du conteneur
	private int minWidth = 0, minHeight = 0;
	// largeur et hauteur preferees du conteneur
	private int preferredWidth = 0, preferredHeight = 0;
	private boolean sizeUnknown = true;

	public VboxLayout() {
		this(2);
	}

	public VboxLayout(int v) {
		vgap = v;
	}

	/* Required by LayoutManager. */
	public void addLayoutComponent(String name, Component comp) {
		// Rien a remplir ici
	}

	/* Required by LayoutManager. */
	public void removeLayoutComponent(Component comp) {
		// Rien a remplir ici
	}

	private void setSizes(Container parent) {
		// nombre de composants du conteneur
		int nComps = parent.getComponentCount();

		Dimension d = null;
		//Reset de preferred/minimum width and height.
		preferredWidth = 0;
		preferredHeight = 0;
		minWidth = 0;
		minHeight = 0;

		for (int i = 0; i < nComps; i++) {
			Component c = parent.getComponent(i);
			if (c.isVisible()) {
				d = c.getPreferredSize();

				if (i > 0) {
					preferredWidth += d.width/2;
					preferredHeight += vgap;
				} else {
					preferredWidth = d.width;
				}
				preferredHeight += d.height;

				minWidth = Math.max(c.getMinimumSize().width,
						minWidth);
				minHeight = preferredHeight;
			}
		}

	}


	/* Required by LayoutManager. */
	public Dimension preferredLayoutSize(Container parent) {
		Dimension dim = new Dimension(0, 0);
		int nComps = parent.getComponentCount();

		setSizes(parent);

		//Always add the container's insets!
		Insets insets = parent.getInsets();
		dim.width = preferredWidth
				+ insets.left + insets.right ;
		dim.height = preferredHeight
				+ insets.top + insets.bottom +(10*nComps);

		sizeUnknown = false;

		return dim;
	}
	/**Question 15 
	 * Windows.pack() utilise les méthodes layoutSize pour donner la taille la plus appropriée à la fenêtre 
	 */

	/* Required by LayoutManager. */
	public Dimension minimumLayoutSize(Container parent) {
		Dimension dim = new Dimension(0, 0);
		int nComps = parent.getComponentCount();

		//Always add the container's insets!
		Insets insets = parent.getInsets();
		dim.width = minWidth +(insets.left + insets.right);
		dim.height = minHeight + (insets.top + insets.bottom)+(10*nComps);

		sizeUnknown = false;

		return dim;
	}

	/* Required by LayoutManager. */
	/*
	 * This is called when the panel is first displayed,
	 * and every time its size changes.
	 * Note: You CAN'T assume preferredLayoutSize or
	 * minimumLayoutSize will be called -- in the case
	 * of applets, at least, they probably won't be.
	 */
	public void layoutContainer(Container parent) {
		Insets insets = parent.getInsets();
		int padding = 10;
		int nComps = parent.getComponentCount();
		int maxWidth = parent.getWidth()
				- (insets.left + insets.right)-(10*nComps);
		int maxHeight = parent.getHeight()
				- (insets.top + insets.bottom)-(10*nComps);
		int previousWidth = 0, previousHeight = 0;
		int x = 0, y = insets.top;
		int xFudge = 0, yFudge = 0;
		boolean oneColumn = false;

		// Go through the components' sizes, if neither
		// preferredLayoutSize nor minimumLayoutSize has
		// been called.
		if (sizeUnknown) {
			setSizes(parent);
		}

		if (maxWidth <= minWidth) {
			oneColumn = true;
		}

		if (maxWidth > preferredWidth) {
			xFudge = (maxWidth - preferredWidth);
		}

		if (maxHeight > preferredHeight) {
			yFudge = (maxHeight - preferredHeight);
		}

		for (int i = 0 ; i < nComps ; i++) {
			Component c = parent.getComponent(i);
			if (c.isVisible()) {
				Dimension d = c.getPreferredSize();
				y+=previousHeight+padding;
				x =((preferredWidth-d.width)/2);
				// Set the component's size and position.
				c.setBounds(x, y, d.width, d.height);

				previousWidth = d.width;
				previousHeight = d.height;
			}
		}
	
	}

	public String toString() {
		String str = "";
		return getClass().getName() + "[vgap=" + vgap + str + "]";
	}
}

