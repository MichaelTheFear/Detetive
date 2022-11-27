package View;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Dices extends JpgImage{
	
	int dice1 = 4;
	int dice2 = 6;
	
	Dices(){
		int[] dices = new int[] {1,2,3,4,5,6};
		for(int dice: dices)
			images.add(readFile("Tabuleiros/dado"+dice));
	}
	
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(images.get(dice1-1),900,0,50,50,null);
		g2D.drawImage(images.get(dice2-1),950,0,50,50,null);
	}
	
	void setDices(int d1,int d2) {
		dice1 = d1;
		dice2 = d2;
		paint(this.getGraphics());
	}
	
	
}
