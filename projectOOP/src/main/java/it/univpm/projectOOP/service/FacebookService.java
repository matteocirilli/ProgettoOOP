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
	
	
	public int ParseJson () {
	JSONObject obj = new JSONObject(jsonString);
	String pageName = obj.getJSONObject("pageInfo").getString("pageName");

	JSONArray arr = obj.getJSONArray("posts");
	for (int i = 0; i < arr.length(); i++)
	{
	    String post_id = arr.getJSONObject(i).getString("post_id");
	    
	}
	
	
	}
	
	

	public int getFromFacebook (String fburl) {
		
		
	int responsecode=0;
		
		try {
		
			  URL url = new URL(fburl);
			  HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			  //useragent
			  BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			  String line = read.readLine();
			  String html = "";
			  
			  while(line!=null) {
			    html += line;
			    line = read.readLine();
			    responsecode = connection.getResponseCode();
			   
			  }
			} catch(MalformedURLException ex) {
			        ex.printStackTrace();
			} catch(IOException ioex) {
			        ioex.printStackTrace();
			}
		
		return responsecode;
		
		
		
	


}

}