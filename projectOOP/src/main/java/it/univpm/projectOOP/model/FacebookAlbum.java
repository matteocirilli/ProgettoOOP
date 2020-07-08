package it.univpm.projectOOP.model;
import java.util.ArrayList;

public class FacebookAlbum {

	
	private ArrayList <String> pixel;
	//private ArrayList <Integer> height;
	//private ArrayList <Integer> width;
	private ArrayList <String> created_time;
	private ArrayList <Integer> byte_dimension;
	
	public FacebookAlbum() {
		
	}

	/**
	 * @return the byte_dimension
	 */
	public ArrayList<Integer> getByte_dimension() {
		return byte_dimension;
	}

	/**
	 * @param byte_dimension the byte_dimension to set
	 */
	public void setByte_dimension(ArrayList<Integer> byte_dimension) {
		this.byte_dimension = byte_dimension;
	}

	/**
	 * @return the height
	 */
//	public ArrayList<Integer> getHeight() {
//		return height;
//	}
//
//	/**
//	 * @param height the height to set
//	 */
//	public void setHeight(ArrayList<Integer> height) {
//		this.height = height;
//	}
//
//	/**
//	 * @return the width
//	 */
//	public ArrayList<Integer> getWidth() {
//		return width;
//	}
//
//	/**
//	 * @param width the width to set
//	 */
//	public void setWidth(ArrayList<Integer> width) {
//		this.width = width;
//	}

	/**
	 * @return the created_time
	 */
	public ArrayList<String> getCreated_time() {
		return created_time;
	}

	/**
	 * @return the pixel
	 */
	public ArrayList<String> getPixel() {
		return pixel;
	}

	/**
	 * @param pixel the pixel to set
	 */
	public void setPixel(ArrayList<String> pixel) {
		this.pixel = pixel;
	}

	/**
	 * @param created_time the created_time to set
	 */
	public void setCreated_time(ArrayList<String> created_time) {
		this.created_time = created_time;
	}
	
	
	
	
	
	
	
}
