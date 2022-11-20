package View;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

class Cards extends JpgImage {


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
