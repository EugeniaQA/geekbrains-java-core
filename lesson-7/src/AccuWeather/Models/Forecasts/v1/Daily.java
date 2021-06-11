package AccuWeather.Models.Forecasts.v1;

/**
 * Погода на несколько дней
 */
public class Daily {
    private Headline Headline;
    private DailyForecastsItem[] DailyForecasts;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Важная информация! " + Headline + "\n");
        for (var dayForecasts: DailyForecasts) {
            builder.append("--------------------------------------------\n");
            builder.append(dayForecasts);
        }

        return builder.toString();
    }
}
