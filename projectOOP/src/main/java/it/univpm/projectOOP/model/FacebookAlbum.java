package it.univpm.projectOOP.model;

import java.util.ArrayList;

/**
 * Classw FacebookAlbum.
 */
public class FacebookAlbum {

	/** Dichiarazione di un facebook album. */
	private ArrayList<FbAlbumPhoto> Album;

	/**
	 * Metodo GET per il facebook album.
	 *
	 * @return il facebook album
	 */
	public ArrayList<FbAlbumPhoto> getAlbum() {
		return Album;
	}

	/**
	 * Metodo SET per il facebook album.
	 *
	 * @param album facebook album da settare
	 */
	public void setAlbum(ArrayList<FbAlbumPhoto> album) {
		Album = album;
	}

}
