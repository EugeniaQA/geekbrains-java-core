import Exception.*;
import org.javatuples.Pair;

public class HomeWorkApp {

    public static void main(String[] args){
        String[][] input = new String[][] {
                {"0", "12", "14", "15"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "o"},
                {"1", "1", "1", "1"}
        };

        try {
            System.out.println("Начало процесса");

            var sum = sumArrayElements(input);

            System.out.println("Результат: " + sum);
        } catch (MyArraySizeException myArraySizeException) {
            System.out.println("MyArraySizeException: " + myArraySizeException.getMessage());
        } catch (MyArrayDataException myArrayDataException) {
            System.out.println("MyArrayDataException: " + myArrayDataException.getMessage());
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        } finally {
            System.out.println("Завершение процесса");
        }
    }

    /**
     * Метод суммирования элементов массива
     * @param array
     * @return
     */
    private static long sumArrayElements(String[][] array) throws MyArraySizeException, MyArrayDataException {
        checkArraySize(array);
        return sumArray(array);
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
    private static long sumArray(String[][] array) throws MyArrayDataException {
        long result = 0;
        for (var i = 0; i < array.length; i++) {
            for (var j = 0; j < array[i].length; j++) {
                var temp = tryParseInt(array[i][j]);
                if (!temp.getValue0()) {
                    throw new MyArrayDataException(i, j);
                }
                result += temp.getValue1();
            }
        }
        return result;
    }

    /**
     * Безопасный парсинг строки
     * @param value
     * @return
     */
    private static Pair<Boolean, Integer> tryParseInt(String value) {
        try {
            var result = Integer.parseInt(value);
            return new Pair(true, result);
        } catch (NumberFormatException e) {
            return new Pair(false, 0);
        }
    }
}

