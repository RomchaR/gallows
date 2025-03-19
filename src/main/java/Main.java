import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Желаете начать новую игру?(да/нет): ");
        String input = scanner.nextLine();


        while (input.equalsIgnoreCase("да")) {
            String randomWord = Game.getRandomNoun();
            char[] randomArr = randomWord.toCharArray();
            String[] pointsOfRandomWord = new String[randomArr.length];
            Arrays.fill(pointsOfRandomWord, "_");
            gameOf(randomArr,randomWord,pointsOfRandomWord);
            System.out.print("Сыграть еще?(да/нет): ");
            input = scanner.nextLine();
        }


    }

    public static void gameOf(char[] arr, String randomWord, String[] points) {
        Scanner scanner = new Scanner(System.in);
        int counter = 6;
        int countMiss = 0;
        String temp = "";
        while (counter >= 0) {
            if(!Arrays.toString(points).contains("_")){
                System.out.println("Вы выйграли!!!");
                System.out.println("Слово: " + randomWord);
                return;
            }
            if(counter == 6) {
                System.out.println(Mistakes.start);
            }
            else if(counter == 5) {
                System.out.println(Mistakes.firstMis);
            }
            else if(counter == 4) {
                System.out.println(Mistakes.secondMis);
            }
            else if(counter == 3) {
                System.out.println(Mistakes.thirdMis);
            }
            else if(counter == 2) {
                System.out.println(Mistakes.fourthMis);
            }
            else if(counter == 1) {
                System.out.println(Mistakes.fifthMis);
            }else{
                System.out.println("Вы проиграли!");
                System.out.println("Слово: " + Arrays.toString(arr));
                System.out.println(Mistakes.lastMis);
                return;
            }
            System.out.print("Введите букву: ");
            String latter = scanner.nextLine();
            int changes = 0;

            ;
            for (int i = 0; i < randomWord.length(); i++) {
                if(arr[i] == latter.charAt(0)) {
                    changes++;
                    points[i] = latter;

                }
            }
            if(changes == 0) {
                countMiss++;
                temp = temp + "," + latter;
                System.out.println("Вы не угадали букву!");
                System.out.println("Слово: " + Arrays.toString(points));
                System.out.println("Колличество ошибок: " + countMiss);
                System.out.println("Неугаданные буквы: " + temp.substring(1));
                counter--;
            }else{
                System.out.println("Вы угадали букву!");
                System.out.println("Слово: " + Arrays.toString(points));
                System.out.println("Колличество ошибок: " + countMiss);
                System.out.println("Неугаданные буквы: " + temp.substring(1));

            }
        }
    }

}
