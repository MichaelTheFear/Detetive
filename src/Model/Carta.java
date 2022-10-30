package Model;

import java.util.Objects;

//Esse abstract e somente para forcar as cartas serem de um dos 3 tipos
abstract class Carta {
	private String nome;
	
	//factory
	
	protected Carta(String nome) {
		this.nome = nome;
	}
	
	protected String getNome() {
		return nome;
	}

	public boolean equals(Object obj) {
		Carta other = (Carta) obj;
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		return Objects.equals(nome, other.nome);
	}
	protected boolean mesmoTipoDeCarta(Carta c[]) {
		int tam = c.length;
		for(int i=0; i<tam; i++) {
			if(!c[0].getClass().equals(c[i].getClass())) {
				return false;
			}
		}
		return true;
	}
	static boolean mesmoTipoDeCarta(Carta c[]) {
		int tam = c.length;
		for(int i=0; i<tam; i++) {
			if(c[0] instanceof CartaArma && !(c[i] instanceof CartaArma)) {
				return false;
			}
			if (c[0] instanceof CartaLocal && !(c[i] instanceof CartaLocal)) {
				return false;
			}
			if(c[0] instanceof CartaSuspeito && !(c[i] instanceof CartaSuspeito)) {
				return false;
			}
		}
		return true;
	}
	
}
