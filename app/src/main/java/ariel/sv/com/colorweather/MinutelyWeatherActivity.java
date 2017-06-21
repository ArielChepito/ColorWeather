package ariel.sv.com.colorweather;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import ariel.sv.com.colorweather.Adapters.MinutelyWeatherAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MinutelyWeatherActivity extends Activity {


    @BindView(R.id.minutelyRecyclerView) RecyclerView minutelyRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minutely_weather);
        ButterKnife.bind(this);

        ArrayList<Minute> minutes = new ArrayList<Minute>();
        minutes.add(new Minute("19:55","45%"));
        minutes.add(new Minute("12:55","99%"));

        MinutelyWeatherAdapter minutelyWeatherAdapter = new MinutelyWeatherAdapter(this,minutes);

        minutelyRecyclerView.setAdapter(minutelyWeatherAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        minutelyRecyclerView.setLayoutManager(layoutManager);

        minutelyRecyclerView.setHasFixedSize(true);





    }
}
