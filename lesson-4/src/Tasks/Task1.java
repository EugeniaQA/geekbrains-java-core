package Tasks;

import org.jetbrains.annotations.Contract;

import java.util.HashMap;

/**
 * Класс выполнения первого задания
 */
public class Task1 implements ITask {

    public void run() {
        printData(
                convert(
                        getInputData()
                )
        );
    }

    /**
     * Входные данные
     * @return
     */
    @Contract(value = " -> new", pure = true)
    private static String[] getInputData() {
        return new String[] {
                "apple",
                "orange",
                "pineapple",
                "berry",
                "blueberry",
                "apple",
                "apple",
                "berry"
        };
    }

    /**
     * Метод обработки входных данных
     * @param inputData
     * @return
     */
    @Contract(value = " -> new", pure = true)
    private static HashMap<String, Integer> convert(String[] inputData) {
        var result = new HashMap<String, Integer>();
        for (var i = 0; i < inputData.length; i++) {
            if (result.containsKey(inputData[i])) {
                result.put(inputData[i], result.get(inputData[i]) + 1);
                continue;
            }

            result.put(inputData[i], 1);
        }

        return result;
    }

    /**
     * Метод вывода данных
     * @param data
     * @return
     */
    private static void printData(HashMap<String, Integer> data) {
        for (var key : data.keySet()) {
            System.out.println(key + ":\t" + data.get(key));
        }
    }
}
