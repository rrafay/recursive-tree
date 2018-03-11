import javax.swing.JComponent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.Random;

/**
 * Recursive Tree Painting class which is responsible for making the tree.
 * 
 * @author Rafay
 *
 */
public class RecursiveTreePainting extends JComponent implements MouseListener {

	// Instance variables
	public static final int NUM_GENERATIONS = 3;
	public static final int NUM_CHILDREN = 3;
	public static final double GOLDEN_RATIO = 1.618;
	public static final double MAX_BRANCHING_initialAngle = 0.5 * Math.PI;
	public static final int BLOSSOM_DIAM = 4;
	public static final int TRUNK_TWINS = 5;

	// Starting and ending point instance variable
	private Point2D startPoint;
	private Point2D endPoint;

	// The paint method
	public void paint(Graphics g) {
		paintBackground(g);
		if (this.endPoint != null) {
			double length = this.endPoint.distance(this.startPoint);
			double initialAngle = Math.atan2(this.endPoint.getY() - this.startPoint.getY(),
					this.endPoint.getX() - this.startPoint.getX());

			// for loop which is calling the paintBranch method
			for (int i = 0; i < 1; i++) {
				paintBranch(g, this.startPoint, length, initialAngle, 9);
			}
		}
	}

	// Paint Background method
	public void paintBackground(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	// paint Branch method : Recursive Method
	public void paintBranch(Graphics g, Point2D p, double length, double initialAngle, int generation) {

		if (generation == 0) {

			drawBlossom(g, p);
		} else {
			Point2D endPoint = computeendPoint(p, length, initialAngle);
			drawTrunk(g, p, endPoint, generation);
			double secondLength = length / GOLDEN_RATIO;

			for (int i = 0; i < 3; i++) {

				double secondinitialAngle = Math.random() * GOLDEN_RATIO;
				if (Math.random() < 0.5) {
					secondinitialAngle = initialAngle + secondinitialAngle;
				} else {
					secondinitialAngle = initialAngle - secondinitialAngle;
				}
				// Calling the PaintBranch method again and decrementing the generation number
				paintBranch(g, endPoint, secondLength, secondinitialAngle, generation - 1);
			}
		}
	}

	// Compute end point method
	public Point2D computeendPoint(Point2D p, double length, double initialAngle) {
		// x is cos
		// y is sin
		return new Point2D.Double(p.getX() + length * Math.cos(initialAngle),
				p.getY() + length * Math.sin(initialAngle));
	}

	// Draw trunk method
	public void drawTrunk(Graphics g, Point2D p, Point2D endPoint, int generation) {

		g.setColor(new Color(100, 61, 61));
		g.drawLine((int) p.getX(), (int) p.getY(), (int) endPoint.getX(), (int) endPoint.getY());
	}

	// Draw Blossom Method
	public void drawBlossom(Graphics g, Point2D p) {
		g.setColor(new Color(247, 159, 70));
		g.fillOval((int) (p.getX()), (int) (p.getY()), 4, 4);
	}

	// Constructor to add mouse listener
	public RecursiveTreePainting() {
		addMouseListener(this);
	}

	// Method which has initial positions of the trunk
	public void initialposTrunk(int x, int y) {
		this.startPoint = new Point2D.Double(x, y);
	}

	// Method which has the ending position of the trunk
	public void endingTrunk(int x, int y) {
		this.endPoint = new Point2D.Double(x, y);
		repaint();
	}

	// Mouse Pressed method
	public void mousePressed(MouseEvent e) {
		initialposTrunk(e.getX(), e.getY());
	}

	// Mouse released Method
	public void mouseReleased(MouseEvent e) {
		endingTrunk(e.getX(), e.getY());
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}
}