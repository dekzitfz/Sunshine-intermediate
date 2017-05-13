package intermediate.bali.iak.sunshine.model;

/**
 * Created by DEKZ on 5/13/2017.
 */

public class Weathers {
    private int id;
    private String main;
    private String description;

    @Override
    public String toString() {
        return "Weathers{" +
                "id=" + id +
                ", main='" + main + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
