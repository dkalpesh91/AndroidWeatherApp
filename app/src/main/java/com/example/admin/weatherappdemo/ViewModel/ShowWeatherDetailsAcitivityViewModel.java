package com.example.admin.weatherappdemo.ViewModel;

import android.util.Log;
import android.widget.TextView;

import com.example.admin.weatherappdemo.Model.CityWeather;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Created by Admin on 06-07-2016.
 */
public class ShowWeatherDetailsAcitivityViewModel {



    String cityName = null;
    String countryCode = null;
    String numberOfDays;

    String clouds;
    String humidity;
    String pressure;
    String speed;
    String temp;
    String date;
    String rain;

    String description;
    String main;



    ArrayList<CityWeather.WeatherDetailsListModel> mWeatherDetailsListModel = null;

    CityWeather cityWeatherDetails = null;

    public void setData(Map<String,CitySearchActivityViewModel> citySearchActivityViewModelMap) {

        CitySearchActivityViewModel cityWeatherViewModel = citySearchActivityViewModelMap.get("cityweatherviewmodel");
        Map<String,CityWeather> cityWeather = cityWeatherViewModel.getCityWeather();
        cityWeatherDetails = cityWeather.get("cityweather");
        Log.d("MTAG",citySearchActivityViewModelMap.toString());
        Log.d("MTAG",cityWeatherDetails.getCityName().toString());

    }

    public void setCityDetails(){
        cityName = cityWeatherDetails.getCityName().toString();
        countryCode = cityWeatherDetails.getCountryCode().toString();
        numberOfDays = String.valueOf(cityWeatherDetails.getNoumberOfDays());
        mWeatherDetailsListModel = cityWeatherDetails.getWeatherDetailsListModels();


    }

    public void setCityWeatherDetails(int index){

        CityWeather.WeatherDetailsListModel detailsListModel = mWeatherDetailsListModel.get(index);
        clouds = String.valueOf(detailsListModel.getCloud());
        humidity = String.valueOf(detailsListModel.getHumidity());
        rain = String.valueOf(detailsListModel.getRain());
        pressure = String.valueOf(detailsListModel.getPressure());
        speed = String.valueOf(detailsListModel.getSpeed());
        temp = String.valueOf(detailsListModel.getTempDay());
        description = detailsListModel.getDescription();
        main = detailsListModel.getMain();
        Date dateAndTime = new Date(detailsListModel.getDate());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = dateFormat.format(dateAndTime);
        date = dateString;
    }

    public ArrayList<CityWeather.WeatherDetailsListModel> getmWeatherDetailsListModel() {
        return mWeatherDetailsListModel;
    }

    public void setmWeatherDetailsListModel(ArrayList<CityWeather.WeatherDetailsListModel> mWeatherDetailsListModel) {
        this.mWeatherDetailsListModel = mWeatherDetailsListModel;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(String numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public String getClouds() {
        return clouds;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

}
