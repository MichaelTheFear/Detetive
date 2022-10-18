package Model;

import java.util.TreeSet;

public class Jogo {
	static protected int NUM_MAX_DADO = 6;
	Tabuleiro t;
	Carta[] cartasAssassino = new Carta[3];
	Jogador jogadores[] = new Jogador[10];
	int vezDe;
	
	public Jogo() {}
	
	static protected int rolarDado() {
		return 5;
	}
	
	protected void jogo() {
		
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
		TreeSet<Carta> t = new TreeSet<Carta>();
		
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
