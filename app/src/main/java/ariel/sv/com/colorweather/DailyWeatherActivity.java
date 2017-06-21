package ariel.sv.com.colorweather;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import ariel.sv.com.colorweather.Adapters.DailyWeatherAdapter;

public class DailyWeatherActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_weather);
        ArrayList<Day> days = new ArrayList<Day>();
        for (int x = 0; x<500; x++){

            days.add(new Day("Lunes","Hoy va a llover", "99%"));

        }


        DailyWeatherAdapter dailyWeatherAdapter = new DailyWeatherAdapter(this,days);

        this.setListAdapter(dailyWeatherAdapter);
    }
}
