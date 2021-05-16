/**
 * Кот
 */
public class Cat implements IMovable {

    /**
     * Максимальная высота прыжка
     */
    private final double maxHeight = 2.0;
    /**
     * Максимальная дистанция забега
     */
    private final double maxDistance = 1000;

    @Override
    public String getName() {
        return "Кот";
    }

    @Override
    public boolean TryMove(Wall wall) {
        var success = wall.getHeight() <= this.maxHeight;
        System.out.printf("Кот. Попытка перепрыгнуть %s - %s%n", wall.getHeight(), success ? "успешно" : "не успешно");
        return success;
    }

    @Override
    public boolean TryMove(Runway runway) {
        var success = runway.getDistance() <= this.maxDistance;
        System.out.printf("Кот. Попытка пробежать %s - %s%n", runway.getDistance(), success ? "успешно" : "не успешно");
        return success;
    }
}
