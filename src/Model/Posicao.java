package Model;

class Posicao{
	
	private Coordenadas[] posicoesProximas = new Coordenadas[4];
	private Coordenadas coordenadas;
	private int passouAqui = 0;
	private int mudadoNoTurno = -1;
	
	protected Posicao(int x, int y) {
		coordenadas = new Coordenadas(x,y);
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
