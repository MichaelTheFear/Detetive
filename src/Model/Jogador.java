package Model;

import java.util.ArrayList;
import java.util.List;

import Util.Personagem;

class Jogador {
	private List<Carta> cartasVistas = new ArrayList<Carta>(); //mudar para ArrayList<Carta> se ele deixar usar as data structure
	private Personagem personagem;
	private boolean podeDarPalpite;
	private boolean errouAcusacao;
	private List<Carta> cartasIniciais = new ArrayList<Carta>();
	private Posicao pos;
	private boolean jogando;
	
	protected Jogador(Personagem personagem) {
		this.personagem = personagem;
		switch(this.personagem)
		{
			case Scarlet:
				this.pos = new Posicao(0,0);
				break;
				
			case Mustard:
				this.pos = new Posicao(0,0);
				break;
			
			case White:
				this.pos = new Posicao(0,0);
				break;
				
			case Green:
				this.pos = new Posicao(0,0);
				break;
				
			case Peacock:
				this.pos = new Posicao(0,0);
				break;
				
			case Plum:
				this.pos = new Posicao(0,0);
				break;
				
			
		}
		this.jogando = false;
		this.errouAcusacao = true;
	}
	
	protected Jogador(Personagem personagem,Carta cartasIniciais[]) {
		this.personagem = personagem;
		switch(this.personagem)
		{
			case Scarlet:
				this.pos = new Posicao(0,0);
				break;
				
			case Mustard:
				this.pos = new Posicao(0,0);
				break;
			
			case White:
				this.pos = new Posicao(0,0);
				break;
				
			case Green:
				this.pos = new Posicao(0,0);
				break;
				
			case Peacock:
				this.pos = new Posicao(0,0);
				break;
				
			case Plum:
				this.pos = new Posicao(0,0);
				break;
				
		}
		for(int i = 0; i<cartasIniciais.length;i++) {
			this.cartasIniciais.add(cartasIniciais[i]);
			this.cartasVistas.add(cartasIniciais[i]);
		}
		this.podeDarPalpite = true;
		this.errouAcusacao = false;
		this.jogando = false;
	}
	

	protected boolean estaJogando() {
		return jogando;
	}

	protected void setJogando(boolean jogando) {
		this.jogando = jogando;
	}

	protected void addCartasVista(Carta c) {
		cartasVistas.add(c);
	}

	protected List<Carta> getCartasVistas() {
		return cartasVistas;
	}

	protected List<Carta> getCartasIniciais() {
		return cartasIniciais;
	}

	protected Posicao getPos() {
		return pos;
	}

	protected Personagem getPersonagem() {
		return personagem;
	}
	
	protected boolean getPodeDarPalpite() {
		return podeDarPalpite;
	}
	
	protected void setPodeDarPalpite(boolean p) {
		podeDarPalpite = p;
	}
	
	protected boolean getErrouAcusacao() {
		return errouAcusacao;
	}
	
	protected void setErrouAcusacao(boolean p) {
		errouAcusacao = p;
	}
	
	protected Carta temCarta(Carta c[]) {
		for(Carta cOut : c) {
			for(Carta cIn : cartasIniciais) {
				if(cIn.equals(cOut))
					return cIn;
			}
		}
		return null;
	}
	
}
