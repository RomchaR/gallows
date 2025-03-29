import java.util.Scanner;

public class Game {
    private final Scanner scanner;
    private final RandomNoun randomNoun;

    public Game(Scanner scanner,
                RandomNoun randomNoun) {
        this.scanner = scanner;
        this.randomNoun = randomNoun;
    }

    public void start() {

        System.out.print("Желаете начать новую игру?(да/нет): ");
        String input = scanner.nextLine();

        input = checkAndGetCorrectInput(input, scanner);
        if (input.equalsIgnoreCase("нет")) {
            scanner.close();
            return;
        }

        while (input.equalsIgnoreCase("да")) {
            String randomWord = randomNoun.getRandomNoun();
            NewGame newGame = new NewGame(scanner, randomWord);
            newGame.startNewGame();

            System.out.print("Сыграть еще?(да/нет): ");
            input = scanner.nextLine();

            input = checkAndGetCorrectInput(input, scanner);
        }
        scanner.close();
    }

    private String checkAndGetCorrectInput(String input, Scanner scanner) {
        while (!input.equalsIgnoreCase("нет") && !input.equalsIgnoreCase("да")) {
            System.out.print("Некорректный ввод! Введите (да/нет): ");
            input = scanner.nextLine();
        }
        return input;
    }
}
