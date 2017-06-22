package ariel.sv.com.colorweather;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ariel on 20/6/2017.
 */

public class Hour implements Parcelable{

    private String title;
    private String weatherDescription;


    public Hour() {
    }

    public Hour(String title, String weatherDescription) {
        this.title = title;
        this.weatherDescription = weatherDescription;
    }

    protected Hour(Parcel in) {
        title = in.readString();
        weatherDescription = in.readString();
    }

    public static final Creator<Hour> CREATOR = new Creator<Hour>() {
        @Override
        public Hour createFromParcel(Parcel in) {
            return new Hour(in);
        }

        @Override
        public Hour[] newArray(int size) {
            return new Hour[size];
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
