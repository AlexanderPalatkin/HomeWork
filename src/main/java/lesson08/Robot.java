package lesson08;

public class Robot implements RunnableJumpable {

    private int length;
    private double height;

    public Robot(int length, double height) {
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
