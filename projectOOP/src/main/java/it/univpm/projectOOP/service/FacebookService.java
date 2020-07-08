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

import it.univpm.projectOOP.filters_statistics.Filtri;
import it.univpm.projectOOP.model.FacebookAlbum;

import org.json.*;



public class FacebookService {
	private ArrayList<FacebookAlbum> myfblist = new ArrayList<FacebookAlbum>();


	public ArrayList<FacebookAlbum> getFacebookAlbums () {
		return myfblist;
	}
	public void ParseJson (String jsonString) throws ParseException {


		FacebookAlbum album = new FacebookAlbum();	

		//ArrayList<Integer> altezza = new  ArrayList<Integer>();
		//ArrayList<Integer> larghezza = new ArrayList <Integer>();
		ArrayList<String> datecreazione = new ArrayList <String>();
		ArrayList<Integer> dimensioni = new ArrayList <Integer>();
		ArrayList<String> pixel_img = new ArrayList <String>();


		JSONObject obj = new JSONObject(jsonString);
		JSONObject photos = obj.getJSONObject("photos");
		JSONArray data = photos.getJSONArray("data");



		for(int i=0;i<data.length();i++)
		{
			//altezza.add(data.getJSONObject(i).getInt("height"));
			//larghezza.add(data.getJSONObject(i).getInt("width"));
			String s = data.getJSONObject(i).getString("created_time");
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+0000'");
			Date date = dateFormat.parse(s);
			DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
			String dateStr = formatter.format(date);
			datecreazione.add(dateStr);
			
			pixel_img.add((data.getJSONObject(i).getInt("width"))+ " X " + (data.getJSONObject(i).getInt("height")));
			dimensioni.add((data.getJSONObject(i).getInt("height"))*(data.getJSONObject(i).getInt("width")));
		}

		//album.setHeight(altezza);
		album.setCreated_time(datecreazione);
		//album.setWidth(larghezza);
		album.setByte_dimension(dimensioni);
		album.setPixel(pixel_img);


		myfblist.add(album);




	}


	public String getFromFacebook (String fburl) {

		String response = "";
	

		try {

			URL url = new URL(fburl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
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
	
	public void filtro (String body)  {
		
		JSONObject jbody = new JSONObject(body);
		
		int width =  jbody.getInt("width");
		int height = jbody.getInt("height");
		String filter = jbody.getString("filter");
		
		myfblist = Filtri.filtroRisoluzione(myfblist, filter, width, height);
		/**Eccezione che parte dal momento in cui i filtri inseriti non sono corretti*/
		//if (!filterFiled.equals("likes") && !filterFiled.equals("retweets") && !filterFiled.equals("time") && !filterFiled.equals("data") ) 
			//throw new WrongFilterException("Il filtro inserito non è corretto!");
		
		
		
	}


}
