package intermediate.bali.iak.sunshine.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import intermediate.bali.iak.sunshine.R;
import intermediate.bali.iak.sunshine.model.DummyForecast;

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

    public void bind(DummyForecast data){
        day.setText(data.getDay());
        weatherDesc.setText(data.getWeather());
        maxTemp.setText(String.valueOf(data.getMaxTemp()));
        minTemp.setText(String.valueOf(data.getMinTemp()));
    }
}
