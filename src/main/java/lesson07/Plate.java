package lesson07;

public class Plate {


    private int foodCount;

    public Plate(int foodCount) {
        this.foodCount = foodCount;
    }


    public void printInfo() {
        System.out.println("Еды в миске: " + foodCount);
    }

    public void decreaseFood(int foodCount) {
        this.foodCount -= foodCount;
    }

    public int getFoodCount() {
        return foodCount;
    }
}
