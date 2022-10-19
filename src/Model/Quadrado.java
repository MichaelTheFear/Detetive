package Model;

import java.util.Objects;

class Quadrado extends Posicao {
	
	private String porta;

	public Quadrado(int i, int j, String string) {
		super(i,j);
		this.porta = string;
	}

	public Quadrado(int i, int j) {
		super(i,j);
		this.porta="nenhum";
	}
	
	public String getPorta() {
		return porta;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Quadrado)) {
			return false;
		}
		Quadrado other = (Quadrado) obj;
		return Objects.equals(porta, other.porta);
	}

	
}
