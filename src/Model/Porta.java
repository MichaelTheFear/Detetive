package Model;

import java.util.Objects;

class Porta extends Posicao {
	
	private String porta;

	public Porta(int i, int j, String string) {
		super(i,j);
		this.porta = string;
	}

	public Porta(int i, int j) {
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
		if (!(obj instanceof Porta)) {
			return false;
		}
		Porta other = (Porta) obj;
		return Objects.equals(porta, other.porta);
	}

	
}
