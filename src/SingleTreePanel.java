import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Single Tree panel class which makes the J panel etc
 * 
 * @author Rafay
 *
 */
public class SingleTreePanel extends JPanel {
	public SingleTreePanel() {
		super(new BorderLayout());
		initGUI();
	}

	//GUI
	public void initGUI() {
		add(new JLabel("Click and drag"), "North");
		add(new RecursiveTreePainting());
	}
}
