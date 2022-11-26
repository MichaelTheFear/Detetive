package Model;

class CartaArma extends Carta {
	CartaArma(String nome) {
		super(nome);
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof CartaArma)) {
			return false;
		}
		return true;
	}

};
