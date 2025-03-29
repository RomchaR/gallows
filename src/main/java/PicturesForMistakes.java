import java.util.Map;

public class PicturesForMistakes {

    public static final String START =
            "                _________\n" +
                    "                |       |\n" +
                    "                |       |\n" +
                    "                |       |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "           ----------------";

    public static final String FIRST =
            "                _________\n" +
                    "                |       |\n" +
                    "                |       |\n" +
                    "                |       |\n" +
                    "                O       |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "           ----------------";

    public static final String SECOND =
            "                _________\n" +
                    "                |       |\n" +
                    "                |       |\n" +
                    "                |       |\n" +
                    "                O       |\n" +
                    "                |       |\n" +
                    "                |       |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "           ----------------";

    public static final String THIRD =
            "                _________\n" +
                    "                |       |\n" +
                    "                |       |\n" +
                    "                |       |\n" +
                    "                O       |\n" +
                    "               \\|       |\n" +
                    "                |       |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "           ----------------";

    public static final String FOURTH =
            "                _________\n" +
                    "                |       |\n" +
                    "                |       |\n" +
                    "                |       |\n" +
                    "                O       |\n" +
                    "               \\|/      |\n" +
                    "                |       |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "           ----------------";

    public static final String FIFTH =
            "                _________\n" +
                    "                |       |\n" +
                    "                |       |\n" +
                    "                |       |\n" +
                    "                O       |\n" +
                    "               \\|/      |\n" +
                    "                |       |\n" +
                    "               /        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "           ----------------";

    public static final String LAST =
            "                _________\n" +
                    "                |       |\n" +
                    "                |       |\n" +
                    "                |       |\n" +
                    "                O       |\n" +
                    "               \\|/      |\n" +
                    "                |       |\n" +
                    "               / \\      |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "                        |\n" +
                    "           ----------------";

    private static final Map<Integer, String> mapOfPictures = Map.of(
            0, START,
            1, FIRST,
            2, SECOND,
            3, THIRD,
            4, FOURTH,
            5, FIFTH,
            6, LAST
    );

    public static String get(Integer orderOfMistakes) {
        return mapOfPictures.get(orderOfMistakes);
    }

}
