package app.belgarion;

import app.belgarion.cardtypes.*;

public class Card {
    public Colour cardColour;
    public Symbol cardSymbol;
    public Card(Colour colour, Symbol symbol) {
        cardColour = colour;
        cardSymbol = symbol;
    }
    public boolean isPlayable(Card cardBelow) {return cardBelow.cardSymbol == cardSymbol || cardBelow.cardColour == cardColour || cardBelow.cardColour == Colour.SPECIAL;}

    @Override
    public String toString() {
        return "Card{" +
                "\ncardColour=" + cardColour +
                ", \ncardSymbol=" + cardSymbol +
                "\n}";
    }
}
