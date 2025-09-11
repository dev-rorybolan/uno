package app.belgarion.UNO.AI;
import app.belgarion.UNO.Card;

import java.util.ArrayList;
import java.util.Random;

import app.belgarion.Main;

import static java.lang.Thread.sleep;


/**
 * "artificial intelligence" that really just checks which cards it can use and picks a random one
 */
public class AI {
    public ArrayList<Card> cards;
    private final Random random;
    private int id;

    public AI(ArrayList<Card> deck, int id) {
        this.cards = deck; random = new Random();
        this.id = id;
    }
    public void Run() {

        ArrayList<Card> playable = new ArrayList<>();
        for (Card card : cards) {
            if (Main.game.check(card)) {
                playable.add(card);
            }
        }
        int index = random.nextInt(0, playable.size());
        Main.game.playCard(playable.get(index));
        cards.remove(playable.get(index));
        System.out.printf("\nAI %d played %s %s\n", this.id, playable.get(index).cardColour, playable.get(index).cardSymbol);



    }
}
