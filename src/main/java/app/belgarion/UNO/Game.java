package app.belgarion.UNO;

import app.belgarion.UNO.AI.AI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.jetbrains.annotations.Nullable;


public class Game {
    private Pile pile;
    private Deck deck;

    public Game() {
        this.pile = new Pile();
        this.deck = new Deck();
    }
    public boolean check(Card card) {
        return pile.isPlayable(card);

    }
    public void playCard(Card card) {
        this.pile.PlayCard(card);
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

    public void run() {
        Scanner scanner = new Scanner(System.in);
        print("How many will be playing? ");
        int players = scanner.nextInt();


        ArrayList<ArrayList<Card>> cards = deck.Deal(players);
        ArrayList<Card> player1_cards = cards.getFirst();
        for (Card card : player1_cards) {
            printf("Card: %s %s\n", card.cardColour, card.cardSymbol);

        }
        Player player = new Player(player1_cards);

        List<ArrayList<Card>> botCards = cards.subList(1, cards.size());
        ArrayList<AI> bots = new ArrayList<>();
        for (ArrayList<Card> card_list : botCards) {
            bots.add(new AI(card_list));
        }
        printf("The first card is a %s %s\n", /* yeah */ pile.pile.peek().cardColour, pile.pile.peek().cardSymbol);
        ArrayList<Card> playable = new ArrayList<>();
        for (Card card : player.cards) {
            if (pile.isPlayable(card)) {
                playable.add(card);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Card card : playable) {
            stringBuilder.append(card.cardColour).append(" ").append(card.cardSymbol).append("\n"); //
        }
        printf("The cards you can play are:\n %s\n", stringBuilder);
        if (playable.isEmpty()) {
            println("you need to draw a card");
        }
        loop: while (true) {
        println(!playable.isEmpty() ? "1: play a card\n2: draw a card" : "2: draw a card (no cards to play)");
        int response = scanner.nextInt();
        switch (response) {
            case 1:
                assert !playable.isEmpty();
                for (int i = 0; i < playable.size(); i++) {
                    printf("%d | %s %s\n", i, playable.get(i).cardColour, playable.get(i).cardSymbol);
                }
                println(null);
                int card_choice = scanner.nextInt();
                Card card_played = playable.remove(card_choice);
                printf("Card %s %s played", card_played.cardColour, card_played.cardSymbol);
                break loop;
            case 2:
                player1_cards.add(deck.draw());
                printf("picked a %s %s", player1_cards.getLast().cardColour, player1_cards.getLast().cardSymbol);
                break loop;

            default:
                println("you need to press 1 or 2");

        }
        }
    }
}