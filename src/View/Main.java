package View;

public class Main {

	public static void main(String[] args) {
		new Window();
		Window.Canvas.addGameStartListner(e -> {
			Window.Canvas.showPanel("Board");
			System.out.println("Passing Phase");
		});
	}

	
	
}
