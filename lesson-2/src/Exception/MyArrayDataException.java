package Exception;

/**
 * Ошибка несоответствия элемента массива числовому значению
 */
public class MyArrayDataException extends Exception {

    public MyArrayDataException(String message) {
        super(message);
    }

    public MyArrayDataException(int row, int column) {
        super("Array element must be integer in [" + row + "," + column + ']');
    }
}