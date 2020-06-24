import java.util.Scanner;

public class Player {

	private String name; 
	private Deck playerDeck = new Deck (7); // players always begin with 7 cards
	private boolean calledUno = false;
	
	public Player(String name) {
		this.name = name;
	}
	
	public void PlayTurn(Card running) {
		
		Scanner reader = new Scanner (System.in);
		
		int choice = 0;
		char color = running.getColor();
		int value = running.getValue();
		
		System.out.println("The Running Card: ");
		System.out.println(running.toString());
		System.out.println();
		
		System.out.println("Your deck: ");
		this.playerDeck.PrintDeck();
		
		System.out.println("Choose from the following: ");
		System.out.println("1) Pick a card to play");
		System.out.println("2) Draw a card");
		System.out.println("3) Call UNO");
		
		choice = Integer.parseInt(reader.nextLine());
		
		switch (choice) {
		case 1:
			Card toPlay = PlayCard(color, value);
			break;
		case 2:
			DrawCard();
			break;
		case 3:
			System.out.println("UNO!!");
			break;
		default: 
			System.out.println("Please enter a valid, integer input. ");
		}
		
	}
	
	public Card PlayCard (char runningColor, int runningValue) {
		
		Scanner reader = new Scanner (System.in);
		
		int index = 0;
		boolean done = false; // boolean to track if chosen card is valid
		Card temp = null;
		
		// play a card for your turn
		System.out.println("Please enter the index (starts at 1)"
					+ " of the card you want to play:");
		index = Integer.parseInt(reader.nextLine());
		// ensure entered index is within bounds
		while (index > this.playerDeck.getCardCount() || index <= 0) {
			System.out.println("Please enter a valid index.");
			index = Integer.parseInt(reader.nextLine());
		}
		
		temp = this.playerDeck.GetCardAt(index-1);
		
		// chosen card must be either of the same color or value to be played legally 
		if (temp.getColor() != runningColor && temp.getValue() != runningValue){
			System.out.println("You can only play a card with the same"
					+ " symbol/value/color as the one currently running");
			return null;
		}
		
		return temp;
		
	}
	
	public void DrawCard () {
		// draw a card from your deck
	}
	
	public void AddCardToDeck(Card card) {
		this.playerDeck.AddCard(card);
		System.out.println("Dealt card to player " + this.name);
	}
	
	public int getCardCount () {
		return this.playerDeck.getCardCount();
	}
	
	public void CheckDeck() {
		System.out.println(this.name + ", you have: ");
		this.playerDeck.PrintDeck();
	}
	
	public String getPlayerName () {
		return this.name;
	}
	
}
