
public class WildCard extends Card{
	
	private String ability; // "DrawFour" or "ColorChange"
	
	public WildCard(String ability, int value) {
		super (value, 'n'); // 'n' color represents "neutral" color
		this.ability = ability;
	}
	
}
