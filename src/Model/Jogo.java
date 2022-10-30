package Model;


class Jogo {
	static protected int NUM_MAX_DADO = 6;
	static protected int NUM_MAX_JOGADOR = 6;
	Tabuleiro t;
	Carta[] cartasAssassino = new Carta[3];
	Jogador jogadores[] = new Jogador[NUM_MAX_JOGADOR];
	int vezDe = 0;
	int numTurno = 0;
	int dados[] = new int[2];
	
	public Jogo() {
		vezDe = proxTurno(jogadores.length);
	}
	
	public void setCartasAssasino(Carta [] cartas) {
		for(int index = 0; index<cartas.length;index++) {
			cartasAssassino[index] = cartas[index];
		}
	}
	
	protected void rolarDado() {
		dados[0] = 5;
		dados[1] = 5;
	}
	
	protected int[] getDados() {
		return dados;
	}
	
	protected void setDados(int[] dados) {
		this.dados = dados;
	}
	
	
	public int proxTurno(int turno) {
		turno++;
		if(turno==jogadores.length)
			turno = 0;
		if(!jogadores[turno].estaJogando()) {
			proxTurno(turno);
		}
		return turno;
	}
	
	public void passaVez() {
		vezDe = proxTurno(vezDe);
	}
	
	public void mover(int posicao[][],int idPlayer) {
		
	}

	
	public boolean acusar(Carta c[]) {
		 //talez mudar td para treeSet
		return false;
	}
	
	public String darPalpite(Carta palpites[]) {
		int proxJogador = proxTurno(vezDe);	
		while(proxJogador!=vezDe) {
			Carta c = jogadores[proxJogador].temCarta(palpites);
			if(c!=null) {
				jogadores[vezDe].addCartasVista(c);
				return c.getNome();
			}
		}
		return "nenhum";
	}
}
