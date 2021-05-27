package Tasks;

import org.jetbrains.annotations.Contract;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Класс выполнения первого задания
 */
public class Task2 implements ITask {

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
                "Иванов",
                "+7-923-777-88-99",
                "Сидоров",
                "+7-913-444-55-66",
                "Петров",
                "+7-999-888-77-66",
                "Сидоров",
                "+7-913-444-55-67",
                "Иванов",
                "+7-923-777-88-00",
                "Сидоров",
                "+7-913-444-55-68"
        };
    }

    /**
     * Метод обработки входных данных
     * @param inputData
     * @return
     */
    @Contract(pure = true)
    private Phonebook convert(String[] inputData) {
        var result = new Phonebook();
        for (var i = 0; i < inputData.length; i += 2) {
            result.add(inputData[i], inputData[i+1]);
        }

        return result;
    }

    /**
     * Метод вывода данных
     * @param data
     * @return
     */
    private static void printData(Phonebook data) {
        for (var key : data.getSurnames()) {
            System.out.println(key + ":\t" + data.get(key));
        }
    }

    /**
     * Класс Телефонный справочник
     */
    public class Phonebook {
        private HashMap<String, HashSet<String>> _phonebook;

        public Phonebook() {
            _phonebook = new HashMap<String, HashSet<String>>();
        }

        /**
         * Добавление номера телефона в справочник
         * @param surname фамилия
         * @param phone телефон
         */
        public void add(String surname, String phone) {
            if (!_phonebook.containsKey(surname)) {
                _phonebook.put(surname, new HashSet<String>());
            }
            _phonebook.get(surname).add(phone);
        }

        /**
         * Получение номеров телефонов по фамилии
         * @param surname фамилия
         * @return список номеров
         */
        public Set<String> get(String surname) {
            if (_phonebook.containsKey(surname)) {
                return _phonebook.get(surname);
            }

            return new HashSet<String>();
        }

        /**
         * Получение всех фамилий
         * @return список фамилий
         */
        protected Set<String> getSurnames() {
            return _phonebook.keySet();
        }
    }
}
