import java.util.ArrayList;
import Exception.*;

public class HomeWorkApp {

    public static void main(String[] args) {

    }

    /**
     * Метод суммирования элементов массива
     * @param array
     * @return
     */
    private static int sumArrayElements(String[][] array) throws MyArraySizeException, MyArrayDataException {
        try {
            System.out.println("Начало процесса");
            checkArraySize(array);
            sumArrayElements(array);

        } catch (MyArraySizeException myArraySizeException) {
            System.out.println("MyArraySizeException: " + myArraySizeException.getMessage());
        } catch (MyArrayDataException myArrayDataException) {
            System.out.println("MyArrayDataException: " + myArrayDataException.getMessage());
        } catch (Exception ex) {
            System.out.println("MyArrayDataException: " + ex.getMessage());
        } finally {
            System.out.println("Завершение процесса");
        }
    }

    /**
     * Метод проверки размерности массива
     * @param array
     */
    private static void checkArraySize(String[][] array) throws MyArraySizeException {
        if (array.length != 4)
            throw new MyArraySizeException();

        if (array[0].length != 4)
            throw new MyArraySizeException();
    }

    /**
     * Метод суммирования элементов массива
     * @param array
     * @return
     */
    private static int sumArray(String[][] array) throws MyArrayDataException {
        for (var i = 0; i < array.length; i++) {
            for (var j = 0; j < array[i].length; j++) {

            }
        }

        throw new MyArrayDataException();
    }
}

