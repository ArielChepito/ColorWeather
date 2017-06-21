package ariel.sv.com.colorweather.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ariel.sv.com.colorweather.Hour;
import ariel.sv.com.colorweather.R;

/**
 * Created by Ariel on 20/6/2017.
 */

public class HourlyWeatherAdapter extends BaseAdapter {
    private final static String TAG = HourlyWeatherAdapter.class.getSimpleName();
    ArrayList<Hour> Hours;
    Context context;

    public HourlyWeatherAdapter(Context context, ArrayList<Hour> Hours) {
        this.Hours = Hours;
        this.context = context;
    }

    @Override
    public int getCount() {
        return Hours.size();
    }

    @Override
    public Object getItem(int position) {
        return Hours.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0; //No lo usaremos
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        HourlyWeatherAdapter.ViewHolder viewHolder;
        Hour Hour = Hours.get(position);


        if(convertView == null){


            convertView = LayoutInflater.from(context).inflate(R.layout.hourly_list_item,parent,false);


            viewHolder = new HourlyWeatherAdapter.ViewHolder();
            viewHolder.HourTitle = (TextView) convertView.findViewById(R.id.hourlyListTitle);
            viewHolder.HourDescription = (TextView) convertView.findViewById(R.id.hourlyListDescription);


            convertView.setTag(viewHolder);

        }else{
            viewHolder = (HourlyWeatherAdapter.ViewHolder) convertView.getTag();
        }



        viewHolder.HourTitle.setText(Hour.getTitle());
        viewHolder.HourDescription.setText(Hour.getWeatherDescription());

        return convertView;
    }


    static class ViewHolder{
        TextView HourTitle;
        TextView HourDescription;
    }
}
