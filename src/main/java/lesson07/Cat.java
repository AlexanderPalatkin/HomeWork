package lesson07;

import java.util.Random;

public class Cat {

    Random random = new Random();

    private int max_satiety = 20;

    public int getMax_satiety() {
        return max_satiety;
    }

    private int satiety;

    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    public void eat(Plate plate) {

        if (satiety < max_satiety) {
            int count = 0;
            int randomNumb = random.nextInt(4) + 8;
            satiety += randomNumb;
            if (satiety > max_satiety){
                count = satiety - max_satiety;
                satiety -= count;
                plate.decreaseFood(randomNumb - count);
                System.out.println(name + " сыт");
            } else {
                plate.decreaseFood(randomNumb);
            }

        }

    }

    public int getSatiety() {
        return satiety;
    }

    public String getName() {
        return name;
    }
}
