import java.util.*;

public class Game {


    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Желаете начать новую игру?(да/нет): ");
        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("нет") && !input.equalsIgnoreCase("да")) {
            System.out.print("Некорректный ввод! Введите (да/нет): ");
            input = scanner.nextLine();
        }
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
            NewGame.startNewSession(randomArr,randomWord,pointsOfRandomWord,scanner);
            System.out.print("Сыграть еще?(да/нет): ");
            input = scanner.nextLine();

            while (!input.equalsIgnoreCase("нет") && !input.equalsIgnoreCase("да")) {
                System.out.print("Некорректный ввод! Введите (да/нет): ");
                input = scanner.nextLine();
            }
        }
        scanner.close();
    }


}
