package lesson13;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static CountDownLatch cdlReady;
    private static CountDownLatch cdlFinish;
    private static CyclicBarrier cb;
    private Race race;
    private int speed;
    private String name;
    static boolean isWon = false;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    static {
        cdlReady = MainClass.cdlReady;
        cdlFinish = MainClass.cdlFinish;
        cb = MainClass.cb;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            cdlReady.countDown();
            System.out.println(this.name + " готов");
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        cdlFinish.countDown();
        if (!isWon) {
            System.out.println(this.name + " - Победитель!");
            isWon = true;
        }

    }
}