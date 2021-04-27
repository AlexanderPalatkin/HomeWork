package lesson06;

public class Dog extends Animal {
    private int runLength = 500;
    private int swimLength = 10;
    private String name;

    public Dog(String name) {
        super();
        this.name = name;
    }

    @Override
    void run(int length) {
        if(length <= runLength) {
            System.out.println("Собака " + name + " пробежала" + length + "м.");
        } else {
            System.out.println("Собака " + name + " не пробежала" + length + "м.");
        }
    }

    @Override
    void swim(int length) {
        if (length <= swimLength) {
            System.out.println("Собака " + name + " проплыла " + length + "м.");
        } else {
            System.out.println("Собака " + name + " утонула " + length + "м.");
        }
    }
}
