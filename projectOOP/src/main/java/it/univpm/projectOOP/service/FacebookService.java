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
<<<<<<< HEAD
=======

		FacebookAlbum album = new FacebookAlbum();
		ArrayList<Integer> altezza = album.getHeight();
		ArrayList<Integer> larghezza = album.getWidth();
		ArrayList<String> datecreazione = album.getCreated_time();

>>>>>>> branch 'master' of https://github.com/matteocirilli/ProgettoOOP.git
		JSONObject obj = new JSONObject(jsonString);
		JSONObject photos = obj.getJSONObject("photos");
		JSONArray data = photos.getJSONArray("data");

		for(int i=0;i<data.length();i++)
		{
			altezza.add(data.getJSONObject(i).getInt("height"));
			larghezza.add(data.getJSONObject(i).getInt("width"));
			datecreazione.add(data.getJSONObject(i).getString("created_time"));
		}
		myfblist.add(album);




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
