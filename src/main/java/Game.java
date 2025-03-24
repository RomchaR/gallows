import java.util.*;

public class Game {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Желаете начать новую игру?(да/нет): ");
        String input = scanner.nextLine();

        input = checkAndGetCorrectInput(input, scanner);
        if (input.equalsIgnoreCase("нет")) {
            return;
        }

        while (input.equalsIgnoreCase("да")) {
            String randomWord = RandomNoun.getRandomNoun();
            List<Character> randomArr = new ArrayList<>();
            for (char c : randomWord.toCharArray()) {
                randomArr.add(c);
            }
            List<Character> pointsOfRandomWord = new ArrayList<>();
            for (int i = 0; i < randomArr.size(); i++) {
                pointsOfRandomWord.add('_');
            }
            NewGame.startNewGame(randomArr, randomWord, pointsOfRandomWord, scanner);
            System.out.print("Сыграть еще?(да/нет): ");
            input = scanner.nextLine();

            input = checkAndGetCorrectInput(input, scanner);
        }
        scanner.close();
    }

    private static String checkAndGetCorrectInput(String input, Scanner scanner) {
        while (!input.equalsIgnoreCase("нет") && !input.equalsIgnoreCase("да")) {
            System.out.print("Некорректный ввод! Введите (да/нет): ");
            input = scanner.nextLine();
        }
        return input;
    }
}
