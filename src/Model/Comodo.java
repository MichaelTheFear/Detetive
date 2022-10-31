package Model;

import java.util.Objects;

class Comodo extends Posicao {

	private String comodo;
	
	
	 Comodo(int i, int j, String string) {
		super(i,j);
		comodo=string;
	}


	 String getComodo() {
		return comodo;
	}

	 public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Comodo)) {
			return false;
		}
		Comodo other = (Comodo) obj;
		return Objects.equals(comodo, other.comodo);
	}
	
	

}
