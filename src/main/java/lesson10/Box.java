package lesson10;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit>{
    ArrayList<T> box;

    public Box(T... fruits) {
        box = new ArrayList<>(Arrays.asList(fruits));
    }

    public void addFruit(T fruit) {
        box.add(fruit);
    }

    public float getWeight() {
        float totalWeight = 0.0f;
        for (T t : box) {
            totalWeight = totalWeight + t.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box<? extends Fruit> boxWithSomething) {
        return Math.abs(getWeight() - boxWithSomething.getWeight()) < 0.0001f;
    }

    public void replaceFruitsToAnotherBox(Box<T> anotherBox) {
        anotherBox.box.addAll(this.box);
        this.box.clear();
    }
}
