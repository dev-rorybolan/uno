package app.belgarion;

import app.belgarion.cardtypes.*;

/**
 * Card class, it just contains the colour and symbol, plus a little bit of boilerplate and a one-liner to check if a card is playable.
 */
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
