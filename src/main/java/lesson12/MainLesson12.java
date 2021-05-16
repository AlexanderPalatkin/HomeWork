package lesson12;

public class MainLesson12 {
    static final int SIZE = 10000000;
    static final int H = SIZE / 2;

    public static void main(String[] args) {

        runArrayFirst();
        runArrayTwo();
    }

    public static float[] compute(float[] arr, int offset) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] *
                    Math.sin(0.2f + (i + offset) / 5) *
                    Math.cos(0.2f + (i + offset) / 5) *
                    Math.cos(0.4f + (i + offset) / 2));
        return arr;
    }

    private static void runArrayFirst() {
        float[] arr = new float[SIZE];
        for (float i : arr) {
            i = 1.0f;
        }
        long a = System.currentTimeMillis();
        compute(arr, 0);
        System.out.println(System.currentTimeMillis() - a);
    }

    private static void runArrayTwo() {
        float[] arr = new float[SIZE];
        for (float i : arr) {
            i = 1.0f;
        }

        long a = System.currentTimeMillis();

        float[] a1 = new float[H];
        float[] a2 = new float[H];

        System.arraycopy(arr, 0, a1, 0, H);
        System.arraycopy(arr, H, a2, 0, H);

        Thread firstThread = new Thread(() -> {
            compute(a1, 0);
        });
        Thread secondThread = new Thread(() -> {
            compute(a2, H);
        });

        firstThread.start();
        secondThread.start();

        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr, 0, H);
        System.arraycopy(a2, 0, arr, H, H);

        System.out.println(System.currentTimeMillis() - a);
    }


}
