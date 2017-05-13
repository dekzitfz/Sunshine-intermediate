package intermediate.bali.iak.sunshine.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import intermediate.bali.iak.sunshine.R;
import intermediate.bali.iak.sunshine.model.DummyForecast;
import intermediate.bali.iak.sunshine.model.WeatherItem;
import intermediate.bali.iak.sunshine.utilities.SunshineWeatherUtils;

/**
 * Created by DEKZ on 5/7/2017.
 */

public class ForecastItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.img_weather)ImageView img;
    @BindView(R.id.tv_day)TextView day;
    @BindView(R.id.tv_weatherDesc)TextView weatherDesc;
    @BindView(R.id.tv_maxTemp)TextView maxTemp;
    @BindView(R.id.tv_minTemp)TextView minTemp;

    public ForecastItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void bind(WeatherItem data){

        img.setImageResource(
                SunshineWeatherUtils
                        .getSmallArtResourceIdForWeatherCondition(
                                data.getWeather().get(0).getId()
                        )
        );

        day.setText(data.getReadableTime());
        weatherDesc.setText(data.getWeather().get(0).getDescription());
        maxTemp.setText(data.getTemp().getResolvedTemp(data.getTemp().getMax()));
        minTemp.setText(data.getTemp().getResolvedTemp(data.getTemp().getMin()));
    }
}
