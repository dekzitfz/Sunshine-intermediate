package intermediate.bali.iak.sunshine;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by DEKZ on 5/18/2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
