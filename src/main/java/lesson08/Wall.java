package lesson08;

public class Wall implements Obstacle {
    private double height;

    public Wall(double height) {
        this.height = height;
    }

    @Override
    public boolean canBeAvoided(RunnableJumpable movement) {
        return movement.jump(height);
    }
}
