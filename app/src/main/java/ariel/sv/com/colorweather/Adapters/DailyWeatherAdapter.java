package ariel.sv.com.colorweather.Adapters;

import android.content.Context;
import android.util.Log;
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

public class DailyWeatherAdapter extends BaseAdapter{

    private final static String TAG = DailyWeatherAdapter.class.getSimpleName();
    ArrayList<Day> days;
    Context context;

    public DailyWeatherAdapter(Context context, ArrayList<Day> days) {
        this.days = days;
        this.context = context;
    }

    @Override
    public int getCount() {
        if(days == null){return 0;}
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

        ViewHolder viewHolder;
        Day day = days.get(position);


        if(convertView == null){


            convertView = LayoutInflater.from(context).inflate(R.layout.daily_list_item,parent,false);


            viewHolder = new ViewHolder();
            viewHolder.dayTitle = (TextView) convertView.findViewById(R.id.dailyListTitle);
            viewHolder.dayDescription = (TextView) convertView.findViewById(R.id.dailyListDescription);
            viewHolder.dayProbality = (TextView) convertView.findViewById(R.id.dailyListProbality);


            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }



        viewHolder.dayTitle.setText(day.getDayName());
        viewHolder.dayDescription.setText(day.getWeatherDescription());
        viewHolder.dayProbality.setText(day.getRainProbality());

        return convertView;
    }


    static class ViewHolder{
        TextView dayTitle;
        TextView dayDescription;
        TextView dayProbality;
    }
}
