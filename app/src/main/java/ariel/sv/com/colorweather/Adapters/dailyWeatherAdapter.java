package ariel.sv.com.colorweather.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ariel.sv.com.colorweather.Day;
import ariel.sv.com.colorweather.R;

/**
 * Created by Ariel on 20/6/2017.
 */

public class dailyWeatherAdapter extends BaseAdapter{


    ArrayList<Day> days;
    Context context;

    public dailyWeatherAdapter(Context context,ArrayList<Day> days) {
        this.days = days;
        this.context = context;
    }

    @Override
    public int getCount() {
        return days.size();
    }

    @Override
    public Object getItem(int position) {
        return days.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0; //No lo usaremos
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //bad shabo no es la mejor forma
        convertView = LayoutInflater.from(context).inflate(R.layout.daily_list_item,null);
        TextView dayTitle = (TextView) convertView.findViewById(R.id.dailyListTitle);
        TextView dayDescription = (TextView) convertView.findViewById(R.id.dailyListDescription);
        TextView dayProbality = (TextView) convertView.findViewById(R.id.dailyListProbality);
        return null;
    }
}
