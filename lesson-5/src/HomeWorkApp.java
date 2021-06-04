import java.util.Arrays;

public class HomeWorkApp {

    public static void main(String[] args){
        var path = System.getProperty("java.class.path");

        var appData = new AppData();
        appData.LoadData(path + "/input.csv");

        System.out.println(String.join(";", appData.getHeader()));
        var data = appData.getData();
        for(var i = 0; i < data.length; i++) {
            var stringArray = Arrays
                    .stream(data[i])
                    .mapToObj(String::valueOf)
                    .toArray(String[]::new);
            System.out.println(String.join(";", stringArray));
        }

        appData.SaveDate(path + "/output.csv");
    }
}