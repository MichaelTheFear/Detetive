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
	
}
