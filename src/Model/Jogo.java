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
			new CartaSuspeito(Personagem.White.toString()) };
	Carta[] cartasAssassino = new Carta[3];
	ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	int qtdEmJogo = 0;
	int vezDe = 0;
	int numTurno = 0;
	int dados[] = new int[2];
	Random gerador = new Random();

	Jogo() {

	}

	void setupJogadores(ArrayList<Personagem> players) {

		for (Personagem susPersonagem : Personagem.values()) {
			for (Personagem p : players) {
				if (susPersonagem == p) {
					jogadores.add(new Jogador(p, false));
					qtdEmJogo++;
					break;
				}
			}
			if (jogadores.isEmpty()) {
				jogadores.add(new Jogador(susPersonagem, true));
			}
			else if (jogadores.get(jogadores.size() - 1).getPersonagem() != susPersonagem) {
				jogadores.add(new Jogador(susPersonagem, true));
			}
		}
	}

	void setCartasAssasino(Carta[] cartas) {
		cartasAssassino[0] = todasCartas[gerador.nextInt(6)]; // De 0 a 5 estão as Cartas de Arma
		cartasAssassino[1] = todasCartas[gerador.nextInt(9) + 6]; // Gera-se nums de 0 a 8 e incrementa 6 para ser de 6 a 14 onde estão as Cartas de Local
		cartasAssassino[2] = todasCartas[gerador.nextInt(6) + 15]; // Gera-se nums de 0 a 5 e incrementa 15 para ser de 15 a 20 onde estão as Cartas de Suspeito
	}

	private ArrayList<Carta> getCartasEmJogo() {
		ArrayList<Carta> cartasEmJogo = new ArrayList<Carta>();
		for (int i = 0; i < todasCartas.length; i++) {
			if (i < 6) {
				if (todasCartas[i].getNome().compareTo(cartasAssassino[0].getNome()) == 0) {
					continue;
				}
			}
			else if (i < 15) {
				if (todasCartas[i].getNome().compareTo(cartasAssassino[1].getNome()) == 0) {
					continue;
				}
			}
			else {
				if (todasCartas[i].getNome().compareTo(cartasAssassino[3].getNome()) == 0) {
					continue;
				}
			}
			cartasEmJogo.add(todasCartas[i]);
		}
		return cartasEmJogo;
	}

	void distribuiCartas() {
		ArrayList<Carta> cartasDistribuir = getCartasEmJogo();
		int numCartasPessoa = cartasDistribuir.size() / qtdEmJogo; // Qtd de cartas que cada um tem = todas as cartas menos do assassino / qtd de jogadores em jogo
		int cont = 0;

		for (int i = 1; i < jogadores.size(); i++) {
			if (jogadores.get(i).ehNpc()) {
				continue;
			}

			ArrayList<Carta> cartasIniciais = new ArrayList<Carta>();
			for (int j = 0; j < numCartasPessoa; j++) {
				Carta carta = cartasDistribuir.get(gerador.nextInt(cartasDistribuir.size()));
				cartasIniciais.add(carta);
				cartasDistribuir.remove(carta);
			}
			jogadores.get(i).setCartasIniciais(cartasIniciais);
		}

		while (!cartasDistribuir.isEmpty()) { // Caso sobrem cartas
			if (cont == jogadores.size()) {
				cont = 0;
			}

			if (!jogadores.get(cont).ehNpc()) { // Se não for NPC
				jogadores.get(cont).getCartasIniciais().add(cartasDistribuir.get(0)); // Adiciona uma carta que sobrou as Cartas Iniciais
				cartasDistribuir.remove(0);
			}
			cont++;
		}
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

	private int proxTurno(int turno) {
		turno++;
		if (turno == jogadores.size())
			turno = 0;
		if (jogadores.get(turno).ehNpc()) {
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
			proxJogador = proxTurno(proxJogador);
		}
		return "nenhum";
	}
}
