import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RandomNoun rand = new RandomNoun();
        Game game = new Game(sc, rand);
        game.start();
    }
}
