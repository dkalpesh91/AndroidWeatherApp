package com.example.admin.weatherappdemo.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.admin.weatherappdemo.Controller.ShowWeatherDetailsActivity;
import com.example.admin.weatherappdemo.R;
import com.example.admin.weatherappdemo.ViewModel.ShowWeatherDetailsAcitivityViewModel;

/**
 * Created by Admin on 06-07-2016.
 */
public class WetherDetailsAdapter extends BaseAdapter {

    String [] result;
    Context context;
    Bitmap[] imageId;
    private static LayoutInflater inflater=null;
    int numberOfRows;
    int mPosition;

    ShowWeatherDetailsAcitivityViewModel mShowWeatherDetailsAcitivityViewModel = null;

    public WetherDetailsAdapter(ShowWeatherDetailsActivity mainActivity,int numberOfRows,ShowWeatherDetailsAcitivityViewModel showWeatherDetailsAcitivityViewModel) {
        // TODO Auto-generated constructor stub
        context=mainActivity;
        this.numberOfRows = numberOfRows;
        this.mShowWeatherDetailsAcitivityViewModel = showWeatherDetailsAcitivityViewModel;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mPosition = 0;

    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return numberOfRows;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }


    public class Holder
    {
        TextView clouds;
        TextView pressure;
        TextView temperature;
        TextView humidity;
        TextView rain;
        TextView speed;
        TextView main;
        TextView description;
        TextView date;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final Holder holder=new Holder();
        final View rowView;
        rowView = inflater.inflate(R.layout.list_row, null);

        mShowWeatherDetailsAcitivityViewModel.setCityWeatherDetails(mPosition);

        Log.d("MTAG","="+position+"nu ="+numberOfRows);
        holder.clouds=(TextView) rowView.findViewById(R.id.clouds_tv);
        holder.pressure = (TextView) rowView.findViewById(R.id.pressure_tv);
        holder.rain = (TextView) rowView.findViewById(R.id.rain_tv);
        holder.temperature=(TextView) rowView.findViewById(R.id.temp_tv);
        holder.humidity=(TextView) rowView.findViewById(R.id.humidity_tv);
        holder.speed = (TextView) rowView.findViewById(R.id.speed_tv);
        holder.main = (TextView) rowView.findViewById(R.id.main_tv);
        holder.description=(TextView) rowView.findViewById(R.id.desc_tv);
        holder.date=(TextView) rowView.findViewById(R.id.date_tv);

        holder.clouds.setText(mShowWeatherDetailsAcitivityViewModel.getClouds());
        holder.pressure.setText(mShowWeatherDetailsAcitivityViewModel.getPressure());
        holder.rain.setText(mShowWeatherDetailsAcitivityViewModel.getRain());
        holder.temperature.setText(mShowWeatherDetailsAcitivityViewModel.getTemp());
        holder.humidity.setText(mShowWeatherDetailsAcitivityViewModel.getHumidity());
        holder.speed.setText(mShowWeatherDetailsAcitivityViewModel.getSpeed());
        holder.main.setText(mShowWeatherDetailsAcitivityViewModel.getMain());
        holder.description.setText(mShowWeatherDetailsAcitivityViewModel.getDescription());
        holder.date.setText(mShowWeatherDetailsAcitivityViewModel.getDate());

        mPosition++;
        return rowView;
    }


}
