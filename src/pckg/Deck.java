package pckg;
import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> deck;
	private int deckIndex;
	private final static int NUMCARDS = 52;
	
	/**
	 * Constructor for deck that assumes deck of cards consists of 52 cards,
	 * the 4 basic suits (Heart, Spades, Clubs, and Spades). 
	 */
	public Deck() {
		deck = new ArrayList<Card>(NUMCARDS);
		
		for(int suit = 0; suit < 4; suit++)
		{
			for(int rank = 1; rank <= 13; rank++) {
				deck.add(new Card(suit, rank));
			}
		}
		deckIndex = 0;
		

	}
	
	/**
	 * Deal card from the top of the deck. Does so by moving deckIndex through ArrayList of Cards
	 * @return the Card at the "top" of the deck 
	 */
	public Card deal( ) {
		Card top = deck.get(deckIndex);
		deckIndex++;
		return top;
	}
	
	/**
	 * Shuffle the deck of cards by randomly swapping cards.
	 */
	public void shuffle() {
		System.out.println("Shuffling deck... \n");
		deckIndex = 0;
		for(int i = 0; i < NUMCARDS; i++) {
			int indexOne = (int)(Math.random()*NUMCARDS);
			int indexTwo = (int)(Math.random()*NUMCARDS);
			
			Card temp = deck.get(indexOne);
			deck.set(indexOne, deck.get(indexTwo));
			deck.set(indexTwo, temp);
		}
	}
}
