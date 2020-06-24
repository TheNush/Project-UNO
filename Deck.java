import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	private int cardCount;
	private ArrayList<Card> cards;
	// --------------------------CONSTRUCTORS---------------------------------- //
	public Deck () {
		System.out.println("Making the standard UNO deck...");
		StandardDeck();
	}
	
	public Deck (int size) {
		this.cards = new ArrayList<Card> (size);
		System.out.println("Deck has been created and is ready to be filled!");
		this.cardCount = 0; // deck is still empty
	}
	
	// --------------------------END OF CONSTS--------------------------------- //
	
	public Card GetCardAt (int index) {
		return this.cards.get(index);
	}
	
	public Card Draw (int index) {
		Card temp = this.cards.get(index);
		this.cards.remove(index);
		
		return temp;
	}
	
	public int getCardCount() {
		return this.cardCount;
	}
	
	public Card Draw () {
		Card temp = this.cards.get(this.cardCount-1);
		// set the last position to null after drawing
		this.cards.set(this.cardCount-1, null);
		this.cardCount--;
		return temp;
	}
	
	public void AddCard (Card thisCard) {
		
		this.cards.add(thisCard); // place thisCard on top of the deck
		this.cardCount++; // increase card count by 1
		
	}
	
	public void Shuffle () {
		// MODERN FISHER-YATES SHUFFLING ALGORITHM
		// (or) RANDOM SWAP ALGORITHM 
		Random rand = new Random();
		int randomIndex;
		Card temp = null;
		
		for (int i = this.cardCount-1; i > 0; i--) {
			randomIndex = rand.nextInt(i+1);
					
			// swap ith position with card in randomIndex position
			temp = this.cards.get(i);
			this.cards.set(i, this.cards.get(randomIndex));
			this.cards.set(randomIndex, temp);
		}
				
		System.out.println("This deck has been shuffled!");
	}
	
	private void StandardDeck () {
		this.cards = new ArrayList<Card> (108);
		char[] colors = {'r', 'g', 'b', 'y'};
		int cardIndex = 0;
		
		while (cardIndex < 108) {
			for (char color : colors) {
				if (cardIndex < 4) {
					// 4 zeros
					this.cards.add(new Card (0, color));
				}
				else if (cardIndex < 12) {
					// 8 ones
					this.cards.add(new Card (1, color));
				}
				else if (cardIndex < 20) {
					// 8 twos
					this.cards.add(new Card (2, color));
				}
				else if (cardIndex < 28) {
					// 8 threes
					this.cards.add(new Card (3, color));
				}
				else if (cardIndex < 36) {
					// 8 fours
					this.cards.add(new Card (4, color));
				}
				else if (cardIndex < 44) {
					// 8 fives
					this.cards.add(new Card (5, color));
				}
				else if (cardIndex < 52) {
					// 8 sixes
					this.cards.add(new Card (6, color));
				}
				else if (cardIndex < 60) {
					// 8 sevens
					this.cards.add(new Card (7, color));
				}
				else if (cardIndex < 68) {
					// 8 eights
					this.cards.add(new Card (8, color));
				}
				else if (cardIndex < 76) {
					// 8 nines
					this.cards.add(new Card (9, color));
				}
				else if (cardIndex < 84) {
					// 8 "skip"s
					this.cards.add(new ActionCard ("Skip", 10, color));
				}
				else if (cardIndex < 92) {
					// 8 "reverse"s
					this.cards.add(new ActionCard ("Reverse", 10, color));
				}
				else if (cardIndex < 100) {
					// 8 "draw two"s
					this.cards.add(new ActionCard ("DrawTwo", 10, color));
				}
				else if (cardIndex < 104) {
					// 4 "change color"s
					this.cards.add(new WildCard ("ColorChange", 13));
				}
				else {
					// 4 "draw four"s
					this.cards.add(new WildCard ("DrawFour", 14));
				}
				cardIndex++;
			}
		}
		
		this.cardCount = cardIndex;
		
	}
	
	public void PrintDeck() {
		for (int i = 0; i < this.cardCount; i++) {
			System.out.printf("%-22s", this.cards.get(i).toString());
			if ((i+1) % 7 == 0 && i != 0) { // print 4 cards in a row
				System.out.println();
			}
		}
		System.out.println();
	}
	
}
