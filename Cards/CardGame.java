public class CardGame {

  public static void main ( String[] args ) {
    
    Deck deck = new Deck();
    
    deck.shuffle();
    
    if ( ! legalDeck(deck) ) { System.out.println ("After shuffling, the deck is not legal."); } 
    else { System.out.println ( deck.toString() ); }
  }
  public class Card {

  // public constants:
  
  public static final int ACE   = 1;
  public static final int DEUCE = 2;
  public static final int TWO   = 2;
  public static final int THREE = 3;
  public static final int FOUR  = 4;
  public static final int FIVE  = 5;
  public static final int SIX   = 6;
  public static final int SEVEN = 7;
  public static final int EIGHT = 8;
  public static final int NINE  = 9;
  public static final int TEN   = 10;
  public static final int JACK  = 11;
  public static final int KNAVE = 11;
  public static final int QUEEN = 12;
  public static final int KING  = 13;
  
  public static final int SPADES  = 1;
  public static final int HEARTS  = 2;
  public static final int DIAMONDS = 3;
  public static final int CLUBS = 4;

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
    // Replace the next instruction with your code:
    throw new UnsupportedOperationException();
  }


}
public class Deck {

  // private instance data;
  private Card[] cards;

  // public constructor:
  public Deck() {
    this.cards = new Card[52];
    int i = 0;
    for ( int suit = Card.SPADES; suit <= Card.CLUBS; suit++ ) {
      for ( int rank = Card.ACE; rank <= Card.KING; rank++ ) {
        this.cards[i] = new Card(rank,suit);
        i++;
      }
    }
  }
  
  /** Returns a copy of the card at the specified index in this deck. */
  public Card cardAt(int index) {
    if ( index < 0 | index > 51 ) {
      throw new IllegalArgumentException();
    } else {
      return new Card( this.cards[index].getRank(),this.cards[index].getSuit() ); 
    }
  }
  
  /** Shuffles this deck. */
  public void shuffle() {
    // Replace the next instruction with your code:
    throw new UnsupportedOperationException();
  }
  
  /** Returns a stringy version of this deck. */
  public String toString() {
    // Replace the next instruction with your code:
    throw new UnsupportedOperationException();
  }


}
  


  /** Returns true if there is one copy of each card in the given deck. */

  public static boolean legalDeck(Deck d) {

    for ( int suit = Card.SPADES; suit <= Card.CLUBS; suit++ ) {
      for ( int rank = Card.ACE; rank <= Card.KING; rank++ ) {
        if ( ! inDeck( new Card(rank,suit), d ) ) { return false; }
      }
    }
    
    return true;
  }


  /** Returns true iff the specified card is somewhere in the specified deck. */

  public static boolean inDeck ( Card c, Deck d) {

    for ( int i = 0; i < 52; i++ ) {
      if ( d.cardAt(i).getRank() == c.getRank()
       &&  d.cardAt(i).getSuit() == c.getSuit() ) {
            return true;
      }
    }
    return false;
  }

}