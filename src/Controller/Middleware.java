package Controller;
import java.util.ArrayList;

import Util.*;
import View.Canvas;

public class Middleware {
	
	Middleware(){
		Canvas.init();
		ArrayList<Personagem> personagens = Canvas.onGameStart(new FunctionClass() {
			public void callbackVoid() {
				
			}
		});
	}
	
	
}
