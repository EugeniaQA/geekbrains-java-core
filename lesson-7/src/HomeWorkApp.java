import java.io.IOException;

import AccuWeather.Models.Forecasts.v1.Daily;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HomeWorkApp {

    public static void main(String[] args){
        // Экземпляр класса OkHttpClient выполняет всю работу по созданию и отправке запросов
        OkHttpClient client = new OkHttpClient();

        // Экземпляр класса Request создается через Builder (см. паттерн проектирования "Строитель")
        // Код города Санкт-Петербург (295212) получен по запросу:
        // http://dataservice.accuweather.com/locations/v1/cities/ru/search.json?apikey=gAwJGM2Nas7v737TazCa6OvEcPjoOV1M&q=saint petersburg
        Request request = new Request.Builder()
                .url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=gAwJGM2Nas7v737TazCa6OvEcPjoOV1M&language=ru-ru&details=true&metric=true")
                .build();

        try (Response response = client.newCall(request).execute()) {
            String body = response.body().string();

            printPrettifyJson(body);
            printMetadata(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void printMetadata(Response response) {
        System.out.println(response.code());
        System.out.println(response.headers());
        System.out.println(response.isRedirect());
        System.out.println(response.isSuccessful());
        System.out.println(response.protocol());
        System.out.println(response.receivedResponseAtMillis());
    }

    private static void printPrettifyJson(String body) {
        JsonElement element = JsonParser.parseString(body);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        var weatherInfo = gson.fromJson(element, Daily.class);

        System.out.println("Погода в Санкт-Петербурге нв ближайшие 5 дней");
        System.out.println(weatherInfo);
    }
}