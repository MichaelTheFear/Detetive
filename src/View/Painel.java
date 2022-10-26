package View;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Painel extends JPanel{
	
	Image image;
	
	Painel(){
		try {
			image=ImageIO.read(new File("images/Armas/Cano.jpg"));
		}catch(IOException e) {
			System.out.println("Erro de file");
		}
	}
	
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(image,0,0,null);
	}
}
