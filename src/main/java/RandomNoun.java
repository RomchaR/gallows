import java.util.List;
import java.util.Random;

public class RandomNoun {

    private static final List<String> nouns = List.of(
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

    private static final Random random = new Random();

    public String getRandomNoun() {
        return nouns.get(random.nextInt(nouns.size()));
    }
}
