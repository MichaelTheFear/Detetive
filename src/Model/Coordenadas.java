package Model;

import java.util.Objects;

public class Coordenadas {
	private int x, y;
	private int passouAqui = 1;
	private int mudadoNoTurno = -1;

	public Coordenadas(int x, int y) {
		this.x = x;
		this.y = y;
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

	public int getPassouAqui() {
		return passouAqui;
	}

	public void setPassouAqui(int passouAqui) {
		this.passouAqui = passouAqui;
	}

	public int getMudadoNoTurno() {
		return mudadoNoTurno;
	}

	public void setMudadoNoTurno(int mudadoNoTurno) {
		this.mudadoNoTurno = mudadoNoTurno;
	}

	public void addUmPassouAqui() {
		passouAqui++;
		
	}
	
	public String toString() {
		return "("+x + "," + y + ") - " +passouAqui;
	}

	@Override
	public int hashCode() {
		return Objects.hash(mudadoNoTurno, passouAqui, x, y);
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
