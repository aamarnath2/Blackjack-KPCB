package pckg;
import java.util.Scanner;

public class BlackJack {

	public static void main(String[] args) {

		//Declare and initialize new deck to play blackjack
		Deck deck = new Deck();

		//Retrieve users name
		Scanner in = new Scanner(System.in);
		String name = "";
		while (name.trim().length() <= 0) {
			System.out.println("What is your name?");
			name = in.nextLine();
		}
		System.out.println();
		
		//create two instances of a Player - one for the user and one for the dealer
		Player dealer = new Player("Dealer", true);
		Player user = new Player(name, false);
		
		//boolean value for the blackjack game loop - each iteration through loop represents one round of blackjack
		boolean keepPlaying = true;
		while (keepPlaying) {
			keepPlaying = playGame(deck, user, dealer);
		}

	}
	/**
	 * Function that simulates one round of blackjack being played. Calls helper function to initiate gameplay
	 * and then assesses all possible end game scenarios. 
	 * @param deck deck of cards being used 
	 * @param user instance of Player class that represents the user
	 * @param dealer instance of Player class that represents the dealer (CPU)
	 * @return boolean value that indicates whether or not user wants to play again
	 */
	public static boolean playGame(Deck deck, Player user, Player dealer) {
		gameStart(deck, user, dealer);
		if (dealer.checkBlackjack() && user.checkBlackjack()) { //check if both players have blackjack - tie
			dealer.showAll();
			user.showAll();
			System.out.println("You and the dealer both have BlackJack! Neither of you won."); 
		} else if (dealer.checkBlackjack()) { //check if only dealer has blackjack 
			dealer.showAll();
			user.showAll();
			System.out.println("The dealer has BlackJack! You lose!"); 
		} else if (user.checkBlackjack()) { //check if only user has blackjack
			dealer.showAll();
			user.showAll();
			System.out.println("You have BlackJack! You win!");
		} else {  //goes through Hit/Stay process for each player if neither has blackjack
			dealer.move(deck);
			user.move(deck);
			dealer.showAll();
			user.showAll();
			if (dealer.getHandValue() > 21 && user.getHandValue() > 21) {
				System.out.println("\nYou and the dealer both busted! Neither of you won.");
			} else if (dealer.getHandValue() > 21) {
				System.out.println("\nThe dealer busted - congrats you won!");
			} else if (user.getHandValue() > 21) {
				System.out.println("\nOh no, you busted! The dealer won.");
			} else if (dealer.getHandValue() > user.getHandValue()) {
				System.out.println("\nThe dealer wins! The score of their hand is " + dealer.getHandValue()
						+ " and the score of your hand is " + user.getHandValue());
			} else if (dealer.getHandValue() == user.getHandValue()) {
				System.out.println("\nThe game is a tie! You and the dealer both have a score of " + dealer.getHandValue());
			} else {
				System.out.println("\nYou win! The score of your hand is " + user.getHandValue()
						+ " and the score of the dealer's hand is " + dealer.getHandValue());
			}
		}
		
		//Check to see if user wants to play again
		Scanner in = new Scanner(System.in);
		System.out.println("\nIf you would not like to play again, please enter 'Q'. Otherwise, enter any key to play again");
		String input = in.nextLine();
		if (input.equals("Q")) {
			return false;
		}
		return true;
	}
	
/**
 * Sets up deck of cards and Players for game. Makes sure Player hands are empty,
 * shuffles the deck, and deals two cards to each player to begin gameplay.
 * @param deck deck of cards being used to play blackjack
 * @param user instance of Player class that represents the user
 * @param dealer instance of Player class that represents the dealer (CPU)
 */
	public static void gameStart(Deck deck, Player user, Player dealer) {
		user.resetHand(); 
		dealer.resetHand();
		deck.shuffle();
		dealer.addToHand(deck);
		user.addToHand(deck);
		dealer.addToHand(deck);
		user.addToHand(deck);
		// cards visible to both players
		System.out.println("Face Up Cards: ");
		dealer.showOne();
		user.showOne();
		System.out.println();
	}

}
