package View;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

class Cards extends JPanel {

	List<Image> images= new ArrayList<Image>();

	Cards(String type, List<String> names) {
		pushImagesFromFs(type,names);
	}

	Cards(String type, String name) {
		images.add(readFile(type+"/"+name));
	}

	Cards(List<String> armas, List<String> comodos, List<String> sus) {
		pushImagesFromFs("Armas",armas);
		pushImagesFromFs("Comodos",comodos);
		pushImagesFromFs("Suspeitos",sus);
	}
	
	void pushImagesFromFs(String where, List<String> names) {
		for(String file: names) {
			images.add(readFile(where+"/"+file));
		}
	}
	
	Image readFile(String path) {
		Image res;
		try {
			res = ImageIO.read(new File("images/" + path + ".jpg"));
		}catch(IOException e) {
			res = null;
			System.out.println("Não foi possivel achar o arquivo "+path);
		}
		return res;
	}

	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		int i = 0;
		int j = 0;
		for (Image image : images) {
			g2D.drawImage(image, i, j,171,271, null); // desenha as cartas da pagina de selecao de personagem como requerido
			i += 200;
			if (i > 1000) {
				i = 0;
				j += 200;
			}
		}
	}
}
