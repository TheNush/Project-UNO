
public class Card {
	
	private char color;
	private int value;
	
	public Card (int value, char color) {
		this.value = value;
		this.color = color;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public char getColor() {
		return this.color;
	}
	
	public String toString () {
		if (this.value == 10) {
			return ("(" + this.color + ", Skip" + ")");
		}
		else if (this.value == 11) {
			return ("(" + this.color + ", Reverse" + ")");
		}
		else if (this.value == 12) {
			return ("(" + this.color + ", Draw Two" + ")");
		}
		else if (this.value == 13) {
			return ("(WILD - Change Color)");
		}
		else if (this.value == 14) {
			return ("(WILD - Draw Four)");
		}
		else {
			return ("(" + this.color + ", " + this.value + ")");
		}
	}
}
