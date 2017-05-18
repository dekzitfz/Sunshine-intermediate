package intermediate.bali.iak.sunshine.model;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by DEKZ on 5/13/2017.
 */

public class WeatherItem {
    private long dt;
    private Temp temp;
    private List<Weathers> weather;
    private int humidity;
    private double pressure;
    private double speed;

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public List<Weathers> getWeather() {
        return weather;
    }

    public void setWeather(List<Weathers> weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "WeatherItem{" +
                "dt=" + dt +
                ", temp=" + temp +
                ", weather=" + weather +
                '}';
    }

    public String getReadableTime(int position){
        if(position == 1){
            return "Tomorrow";
        }else{
            Date date = new Date(dt * 1000L);
            DateFormat format = new SimpleDateFormat("EEEE");
            return format.format(date);
        }
    }

    public String getTodayReadableTime(){
        Date date = new Date(dt * 1000L);
        DateFormat format = new SimpleDateFormat("MMM dd");
        return "Today, "+format.format(date);
    }

    public String getReadableHumidity() {
        return humidity + " %";
    }

    public String getReadablePressure() {
        return Math.round(pressure) + " hPa";
    }

    public String getReadableWindSpeed() {
        return Math.round(speed) + " m/sec";
    }
}
