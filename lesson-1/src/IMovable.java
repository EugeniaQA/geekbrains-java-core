/**
 * Интерфейс описания подвижных сущностей
 */
public interface IMovable {
    /**
     * Получение имени сущности
     * @return
     */
    String getName();

    /**
     * Попытка перепрыгнуть стену
     * @param wall
     * @return
     */
    boolean TryMove(Wall wall);

    /**
     * Попытка пробежать дорожку
     * @param runway
     * @return
     */
    boolean TryMove(Runway runway);
}
