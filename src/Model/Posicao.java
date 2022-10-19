package Model;

import java.util.Arrays;

public abstract class Posicao{
	
	private Posicao[] posicoesProximas = new Posicao[4];
	private int[] coordenadas;
	private boolean jogadorAqui;
	private int passouAqui = 0;
	private int mudadoNoTurno = -1;
	
	protected Posicao(int x, int y) {
		coordenadas = new int[] {x,y};
		jogadorAqui = false;
	}
	
	protected int getMudadoNoTurno() {
		return mudadoNoTurno;
	}
	
	protected void setMudadoNoTurno(int t) {
		mudadoNoTurno = t;
	}
	

	protected void setPosicoesProximas(Posicao[] posicoesAdjacentes) {
		this.posicoesProximas = posicoesAdjacentes;
	}

	protected Posicao[] getPosicoesProximas() {
		return this.posicoesProximas;
	}

	protected boolean getJogadorAqui() {
		return this.jogadorAqui;
	}
	
	protected void setJogadorAqui(boolean b) {
		jogadorAqui = b;
	}

	protected int[] getCoordenadas() {
		return this.coordenadas;
	}
	
	protected int getPassouAqui() {
		return passouAqui;
	}
	
	protected void setPassouAqui(int p) {
		passouAqui = p;
	}
	
	protected void addUmPassouAqui() {
		passouAqui++;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		Posicao other = (Posicao) obj;
		return Arrays.equals(coordenadas, other.coordenadas);
	}

	

}
