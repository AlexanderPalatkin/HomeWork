package lesson06;

public class MainLesson06 {
    public static void main(String[] args) {
        Animal dog1 = new Dog("Шарик");
        Animal dog2 = new Dog("Бобик");
        Animal cat1 = new Cat("Барсик");
        Animal cat2 = new Cat("Мурзик");

        dog1.run(1000);
        dog2.run(400);
        dog1.swim(10);
        dog2.swim(15);
        cat1.run(100);
        cat2.run(300);
        cat1.swim(50);

        System.out.println(Animal.count);


    }
}
