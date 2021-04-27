package lesson07;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat("Martin");
        Plate plate = new Plate(100);

        plate.printInfo();

        while (plate.getFoodCount() > 0) {
            cat.eat(plate);
            plate.printInfo();
            Thread.sleep(3000);

            //метод котики голодают
        }

    }

}
