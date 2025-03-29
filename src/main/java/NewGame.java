import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewGame {
    private final Scanner scanner;
    private final List<String> wordAsChar;
    private final String hiddenWord;
    private final StringBuilder temp = new StringBuilder();

    public NewGame(Scanner scanner,
                   String hiddenWord) {
        this.scanner = scanner;
        this.hiddenWord = hiddenWord;
        this.wordAsChar = List.of(hiddenWord.split(""));
    }

    public void startNewGame() {
        List<String> emptyWord = getEmptyWord();
        int counterOfMistakes = 6;

        while (counterOfMistakes >= 0) {
            if (checkIsOver(emptyWord, counterOfMistakes)) {
                return;
            }

            System.out.print(SetOfConstants.letter);
            String latter = scanner.nextLine();
            int changes = 0;

            while (latter.length() > 1 || !SetOfConstants.containsInAlphabet(latter)) {
                System.out.println(SetOfConstants.incorrectInput);
                latter = scanner.nextLine();
            }

            changes = getChangesForMistakes(latter, changes, emptyWord);
            counterOfMistakes = checkHiddenLatter(changes, counterOfMistakes, latter, emptyWord);
        }
    }

    private boolean checkIsOver(List<String> emptyWord, int counterOfMistakes) {
        if (!emptyWord.contains("_")) {
            System.out.println("Вы выйграли!!!");
            System.out.println(SetOfConstants.word + hiddenWord);
            return true;
        }
        if (counterOfMistakes <= 6 && counterOfMistakes > 0) {
            System.out.println(PicturesForMistakes.get(Math.abs(counterOfMistakes - 6)));
            return false;
        } else {
            System.out.println("Вы проиграли!");
            System.out.println(SetOfConstants.word + hiddenWord);
            System.out.println(PicturesForMistakes.LAST);
            return true;
        }
    }

    private List<String> getEmptyWord() {
        List<String> emptyWord = new ArrayList<>();
        for (int i = 0; i < wordAsChar.size(); i++) {
            emptyWord.add("_");
        }
        return emptyWord;
    }

    private int checkHiddenLatter(int changes, int counterOfMistakes, String latter, List<String> emptyWord) {
        if (changes == 0) {
            counterOfMistakes--;
            temp.append(",").append(latter);
            System.out.println("Вы не угадали букву!");
            System.out.println(SetOfConstants.word + emptyWord);
            System.out.println(SetOfConstants.numberOfMistakes + Math.abs(counterOfMistakes - 6));
            System.out.println(SetOfConstants.unguessedLetters + temp.substring(1));
        } else {
            System.out.println("Вы угадали букву!");
            System.out.println(SetOfConstants.word + emptyWord);
            System.out.println(SetOfConstants.numberOfMistakes + Math.abs(counterOfMistakes - 6));
            if (!temp.toString().isEmpty()) {
                System.out.println(SetOfConstants.unguessedLetters + temp.substring(1));
            }
        }
        return counterOfMistakes;
    }

    private int getChangesForMistakes(String latter, int changes, List<String> emptyWord) {
        for (int i = 0; i < wordAsChar.size(); i++) {
            if (wordAsChar.get(i).equals(latter.charAt(0) + "")) {
                changes++;
                emptyWord.set(i, wordAsChar.get(i));
            }
        }
        return changes;
    }
}
