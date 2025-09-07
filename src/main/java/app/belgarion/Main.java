package app.belgarion;



import app.belgarion.AI.AI;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main class, effectively the game, all the other files are used here (or will be).
 */
public class Main {

    public static Pile pile = new Pile();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        print("How many will be playing? ");
        int players = scanner.nextInt();
        Deck deck = new Deck();

        ArrayList<ArrayList<Card>> cards = deck.Deal(players);
        ArrayList<Card> player1_cards = cards.getFirst();
        for (Card card : player1_cards) {
            printf("Card: %s %s\n", card.cardColour, card.cardSymbol);

        }
        List<ArrayList<Card>> botCards = cards.subList(1, cards.size());
        ArrayList<AI> bots = new ArrayList<>();
        for (ArrayList<Card> card_list : botCards) {
            bots.add(new AI(card_list));
        }
        printf("The first card is a %s %s\n", pile.pile.peek().cardColour, pile.pile.peek().cardSymbol);
        ArrayList<Card> playable = new ArrayList<>();
        for (Card card : player1_cards) {
            if (Main.pile.isPlayable(card)) {
                playable.add(card);
            }
        }
        StringBuilder finalstr = new StringBuilder();
        for (Card card : playable) {
            finalstr.append(card.cardColour).append(" ").append(card.cardSymbol).append("\n");
        }
        printf("The cards you can play are:\n %s\n", finalstr);
        if (playable.equals(new ArrayList<Card>())) {
            println("you need to draw a card");
        }
        println(playable.equals(new ArrayList<Card>()) ? "1: play a card\n2: draw a card" : "2: draw a card (no cards to play)");
        int response = scanner.nextInt();
        switch (response) {
            case 1:
                assert !playable.equals(new ArrayList<>());
                for (int i = 0; i < playable.size(); i++) {
                    printf("%d | %s %s", i, playable.getFirst().cardColour, playable.getFirst().cardSymbol);
                }
                println(null);
                int card_choice = scanner.nextInt();
                Card card_played = playable.remove(card_choice);
                printf("Card %s %s played", card_played.cardColour, card_played.cardSymbol);
            case 2:
                player1_cards.add(deck.draw());
                printf("picked a %s %s", player1_cards.getLast().cardColour, player1_cards.getLast().cardSymbol);
            default:

        }
    }

    public static void printf(String s, Object... args) {
        System.out.printf(s, args);
    }
    public static void print(String s) {
        System.out.print(s);
    }
    public static void println(@Nullable String s) {
        System.out.println(s != null ? s : "");
    }
}
