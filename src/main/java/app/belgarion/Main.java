package app.belgarion;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Pile pile = new Pile();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many will be playing? ");
        int players = scanner.nextInt();
        Deck deck = new Deck();

        ArrayList<ArrayList<Card>> cards = deck.Deal(players);
        ArrayList<Card> player1_cards = cards.getFirst();
        for (Card card : player1_cards) {
            printf("Card: %s %s", card.cardColour, card.cardSymbol);

        }
    }

    public static void printf(String s, Object... args) {
        System.out.printf(s, args);
    }
}
