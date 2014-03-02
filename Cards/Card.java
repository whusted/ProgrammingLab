public class Card {

	// public constants:
	
	public static final int ACE		= 1;
	public static final int DEUCE	= 2;
	public static final int TWO		= 2;
	public static final int THREE	= 3;
	public static final int FOUR	= 4;
	public static final int FIVE	= 5;
	public static final int SIX		= 6;
	public static final int SEVEN	= 7;
	public static final int EIGHT	= 8;
	public static final int NINE	= 9;
	public static final int TEN		= 10;
	public static final int JACK	= 11;
	public static final int KNAVE	= 11;
	public static final int QUEEN	= 12;
	public static final int KING	= 13;
	
	public static final int SPADES	= 1;
	public static final int HEARTS	= 2;
	public static final int DIAMONDS = 3;
	public static final int CLUBS	= 4;

	// private instance data;

	private int rank;
	private int suit;

	// public constructor:
	public Card ( int rank, int suit ) {
		if ( rank < Card.ACE | rank > Card.KING | suit < Card.SPADES | suit > Card.CLUBS ) {
			throw new IllegalArgumentException();
		} else {
			this.rank = rank;
			this.suit = suit;
		}
	}
	
	/** Returns this card's suit. */
	public int getSuit() {
		return this.suit;
	}

	/** Returns this card's rank. */
	public int getRank() {
		return this.rank;
	}	
	
	/** Returns a stringy version of this card. */
	public String toString() {
    String cardRank = " ";
    String cardSuit = " ";
    if (this.getRank() == 1) {
      cardRank = "ACE";
    } else if (this.getRank() == 2) {
      cardRank = "TWO";
    } else if (this.getRank() == 3) {
      cardRank = "THREE";
    } else if (this.getRank() == 4) {
      cardRank = "FOUR";
    } else if (this.getRank() == 5) {
      cardRank = "FIVE";
    } else if (this.getRank() == 6) {
      cardRank = "SIX";
    } else if (this.getRank() == 7) {
      cardRank = "SEVEN";
    } else if (this.getRank() == 8) {
      cardRank = "EIGHT";
    } else if (this.getRank() == 9) {
      cardRank = "NINE";
    } else if (this.getRank() == 10) {
      cardRank = "TEN";
    } else if (this.getRank() == 11) {
      cardRank = "JACK";
    } else if (this.getRank() == 12) {
      cardRank = "QUEEN";
    } else if (this.getRank() == 13) {
      cardRank = "KING";
    }
    if (this.getSuit() == 1) {
      cardSuit = "SPADES";
    } else if (this.getSuit() == 2) {
      cardSuit = "HEARTS";
    } else if (this.getSuit() == 3) {
      cardSuit = "DIAMONDS";
    } else if (this.getSuit() == 4) {
      cardSuit = "CLUBS";
    }
      return(cardRank + " of " + cardSuit);
  }
}
