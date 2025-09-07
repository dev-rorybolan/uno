package app.belgarion;


import app.belgarion.UNO.Game;

/**
 * Main class, effectively the game, all the other files are used here (or will be).
 */
public class Main {

    public static Game game = new Game();

    public static void main(String[] args) {
        game.run();
    }
}
