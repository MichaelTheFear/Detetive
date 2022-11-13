package Model;

class Posicao {

	private Posicao[] posicoesProximas = new Posicao[53];
	private int linha, coluna;
	private boolean passouAqui = false;
	private boolean jogadorAqui = false;
	private int mudadoNoTurno = -1;

	Posicao(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

	int getMudadoNoTurno() {
		return mudadoNoTurno;
	}

	void setMudadoNoTurno(int t) {
		mudadoNoTurno = t;
	}

	void setPosicoesProximas(Posicao[] posicoesAdjacentes) {
		this.posicoesProximas = posicoesAdjacentes;
	}

	Posicao[] getPosicoesProximas() {
		return this.posicoesProximas;
	}

	int getLinha() {
		return this.linha;
	}
	
	int getColuna() {
		return this.coluna;
	}

	boolean getPassouAqui() {
		return passouAqui;
	}

	void setPassouAqui(boolean passouAqui) {
		this.passouAqui = passouAqui;
	}
	
	boolean getJogadorAqui() {
		return this.jogadorAqui;
	}
	
	void setJogadorAqui(boolean jogadorAqui) {
		this.jogadorAqui = jogadorAqui;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		Posicao other = (Posicao) obj;
		return (linha == other.getLinha() && coluna == other.getColuna());
	}

	public String toString() {
		return "(" + coluna + "," + linha + ")";
	}

}
