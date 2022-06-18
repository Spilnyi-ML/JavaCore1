package homeWorkLesson8;

import homeWorkLesson8.entity.Weather;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseRepository {
    private String insertWeather = "insert into weather (cityName, localdate, metric, " +
            "iconPhraseDay, iconPhraseNight, temperatureMin, temperatureMax) values (?, ?, ?, ?, ?, ?, ?)";
    private String getWeather = "select * from weather";
    private static final String DB_PATH = "jdbc:sqlite:geekbrains.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean saveWeatherToDataBase(Weather weather) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            saveWeather.setString(1, weather.getCityName());
            saveWeather.setString(2, weather.getLocalDate());
            saveWeather.setString(3, weather.getMetric());
            saveWeather.setString(4, weather.getIconPhraseDay());
            saveWeather.setString(5, weather.getIconPhraseNight());
            saveWeather.setDouble(6, weather.getTemperatureMin());
            saveWeather.setDouble(7, weather.getTemperatureMax());


            return saveWeather.execute();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Сохранение погоды в базу данных не выполнено!");
    }

    public void saveWeatherToDataBase(List<Weather> weatherList) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            for (Weather weather : weatherList) {
                saveWeather.setString(1, weather.getCityName());
                saveWeather.setString(2, weather.getLocalDate());
                saveWeather.setString(3, weather.getMetric());
                saveWeather.setString(4, weather.getIconPhraseDay());
                saveWeather.setString(5, weather.getIconPhraseNight());
                saveWeather.setDouble(6, weather.getTemperatureMin());
                saveWeather.setDouble(7, weather.getTemperatureMax());
                saveWeather.addBatch();
            }
            connection.close();
            saveWeather.executeBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Weather> getSavedToDBWeather() {
        List<Weather> weathers = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getWeather);
            while (resultSet.next()) {

                System.out.println("Погода в городе "  + resultSet.getString("cityName") +
                        " на: " + resultSet.getString("localdate"));
                System.out.println("Минимальная температура: " + resultSet.getDouble("temperatureMin") +
                        " " + resultSet.getString("metric") + ". " +
                        "Максимальная температура: " + resultSet.getDouble("temperatureMax") +
                        " " + resultSet.getString("metric") + ".");
                System.out.println("Днём: " + resultSet.getString("iconPhraseDay") +
                        ". Ночью: " + resultSet.getString("iconPhraseNight") + ".");

                weathers.add(new Weather(resultSet.getString("cityName"),
                        resultSet.getString("localDate"),
                        resultSet.getString("metric"),
                        resultSet.getString("iconPhraseDay"),
                        resultSet.getString("iconPhraseNight"),
                        resultSet.getDouble("temperatureMin"),
                        resultSet.getDouble("temperatureMax")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return weathers;
    }

    public static void main(String[] args) throws SQLException {
        DataBaseRepository dataBaseRepository = new DataBaseRepository();
        System.out.println(dataBaseRepository.getSavedToDBWeather());
    }
}
