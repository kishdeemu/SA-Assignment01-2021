package weatherserviceproducer;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.org.json.JSONArray;
import com.org.json.JSONObject;
import com.org.json.JSONParser;

public class WeatherServicePublishImpl implements WeatherServicePublish{
	private int responseCode;
	private String wDescription = "";
	private double wTemp;
	private String dataStream = "";
	private int wHumidity;

	@Override
	public String getDesciption(String cityName) throws IOException {
		this.dataStream = "";
		try {
			URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q="+cityName+"&appid=9ca8f530fb5813dd72065d8d791d2049");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			this.responseCode = conn.getResponseCode();
			if(this.responseCode != 200) {
				throw new RuntimeException("HttpResponseCode: " + this.responseCode);
			}else {
				Scanner sc = new Scanner(url.openStream());
				while(sc.hasNext()) {
					this.dataStream+=sc.nextLine();
				}
				sc.close();
				
			}
			JSONParser parse = new JSONParser();
			
			JSONObject jObj_main = (JSONObject) parse.parse(this.dataStream);
			JSONArray jArr_weather = (JSONArray) jObj_main.get("weather");
			JSONObject jObj_description = (JSONObject) jArr_weather.get(0);
			this.wDescription = jObj_description.get("description").toString();
			conn.disconnect();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.wDescription;	
	}

	@Override
	public double getTemperature(String cityName) throws IOException {
		this.dataStream = "";
		try {
			URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q="+cityName+"&appid=9ca8f530fb5813dd72065d8d791d2049");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			this.responseCode = conn.getResponseCode();
			if(this.responseCode != 200) {
				throw new RuntimeException("HttpResponseCode: " + this.responseCode);
			}else {
				Scanner sc = new Scanner(url.openStream());
				while(sc.hasNext()) {
					this.dataStream+=sc.nextLine();
				}
				sc.close();
				
			}
			JSONParser parse = new JSONParser();
			
			JSONObject jObj_main = (JSONObject) parse.parse(this.dataStream);
			JSONObject jObj_temp = (JSONObject) jObj_main.get("main");
			this.wTemp = (double) jObj_temp.get("temp");
			conn.disconnect();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.wTemp;	
	}

	@Override
	public int getHumidity(String cityName) throws IOException {
		this.dataStream = "";
		try {
			URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q="+cityName+"&appid=9ca8f530fb5813dd72065d8d791d2049");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			this.responseCode = conn.getResponseCode();
			if(this.responseCode != 200) {
				throw new RuntimeException("HttpResponseCode: " + this.responseCode);
			}else {
				Scanner sc = new Scanner(url.openStream());
				while(sc.hasNext()) {
					this.dataStream+=sc.nextLine();
				}
				sc.close();
				
			}
			JSONParser parse = new JSONParser();
			
			JSONObject jObj_main = (JSONObject) parse.parse(this.dataStream);
			JSONObject jObj_temp = (JSONObject) jObj_main.get("main");
			this.wHumidity = (int) jObj_temp.get("humidity");
			conn.disconnect();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.wHumidity;	
	}

}
