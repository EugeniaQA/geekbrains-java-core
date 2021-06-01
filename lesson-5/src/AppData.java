import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Класс загрузки и сохранения данных из csv-файлов
 */
public class AppData {
    private final String DELIMITER = ";";
    private String[] header;
    private int[][] data;

    public AppData() {
    }

    /**
     * Массив заголовков
     * @return
     */
    public String[] getHeader() {
        return header;
    }

    /**
     * Массив данных
     * @return
     */
    public int[][] getData() {
        return data;
    }

    /**
     * Загрузка данных из файла
     * @param filePath - путь до файла
     */
    public void LoadData(String filePath) {
        List<List<String>> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String str;
            var lineNum = 0;
            while ((str = reader.readLine()) != null) {
                var lineArray = str.split(DELIMITER);
                if (lineNum > 0) {
                    lines.add(Arrays.asList(lineArray));
                    continue;
                }
                InitHeader(lineArray);
                lineNum++;
            }

            InitData(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Сохранение данных в файл
     * @param filePath - путь до файла
     */
    public void SaveDate(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            SaveHeader(writer);
            SaveData(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void InitHeader(String[] lineArray) {
        header = new String[lineArray.length];
        for (var i = 0; i < lineArray.length; i++) {
            header[i] = lineArray[i];
        }
    }

    private void SaveHeader(BufferedWriter writer) throws IOException {
        writer.write(String.join(DELIMITER, header) + "\n");
    }

    private void InitData(List<List<String>> lines) {
        data = new int[lines.size()][];
        var i = 0;
        for (var line : lines) {
            data[i] = new int[line.size()];
            for (var j = 0; j < line.size(); j++) {
                data[i][j] = Integer.parseInt(line.get(j));
            }
            i++;
        }
    }

    private void SaveData(BufferedWriter writer) throws IOException {
        for (var i = 0; i < data.length; i++) {
            var stringArray = Arrays
                    .stream(data[i])
                    .mapToObj(String::valueOf)
                    .toArray(String[]::new);
            writer.write(String.join(DELIMITER, stringArray) + "\n");
        }
    }
}
