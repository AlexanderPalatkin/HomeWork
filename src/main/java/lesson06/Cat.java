package lesson06;

public class Cat extends Animal{
    private int runLength = 200;
    private String name;

    public Cat(String name) {
        super();
        this.name = name;
    }

    @Override
    void run(int length) {
        if(length <= runLength) {
            System.out.println("Кот " + name + " пробежал " + length + "м.");
        } else {
            System.out.println("Кот " + name + " не пробежал " + length + "м.");
        }
    }

    @Override
    void swim(int length) {
        System.out.println("Котик не любит плавать");
    }
}
