package ariel.sv.com.colorweather;

/**
 * Created by Ariel on 20/6/2017.
 */

public class Day {

    private String dayName;
    private String weatherDescription;
    private String rainProbality;

    public Day() {
    }

    public Day(String dayName, String weatherDescription, String rainProbality) {
        this.dayName = dayName;
        this.weatherDescription = weatherDescription;
        this.rainProbality = rainProbality;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getRainProbality() {
        return rainProbality;
    }

    public void setRainProbality(String rainProbality) {
        this.rainProbality = rainProbality;
    }
}
