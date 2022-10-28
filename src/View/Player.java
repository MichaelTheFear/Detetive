package View;

import java.awt.Color;
import java.util.HashMap;
import java.util.Objects;

public class Player {
	Color c;
	int x,y; 
	static HashMap<String,Player> players =  new HashMap<String,Player>();
	
	static {
		players.put("Green",new Player(Color.green,2,16));
		players.put("White",new Player(Color.WHITE,2,11));
		players.put("Peacock",new Player(Color.blue,8,25));
		players.put("Plum",new Player(Color.magenta,21,25));
		players.put("Scarlet",new Player(Color.red,26,9));
		players.put("Mustard",new Player(Color.orange,19,2));
	}
	
	static Color getColorOf(String p) {
		return players.get(p).c;
	}
	
	static void setPlayerTo(String name,int x, int y) {
		Player p= players.get(name); 
		p.x = x;
		p.y = y;
	}
	
	
	public Player(Color c,int x, int y) {
		this.c=c;
		this.x=x;
		this.y=y;
	}

	public int getX() {
		
		return x;
	}
	public int getY() {
		
		return y;
	}


	@Override
	public int hashCode() {
		return Objects.hash(c, x, y);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(c, other.c) && x == other.x && y == other.y;
	}
	
	
}
