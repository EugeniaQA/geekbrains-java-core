/**
 * Робот
 */
public class Robot implements IMovable {

    /**
     * Максимальная высота прыжка
     */
    private final double maxHeight = 5;
    /**
     * Максимальная дистанция забега
     */
    private final double maxDistance = 5000;

    @Override
    public String getName() {
        return "Робот";
    }

    @Override
    public boolean TryMove(Wall wall) {
        var success = wall.getHeight() <= this.maxHeight;
        System.out.printf("Робот. Попытка перепрыгнуть %s - %s%n", wall.getHeight(), success ? "успешно" : "не успешно");
        return success;
    }

    @Override
    public boolean TryMove(Runway runway) {
        var success = runway.getDistance() <= this.maxDistance;
        System.out.printf("Робот. Попытка пробежать %s - %s%n", runway.getDistance(), success ? "успешно" : "не успешно");
        return success;
    }
}
