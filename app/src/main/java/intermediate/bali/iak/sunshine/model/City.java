package intermediate.bali.iak.sunshine.model;

/**
 * Created by DEKZ on 5/13/2017.
 */

public class City {
    int id;

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}