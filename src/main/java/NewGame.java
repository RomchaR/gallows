import java.util.List;
import java.util.Scanner;

public class NewGame {


    public static void startNewSession(List<Character> arr, String randomWord, List<Character> points, Scanner scanner) {
        int counterOfMistakes = 6;
        int countMiss = 0;
        StringBuilder temp = new StringBuilder();
        while (counterOfMistakes >= 0) {
            if (!points.contains('_')) {
                System.out.println("Вы выйграли!!!");
                System.out.println(SetOfConstants.word + randomWord);
                return;
            }
            if (counterOfMistakes == 6) {
                System.out.println(PicturesForMistakes.start);
            } else if (counterOfMistakes == 5) {
                System.out.println(PicturesForMistakes.firstMistake);
            } else if (counterOfMistakes == 4) {
                System.out.println(PicturesForMistakes.secondMistake);
            } else if (counterOfMistakes == 3) {
                System.out.println(PicturesForMistakes.thirdMistake);
            } else if (counterOfMistakes == 2) {
                System.out.println(PicturesForMistakes.fourthMistake);
            } else if (counterOfMistakes == 1) {
                System.out.println(PicturesForMistakes.fifthMistake);
            } else {
                System.out.println("Вы проиграли!");
                System.out.println(SetOfConstants.word + randomWord);
                System.out.println(PicturesForMistakes.lastMistake);
                return;
            }

            System.out.print(SetOfConstants.word);
            String latter = scanner.nextLine();
            int changes = 0;

            while (latter.length() > 1 || !SetOfConstants.alphabet.contains(latter.toUpperCase().charAt(0))) {
                System.out.println(SetOfConstants.incorrectInput);
                latter = scanner.nextLine();
            }

            for (int i = 0; i < randomWord.length(); i++) {
                if (arr.get(i) == latter.charAt(0)) {
                    changes++;
                    points.set(i, arr.get(i));

                }
            }

            if (changes == 0) {
                countMiss++;
                temp.append(",").append(latter);
                System.out.println("Вы не угадали букву!");
                System.out.println(SetOfConstants.word + points);
                System.out.println(SetOfConstants.numberOfMistakes + countMiss);
                System.out.println(SetOfConstants.noGuessedLetters + temp.substring(1));
                counterOfMistakes--;
            } else {
                System.out.println("Вы угадали букву!");
                System.out.println(SetOfConstants.word + points);
                System.out.println(SetOfConstants.numberOfMistakes + countMiss);
                if (!temp.toString().isEmpty()) {
                    System.out.println(SetOfConstants.noGuessedLetters + temp.substring(1));
                }
            }
        }
    }
}
