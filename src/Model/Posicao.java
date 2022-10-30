package Model;

class Posicao{
	
	private Coordenadas[] posicoesProximas = new Coordenadas[4];
	private Coordenadas coordenadas;
	private int passouAqui = 0;
	private int mudadoNoTurno = -1;
	
	  Posicao(int x, int y) {
		coordenadas = new Coordenadas(x,y);
	}
	
	  int getMudadoNoTurno() {
		return mudadoNoTurno;
	}
	
	  void setMudadoNoTurno(int t) {
		mudadoNoTurno = t;
	}
	

	  void setPosicoesProximas(Coordenadas[] posicoesAdjacentes) {
		this.posicoesProximas = posicoesAdjacentes;
	}

	  Coordenadas[] getPosicoesProximas() {
		return this.posicoesProximas;
	}


	  Coordenadas getCoordenadas() {
		return this.coordenadas;
	}
	
	  int getPassouAqui() {
		return passouAqui;
	}
	
	  void setPassouAqui(int p) {
		passouAqui = p;
	}
	
	  void addUmPassouAqui() {
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
