package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Util.FunctionClass;

public class Main {

	public static void main(String[] args) {
		Canvas.init();
		Canvas.addGameStartListner(new FunctionClass() {
			public void callback() {
				
			}
		});
	}

	
	
}
