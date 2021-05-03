package lesson08;

public class Human implements RunnableJumpable {

    private int length;
    private double height;

    public Human(int length, double height) {
        this.length = length;
        this.height = height;
    }

    @Override
    public boolean run(int distance) {
        return (distance <= length);
    }

    @Override
    public boolean jump(double distance) {
        return (distance <= height);
    }
}
