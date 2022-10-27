package View;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class ColoredSquare extends JPanel{

	int pieceSize = 24;
	
	public ColoredSquare() {
		
	}
	
	public void paint(Graphics g){
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawRect(0,0,24,24);
		g2D.
	}
}
