/**
 * Стена
 */
public class Wall implements IObstacle {
    private double height;

    /**
     * Конструктор
     * @param height
     */
    public Wall(double height) {
        this.height = height;
    }

    /**
     * Высота стены
     * @return
     */
    public double getHeight() {
        return this.height;
    }
}
