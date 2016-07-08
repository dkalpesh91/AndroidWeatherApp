package com.example.admin.weatherappdemo.Interface;

import com.example.admin.weatherappdemo.Model.CityWeather;
import com.example.admin.weatherappdemo.ViewModel.CitySearchActivityViewModel;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Admin on 06-07-2016.
 */
public interface ResponseDataCallBack {

    void onSuccess(Map<String,CitySearchActivityViewModel> citySearchActivityViewModel);

}
