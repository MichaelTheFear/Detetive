package Model;


 class Coordenadas {
	private int x, y;
	private boolean passouAqui = false;
	private boolean jogadorAqui = false;

	 Coordenadas(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	protected boolean getJogadorAqui() {
		return this.jogadorAqui;
	}
	
	protected void setJogadorAqui(boolean b) {
		jogadorAqui = b;
	}

	 int getX() {
		return x;
	}

	 void setX(int x) {
		this.x = x;
	}

	 int getY() {
		return y;
	}

	 void setY(int y) {
		this.y = y;
	}

	 boolean getPassouAqui() {
		return passouAqui;
	}

	 void setPassouAqui(boolean passouAqui) {
		this.passouAqui = passouAqui;
	}


	
	 public String toString() {
		return "("+x + "," + y + ") ";
	}

	

	@Override
	public
	 boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Coordenadas other = (Coordenadas) obj;
		return x == other.x && y == other.y;
	}
	
	
	
	
}
