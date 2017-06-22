package ariel.sv.com.colorweather;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ariel on 20/6/2017.
 */

public class Minute implements Parcelable {
    private String title;
    private String weatherDescription;

    public Minute() {
    }

    public Minute(String title, String weatherDescription) {
        this.title = title;
        this.weatherDescription = weatherDescription;
    }

    protected Minute(Parcel in) {
        title = in.readString();
        weatherDescription = in.readString();
    }

    public static final Creator<Minute> CREATOR = new Creator<Minute>() {
        @Override
        public Minute createFromParcel(Parcel in) {
            return new Minute(in);
        }

        @Override
        public Minute[] newArray(int size) {
            return new Minute[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(weatherDescription);
    }
}
