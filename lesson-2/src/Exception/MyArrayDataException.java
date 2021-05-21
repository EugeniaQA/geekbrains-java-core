package Exception;

/**
 * Ошибка несоответствия массива указанным параметрам
 */
public class MyArrayDataException extends Exception {

    public MyArrayDataException(String message) {
        super(message);
    }

    public MyArrayDataException() {
        super("Array element must be integer");
    }
}