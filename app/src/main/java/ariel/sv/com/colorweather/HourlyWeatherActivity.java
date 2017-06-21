package ariel.sv.com.colorweather;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;

import java.util.ArrayList;

import ariel.sv.com.colorweather.Adapters.DailyWeatherAdapter;
import ariel.sv.com.colorweather.Adapters.HourlyWeatherAdapter;

public class HourlyWeatherActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_weather);



        ArrayList<Hour> hour = new ArrayList<Hour>();
        for (int x = 0; x<500; x++){

            hour.add(new Hour("19:00","Despejado"));

        }


        HourlyWeatherAdapter dailyWeatherAdapter = new HourlyWeatherAdapter(this,hour);

        this.setListAdapter(dailyWeatherAdapter);

    }
}
