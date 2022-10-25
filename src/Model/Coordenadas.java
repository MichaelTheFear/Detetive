package Model;


public class Coordenadas {
	private int x, y;
	private boolean passouAqui = false;
	private boolean jogadorAqui = false;

	public Coordenadas(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	protected boolean getJogadorAqui() {
		return this.jogadorAqui;
	}
	
	protected void setJogadorAqui(boolean b) {
		jogadorAqui = b;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean getPassouAqui() {
		return passouAqui;
	}

	public void setPassouAqui(boolean passouAqui) {
		this.passouAqui = passouAqui;
	}


	
	public String toString() {
		return "("+x + "," + y + ") ";
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Coordenadas other = (Coordenadas) obj;
		return x == other.x && y == other.y;
	}
	
	
	
	
}
