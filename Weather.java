package homeWorkLesson8.entity;

public class Weather {
    private String cityName;
    private String localDate;
    private String metric;
    private String iconPhraseDay;
    private String iconPhraseNight;
    private double temperatureMin;
    private double temperatureMax;

    public Weather(String cityName, String localDate, String metric, String iconPhraseDay,
                   String iconPhraseNight, double temperatureMin, double temperatureMax) {
        this.cityName = cityName;
        this.localDate = localDate;
        this.metric = metric;
        this.iconPhraseDay = iconPhraseDay;
        this.iconPhraseNight = iconPhraseNight;
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public String getIconPhraseDay() {
        return iconPhraseDay;
    }

    public void setIconPhraseDay(String iconPhraseDay) {
        this.iconPhraseDay = iconPhraseDay;
    }

    public String getIconPhraseNight() {
        return iconPhraseNight;
    }

    public void setIconPhraseNight(String iconPhraseNight) {
        this.iconPhraseNight = iconPhraseNight;
    }

    public double getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public double getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "cityName='" + cityName + '\'' +
                ", localDate='" + localDate + '\'' +
                ", metric='" + metric + '\'' +
                ", iconPhraseDay='" + iconPhraseDay + '\'' +
                ", iconPhraseNight='" + iconPhraseNight + '\'' +
                ", temperatureMin=" + temperatureMin +
                ", temperatureMax=" + temperatureMax +
                '}';
    }
}
