package homeWorkLesson8;

import com.fasterxml.jackson.databind.ObjectMapper;
import homeWorkLesson8.entity.Weather;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AccuweatherModel implements WeatherModel {
    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAY = "5day";
//    private static final String API_KEY = "wwhPw3tNJSuUFX2d6X5YN6eKWAy5aWes";
//    private static final String API_KEY = "PQVwhz4wkZt6Zcqd4uGmX2u2tGYMgDYH";
    private static final String API_KEY = "E6Ufpt2OrzI6v0BtEnUEx0xGw7RIydZn";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LANGUAGE = "ru";
    private static final String LANGUAGE_QUERY_PARAM = "language";
    private static final String METRIC = "true";
    private static final String METRIC_QUERY_PARAM = "metric";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final homeWorkLesson8.DataBaseRepository dataBaseRepository = new DataBaseRepository();

    public void getWeather(String selectedCity, Period period) throws IOException {
        switch (period) {
            case NOW:
                HttpUrl httpUrlOneDay = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(LANGUAGE_QUERY_PARAM, LANGUAGE)
                        .addQueryParameter(METRIC_QUERY_PARAM, METRIC)
                        .build();

                Request requestOneDay = new Request.Builder()
                        .url(httpUrlOneDay)
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(requestOneDay).execute();
                String weatherResponseOneDay = oneDayForecastResponse.body().string();

                String dateOneDay = objectMapper.readTree(weatherResponseOneDay).get("DailyForecasts")
                        .get(0).at("/Date").asText();
                String metricOneDay = objectMapper.readTree(weatherResponseOneDay).get("DailyForecasts")
                        .get(0).at("/Temperature/Minimum/Unit").asText();
                Double tempMinOneDay =
                        Double.valueOf(objectMapper.readTree(weatherResponseOneDay).get("DailyForecasts")
                                .get(0).at("/Temperature/Minimum/Value").asText());
                Double tempMaxOneDay =
                        Double.valueOf(objectMapper.readTree(weatherResponseOneDay).get("DailyForecasts")
                                .get(0).at("/Temperature/Maximum/Value").asText());
                String iconPhraseDayOneDay =
                        objectMapper.readTree(weatherResponseOneDay).get("DailyForecasts")
                                .get(0).at("/Day/IconPhrase").asText();
                String iconPhraseNightOneDay =
                        objectMapper.readTree(weatherResponseOneDay).get("DailyForecasts")
                                .get(0).at("/Night/IconPhrase").asText();

                System.out.println("Погода в городе "  + selectedCity + " на: " + dateOneDay);
                System.out.println("Минимальная температура: " + tempMinOneDay + " " + metricOneDay + ". " +
                        "Максимальная температура: " + tempMaxOneDay + " " + metricOneDay + ".");
                System.out.println("Днём: " + iconPhraseDayOneDay + ". Ночью: " + iconPhraseNightOneDay + ".");

                try {
                    dataBaseRepository.saveWeatherToDataBase(new Weather(selectedCity,
                            dateOneDay, metricOneDay, iconPhraseDayOneDay, iconPhraseNightOneDay,
                            tempMinOneDay, tempMaxOneDay));
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                break;

            case FIVE_DAYS:
                HttpUrl httpUrlFiveDay = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(LANGUAGE_QUERY_PARAM, LANGUAGE)
                        .addQueryParameter(METRIC_QUERY_PARAM, METRIC)
                        .build();

                Request requestFiveDay = new Request.Builder()
                        .url(httpUrlFiveDay)
                        .build();

                Response oneDayForecastResponseFiveDay = okHttpClient.newCall(requestFiveDay).execute();
                String weatherResponseFiveDay = oneDayForecastResponseFiveDay.body().string();

                for (int i = 0; i < 5; i++){
                    String dateFiveDay = objectMapper.readTree(weatherResponseFiveDay).get("DailyForecasts")
                            .get(i).at("/Date").asText();
                    String metricFiveDay = objectMapper.readTree(weatherResponseFiveDay).get("DailyForecasts")
                            .get(i).at("/Temperature/Minimum/Unit").asText();
                    Double tempMinFiveDay = Double.valueOf(objectMapper.readTree(weatherResponseFiveDay).get("DailyForecasts")
                            .get(i).at("/Temperature/Minimum/Value").asText());
                    Double tempMaxFiveDay = Double.valueOf(objectMapper.readTree(weatherResponseFiveDay).get("DailyForecasts")
                            .get(i).at("/Temperature/Maximum/Value").asText());
                    String iconPhraseDayFiveDay = objectMapper.readTree(weatherResponseFiveDay).get("DailyForecasts")
                            .get(i).at("/Day/IconPhrase").asText();
                    String iconPhraseNightFiveDay = objectMapper.readTree(weatherResponseFiveDay).get("DailyForecasts")
                            .get(i).at("/Night/IconPhrase").asText();

                    System.out.println("Погода в городе "  + selectedCity + " на: " + dateFiveDay);
                    System.out.println("Минимальная температура: " + tempMinFiveDay + " " + metricFiveDay + ". " +
                            "Максимальная температура: " + tempMaxFiveDay + " " + metricFiveDay + ".");
                    System.out.println("Днём: " + iconPhraseDayFiveDay + ". Ночью: " + iconPhraseNightFiveDay + ".");

                    try {
                        dataBaseRepository.saveWeatherToDataBase(new Weather(selectedCity, dateFiveDay,
                                metricFiveDay, iconPhraseDayFiveDay, iconPhraseNightFiveDay,
                                tempMinFiveDay, tempMaxFiveDay));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    @Override
    public List<Weather> getSavedToDBWeather() {
       return dataBaseRepository.getSavedToDBWeather();
    }

    private String detectCityKey(String selectCity) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();

        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
        return cityKey;
    }
}