package ariel.sv.com.colorweather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import ariel.sv.com.colorweather.Adapters.MinutelyWeatherAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MinutelyWeatherActivity extends Activity {


    @BindView(R.id.minutelyRecyclerView) RecyclerView minutelyRecyclerView;
    @BindView(R.id.noDataRecycler) TextView noDataRecybler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minutely_weather);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        ArrayList<Minute> minutes = intent.getParcelableArrayListExtra(MainActivity.MINUTE_ARRAY_LIST);


        if(minutes != null && !minutes.isEmpty() ){

            noDataRecybler.setVisibility(View.GONE);
            minutelyRecyclerView.setVisibility(View.VISIBLE);

            MinutelyWeatherAdapter minutelyWeatherAdapter = new MinutelyWeatherAdapter(this,minutes);

            minutelyRecyclerView.setAdapter(minutelyWeatherAdapter);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

            minutelyRecyclerView.setLayoutManager(layoutManager);

            minutelyRecyclerView.setHasFixedSize(true);


        }
        else{

            //desplegar no data textview

            //volver recycler view invisible

            noDataRecybler.setVisibility(View.VISIBLE);
            minutelyRecyclerView.setVisibility(View.GONE);

        }








    }
}
