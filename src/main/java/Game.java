import java.util.*;

public class Game {


    private final List<String> nouns = List.of(
            "яблоко", "машина", "дом", "стол", "дерево", "река", "собака", "кот", "птица", "небо",
            "жизнь", "планета", "книга", "солнце", "звезда", "книга", "облако", "туча", "друг", "папа",
            "мама", "учитель", "работа", "песок", "лес", "горе", "свет", "хлеб", "город", "страна",
            "день", "ночь", "время", "счастье", "любовь", "работа", "улыбка", "смеяться", "покой", "воля",
            "сила", "смешарики", "друзья", "волк", "скала", "камень", "обувь", "пальто", "шляпа",
            "молоко", "птица", "рыба", "цветок", "трава", "лес", "картина", "штат", "транспорт", "животное",
            "акула", "живопись", "компьютер", "интернет", "автомобиль", "телефон", "новости", "картинка", "письмо",
            "глобус", "зеркало", "письмо", "снаряд", "ракета", "стрела", "ткань", "песня", "история", "сказка",
            "фильм", "магазин", "дерево", "страшилка", "шарик", "пуля", "губка", "телевизор", "сериал",
            "пункт", "свитер", "подушка", "зонт", "гитара", "тетрис", "костюм", "платок", "медаль", "отель",
            "портфель", "сумка", "работа", "результат", "вопрос", "подарок", "штучка", "мозаика", "цветок");

    private final Random rand = new Random();

    private String getRandomNoun() {
        return nouns.get(rand.nextInt(nouns.size()));
    }

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
            String randomWord = getRandomNoun();
            List<Character> randomArr = new ArrayList<>();
            for (char c : randomWord.toCharArray()) {
                randomArr.add(c);
            }
            List<Character> pointsOfRandomWord = new ArrayList<>();
            for (int i = 0; i < randomArr.size(); i++) {
                pointsOfRandomWord.add('_');
            }
            sessionOfTheGame(randomArr, randomWord, pointsOfRandomWord);
            System.out.print("Сыграть еще?(да/нет): ");
            input = scanner.nextLine();

            while (!input.equalsIgnoreCase("нет") && !input.equalsIgnoreCase("да")) {
                System.out.print("Некорректный ввод! Введите (да/нет): ");
                input = scanner.nextLine();
            }
        }
        scanner.close();
    }

    public static void sessionOfTheGame(List<Character> arr, String randomWord, List<Character> points) {
        Scanner scanner = new Scanner(System.in);
        int counter = 6;
        int countMiss = 0;
        StringBuilder temp = new StringBuilder();
        List<Character> tempArr = List.of('А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я');
        while (counter >= 0) {
            if (!points.contains('_')) {
                System.out.println("Вы выйграли!!!");
                System.out.println("Слово: " + randomWord);
                return;
            }
            if (counter == 6) {
                System.out.println(PicturesForMistakes.start);
            } else if (counter == 5) {
                System.out.println(PicturesForMistakes.firstMis);
            } else if (counter == 4) {
                System.out.println(PicturesForMistakes.secondMis);
            } else if (counter == 3) {
                System.out.println(PicturesForMistakes.thirdMis);
            } else if (counter == 2) {
                System.out.println(PicturesForMistakes.fourthMis);
            } else if (counter == 1) {
                System.out.println(PicturesForMistakes.fifthMis);
            } else {
                System.out.println("Вы проиграли!");
                System.out.println("Слово: " + randomWord);
                System.out.println(PicturesForMistakes.lastMis);
                return;
            }

            System.out.print("Введите букву: ");
            String latter = scanner.nextLine();
            int changes = 0;

            while (latter.length() > 1 || !tempArr.contains(latter.toUpperCase().charAt(0))) {
                System.out.println("Некорректный ввод! Введите букву: ");
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
                System.out.println("Слово: " + points);
                System.out.println("Колличество ошибок: " + countMiss);
                System.out.println("Неугаданные буквы: " + temp.substring(1));
                counter--;
            } else {
                System.out.println("Вы угадали букву!");
                System.out.println("Слово: " + points);
                System.out.println("Колличество ошибок: " + countMiss);
                if (!temp.toString().isEmpty()) {
                    System.out.println("Неугаданные буквы: " + temp.substring(1));
                }


            }
        }
        scanner.close();
    }


}
