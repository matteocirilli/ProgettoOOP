package it.univpm.projectOOP.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import it.univpm.projectOOP.model.FacebookAlbum;

import org.json.*;



public class FacebookService {
	private ArrayList<FacebookAlbum> myfblist = new ArrayList<FacebookAlbum>();


	public ArrayList<FacebookAlbum> getFacebookAlbums () {
		return myfblist;
	}
	public void ParseJson (String jsonString) throws ParseException {


		FacebookAlbum album = new FacebookAlbum();	

		ArrayList<Integer> altezza = new  ArrayList<Integer>();
		ArrayList<Integer> larghezza = new ArrayList <Integer>();
		ArrayList<String> datecreazione = new ArrayList <String>();
		ArrayList<Integer> dimensioni = new ArrayList <Integer>();


		JSONObject obj = new JSONObject(jsonString);
		JSONObject photos = obj.getJSONObject("photos");
		JSONArray data = photos.getJSONArray("data");



		for(int i=0;i<data.length();i++)
		{
			altezza.add(data.getJSONObject(i).getInt("height"));
			larghezza.add(data.getJSONObject(i).getInt("width"));
			String s = data.getJSONObject(i).getString("created_time");
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+0000'");
			Date date = dateFormat.parse(s);//You will get date object relative to server/client timezone wherever it is parsed
			DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); //If you need time just put specific format for time like 'HH:mm:ss'
			String dateStr = formatter.format(date);
			datecreazione.add(dateStr);
			
			dimensioni.add((data.getJSONObject(i).getInt("height"))*(data.getJSONObject(i).getInt("width")));
		}

		album.setHeight(altezza);
		album.setCreated_time(datecreazione);
		album.setWidth(larghezza);
		album.setByte_dimension(dimensioni);


		myfblist.add(album);




	}


	public String getFromFacebook (String fburl) {

		String response = "";
		int responsecode=0;

		try {

			URL url = new URL(fburl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			//useragent
			BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = read.readLine();

			response=line;


		} catch(MalformedURLException ex) {
			ex.printStackTrace();
		} catch(IOException ioex) {
			ioex.printStackTrace();
		}


		return response;


	}

}
