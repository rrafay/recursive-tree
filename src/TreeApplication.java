
import javax.swing.JFrame;

/**
 * Tree Application class which contains the main mathod and calls methods from
 * other classes
 * 
 * @author Rafay
 *
 */
public class TreeApplication {
	public static void main(String[] args) {
		JFrame treeFrame = new JFrame("Tree Painting");

		treeFrame.setSize(600, 500);

		treeFrame.add(new SingleTreePanel());

		treeFrame.setDefaultCloseOperation(3);

		treeFrame.setVisible(true);

		

	}
}