package Model;

import java.util.Random;

class Jogo {
	static protected int NUM_MAX_DADO = 6;
	Tabuleiro t;
	Carta[] cartasAssassino = new Carta[3];
	Jogador jogadores[] = new Jogador[10];
	int vezDe = 0;
	int numTurno = 0;
	int dados[] = new int[2];
	Random gerador = new Random();
	
	public Jogo() {
		vezDe = proxTurno(jogadores.length);
	}
	
	protected void rolarDado() {
		dados[0] = gerador.nextInt(6) + 1; //Gera-se nums de 0 a 5 e incrementa 1 para ser de 1 a 6
		dados[1] = gerador.nextInt(6) + 1;
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
		if(jogadores[turno].estaJogando()) {
			proxTurno(turno);
		}
		return turno;
	}
	
	public void passaVez() {
		vezDe = proxTurno(vezDe);
	}
	
	public void mover() {
		
	}

	
	
	
	public int acusar(Carta c[]) {
		 //talez mudar td para treeSet
		return -1;
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
