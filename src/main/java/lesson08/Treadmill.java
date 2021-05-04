package lesson08;

public class Treadmill implements Obstacle {

    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    @Override
    public boolean canBeAvoided(RunnableJumpable movement) {
        return movement.run(length);
    }
}
