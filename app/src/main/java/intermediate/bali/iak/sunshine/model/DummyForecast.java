package intermediate.bali.iak.sunshine.model;

/**
 * Created by DEKZ on 5/7/2017.
 */

public class DummyForecast {
    private String day;
    private String weather;
    private int maxTemp;
    private int minTemp;
    private int weatherID;

    public DummyForecast(String day, String weather, int maxTemp, int minTemp, int weatherID) {
        this.day = day;
        this.weather = weather;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.weatherID = weatherID;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public int getWeatherID() {
        return weatherID;
    }

    public void setWeatherID(int weatherID) {
        this.weatherID = weatherID;
    }

    @Override
    public String toString() {
        return "DummyForecast{" +
                "day='" + day + '\'' +
                ", weather='" + weather + '\'' +
                ", maxTemp=" + maxTemp +
                ", minTemp=" + minTemp +
                ", weatherID=" + weatherID +
                '}';
    }
}
