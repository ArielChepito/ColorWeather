package ariel.sv.com.colorweather;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import ariel.sv.com.colorweather.Adapters.DailyWeatherAdapter;
import ariel.sv.com.colorweather.Adapters.HourlyWeatherAdapter;

public class HourlyWeatherActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_weather);


        Intent intent = getIntent();
        ArrayList<Hour> hour =intent.getParcelableArrayListExtra(MainActivity.HOUR_ARRAY_LIST);


        HourlyWeatherAdapter dailyWeatherAdapter = new HourlyWeatherAdapter(this,hour);

        this.setListAdapter(dailyWeatherAdapter);

    }
}
