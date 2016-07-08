package com.example.admin.weatherappdemo.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 05-07-2016.
 */
public class CityWeather implements Serializable {

    String cityName = null;
    String countryCode = null;
    double latitude ;
    double longitude;
    int noumberOfDays;
    ArrayList<WeatherDetailsListModel> weatherDetailsListModels = null;


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getNoumberOfDays() {
        return noumberOfDays;
    }

    public void setNoumberOfDays(int noumberOfDays) {
        this.noumberOfDays = noumberOfDays;
    }

    public ArrayList<WeatherDetailsListModel> getWeatherDetailsListModels() {
        return weatherDetailsListModels;
    }

    public void setWeatherDetailsListModels(ArrayList<WeatherDetailsListModel> weatherDetailsListModels) {
        this.weatherDetailsListModels = weatherDetailsListModels;
    }


    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }




    public static class WeatherDetailsListModel implements Serializable {

        int date;
        int cloud;
        float tempDay;
        float pressure ;
        int humidity;
        float rain;

        public float getSpeed() {
            return speed;
        }

        public void setSpeed(float speed) {
            this.speed = speed;
        }

        float speed;
        String main = null;
        String description = null;



        public float getRain() {
            return rain;
        }

        public void setRain(float rain) {
            this.rain = rain;
        }

        public int getCloud() {
            return cloud;
        }

        public void setCloud(int cloud) {
            this.cloud = cloud;
        }

        public float getTempDay() {
            return tempDay;
        }

        public void setTempDay(float tempDay) {
            this.tempDay = tempDay;
        }

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public float getPressure() {
            return pressure;
        }

        public void setPressure(float pressure) {
            this.pressure = pressure;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public float getDay() {
            return tempDay;
        }

        public void setDay(float day) {
            this.tempDay = day;
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




}
