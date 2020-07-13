package it.univpm.projectOOP.model;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class FacebookAlbum.
 */
public class FacebookAlbum {

	/** The Album number. */
	private static int AlbumNumber = 0;

	/** The Album. */
	private ArrayList<FbAlbumPhoto> Album;

	/**
	 * Instantiates a new facebook album.
	 */
	public FacebookAlbum() {

		AlbumNumber++;
	}

	/**
	 * Gets the album.
	 *
	 * @return the album
	 */
	public ArrayList<FbAlbumPhoto> getAlbum() {
		return Album;
	}

	/**
	 * Sets the album.
	 *
	 * @param album the album to set
	 */
	public void setAlbum(ArrayList<FbAlbumPhoto> album) {
		Album = album;
	}

}
