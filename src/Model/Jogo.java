package Model;

import java.util.Random;

class Jogo {
	static protected int NUM_MAX_DADO = 6;
	static protected int NUM_MAX_JOGADOR = 6;
	Tabuleiro t;
	Carta[] cartasAssassino = new Carta[3];
	Jogador jogadores[] = new Jogador[NUM_MAX_JOGADOR];
	int vezDe = 0;
	int numTurno = 0;
	int dados[] = new int[2];
	Random gerador = new Random();
	
	public Jogo() {
		vezDe = proxTurno(jogadores.length);
	}
	
	public void setCartasAssasino(Carta [] cartas) {
		for(int index = 0; index<cartas.length;index++) {
			cartasAssassino[index] = cartas[index];
		}
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
		if(!jogadores[turno].estaJogando()) {
			proxTurno(turno);
		}
		return turno;
	}
	
	public void passaVez() {
		vezDe = proxTurno(vezDe);
		t.houseKeepingTabuleiro();
	}
	
	public void mover(Coordenadas escolhida) throws ExceptionLugarNaoPermitido{
		for(Coordenadas pos :jogadores[vezDe].getPos().getPosicoesProximas())
		{
			if(pos.equals(escolhida))
			{
				if(pos.getPassouAqui())
				{
					throw new ExceptionLugarNaoPermitido("Já passou aqui");
				}
				jogadores[vezDe].getPos().getCoordenadas().setPassouAqui(true);
				jogadores[vezDe].getPos().getCoordenadas().setJogadorAqui(false);
				pos.setJogadorAqui(true);
				return;
			}
		}
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
