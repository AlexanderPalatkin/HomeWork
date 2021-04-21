package lesson02;

import java.util.Arrays;

public class MainLesson02 {
    public static void main(String[] args) {
//        exercise 1
        int[] arr1 = {1, 1, 0, 1, 0, 1, 1, 0};
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 0) {
                arr1[i] = 1;
            } else arr1[i] = 0;
        }
//        check exercise 1
        System.out.println(Arrays.toString(arr1));

//        exercise 2
        int[] arr2 = new int[8];
        int count = 0;
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = count;
            count += 3;
        }
//        check exercise 2
        System.out.println(Arrays.toString(arr2));

//        exercise 3
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) arr3[i] *= 2;
        }
//        check exercise 3
        System.out.println(Arrays.toString(arr3));

//        exercise 4
        int[][] arr4 = new int[7][7];
        for (int i = 0; i < arr4.length; i++) {
            arr4[i][i] = 1;
            arr4[i][arr4.length - 1 - i] = 1;
        }
//        check exercise 4
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                System.out.print(arr4[i][j] + " ");
            }
            System.out.println();
        }

//        exercise 5
        int[] arr5 = {1, 5, 8, 4, -12, 0, 7};
        int minValue = arr5[0];
        int maxValue = arr5[0];
        for (int i : arr5) {
            if (i < minValue) {
                minValue = i;
            }
            if (i > maxValue) {
                maxValue = i;
            }
        }
//        check exercise 5
        System.out.println("Минимальное значение: " + minValue);
        System.out.println("Максимальное значение: " + maxValue);

//        check exercise 6
        int[] arr6 = {1, 2, 3, 4, 2};
        System.out.println(checkBalance(arr6));

//        check exercise 7
        int[] arr7 = {1, 2, 3, 4, 5, 6, 7};
        swapArray(arr7, 2);
        System.out.println(Arrays.toString(arr7));

    }

    //        exercise 6
    public static boolean checkBalance(int[] arr) {
        int leftSum;
        int rightSum;
        for (int i = 0; i < arr.length; i++) {
            leftSum = 0;
            rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }
            for (int j = i; j < arr.length; j++) {
                rightSum += arr[j];
            }
            if (leftSum == rightSum) {
                return true;
            }
        }
        return false;
    }

    //        exercise 7
    public static void swapArray(int[] arr, int n) {
        int swap = 0;
        if (n > 0) {
            while (n >= 1) {
                for (int i = arr.length - 1; i > 0; i--) {
                    swap = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = swap;
                }
                n--;
            }
        }
        if (n < 0) {
            while (n < 0) {
                for (int i = 0; i < arr.length - 1; i++) {
                    swap = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = swap;
                }
                n++;
            }
        }
    }
}
