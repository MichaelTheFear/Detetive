package View;

public class Main {

	public static void main(String[] args) {
		Window window = new Window();
		Window.addGameStartListner(e -> {
			Window.Canvas.showPanel("Board");
			System.out.println("Passing Phase");
		});
	}

}
