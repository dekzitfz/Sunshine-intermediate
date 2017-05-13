package intermediate.bali.iak.sunshine.model;

import java.util.List;

/**
 * Created by DEKZ on 5/13/2017.
 */

public class WeatherItem {
    private long dt;
    private Temp temp;
    private List<Weathers> weather;

    @Override
    public String toString() {
        return "WeatherItem{" +
                "dt=" + dt +
                ", temp=" + temp +
                ", weather=" + weather +
                '}';
    }
}
