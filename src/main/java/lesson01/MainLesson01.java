package lesson01;

public class MainLesson01 {
    // exercise 01
    public static void main(String[] args) {
        // exercise 02
        byte b = 1;
        short s = 2;
        int i = 3;
        long l = 4L;
        float f = 5.0f;
        double d = 6.0;
        char c = '7';
        boolean t = true;
        String str = "Hello";

        System.out.println(calculate(1, 2, 4, 2));
        System.out.println(checkRange(12, 22));
        checkNumb(5);
        System.out.println(checkNumbBool(4));
        welcomes("Александр");
        checkLeapYear(1161);

    }

    // exercise 03
    public static float calculate(float a, float b, float c, float d) {
        return (a * (b + (c / d)));
    }
    // exercise 04
    public static boolean checkRange(int a, int b) {
        if((a + b) >= 10 && (a + b) <= 20) {
            return true;
        }
        else return false;
    }
    // exercise 05
    public static void checkNumb(int a) {
        if (a >= 0) {
            System.out.println(a + " positive number");
        }
        else System.out.println(a + " negative number");
    }
    // exercise 06
    public static boolean checkNumbBool(int a) {
        if (a < 0) {
            return true;
        }
        else return false;
    }
    // exercise 07
    public static void welcomes(String name) {
        System.out.println("Привет, " + name + "!");
    }
    // exercise 08
    public static void checkLeapYear(int year) {
        if (year % 400 == 0) System.out.println(year + " - високосный год.");
        else if (year % 100 == 0) System.out.println(year + " - невисокосный год.");
        else if (year % 4 == 0) System.out.println(year + " - високосный год.");
        else System.out.println(year + " - невисокосный год.");
    }

}
