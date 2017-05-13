package intermediate.bali.iak.sunshine.model;

import java.util.List;

/**
 * Created by DEKZ on 5/13/2017.
 */

public class DailyForecast {
    private City city;
    private List<WeatherItem> list;

    @Override
    public String toString() {
        return "DailyForecast{" +
                "city=" + city +
                ", list=" + list +
                '}';
    }


}
