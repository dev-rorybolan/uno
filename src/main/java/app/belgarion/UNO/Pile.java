package app.belgarion.UNO;

import app.belgarion.Main;
import app.belgarion.UNO.cardtypes.Cards;
import app.belgarion.UNO.cardtypes.Colour;

import java.util.Random;
import java.util.Stack;

public class Pile {
    /*
    Class of the pile of Uno cards, effectively a java.util.Stack<Card> wrapper
     */
    public Stack<Card> pile;
    private final Random rand;

    {
        pile = new Stack<>();
        rand = new Random();
    }

    public Pile() {
        Card card = Main.game.deck.cards.allCards[rand.nextInt(0, 108)];
        card_not_special_loop: while (true) {
            if (card.cardColour != Colour.SPECIAL) {
                pile.push(card);
                break card_not_special_loop;
            } else {
                card = Main.game.deck.cards.allCards[rand.nextInt(0, 108)];
            }
        }
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
        return Main.game.deck.cards.allCards[rand.nextInt(0, 108)];
    }


}
