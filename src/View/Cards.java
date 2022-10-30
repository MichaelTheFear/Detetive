package View;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Cards extends JPanel{
	
	Image images[];
	
	
	Cards(String type,String names[]){
		images = new Image[names.length];
		String name;
		for(int i = 0;i<names.length;i++) {
			name = names[i];
			try {
				images[i]=ImageIO.read(new File("images/"+type+"/"+name+".jpg")); //le arquivo (em O(1))
			}catch(IOException e) {
				System.out.println("Erro de file"); 
			}
		}
	}
	
	Cards(String type,String name){
		try {
			images[0]=ImageIO.read(new File("images/"+type+"/"+name+".jpg"));
		}catch(IOException e) {
			System.out.println("Erro de file");
		}
	}
	
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		int i = 0;
		for(Image image:images) {
			g2D.drawImage(image,i,0,null); //desenha as cartas da pagina de selecao de personagem
			i+=200;
			if(i>1000) {
				i=0;
			}
		}
	}
}
