package lesson10;

import java.util.Arrays;
import java.util.List;

public class MainLesson10 {
    public static void main(String[] args) {

        // Первая задача
        Integer[] arr = {5, 8, 20, 13, 19, 24};
        swap(arr, 3, 4);
        System.out.println(Arrays.toString(arr));

        // Третья задача
        Box<Apple> boxWithApple = new Box<>(new Apple(), new Apple(), new Apple());
        Box<Orange> boxWithOranges = new Box<>(new Orange(), new Orange());
        Box<Orange> anotherBoxWithOranges = new Box<>(new Orange());
        boxWithOranges.addFruit(new Orange());
        System.out.println("A box of apples weighs " + boxWithApple.getWeight());
        System.out.println("A box of oranges weight " + boxWithOranges.getWeight());
        System.out.println("A box of oranges weight " + anotherBoxWithOranges.getWeight());
        System.out.println(boxWithApple.compare(boxWithOranges));
        boxWithOranges.replaceFruitsToAnotherBox(anotherBoxWithOranges);
        System.out.println("A box of oranges weight " + boxWithOranges.getWeight());
        System.out.println("A another box of oranges weight " + anotherBoxWithOranges.getWeight());
    }

    //Первая задача: swap элементов массива
    private static <T> void swap(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
