package lesson04;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static final int SIZE = 7;
    static final int WIN_SCORE = 4;

    private static final String EMPTY = " ";
    private static final String HEADER_FIRST_SYMBOL = "♥";

    static final char DOT_EMPTY = '•';
    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = 'O';

    static final char[][] MAP = new char[SIZE][SIZE];
    static final Scanner in = new Scanner(System.in);
    static final Random random = new Random();
    static int turnsCount = 0;


    public static void main(String[] args) {

        turnGame();
    }

    private static void turnGame() {
        do {
            initMap();

            printMap();

            playGame();

            endGame();

        } while (false);
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printHeaderMap();

        printBodyMap();
    }

    private static void printHeaderMap() {
        System.out.print(HEADER_FIRST_SYMBOL + EMPTY);
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }

    private static void printBodyMap() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + EMPTY);
            }
            System.out.println();
        }
    }

    private static void printMapNumber(int i) {
        System.out.print(i + 1 + EMPTY);
    }


    private static void playGame() {

        do {
            humanTurn();
            printMap();
            if (checkEnd(DOT_HUMAN)) {
                break;
            }

            aiTurn();
            printMap();
            if (checkEnd(DOT_AI)) {
                break;
            }
        } while (true);

    }

    private static void humanTurn() {
        int rowNumber;
        int colNumber;
        boolean isInputValid;

        System.out.println("\nХод человека! Введите номера строки и столбца");
        do {
            rowNumber = -1;
            colNumber = -1;
            isInputValid = true;

            System.out.print("Строка: ");
            if (in.hasNextInt()) {
                rowNumber = in.nextInt() - 1;
            } else {
                processingIncorrectInput();
                isInputValid = false;
                continue;
            }

            System.out.print("Столбец: ");
            if (in.hasNextInt()) {
                colNumber = in.nextInt() - 1;
            } else {
                processingIncorrectInput();
                isInputValid = false;
            }
        } while (!(isInputValid && isHumanTurnValid(rowNumber, colNumber)));

        MAP[rowNumber][colNumber] = DOT_HUMAN;
        turnsCount++;
    }

    private static void processingIncorrectInput() {
        System.out.println("Ошибка ввода! Введите число в диапазоне игрового поля");
        in.next();
    }

    private static boolean isHumanTurnValid(int rowNumber, int colNumber) {
        if (!isNumberValid(rowNumber, colNumber)) {
            System.out.println("\nПроверьте значение строки и столбца");
            return false;
        }
        if (!isCellFree(rowNumber, colNumber)) {
            System.out.println("\nВы выбрали занятую ячейку");
            return false;
        }
        return true;
    }

    private static boolean isNumberValid(int rowNumber, int colNumber) {
        return rowNumber < SIZE && rowNumber >= 0 && colNumber < SIZE && colNumber >= 0;
    }

    private static boolean isCellFree(int rowNumber, int colNumber) {
        return MAP[rowNumber][colNumber] == DOT_EMPTY;
    }


    private static boolean checkEnd(char symbol) {

        if (checkWin(symbol, WIN_SCORE)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("Ура! Вы победили!");
            } else {
                System.out.println("Восстание близко... ИИ победил");
            }
            return true;
        }
        if (isMapFull()) {
            System.out.println("Ничья!");
            return true;
        }

        return false;
    }

    private static boolean isMapFull() {
        return turnsCount == SIZE * SIZE;
    }

    private static boolean checkWin(char symbol, int winScore) {
        //Проверка горизонтали и вертикали
        for (int i = 0; i < SIZE; i++) {
            int lineCount = 0;
            int lineMaxCount = 0;
            int columnCount = 0;
            int columnMaxCount = 0;
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == symbol) {
                    lineCount++;
                    if (lineCount > lineMaxCount) lineMaxCount = lineCount;
                } else {
                    lineCount = 0;
                }
                if (MAP[j][i] == symbol) {
                    columnCount++;
                    if (columnCount > columnMaxCount) columnMaxCount = columnCount;
                } else {
                    columnCount = 0;
                }
            }
            if (lineMaxCount == winScore || columnMaxCount == winScore) {
                return true;
            }
        }

        //Проверка диагоналей
        for (int i = 0; i <= SIZE - winScore; i++) {
            for (int j = 0; j <= SIZE - winScore; j++) {
                int leftSideCount = 0;
                int rightSideCount = 0;
                for (int offset = 0; offset < winScore; offset++) {
                    if (MAP[i + offset][i + offset] == symbol) {
                        leftSideCount++;
                    }
                    if (MAP[i + offset][j + (winScore - 1) - offset] == symbol) {
                        rightSideCount++;
                    }
                }
                if (leftSideCount == winScore || rightSideCount == winScore) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void aiTurn() {
        int rowNumber;
        int colNumber;

        System.out.println("\nХод компуктера");
        do {
            rowNumber = random.nextInt(SIZE);
            colNumber = random.nextInt(SIZE);
        } while (!isCellFree(rowNumber, colNumber));
        MAP[rowNumber][colNumber] = DOT_AI;
        turnsCount++;
    }

    private static void endGame() {
        System.exit(0);
    }
}

