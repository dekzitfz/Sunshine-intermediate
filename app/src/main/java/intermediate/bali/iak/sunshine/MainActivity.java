package intermediate.bali.iak.sunshine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import intermediate.bali.iak.sunshine.adapter.ListForecastAdapter;
import intermediate.bali.iak.sunshine.model.DailyForecast;
import intermediate.bali.iak.sunshine.model.DummyForecast;
import intermediate.bali.iak.sunshine.model.WeatherItem;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.rv_forecast)RecyclerView rv;

    private ListForecastAdapter adapter;
    private List<WeatherItem> list = new ArrayList<>();
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupRecyclerView();
    }

    private void setupRecyclerView(){
        adapter = new ListForecastAdapter(list);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        getDataFromAPI();
    }

    /*private void populateData(){
        for(int i=0;i<10;i++){
            DummyForecast dummy = new DummyForecast("Sunday","Rainy",23,18,123);
            list.add(dummy);
        }
        adapter.notifyDataSetChanged();

        getDataFromAPI();
    }*/

    private void getDataFromAPI(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final String URL = "http://api.openweathermap.org/data/2.5/forecast/daily?cnt=16&appid=6798555075668607c0a539f2093da3ab&units=metric&q=Denpasar";

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG,response);
                        try {
                            DailyForecast dailyForecast = gson.fromJson(response,DailyForecast.class);
                            Log.d(TAG,dailyForecast.toString());
                            for(WeatherItem item : dailyForecast.getList()){
                                list.add(item);
                            }
                            adapter.notifyDataSetChanged();
                        } catch (Exception e){
                            Log.e(TAG,e.getMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if(error!=null){
                            Log.e(TAG,error.getMessage());
                        }else{
                            Log.e(TAG,"something error happened!");
                        }
                    }
                }
        );

        requestQueue.add(stringRequest);

    }
}
