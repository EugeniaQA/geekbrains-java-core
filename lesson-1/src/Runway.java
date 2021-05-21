/**
 * Дорожка
 */
public class Runway implements IObstacle {
    private double distance;

    /**
     * Конструктор
     * @param distance
     */
    public Runway(double distance) {
        this.distance = distance;
    }

    /**
     * Длина дорожки
     * @return
     */
    public double getDistance() {
        return this.distance;
    }
}
