package it.univpm.projectOOP.model;
import java.util.ArrayList;


public class FacebookAlbum {
	
	private static int AlbumNumber = 0;
	

	private ArrayList <FbAlbumPhoto> Album;
	
	public FacebookAlbum() {
		
		AlbumNumber++;
	}
	

	/**
	 * @return the album
	 */
	public ArrayList<FbAlbumPhoto> getAlbum() {
		return Album;
	}

	/**
	 * @param album the album to set
	 */
	public void setAlbum(ArrayList<FbAlbumPhoto> album) {
		Album = album;
	}
	
	
	
	
	
	
	
}
