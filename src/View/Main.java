package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

	public static void main(String[] args) {
		new Window();
		Window.Canvas.addGameStartListner(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Window.Canvas.showPanel("Board"); // exemplo de como sera usado pelo controller
			}
			
		});
	}

	
	
}
