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
	
	Cards(String armas[],String comodos[],String sus[]){
		images = new Image[armas.length+comodos.length+sus.length];
		String name;
		int j = 0;
			for(int i = 0;i<comodos.length;i++) {
				name = comodos[i];
				try {
					images[i]=ImageIO.read(new File("images/Comodos/"+name+".jpg")); //le arquivo (em O(1))
				}catch(IOException e) {
					System.out.println(name); 
				}
				j++;
			}
			
			for(int i = 0;i<armas.length;i++) {
				name = armas[i];
				try {
					images[j]=ImageIO.read(new File("images/Armas/"+name+".jpg")); //le arquivo (em O(1))
				}catch(IOException e) {
					System.out.println(name); 
				}
				j++;
			}
			
			for(int i = 0;i<sus.length;i++) {
				name = sus[i];
				try {
					images[j]=ImageIO.read(new File("images/Suspeitos/"+name+".jpg")); //le arquivo (em O(1))
				}catch(IOException e) {
					System.out.println(name); 
				}
				j++;
			}
		
	}
	
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		int i = 0;
		int j = 0;
		for(Image image:images) {
			g2D.drawImage(image,i,j,null); //desenha as cartas da pagina de selecao de personagem como requerido
			i+=200;
			if(i>1000) {
				i=0;
				j+=200;
			}
		}
	}
}
