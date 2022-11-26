package Model;

import java.util.Objects;

//Esse abstract e somente para forcar as cartas serem de um dos 3 tipos
abstract class Carta {
	private String nome;
	
	//factory
	
	  Carta(String nome) {
		this.nome = nome;
	}
	
	  String getNome() {
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
	 
	static boolean mesmoTipoDeCarta(Carta c[]) {
		int tam = c.length;
		boolean res = false;
		for(int i=0; i<tam; i++) {
			res |= (c[i%tam] instanceof CartaArma &&
					c[(i+1)%tam] instanceof CartaLocal &&
					c[(i+2)%tam] instanceof CartaSuspeito); 
		}
		return res;
	}
	
}
