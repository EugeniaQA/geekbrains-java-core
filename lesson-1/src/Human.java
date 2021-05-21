/**
 * Человек
 */
public class Human implements IMovable {

    /**
     * Максимальная высота прыжка
     */
    private final double maxHeight = 2.5;
    /**
     * Максимальная дистанция забега
     */
    private final double maxDistance = 3000;

    @Override
    public String getName() {
        return "Человек";
    }

    @Override
    public boolean TryMove(Wall wall) {
        var success = wall.getHeight() <= this.maxHeight;
        System.out.printf("Человек. Попытка перепрыгнуть %s - %s%n", wall.getHeight(), success ? "успешно" : "не успешно");
        return success;
    }

    @Override
    public boolean TryMove(Runway runway) {
        var success = runway.getDistance() <= this.maxDistance;
        System.out.printf("Человек. Попытка пробежать %s - %s%n", runway.getDistance(), success ? "успешно" : "не успешно");
        return success;
    }
}
