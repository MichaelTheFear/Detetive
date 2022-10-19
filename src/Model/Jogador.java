package Model;

import java.util.ArrayList;
import java.util.List;

class Jogador {
	private List<Carta> cartasVistas = new ArrayList<Carta>(); //mudar para ArrayList<Carta> se ele deixar usar as data structure
	private String personagem;
	private boolean podeDarPalpite;
	private boolean errouAcusacao;
	private List<Carta> cartasIniciais = new ArrayList<Carta>();
	private Posicao pos;
	private boolean jogando;
	
	protected Jogador(String personagem,Carta cartasIniciais[],Posicao posInicial) {
		this.personagem = personagem;
		this.pos = posInicial;
		this.pos.setJogadorAqui(true);
		for(int i = 0; i<cartasIniciais.length;i++) {
			this.cartasIniciais.add(cartasIniciais[i]);
			this.cartasVistas.add(cartasIniciais[i]);
		}
		this.podeDarPalpite = true;
		this.errouAcusacao = false;
	}
	
	protected Jogador(String personagem,Carta cartasIniciais[],Posicao posInicial,boolean jogando) {
		this.personagem = personagem;
		this.pos = posInicial;
		this.pos.setJogadorAqui(true);
		for(int i = 0; i<cartasIniciais.length;i++) {
			this.cartasIniciais.add(cartasIniciais[i]);
			this.cartasVistas.add(cartasIniciais[i]);
		}
		this.podeDarPalpite = true;
		this.errouAcusacao = false;
		this.jogando = jogando;
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

	protected String getPersonagem() {
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
