package Model;

import java.util.ArrayList;
import java.util.List;

import Util.Personagem;

class Jogador {
	private List<Carta> cartasVistas = new ArrayList<Carta>();
	private Personagem personagem;
	private boolean podeDarPalpite;
	private boolean errouAcusacao;
	private List<Carta> cartasIniciais = new ArrayList<Carta>();
	private Posicao pos;
	private boolean jogando;
	private boolean npc;

	Jogador(Personagem personagem, boolean ehNpc, Tabuleiro t) {
		this.personagem = personagem;
		switch (this.personagem) {
		case Scarlet:
			this.pos = t.getPosicaoAt(26, 9);
			break;

		case Mustard:
			this.pos = t.getPosicaoAt(19, 2);
			break;

		case White:
			this.pos = t.getPosicaoAt(2, 11);
			break;

		case Green:
			this.pos = t.getPosicaoAt(2, 16);
			break;

		case Peacock:
			this.pos = t.getPosicaoAt(8, 25);
			break;

		case Plum:
			this.pos = t.getPosicaoAt(21, 25);
			break;

		}
		this.jogando = false;
		this.npc = ehNpc;
	}

	boolean ehNpc() {
		return npc;
	}
	
	boolean estaJogando() {
		return jogando;
	}

	void setJogando(boolean jogando) {
		this.jogando = jogando;
	}

	void addCartasVista(Carta c) {
		cartasVistas.add(c);
	}

	List<Carta> getCartasVistas() {
		return cartasVistas;
	}

	void setCartasIniciais(List<Carta> cartasIniciais) {
		this.cartasIniciais = cartasIniciais;
	}

	List<Carta> getCartasIniciais() {
		return cartasIniciais;
	}
	
	void setPos(Posicao pos) {
		this.pos = pos;
	}
	
	Posicao getPos() {
		return pos;
	}

	Personagem getPersonagem() {
		return personagem;
	}

	boolean getPodeDarPalpite() {
		return podeDarPalpite;
	}

	void setPodeDarPalpite(boolean p) {
		podeDarPalpite = p;
	}

	boolean getErrouAcusacao() {
		return errouAcusacao;
	}

	void setErrouAcusacao(boolean p) {
		errouAcusacao = p;
	}

	Carta temCarta(List<Carta> c) {
		for (Carta cOut : c) {
			for (Carta cIn : cartasIniciais) {
				if (cIn.equals(cOut))
					return cIn;
			}
		}
		return null;
	}
	
	

	Carta temCarta(Carta[] c) {
		for (Carta cOut : c) {
			for (Carta cIn : cartasIniciais) {
				if (cIn.equals(cOut))
					return cIn;
			}
		}
		return null;
	}
	
	Carta temCarta(String[] c) {
		for(String cOut: c) {
			for(Carta cIn : cartasIniciais) {
				if(cIn.getNome().equals(cOut))
					return cIn;
			}
		}
		return null;
	}
}
