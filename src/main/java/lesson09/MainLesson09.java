package lesson09;

public class MainLesson09 {
    public static void main(String[] args) {
        String[][] stringArray = new String[4][4];
        int count = 1;
        for (int i = 0; i < stringArray.length; i++) {
            for (int j = 0; j < stringArray[i].length; j++) {
                stringArray[i][j] = String.valueOf(count);
//                stringArray[i][j] = "a";
                count++;
                System.out.print(stringArray[i][j] + " ");
            }
        }
        System.out.println();
        convertArray(stringArray);
    }

    public static void convertArray(String[][] array) {
        int[][] intArray = new int[4][4];
//        array[0][0] = "2";
//        array[0][1] = "3";
//        array[0][2] = "4";
        try {
            if (intArray.length != array.length) {
                throw new MyArraySizeException();
            }
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    intArray[i][j] = Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("В ячейке массива " + "[" + i + "][" + j + "]" + " не число");
                }
                sum += intArray[i][j];
                System.out.print(intArray[i][j] + " ");
            }
        }
        System.out.println();
        System.out.println(sum);
    }
}
