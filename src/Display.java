import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display extends JFrame {
	
	private Canvas canvas;
	
	private static final int Height = 840;
	private static final int Weight = 840;
	private String Title = "Alien War";
	
	Display(){
		this.setSize(Weight,Height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle(Title);
		this.setLocationRelativeTo(null);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(Weight,Height));
		canvas.setMaximumSize(new Dimension(Weight,Height));
		canvas.setMinimumSize(new Dimension(Weight,Height));
		
		this.add(canvas);
		this.pack();
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public int getHeight() {
		return Height;
	}

	public int getWeight() {
		return Weight;
	}
}
