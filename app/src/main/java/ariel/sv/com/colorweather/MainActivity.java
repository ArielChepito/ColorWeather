package ariel.sv.com.colorweather;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.dailyTextView) TextView dailyTextView;
    @BindView(R.id.hourlyTextView) TextView hourlyTextView;
    @BindView(R.id.minutelyTextView) TextView minutelyTextView;
    @BindView(R.id.iconImageView)  ImageView iconImageView;
    @BindView(R.id.descriptionTextView) TextView descriptionTextView;
    @BindView(R.id.currentTempTextView) TextView currentTempTextView;
    @BindView(R.id.highestTempTextView) TextView highestTempTextView;
    @BindView(R.id.lowestTempTextView) TextView lowestTempTextView;
    @BindDrawable(R.drawable.clear_night) Drawable clear_night;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://api.darksky.net/forecast/a5377b366aad874f7941efdaf70c1464/37.8267,-122.4233?units=si";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try {
                            CurrentWeather currentWeather = getCurrentWeatherFromJson(response);
                            iconImageView.setImageDrawable(currentWeather.getIconDrawableResource());
                            descriptionTextView.setText(currentWeather.getDescription());
                            currentTempTextView.setText(currentWeather.getCurrentTemperature());
                            highestTempTextView.setText(String.format("H: %s °",currentWeather.getHighestTemperature()));
                            lowestTempTextView.setText(String.format("L: %s °", currentWeather.getLowestTemperature()));


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG,"That didn't work! :" + error.getMessage());
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }


    //metodo click con butterKnife:3
    @OnClick (R.id.dailyTextView)
    public void dailyTextViewClick(){
        Intent dailyActivityIntent = new Intent(MainActivity.this,  DailyWeatherActivity.class);
        startActivity(dailyActivityIntent);
    }

    @OnClick (R.id.hourlyTextView)
    public void hourlyTextViewClick(){
        Intent dailyActivityIntent = new Intent(MainActivity.this,  HourlyWeatherActivity.class);
        startActivity(dailyActivityIntent);
    }

    @OnClick(R.id.minutelyTextView)
    public void minutelyTextViewClick(){
        Intent dailyActivityIntent = new Intent(MainActivity.this,  MinutelyWeatherActivity.class);
        startActivity(dailyActivityIntent);
    }

    private CurrentWeather getCurrentWeatherFromJson(String json) throws JSONException{
        JSONObject jsonObject = new JSONObject(json);

        JSONObject jsonWithCurrentWeather = jsonObject.getJSONObject("currently");

        JSONObject jsonWithDailyWeather= jsonObject.getJSONObject("daily");

        JSONArray jsonWithDailyWeatherData = jsonWithDailyWeather.getJSONArray("data");

        JSONObject jsonWithTodayData = jsonWithDailyWeatherData.getJSONObject(0);



        String summary = jsonWithCurrentWeather.getString("summary");
        String icon= jsonWithCurrentWeather.getString("icon");

        String temperature = Math.round(jsonWithCurrentWeather.getDouble("temperature")) + "";

        String maxTemperature = Math.round(jsonWithTodayData.getDouble("temperatureMax")) + "";

        String minTemperature = Math.round(jsonWithTodayData.getDouble("temperatureMin")) + "";


        CurrentWeather currentWeather = new CurrentWeather(this);
        currentWeather.setDescription(summary);
        currentWeather.setIconImage(icon);
        currentWeather.setCurrentTemperature(temperature);
        currentWeather.setHighestTemperature(maxTemperature);
        currentWeather.setLowestTemperature(minTemperature);

        return currentWeather;

    }



}
