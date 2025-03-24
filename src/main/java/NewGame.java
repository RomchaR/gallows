import java.util.List;
import java.util.Scanner;

public class NewGame {

    public static void startNewGame(List<Character> arr, String randomWord, List<Character> emptyWord, Scanner scanner) {
        int counterOfMistakes = 6;
        StringBuilder temp = new StringBuilder();
        while (counterOfMistakes >= 0) {
            if (checkIsOver(emptyWord, randomWord, counterOfMistakes)) {
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
                    emptyWord.set(i, arr.get(i));

                }
            }

            if (changes == 0) {
                counterOfMistakes--;
                temp.append(",").append(latter);
                System.out.println("Вы не угадали букву!");
                System.out.println(SetOfConstants.word + emptyWord);
                System.out.println(SetOfConstants.numberOfMistakes + Math.abs(counterOfMistakes - 6));
                System.out.println(SetOfConstants.noGuessedLetters + temp.substring(1));

            } else {
                System.out.println("Вы угадали букву!");
                System.out.println(SetOfConstants.word + emptyWord);
                System.out.println(SetOfConstants.numberOfMistakes + Math.abs(counterOfMistakes - 6));
                if (!temp.toString().isEmpty()) {
                    System.out.println(SetOfConstants.noGuessedLetters + temp.substring(1));
                }
            }
        }
    }

    private static String getPictureForMistakes(int mistakes) {
        if (mistakes == 6) {
            return PicturesForMistakes.start;
        } else if (mistakes == 5) {
            return PicturesForMistakes.firstMistake;
        } else if (mistakes == 4) {
            return PicturesForMistakes.secondMistake;
        } else if (mistakes == 3) {
            return PicturesForMistakes.thirdMistake;
        } else if (mistakes == 2) {
            return PicturesForMistakes.fourthMistake;
        } else if (mistakes == 1) {
            return PicturesForMistakes.fifthMistake;
        }
        return null;
    }

    private static boolean checkIsOver(List<Character> emptyWord, String randomWord, int counterOfMistakes) {
        if (!emptyWord.contains('_')) {
            System.out.println("Вы выйграли!!!");
            System.out.println(SetOfConstants.word + randomWord);
            return true;
        }
        if (getPictureForMistakes(counterOfMistakes) != null) {
            System.out.println(getPictureForMistakes(counterOfMistakes));
            return false;
        } else {
            System.out.println("Вы проиграли!");
            System.out.println(SetOfConstants.word + randomWord);
            System.out.println(PicturesForMistakes.lastMistake);
            return true;
        }
    }
}
