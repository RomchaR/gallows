import java.util.Set;

public class SetOfConstants {
    private static final Set<Character> alphabet = Set.of('А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И',
            'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ',
            'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я');
    public static final String word = "Слово: ";
    public static final String incorrectInput = "Некорректный ввод! Введите букву: ";
    public static final String numberOfMistakes = "Количество ошибок: ";
    public static final String unguessedLetters = "Неугаданные буквы: ";
    public static final String letter = "Буква: ";

    public static boolean containsInAlphabet(String input) {
        return alphabet.contains(input.toUpperCase().charAt(0));
    }
}
