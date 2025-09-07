package app.belgarion.UNO;

import app.belgarion.UNO.cardtypes.Cards;

import java.util.Random;
import java.util.Stack;

public class Pile {
    /*
    Class of the pile of Uno cards, effectively a java.util.Stack<Card> wrapper
     */
    public Stack<Card> pile = new Stack<>();
    private final Random rand = new Random();
    public Pile() {

        pile.push(Cards.allCards[rand.nextInt(0, 108)]);
    }
    public void PlayCard(Card card) {
        if (pile.peek().isPlayable(card)) {
            pile.push(card);

        }
    }
    public boolean isPlayable(Card card) {
        return card.isPlayable(pile.peek());
    }
    public Card PickCard() {
        return Cards.allCards[rand.nextInt(0, 108)];
    }


}
