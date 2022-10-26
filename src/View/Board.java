package View;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel{

	Image image;
	
	Board(){
		try {
			image = ImageIO.read(new File("images/Tabuleiro"));
		}catch(IOException e) {
			System.out.println();
		}
	}
}
