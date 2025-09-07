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
    private final Random random = new Random();
    public AI(ArrayList<Card> deck) {
        cards = deck;
    }
    public void Run() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("u fucked up");
        }
        ArrayList<Card> playable = new ArrayList<>();
        for (Card card : cards) {
            if (Main.game.check(card)) {
                playable.add(card);
            }
        }
        int index = random.nextInt(0, playable.size());
        Main.game.playCard(playable.get(index));
        cards.remove(playable.get(index));



    }
}
