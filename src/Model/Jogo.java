package Model;

import java.util.ArrayList;
import java.util.Random;

import Util.*;

class Jogo {
	static int NUM_MAX_DADO = 6;
	
	Tabuleiro t;
	Carta[] todasCartas = new Carta[] { 
			new CartaArma(Armas.Cano.toString()),
			new CartaArma(Armas.Castical.toString()),
			new CartaArma(Armas.ChaveInglesa.toString()),
			new CartaArma(Armas.Corda.toString()),
			new CartaArma(Armas.Faca.toString()),
			new CartaArma(Armas.Revolver.toString()),
			new CartaLocal(Comodos.Biblioteca.toString()),
			new CartaLocal(Comodos.Cozinha.toString()),
			new CartaLocal(Comodos.Entrada.toString()),
			new CartaLocal(Comodos.Escritorio.toString()),
			new CartaLocal(Comodos.JardimInverno.toString()),
			new CartaLocal(Comodos.SalaDeEstar.toString()),
			new CartaLocal(Comodos.SalaDeJantar.toString()),
			new CartaLocal(Comodos.SalaDeMusica.toString()),
			new CartaLocal(Comodos.SalaoDeJogos.toString()),
			new CartaSuspeito(Personagem.Green.toString()),
			new CartaSuspeito(Personagem.Mustard.toString()),
			new CartaSuspeito(Personagem.Peacock.toString()),
			new CartaSuspeito(Personagem.Plum.toString()),
			new CartaSuspeito(Personagem.Scarlet.toString()),
			new CartaSuspeito(Personagem.White.toString())
			};
	Carta[] cartasAssassino = new Carta[3];
	ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	int vezDe = 0;
	int numTurno = 0;
	int dados[] = new int[2];
	Random gerador = new Random();

	Jogo() {

	}

	void setupJogadores(ArrayList<String> players) {
		ArrayList<Carta> cartasIniciaisMock = new ArrayList<Carta>();
		cartasIniciaisMock.add(new CartaArma("Candelabro"));
		cartasIniciaisMock.add(new CartaLocal("Biblioteca"));
		cartasIniciaisMock.add(new CartaSuspeito("Mostarda"));

		for (String p : players) {
			jogadores.add(new Jogador(Personagem.valueOf(p), cartasIniciaisMock));
		}
	}

	void setCartasAssasino(Carta[] cartas) {
		cartasAssassino[0] = todasCartas[gerador.nextInt(6)]; 		// De 0 a 5 estão as Cartas de Arma
		cartasAssassino[1] = todasCartas[gerador.nextInt(9) + 6];	// Gera-se nums de 0 a 8 e incrementa 6 para ser de 6 a 14 onde estão as Cartas de Local
		cartasAssassino[2] = todasCartas[gerador.nextInt(6) + 15];	// Gera-se nums de 0 a 5 e incrementa 15 para ser de 15 a 20 onde estão as Cartas de Suspeito
	}
	
	void distribuiCartas() {
		int numCartasPessoa = (todasCartas.length - 3) / jogadores.size(); //Qtd de cartas que cada um tem = todas as cartas menos do assassino / qtd de jogadores em jogo
	}

	void rolarDado() {
		dados[0] = gerador.nextInt(6) + 1; // Gera-se nums de 0 a 5 e incrementa 1 para ser de 1 a 6
		dados[1] = gerador.nextInt(6) + 1;
	}

	int[] getDados() {
		return dados;
	}

	void setDados(int[] dados) {
		this.dados = dados;
	}

	int proxTurno(int turno) {
		turno++;
		if (turno == jogadores.size())
			turno = 0;
		if (!jogadores.get(turno).estaJogando()) {
			proxTurno(turno);
		}
		return turno;
	}

	void passaVez() {
		vezDe = proxTurno(vezDe);
		t.houseKeepingTabuleiro();
	}

	void mover(Coordenadas escolhida) throws ExceptionLugarNaoPermitido {
		for (Coordenadas pos : jogadores.get(vezDe).getPos().getPosicoesProximas()) {
			if (pos.equals(escolhida)) {
				if (pos.getPassouAqui()) {
					throw new ExceptionLugarNaoPermitido("Já passou aqui");
				}
				jogadores.get(vezDe).getPos().getCoordenadas().setPassouAqui(true);
				jogadores.get(vezDe).getPos().getCoordenadas().setJogadorAqui(false);
				pos.setJogadorAqui(true);
				return;
			}
		}
	}

	boolean acusar(Carta acusacao[]) {
		// talvez mudar td para treeSet
		for (int i = 0; i < 3; i++) {
			if (!acusacao[0].equals(cartasAssassino[i]) && !acusacao[1].equals(cartasAssassino[i])
					&& !acusacao[2].equals(cartasAssassino[i])) {
				return false;
			}

		}
		return true;

	}

	String darPalpite(Carta palpites[]) {
		int proxJogador = proxTurno(vezDe);
		while (proxJogador != vezDe) {
			Carta c = jogadores.get(proxJogador).temCarta(palpites);
			if (c != null) {
				jogadores.get(vezDe).addCartasVista(c);
				return c.getNome();
			}
		}
		return "nenhum";
	}
}
