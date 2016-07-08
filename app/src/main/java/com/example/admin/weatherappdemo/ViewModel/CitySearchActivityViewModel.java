package com.example.admin.weatherappdemo.ViewModel;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.admin.weatherappdemo.Interface.ResponseDataCallBack;
import com.example.admin.weatherappdemo.Utils.ConstantUtils;
import com.example.admin.weatherappdemo.Model.CityWeather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.example.admin.weatherappdemo.Model.CityWeather.*;

/**
 * Created by Admin on 30-06-2016.
 */
public class CitySearchActivityViewModel implements Serializable {


    Map<String,CityWeather> cityWeather;
    Map<String,CitySearchActivityViewModel> citySearchActivityViewModel;
    ArrayList<CityWeather.WeatherDetailsListModel> weatherDetailsListModel;

    public Map<String, CityWeather> getCityWeather() {
        return cityWeather;
    }

    public void setCityWeather(Map<String, CityWeather> cityWeather) {
        this.cityWeather = cityWeather;
    }

    public void getCityName(String city,Context context){
        String url = ConstantUtils.TARGET_URL + "?q="+city+"&mode="+ConstantUtils.Mode.json
                +"&units=metric&cnt="+ConstantUtils.NUMBER_OF_DAYS_WEATHER+"&appid="+ConstantUtils.APPKEY;
        getCityWeather(url,context, (ResponseDataCallBack) context);
    }

    public void getCityLatAndLon(float lat,float lon,Context context){

       // http://api.openweathermap.org/data/2.5/forecast/daily?lat=35&lon=139&cnt=10&mode=json&appid=b1b15e88fa797225412429c1c50c122a

        String url = ConstantUtils.TARGET_URL + "?lat="+String.valueOf(lat)+"&lon="
                +String.valueOf(lon)+"&cnt="+ConstantUtils.NUMBER_OF_DAYS_WEATHER+"&mode=json"+"&appid="+ConstantUtils.APPKEY;
        getCityWeather(url,context, (ResponseDataCallBack) context);

    }

    public void getCityWeather(String url,Context context, final ResponseDataCallBack responseDataCallBack) {

        String dataRetrivalMode = "json";

        RequestQueue queue = Volley.newRequestQueue(context);

       // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("MTAG","Response is: "+ response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Log.d("MTAG","Response is: "+ jsonObject);
                            JSONObject cityObject  = jsonObject.getJSONObject("city");


                            String cityName = cityObject.getString("name");
                            JSONObject coordinateModel = cityObject.getJSONObject("coord");
                            double latitude = coordinateModel.getDouble("lat");
                            double longitude = coordinateModel.getDouble("lon");
                            String countryCode = cityObject.getString("country");
                            int numberOfDays = jsonObject.getInt("cnt");

                            JSONArray cityListObject  = jsonObject.getJSONArray("list");
                            WeatherDetailsListModel weatherDetailsListObject = new WeatherDetailsListModel();
                            weatherDetailsListModel = new ArrayList<CityWeather.WeatherDetailsListModel>();
                            for(int i = 0; i<cityListObject.length(); i++){
                                JSONObject listObj = (JSONObject) cityListObject.get(i);
                                int date = listObj.getInt("dt");
                                JSONObject temp = listObj.getJSONObject("temp");
                                float tempDay = (float) temp.getDouble("day");
                                int cloud = listObj.getInt("clouds") ;
                                float rain = (float) listObj.getDouble("rain");
                                float speed = (float) listObj.getDouble("speed");
                                float pressure = (float) listObj.getDouble("pressure");
                                int humidity = (int) listObj.getDouble("humidity");

                                JSONArray weather = listObj.getJSONArray("weather");
                                JSONObject wetherDetails = (JSONObject) weather.get(0);

                                String main = wetherDetails.getString("main");
                                String description = wetherDetails.getString("description");

                                weatherDetailsListObject.setDate(date);
                                weatherDetailsListObject.setDay(tempDay);
                                weatherDetailsListObject.setDescription(description);
                                weatherDetailsListObject.setMain(main);
                                weatherDetailsListObject.setHumidity(humidity);
                                weatherDetailsListObject.setPressure(pressure);
                                weatherDetailsListObject.setCloud(cloud);
                                weatherDetailsListObject.setRain(rain);
                                weatherDetailsListObject.setSpeed(speed);


                                weatherDetailsListModel.add(weatherDetailsListObject);
                            }

                            CityWeather cityWeatherObject = new CityWeather();
                            cityWeatherObject.setCityName(cityName);
                            cityWeatherObject.setCountryCode(countryCode);
                            cityWeatherObject.setLatitude(latitude);
                            cityWeatherObject.setLongitude(longitude);
                            cityWeatherObject.setNoumberOfDays(numberOfDays);
                            cityWeatherObject.setWeatherDetailsListModels(weatherDetailsListModel);

                            cityWeather = new <String,CityWeather>HashMap();

                            cityWeather.put("cityweather",cityWeatherObject);

                            citySearchActivityViewModel = new <String,CitySearchActivityViewModel>HashMap();

                            CitySearchActivityViewModel temp = new CitySearchActivityViewModel();
                            temp.setCityWeather(cityWeather);

                            citySearchActivityViewModel.put("cityweatherviewmodel", temp);


                            responseDataCallBack.onSuccess(citySearchActivityViewModel);


//                            {"city":
//                                {"id":1259229,"name":"Pune","coord":{"lon":73.855347,"lat":18.519569},
//                             "country":"IN",
//                             "population":0},
//                             "cod":"200",
//                             "message":0.0167,
//                             "cnt":14,
//                             "list":[
//                                {"dt":1467788400,
//                                 "temp":{"day":22.77,"min":22.19,"max":23.01,"night":22.19,"eve":22.79,"morn":22.5},
//                                 "pressure":942.97,
//                                 "humidity":100,
//                                 "weather":[{"id":502,"main":"Rain","description":"heavy intensity rain","icon":"10d"}],
//                                 "speed":3.46,
//                                 "deg":259,
//                                 "clouds":92,
//                                 "rain":12.46},


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("MTAG","That didn't work!");
            }
        });
        queue.add(stringRequest);
        Log.d("MTAG","Return");
    }

}
