package app.belgarion;
import java.util.ArrayList;
import java.util.Random;
import app.belgarion.cardtypes.*;

public class Deck {
    public ArrayList<Card> Deal() {
        ArrayList<Card> cards = new ArrayList<Card>();
        Random random = new Random();

        for (int i = 0; i < 7; i++) {
            Colour col = randomEnum(Colour.class);
            Symbol sym = randomEnum(Symbol.class);
            if (col == Colour.SPECIAL) {
                sym = random.nextBoolean() ? Symbol.WILD : Symbol.PLUS_4;
            }
            cards.add(new Card(col, sym));
        }
        return cards;
    }
    public static <T extends Enum<?>> T randomEnum(Class<T> clas){
        Random random = new Random();
        int x = random.nextInt(clas.getEnumConstants().length);
        return clas.getEnumConstants()[x];
    }

}
