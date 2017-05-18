package intermediate.bali.iak.sunshine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import intermediate.bali.iak.sunshine.model.WeatherItem;
import intermediate.bali.iak.sunshine.utilities.SunshineWeatherUtils;

/**
 * Created by DEKZ on 5/13/2017.
 */

public class DetailActivity extends AppCompatActivity{

    private static final String TAG = DetailActivity.class.getSimpleName();

    @BindView(R.id.detail_date)
    TextView date;
    @BindView(R.id.detail_high_temperature)
    TextView highTemp;
    @BindView(R.id.detail_low_temperature)
    TextView lowTemp;
    @BindView(R.id.detail_weather_icon)
    ImageView weatherIcon;
    @BindView(R.id.detail_weather_description)
    TextView weatherDesc;
    @BindView(R.id.detail_humidity)
    TextView humidity;
    @BindView(R.id.detail_pressure)
    TextView pressure;
    @BindView(R.id.detail_wind)
    TextView wind;

    private String jsonData;
    private int position;
    private WeatherItem weatherDetail;
    private Gson gson = new Gson();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        jsonData = getIntent().getStringExtra("data");
        position = getIntent().getIntExtra("position", 0);

        if (jsonData != null) {
            weatherDetail = gson.fromJson(jsonData, WeatherItem.class);
            bindData();
        }else{
            Log.w(TAG,"data is null!");
        }
    }

    private void bindData(){
        if (position == 0) {
            date.setText(weatherDetail.getTodayReadableTime());
        } else {
            date.setText(weatherDetail.getReadableTime(position));
        }

        weatherIcon.setImageResource(
                SunshineWeatherUtils
                        .getSmallArtResourceIdForWeatherCondition(
                                weatherDetail.getWeather().get(0).getId()
                        )
        );

        highTemp.setText(
                weatherDetail.getTemp().getResolvedTemp(weatherDetail.getTemp().getMax())
        );
        lowTemp.setText(
                weatherDetail.getTemp().getResolvedTemp(weatherDetail.getTemp().getMin())
        );

        weatherDesc.setText(weatherDetail.getWeather().get(0).getDescription());
        humidity.setText(weatherDetail.getReadableHumidity());
        wind.setText(weatherDetail.getReadableWindSpeed());
        pressure.setText(weatherDetail.getReadablePressure());
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        NavUtils.navigateUpFromSameTask(this);
    }
}
