package covidtrackerserviceproducer;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.org.json.JSONArray;
import com.org.json.JSONObject;
import com.org.json.JSONParser;

public class CovidTrackerPublishImpl implements CovidTrackerPublish {
	private int totalConfirmed;
	private int totalDeaths;
	private int totalRecovered;
	private String dataStream = "";
	private int responseCode;

	@Override
	public int getTotalConfirmed(String countryName) {
		this.dataStream = "";
		try {
			URL url = new URL("https://api.covid19api.com/summary");
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
			JSONArray jArr_countries = (JSONArray) jObj_main.get("Countries");
			for(int i = 0; i < jArr_countries.size(); i++) {
				JSONObject jObj_cname = (JSONObject) jArr_countries.get(i);
				if(jObj_cname.get("Country").toString().equals(countryName)) {
					this.totalConfirmed = Integer.parseInt(jObj_cname.get("TotalConfirmed").toString());
					break;
				}else {
					continue;
				}
					
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.totalConfirmed;	
	}

	@Override
	public int getTotalDeaths(String countryName) {
		this.dataStream = "";
		try {
			URL url = new URL("https://api.covid19api.com/summary");
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
			JSONArray jArr_countries = (JSONArray) jObj_main.get("Countries");
			for(int i = 0; i < jArr_countries.size(); i++) {
				JSONObject jObj_cname = (JSONObject) jArr_countries.get(i);
				if(jObj_cname.get("Country").toString().equals(countryName)) {
					this.totalDeaths = Integer.parseInt(jObj_cname.get("TotalDeaths").toString());
					break;
				}else {
					continue;
				}
					
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.totalDeaths;	
	}

	@Override
	public int getTotalRecovered(String countryName) {
		
		return 0;
	}

}
