package Exception;

/**
 * Ошибка несоответствия массива указанным параметрам
 */
public class MyArraySizeException extends Exception {

    public MyArraySizeException(String message) {
        super(message);
    }

    public MyArraySizeException() {
        super("Array must have 4x4 size");
    }
}
