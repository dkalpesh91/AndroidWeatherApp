package com.example.admin.weatherappdemo.Controller;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Response;
import com.example.admin.weatherappdemo.Interface.ResponseDataCallBack;
import com.example.admin.weatherappdemo.Model.CityWeather;
import com.example.admin.weatherappdemo.R;
import com.example.admin.weatherappdemo.Utils.GPSTrackerUtil;
import com.example.admin.weatherappdemo.ViewModel.CitySearchActivityViewModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Map;

public class CitySearchActivity extends AppCompatActivity implements View.OnClickListener, ResponseDataCallBack {

	private EditText searchWeatherForCity = null;
	private Button submitButton = null;
	private Button accessLocationButton = null;
	Context context = null;
	CitySearchActivityViewModel networkOperation = new CitySearchActivityViewModel();
	GPSTrackerUtil gpsTracker;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();

	}

	private void initView() {

		gpsTracker = new GPSTrackerUtil(this);

		searchWeatherForCity = (EditText) findViewById(R.id.editText);
		submitButton = (Button) findViewById(R.id.submit_button);
		accessLocationButton = (Button) findViewById(R.id.access_location_btn);

		submitButton.setOnClickListener(this);
		accessLocationButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {


				if (gpsTracker.getIsGPSTrackingEnabled()) {
					double longitude = gpsTracker.getLongitude();
					double latitude = gpsTracker.getLatitude();
					networkOperation.getCityLatAndLon((float) latitude, (float) longitude, CitySearchActivity.this);
				}
			}
		});


	}

	@Override
	public void onClick(View v) {
		networkOperation.getCityName(searchWeatherForCity.getText().toString(), this);

	}


	@Override
	public void onSuccess(Map<String, CitySearchActivityViewModel> citySearchActivityViewModel) {
		context = CitySearchActivity.this;
		Intent intent = new Intent(context,ShowWeatherDetailsActivity.class);
		intent.putExtra("data", (Serializable) citySearchActivityViewModel);
		startActivity(intent);
	}
}
