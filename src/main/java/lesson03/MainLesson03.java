package lesson03;

import java.util.Random;
import java.util.Scanner;

public class MainLesson03 {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
//        Зачача: 1
        final int MAX_VALUE = 10;
        int randomNumber = random.nextInt(MAX_VALUE);
        int countSize = 3;
        System.out.println("Угадайте загаданное число от 0 до " + MAX_VALUE + ", у вас 3 попытки!");
        for (int i = 0; i < countSize; i++) {
            int a = scanner.nextInt();
            if (a > 10 || a < 0) {
                System.out.println("Загаданное число от 0 до " + MAX_VALUE + "!");
            } else if (a == randomNumber) {
                System.out.println("Вы угадали! Поздравляю.");
                if (continueGame(countSize)) {
                    randomNumber = random.nextInt(MAX_VALUE);
                    i = -1;
                } else break;
            } else if (a < randomNumber) {
                System.out.println("Не угадали, загаданное число больше");
            } else {
                System.out.println("Не угадали, загаданное число меньше");
            }
            if (i + 1 == 3) {
                boolean reGame = continueGame(countSize);
                if (reGame) {
                    randomNumber = random.nextInt(10);
                    i = -1;
                } else break;
            }
        }

//        Задача: 2
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String randomWord = words[random.nextInt(words.length - 1)]; // загаданное слово
        System.out.println("Угадайте загаданное слово, подсказка: Это плод растения!");
        System.out.println(randomWord);
        final int MAX_ANSWER_LENGTH = 15; // максимальная длина ответа
        String askWord = scanner.nextLine(); // ответ игрока
        boolean goOn = true;
        while (goOn) {
            askWord = scanner.nextLine();
            String chekAnswer = checkEqualWords(randomWord, askWord, MAX_ANSWER_LENGTH);
            if (chekAnswer.equalsIgnoreCase(askWord)) {
                System.out.println("Вы угадали! Это слово: " + chekAnswer);
                goOn = false;
            } else {
                System.out.println("Вы не угадали, попробуйте снова. Угаданные буквы: " + chekAnswer);
            }
        }
        scanner.close();
    }

    //    Метод для первой задачи. Рестарт или завершение игры.
    public static boolean continueGame(int countSize) {
        System.out.println("Хотите сыграть еще раз? Y/N?");
        String answer = scanner.next();
        if (answer.equalsIgnoreCase("Y")) {
            System.out.println("Угадайте другое загаданное число от 0 до 10, у вас " + countSize + " попытки!");
            return true;
        } else if (answer.equalsIgnoreCase("N")) {
            System.out.println("Досвидули!");
            return false;
        } else {
            System.out.println("Кажется, ты устал, отдохни");
            return false;
        }
    }

    //    Метод для второй задачи, проверка на равенство 2 строк c заданной длиной
    public static String checkEqualWords(String randomWord, String askWord, int answerLength) {
        char[] answer = new char[answerLength];
        if (randomWord.equalsIgnoreCase(askWord)) {
            return randomWord;
        } else {
            for (int i = 0; i < answerLength; i++) {
                if (i > (randomWord.length() - 1) || i > (askWord.length() - 1)) {
                    answer[i] = '#';
                } else if (randomWord.charAt(i) == askWord.charAt(i)) {
                    answer[i] = randomWord.charAt(i);
                } else {
                    answer[i] = '#';
                }
            }
            return new String(answer);
        }
    }
}
