package ariel.sv.com.colorweather;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ariel on 20/6/2017.
 */

public class Day implements Parcelable{

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

    protected Day(Parcel in) {
        dayName = in.readString();
        weatherDescription = in.readString();
        rainProbality = in.readString();
    }

    public static final Creator<Day> CREATOR = new Creator<Day>() {
        @Override
        public Day createFromParcel(Parcel in) {
            return new Day(in);
        }

        @Override
        public Day[] newArray(int size) {
            return new Day[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0; //No lo necesitamos jajaja
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(dayName);
        dest.writeString(weatherDescription);
        dest.writeString(rainProbality);

    }
}
