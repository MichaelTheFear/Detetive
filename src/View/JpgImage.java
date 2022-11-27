package View;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JpgImage extends JPanel{
	
	List<Image> images= new ArrayList<Image>();
	
	void pushImagesFromFs(String where, List<String> names) {
		for(String file: names) {
			images.add(readFile(where+"/"+file));
		}
	}
	
	Image readFile(String path) {
		Image res;
		try {
			res = ImageIO.read(new File("images/" + path + ".jpg"));
			System.out.println("File Ok!");
		}catch(IOException e) {
			res = null;
			System.out.println("Não foi possivel achar o arquivo "+path);
		}
		return res;
	}
	
	
}
