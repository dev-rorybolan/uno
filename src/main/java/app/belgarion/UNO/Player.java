package app.belgarion.UNO;

import app.belgarion.Main;

import java.util.ArrayList;

public class Player {
    public ArrayList<Card> cards;
    boolean skipped = false;
    public Player(ArrayList<Card> cards) {
        this.cards = cards;
    }
    public ArrayList<Card> getPlayable(Card card_below) {
        ArrayList<Card> playable = new ArrayList<>();
        for (Card card : cards) {
            if (Main.game.check(card)) {
                playable.add(card);
            }
        }
        return playable;
    }
}
