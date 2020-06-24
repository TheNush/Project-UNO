import java.util.Scanner; 

public class Game {

	private Player[] players;
	private Deck mainDeck;
	private Deck runningDeck;
	private int numOfPlayers;
	private char runningColor;
	private int runningValue;
	
	public Game() { // sets up the game
		
		Scanner reader = new Scanner (System.in);
		
		System.out.println("Please enter the number of players: ");
		this.numOfPlayers = Integer.parseInt(reader.nextLine());
		
		// initialize players
		createPlayers();
		
		// initialize the main deck
		this.mainDeck = new Deck (); // create standard UNO deck
		this.mainDeck.Shuffle(); // shuffle the deck
		System.out.println("Deck at the ready.");
		this.mainDeck.PrintDeck();
		
		// deal cards
		DealCards();
		System.out.println("Cards have been distributed. Game is almost ready to begin...");
		
		// players, check your decks
		for (Player player : this.players) {
			player.CheckDeck();
		}
		
		// set up the running deck
		this.runningDeck = new Deck(1); // create an empty deck of any size
		// -> draw card from mainDeck
		Card temp = mainDeck.Draw();
		// -> add this card to runningDeck
		this.runningDeck.AddCard(temp);
		// -> set the running color and value
		this.runningColor = temp.getColor();
		this.runningValue = temp.getValue();
		// -> empty the null variable
		temp = null;
		// runningDeck has been initialized!
		
		// Players can begin playing!
		
	}
	
	public void PlayUNO() {
		// plays the game
		
		// input - last card on top in the runningDeck
		this.players[0].PlayTurn(this.runningDeck.GetCardAt(this.runningDeck.getCardCount()-1));
	}
	
	public void DealCards() {
		for (int i = 0; i < this.numOfPlayers; i++) {
			for (int j = 0; j < 7; j++) {
				// deal out 7 cards to each player
				this.players[i].AddCardToDeck(this.mainDeck.Draw());
			}
			System.out.println("Player " + this.players[i].getPlayerName() + " is ready...");
		}
	}
	
	public void createPlayers () {
		Scanner reader = new Scanner (System.in);
		String playerName;
		
		this.players = new Player [this.numOfPlayers]; // instantiate player array 
		for (int i = 0; i < this.numOfPlayers; i++) {
			System.out.println("Please enter name for Player" + i + ":");
			// get name for each player
			playerName = reader.nextLine(); // maybe add a uniqueness verifier later on  *
			this.players[i] = new Player (playerName); // fill player array with Player objects
		}
		
	}
	
}
