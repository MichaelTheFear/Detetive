package Model;

import java.util.Arrays;

public abstract class Posicao {
	
	private Posicao[] posicoesProximas = new Posicao[4];
	private int[] coordenadas;
	private boolean jogadorAqui;
	
	protected Posicao(int x, int y) {
		coordenadas = new int[] {x,y};
		jogadorAqui = false;
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

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		Posicao other = (Posicao) obj;
		return Arrays.equals(coordenadas, other.coordenadas);
	}

	

}
