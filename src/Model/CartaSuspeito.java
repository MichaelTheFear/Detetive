package Model;

class CartaSuspeito extends Carta{
	public CartaSuspeito(String nome) {
		super(nome);
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof CartaSuspeito)) {
			return false;
		}
		return true;
	}
}
