package lesson07;

import java.util.Random;

public class Cat {

    Random random = new Random();
    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    public void eat(Plate plate) {
        plate.decreaseFood(random.nextInt(4) + 3);
    }
}
