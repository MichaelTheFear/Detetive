package Model;

class CartaLocal extends Carta{
	public CartaLocal(String nome) {
		super(nome);
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof CartaLocal)) {
			return false;
		}
		return true;
	}
}
