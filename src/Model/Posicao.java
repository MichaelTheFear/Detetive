package Model;

import java.util.ArrayList;

class Posicao {

	private ArrayList<Posicao> posicoesProximas = new ArrayList<Posicao>();
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

	void setPosicoesProximas(ArrayList<Posicao> posicoesAdjacentes) {
		this.posicoesProximas = posicoesAdjacentes;
	}
	
	void addPosicoesProximas(ArrayList<Posicao> posicoesAdjacentes) {
		this.posicoesProximas.addAll(posicoesAdjacentes);
	}
	
	void addComodosProximos(ArrayList<Comodo> posicoesAdjacentes) {
		for(Posicao pos : posicoesAdjacentes) {
			this.posicoesProximas.add(pos);
		}
	}

	ArrayList<Posicao> getPosicoesProximas() {
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
