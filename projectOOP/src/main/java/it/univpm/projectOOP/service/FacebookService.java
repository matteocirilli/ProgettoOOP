package it.univpm.projectOOP.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.ArrayList;

import it.univpm.projectOOP.model.FacebookAlbum;

import org.json.*;



public class FacebookService {
	private ArrayList<FacebookAlbum> myfblist = new ArrayList<FacebookAlbum>();

	public ArrayList<FacebookAlbum> getFacebookAlbums () {
		return myfblist;
	}



	public FacebookAlbum[] ParseJson (String jsonString) {
	public void ParseJson (String jsonString) {
		JSONObject obj = new JSONObject(jsonString);
		JSONObject photos = obj.getJSONObject("photos");
		JSONArray data = photos.getJSONArray("data");
		
		


	}


	public String getFromFacebook (String fburl) {
		
		StringBuilder response = new StringBuilder();
		int responsecode=0;
		
		try {

			URL url = new URL(fburl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			//useragent
			BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = read.readLine();

			while(line!=null) {
				response.append(line);
				responsecode = connection.getResponseCode();

			}

		} catch(MalformedURLException ex) {
			ex.printStackTrace();
		} catch(IOException ioex) {
			ioex.printStackTrace();
		}
			
		
		return response.toString();	
		

	}

}
