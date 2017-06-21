package ariel.sv.com.colorweather;

/**
 * Created by Ariel on 20/6/2017.
 */

public class Minute {
    private String title;
    private String weatherDescription;

    public Minute() {
    }

    public Minute(String title, String weatherDescription) {
        this.title = title;
        this.weatherDescription = weatherDescription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }
}
