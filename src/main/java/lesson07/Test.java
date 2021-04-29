package lesson07;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Sheldon");
        cats[1] = new Cat("Asty");
        cats[2] = new Cat("Martin");
        cats[3] = new Cat("Gin");
        cats[4] = new Cat("Jamal");
        Plate plate = new Plate(50);

        plate.printInfo();

        boolean feeding = true;

        while (feeding) {
            for (Cat cat : cats) {
                if (plate.getFoodCount() == 0) {
                    System.out.println("Введите количество еды, чтобы пополнить тарелку или введите \"0\", если не хотите");
                    if (scanner.hasNextInt()) {
                        int addFood = scanner.nextInt();
                        if (addFood == 0) {
                            System.out.println("Здоровее будут, до свидания!");
                            feeding = false;
                            break;
                        } else if (addFood > 0) {
                            plate.setFoodCount(addFood);
                        } else {
                            System.out.println("Мне нечего вам сказать, до свидания.");
                            feeding = false;
                            break;
                        }
                    } else {
                        System.out.println("Мне нечего вам сказать, до свидания.");
                        feeding = false;
                        break;
                    }
                } else if (cat.getSatiety() < cat.getMax_satiety()) {
                    cat.eat(plate);
                    plate.printInfo();
                    Thread.sleep(500);
                } else {
                    feeding = false;
                }
            }
            if (cats[cats.length - 1].getSatiety() == cats[cats.length - 1].getMax_satiety()) {
                System.out.println("Все котики сыты");
                break;
            }
        }

        for (Cat cat : cats) {
            System.out.println("У кота \"" + cat.getName() + "\" сытость заполнена на: " +
                    cat.getSatiety() + " из " + cat.getMax_satiety());
        }

    }

}
