package pckg;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	private static BufferedReader stdin = 
            new BufferedReader( new InputStreamReader( System.in ) );
	
	private String name;
	private ArrayList<Card> hand;
	private int handValue;
	private int numAces;
	boolean dealer;
	
	/**
	 * Player constructor that sets Player's name and initializes the Player's hand.
	 * @param n name of player (name of dealer will always be "Dealer")
	 * @param d boolean value to determine whether this Player is the dealer or the user
	 */
	public Player(String n, boolean d) {
		this.name = n;
		hand = new ArrayList<Card>();
		handValue = 0;
		dealer = d;
		numAces = 0;
	}
	
	/**
	 * Getter for Player name.
	 * @return Player's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Adds card from the deck to the respective Player's hands. Adds to handValue
	 * based on the appropriate Blackjack value of the new card in the Player's hand.
	 * @param deck Deck of cards being used to play game of Blackjack
	 */
	public void addToHand(Deck deck) {
		Card topCard = deck.deal();
		int rank = topCard.getValue();
		if(rank >=10) 
			handValue+= 10;
		else if(rank==1) {
				handValue += 11;
				numAces++;
				checkAces();
		}
		else 
			handValue += topCard.getValue();
		hand.add(topCard);
	}
	
	/**
	 * Clear the user's hand and set the value of the user's hand to zero.
	 */
	public void resetHand() {
		handValue = 0;
		hand.clear();
	}
	
	/**
	 * Getter function for the value of the user's hand
	 * @return Player's handValue
	 */
	public int getHandValue() {
		return handValue;
	}
	
	/**
	 * Getter function for the number of cards in the user's hand
	 * @return size of Player's ArrayList of Cards
	 */
	public int getNumCards() {
		return hand.size();
	}
	
	/**
	 * Display one card from the Player's hand.
	 */
	public void showOne() {
		Card card1 = hand.get(0);
		System.out.println(name + " has a: " + card1.getCardName());
	}
	
	/**
	 * Display all the cards in the Player's hand.
	 */
	public void showAll() {
		String cardsList = "";
		for(int i = 0; i < hand.size(); i++) {
			Card card = hand.get(i);
			cardsList += card.getCardName() + ", ";
		}
		if(dealer) {
			System.out.println("The dealer has " + cardsList + " making the value of their hand " + getHandValue());
		}
		else {
			System.out.println("You have the: " + cardsList + " making the value of your hand " + getHandValue());
		}
	}
	
	/**
	 * Check whether the Player has Blackjack (An ace and another card with a value of 10)
	 * @return boolean value indicating whether or not Player has blackjack
	 */
	public boolean checkBlackjack() {
		if(getNumCards()==2) {
			Card card1 = hand.get(0);
			Card card2 = hand.get(1);
			if((card1.getValue()==1 || card2.getValue()==1) && (card1.getValue()>=10 || card2.getValue()>=10)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * If Player is the dealer, assume that Player will always Hit (add card to hand) if handValue is less than 17 and
	 * will always stay if hand is greater than or equal to 17 and under 21. If user, function gives option to either 
	 * Hit (add one card to hand) or Stay (add no cards to hand) based on user input.
	 * Uf 
	 * @param deck Deck of cards being used in game of Blackjack
	 */
	public void move(Deck deck) {
		if(dealer) {
			while(handValue <= 16)
				addToHand(deck);
				checkAces();
		}
		else {
			while(handValue < 21) {
				showAll();
				Scanner in = new Scanner(System.in);
				System.out.println("Hit ('H') or Stand ('S')?");
				String input = in.nextLine();
				System.out.println();
				if(input.equals("H")) {
					addToHand(deck);
				}
				else if(input.equals("S")) {
					break;
				}
				checkAces();
			}
		}
	}
	
	/**
	 * Determine whether the value of Aces in a Player's hand should be 1 or 11.
	 */
	public void checkAces() {
		if(handValue > 21 && numAces > 0) {
			handValue-=10;
			numAces--;
		}
	}
}