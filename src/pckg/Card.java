package pckg;

public class Card {
	private int rankValue;
	private int suit;
	private String cardName;
	
	/**
	 * Constructor that initializes of card
	 * @param s Suit of the card
	 * @param r Rank of the card
	 */
	public Card(int s, int r) {
		this.suit = s;
		this.rankValue = r;
		setCardName();
	}

	/**
	 * Sets the name of the card based on the rank. Cards with rank 1 are Aces, Cards
	 * with rank 11 are Jacks, cards with rank 12 are Queen, and cards with 13 are King.
	 */
	public void setCardName() {
		String rankName = "";
		if(rankValue == 1) {
			rankName = "Ace";
		}
		else if(rankValue == 11) {
			rankName = "Jack";
		}
		else if(rankValue == 12) {
			rankName = "Queen";
		}
		else if(rankValue == 13) {
			rankName = "King";
		}
		else {
			rankName = Integer.toString(rankValue);
		}
		cardName = rankName + " of " + getSuit();
	}
	
	/**
	 * Cards with value.
	 * @return  the rank value of the card
	 */
	public int getValue() {
		return rankValue;
	}

	/**
	 * Getter function for the suit of the car
	 * @return the suit of the card (Spades, Hearts, Clubs, Diamonds)
	 */
	public String getSuit() {
		if(suit == 0) {
			return "Spades";
		}
		else if(suit == 1) {
			return "Hearts";
		}
		else if(suit == 2) {
			return "Clubs";
		}
		else {
			return "Diamonds";
		}
	}
	
	/**
	 * Name of the card is based on the rank and the Suit
	 * @return the name of the card
	 */
	public String getCardName() {
		return cardName;
	}
}
