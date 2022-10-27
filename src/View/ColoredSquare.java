package View;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class ColoredSquare extends JPanel{

	int pieceSize = 24;
	
	public ColoredSquare() {
		
	}
	
	public void paint(Graphics g){
		Graphics2D g2D = (Graphics2D) g;
		g2D.setPaint(Color.BLUE);
		g2D.setStroke(new BasicStroke(5));
		g2D.setColor(Color.BLUE);
		g2D.drawRect(0,0,24,24);
	}
}
