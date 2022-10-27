package View;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel{

	Image image;
	
	Board(){
		try {
			image = ImageIO.read(new File("images/Tabuleiros/Tabuleiro-Clue-C.jpg"));
		}catch(IOException e) {
			System.out.println();
		}
		this.setSize(Window.WIDTH,Window.HEIGHT);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(image,0,0,null);
	}
}
