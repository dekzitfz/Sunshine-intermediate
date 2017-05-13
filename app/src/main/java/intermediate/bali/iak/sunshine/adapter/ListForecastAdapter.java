package intermediate.bali.iak.sunshine.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import intermediate.bali.iak.sunshine.R;
import intermediate.bali.iak.sunshine.model.DummyForecast;
import intermediate.bali.iak.sunshine.model.WeatherItem;

/**
 * Created by DEKZ on 5/7/2017.
 */

public class ListForecastAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<WeatherItem> list = new ArrayList<>();
    private static final int VIEW_TODAY = 0;
    private static final int VIEW_OTHER = 1;

    public ListForecastAdapter(List<WeatherItem> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == VIEW_TODAY){
            return new TodayItemForecastViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_today_forcast, parent, false));
        }else{
            return new ForecastItemViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_forecast_item, parent, false));
        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == 0){
            ((TodayItemForecastViewHolder) holder).bind(list.get(position));
        }else{
            ((ForecastItemViewHolder) holder).bind(list.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            //top position aka Today
            return VIEW_TODAY;
        }else{
            return VIEW_OTHER;
        }
    }
}
