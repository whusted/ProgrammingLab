public class CarderGame {
  public static void main(String[] args) {
    
  }
  public class Deck {
    private Card[]cards;
    public Deck() {
      cards = newCard[52];
      int i = 0;
      for (int s = Card.SPADES; s <= Card.CLUBS; s++) {
        for (int r = Card.ACE; r <= Card.KING; r++) {
        cards[i] = newCard();
        int ++;
        }
      }
    }  

    public String toString() {
      private Card[]cards;
      deckToString = new String[52];
      for (int i = 0; i < Deck.length; i++) {
        deckToString = deckToString + cards[i].toString;
      } return deckToString;
    }

    public Card cardAt(int i) {
      if ((i < 0) || (i > 51)) {
        throw new IllegalArgumentException("Must be between 0 and 51");
      } else {
        return new Card(cards[i].getRank(), cards[i].getSuit());
      }
    }

    public void shuffle() {
      shuffledDeck = new int[52];
      for (int i = 0; i < Deck.length; i++) {

        int random = (int)Math.floor((Math.random() * 52));

        shuffledDeck = shuffledDeck + cards[i];
      }
  }
  }
  public class Card {
    private int rank;
    private int suit;
    public static final int ACE = 1;
    public static final int DEUCE = 2;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    public static final int SEVEN = 7;
    public static final int EIGHT = 8;
    public static final int NINE = 9;
    public static final int TEN = 10;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int SPADES = 1;
    public static final int HEARTS = 2;
    public static final int DIAMONDS = 3;
    public static final int CLUBS = 4;

    public Card(int rank, int suit) {
      if (rank < 1 || rank > 12 || suit < 1 || suit > 4) {
        throw new IllegalArgumentException("Bad Card");
      } else {
      this.rank = rank;
      this.suit = suit;
      }
    }
    public int getSuit() {
    return this.suit;
    }
    public int getRank() {
      return this.rank;
      }

    public String toString() {
      return (this.getRank() + " of " this.getSuit());
    }  
  }  
}