package Model;

public class Jogo {
	static protected int NUM_MAX_DADO = 6;
	Tabuleiro t;
	Carta[] cartasAssassino;
	Jogador jogadores[] = new Jogador[10];
	int vezDe;
	
	public Jogo() {}
	
	static protected int rolarDado() {
		return 5;
	}
	
	protected void jogo() {
		
	}
	
	public void passaVez() {
		vezDe++;
		if(vezDe==jogadores.length)
			vezDe = 0;
		if(jogadores[vezDe].estaJogando()) {
			passaVez();
		}
	}
	
	public void mover() {
		
	}
	
}
