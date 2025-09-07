package app.belgarion.UNO;
import app.belgarion.UNO.cardtypes.Cards;

import java.util.ArrayList;
import java.util.Random;


public class Deck {
    Random random = new Random();
    public ArrayList<Card> DealOneHand() {
        ArrayList<Card> cards = new ArrayList<>();

        ArrayList<Integer> card_indices = new ArrayList<>();

        while (card_indices.size() < 7) {
            int num = random.nextInt(0, 108);
            if (!card_indices.contains(num)) {
                card_indices.add(num);
            }
        }
        for (int num : card_indices) {
            cards.add(Cards.allCards[num]);
        }
        return cards.size() == 7? cards : new ArrayList<>();
    }
    public ArrayList<ArrayList<Card>> Deal(int playerCount) {
        ArrayList<ArrayList<Card>> cards = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            cards.add(DealOneHand());
        }
        return cards;
    }
    public Card draw() {
        return Cards.allCards[random.nextInt(0, 108)];
    }


}
