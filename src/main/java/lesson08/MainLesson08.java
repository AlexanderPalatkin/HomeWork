package lesson08;

public class MainLesson08 {

    public static void main(String[] args) {
        RunnableJumpable[] movements = new RunnableJumpable[6];
        movements[0] = new Human(200, 0.5);
        movements[1] = new Human(300, 1);
        movements[2] = new Cat(500, 1.5);
        movements[3] = new Cat(300, 2);
        movements[4] = new Robot(100, 0.5);
        movements[5] = new Robot(200, 0.2);

        Obstacle[] obstacles = new Obstacle[4];
        obstacles[0] = new Treadmill(100);
        obstacles[1] = new Treadmill(500);
        obstacles[2] = new Wall(0.2);
        obstacles[3] = new Wall(2);

        for (int i = 0; i < movements.length; i++) {
            System.out.println("Участник №" + (i + 1) + " приступает к прохождению препятствий");
            for (int j = 0; j < obstacles.length; j++) {
                if (obstacles[j].canBeAvoided(movements[i])) {
                    System.out.println("Препятствие " + (j + 1) + " преодолено");
                } else {
                    System.out.println("Участник №" + (i + 1) + " не смог пройти " + (j + 1) + " препятствие");
                    break;
                }
            }
        }
    }
}
