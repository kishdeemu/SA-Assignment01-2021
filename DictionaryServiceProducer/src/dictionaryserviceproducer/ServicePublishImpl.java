package dictionaryserviceproducer;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import com.org.json.JSONArray;
import com.org.json.JSONObject;
import com.org.json.JSONParser;

public class ServicePublishImpl implements ServicePublish{
	private int responseCode;
	private String dataStream = "";
	private String meaning = "";
	private String example = "";
	private ArrayList<String> synonyms = new ArrayList<String>() ;

	@Override
	public String getMeaning(String word) throws IOException{
		this.dataStream = "";
		try {
			URL url = new URL("https://api.dictionaryapi.dev/api/v2/entries/en_US/"+word);
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
			
			JSONArray jsonarr = (JSONArray) parse.parse(this.dataStream);
			JSONObject jsonObj = (JSONObject) jsonarr.get(0);
			JSONArray jsonarr2 = (JSONArray) jsonObj.get("meanings");
			JSONObject jsonObj2 = (JSONObject) jsonarr2.get(0);
			JSONArray jsonarr3 = (JSONArray) jsonObj2.get("definitions");
			JSONObject jsonObj3 = (JSONObject) jsonarr3.get(0);
			this.meaning = jsonObj3.get("definition").toString();
			conn.disconnect();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.meaning;
	}

	@Override
	public ArrayList<String> getSynonyms(String word) throws IOException {
		this.dataStream = "";
		try {
			URL url = new URL("https://api.dictionaryapi.dev/api/v2/entries/en_US/"+word);
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
			
			JSONArray jsonarr = (JSONArray) parse.parse(this.dataStream);
			JSONObject jsonObj = (JSONObject) jsonarr.get(0);
			JSONArray jsonarr2 = (JSONArray) jsonObj.get("meanings");
			JSONObject jsonObj2 = (JSONObject) jsonarr2.get(0);
			JSONArray jsonarr3 = (JSONArray) jsonObj2.get("definitions");
			JSONObject jsonObj3 = (JSONObject) jsonarr3.get(0);
			JSONArray synonymsArr = (JSONArray) jsonObj3.get("synonyms");
			for(int i = 0; i < synonymsArr.size(); i++) {
				this.synonyms.add(synonymsArr.get(i).toString());
			}
			conn.disconnect();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.synonyms;
	}

	@Override
	public String getExample(String word) throws IOException {
		this.dataStream = "";
		try {
			URL url = new URL("https://api.dictionaryapi.dev/api/v2/entries/en_US/"+word);
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
			
			JSONArray jsonarr = (JSONArray) parse.parse(this.dataStream);
			JSONObject jsonObj = (JSONObject) jsonarr.get(0);
			JSONArray jsonarr2 = (JSONArray) jsonObj.get("meanings");
			JSONObject jsonObj2 = (JSONObject) jsonarr2.get(0);
			JSONArray jsonarr3 = (JSONArray) jsonObj2.get("definitions");
			JSONObject jsonObj3 = (JSONObject) jsonarr3.get(0);
			this.example = jsonObj3.get("example").toString();
			conn.disconnect();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.example;
	
		
	}
	

}
