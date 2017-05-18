package intermediate.bali.iak.sunshine.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import intermediate.bali.iak.sunshine.R;
import intermediate.bali.iak.sunshine.model.WeatherItem;
import intermediate.bali.iak.sunshine.utilities.SunshineWeatherUtils;

/**
 * Created by DEKZ on 5/13/2017.
 */

public class TodayItemForecastViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.weather_icon)ImageView img;
    @BindView(R.id.date)TextView day;
    @BindView(R.id.weather_description)TextView weatherDesc;
    @BindView(R.id.high_temperature)TextView maxTemp;
    @BindView(R.id.low_temperature)TextView minTemp;

    public TodayItemForecastViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void bind(final WeatherItem data, final OnClickListener clickListener){
        img.setImageResource(
                SunshineWeatherUtils
                        .getSmallArtResourceIdForWeatherCondition(
                                data.getWeather().get(0).getId()
                        )
        );

        day.setText(data.getTodayReadableTime());
        weatherDesc.setText(data.getWeather().get(0).getDescription());
        maxTemp.setText(data.getTemp().getResolvedTemp(data.getTemp().getMax()));
        minTemp.setText(data.getTemp().getResolvedTemp(data.getTemp().getMin()));

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(data,0);
            }
        });
    }
}
