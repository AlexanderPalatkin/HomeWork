package lesson07;

public class Plate {

    private int foodCount;

    public Plate(int foodCount) {
        this.foodCount = foodCount;
    }

    public void printInfo() {
        System.out.println("Еды в миске: " + foodCount);
    }

    public void addFood(int count) {
        this.foodCount = count;
    }

    public void decreaseFood(int foodCount) {
        if (this.foodCount - foodCount < 0) {
            this.foodCount = 0;
        } else {
            this.foodCount -= foodCount;
        }
    }

    public int getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;
    }
}
