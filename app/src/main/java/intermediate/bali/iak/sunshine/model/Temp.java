package intermediate.bali.iak.sunshine.model;

/**
 * Created by DEKZ on 5/13/2017.
 */

public class Temp {
    private Double min;
    private Double max;

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public String getResolvedTemp(double temp){
        int result = (int) temp;
        return result+"\u00b0";
    }
}
