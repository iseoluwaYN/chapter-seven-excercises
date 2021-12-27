package cards;

import java.security.SecureRandom;
import java.util.Random;

public class DeckOfCards {

    private Card[] deck;
    private int currentCard;
    private final int NUMBER_OF_CARDS=52;
    private SecureRandom randomNumbers = new SecureRandom();

    public DeckOfCards() {
        String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        deck = new Card[NUMBER_OF_CARDS];
        currentCard = 0;
        for (int count = 0; count < deck.length; count++)
            deck[count] = new Card(faces[count % 13], suits[count / 13]);
    }

    public void shuffle() {
        // next call to method dealCard should start at deck[0] again
         currentCard = 0;
        // for each Card, pick another random Card (0-51) and swap them
         for (int first = 0; first < deck.length; first++){
            // select a random number between 0 and 51
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
            // swap current Card with randomly selected Card
             Card temp = deck[first];
             deck[first] = deck[second];
             deck[second] = temp;
         }
    }

    public Card dealCard() {
        if ( currentCard < deck.length)
            return deck[currentCard++]; // return current Card in array
        else
        return null;
    }
}
