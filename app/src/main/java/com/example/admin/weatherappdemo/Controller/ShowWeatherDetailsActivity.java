package com.example.admin.weatherappdemo.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.weatherappdemo.Adapter.WetherDetailsAdapter;
import com.example.admin.weatherappdemo.Model.CityWeather;
import com.example.admin.weatherappdemo.R;
import com.example.admin.weatherappdemo.ViewModel.CitySearchActivityViewModel;
import com.example.admin.weatherappdemo.ViewModel.ShowWeatherDetailsAcitivityViewModel;

import java.util.Map;

public class ShowWeatherDetailsActivity extends AppCompatActivity {

    Map<String,CitySearchActivityViewModel> citySearchActivityViewModelMap;
    ShowWeatherDetailsAcitivityViewModel showWeatherDetailsAcitivityViewModel = null;

    private TextView mCityName = null;
    private TextView mCountryCode = null;
    private TextView mNoOfDays = null;
    private ListView mListView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_weather_details);

        showWeatherDetailsAcitivityViewModel = new ShowWeatherDetailsAcitivityViewModel();

        Intent intent = getIntent();
        citySearchActivityViewModelMap =(Map<String,CitySearchActivityViewModel>) intent.getExtras().getSerializable("data");

        showWeatherDetailsAcitivityViewModel.setData(citySearchActivityViewModelMap);

         initView();

    }

    private void initView(){
        mCityName = (TextView) findViewById(R.id.cityname_tv);
        mCountryCode = (TextView) findViewById(R.id.country_code_tv);
        mNoOfDays = (TextView) findViewById(R.id.number_of_days_tv);
        mListView = (ListView) findViewById(R.id.weather_details_lv);

        showWeatherDetailsAcitivityViewModel.setCityDetails();

        mCityName.setText(showWeatherDetailsAcitivityViewModel.getCityName());
        mCountryCode.setText(showWeatherDetailsAcitivityViewModel.getCountryCode());
        mNoOfDays.setText(showWeatherDetailsAcitivityViewModel.getNumberOfDays());

        WetherDetailsAdapter wetherDetailsAdapter = new WetherDetailsAdapter(this,Integer.parseInt(mNoOfDays.getText().toString()),showWeatherDetailsAcitivityViewModel);
        mListView.setAdapter(wetherDetailsAdapter);


    }
}
