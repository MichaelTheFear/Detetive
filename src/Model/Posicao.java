package Model;

class Posicao{
	
	private Coordenadas[] posicoesProximas = new Coordenadas[4];
	private Coordenadas coordenadas;
	private boolean jogadorAqui;
	private int passouAqui = 0;
	private int mudadoNoTurno = -1;
	
	protected Posicao(int x, int y) {
		coordenadas = new Coordenadas(x,y);
		jogadorAqui = false;
	}
	
	protected int getMudadoNoTurno() {
		return mudadoNoTurno;
	}
	
	protected void setMudadoNoTurno(int t) {
		mudadoNoTurno = t;
	}
	

	protected void setPosicoesProximas(Coordenadas[] posicoesAdjacentes) {
		this.posicoesProximas = posicoesAdjacentes;
	}

	protected Coordenadas[] getPosicoesProximas() {
		return this.posicoesProximas;
	}

	protected boolean getJogadorAqui() {
		return this.jogadorAqui;
	}
	
	protected void setJogadorAqui(boolean b) {
		jogadorAqui = b;
	}

	protected Coordenadas getCoordenadas() {
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
		return coordenadas.equals(other.coordenadas);
	}

	public String toString() {
		return "("+coordenadas.getX()+","+coordenadas.getY()+")";
	}

}
