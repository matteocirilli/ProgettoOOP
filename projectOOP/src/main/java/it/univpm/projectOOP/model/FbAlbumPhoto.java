package it.univpm.projectOOP.model;



// TODO: Auto-generated Javadoc
/**
 * The Class FbAlbumPhoto.
 */
public class FbAlbumPhoto {


	/** The width. */
	private int width;
	
	/** The height. */
	private int height;
	
	/** The pixel. */
	private String pixel;
	
	/** The byte dimension. */
	private int byte_dimension;
	
	/** The created time. */
	private String created_time;



	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FbAlbumPhoto other = (FbAlbumPhoto) obj;
		if (byte_dimension != other.byte_dimension)
			return false;
		if (created_time == null) {
			if (other.created_time != null)
				return false;
		} else if (!created_time.equals(other.created_time))
			return false;
		if (height != other.height)
			return false;
		if (pixel == null) {
			if (other.pixel != null)
				return false;
		} else if (!pixel.equals(other.pixel))
			return false;
		if (width != other.width)
			return false;
		return true;
	}
	
	/**
	 * Gets the pixel.
	 *
	 * @return the pixel
	 */
	public String getPixel() {
		return pixel;
	}
	
	/**
	 * Sets the pixel.
	 *
	 * @param pixel the pixel to set
	 */
	public void setPixel(String pixel) {
		this.pixel = pixel;
	}
	
	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Sets the height.
	 *
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Sets the width.
	 *
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * Gets the created time.
	 *
	 * @return the created_time
	 */
	public String getCreated_time() {
		return created_time;
	}
	
	/**
	 * Sets the created time.
	 *
	 * @param created_time the created_time to set
	 */
	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}
	
	/**
	 * Gets the byte dimension.
	 *
	 * @return the byte_dimension
	 */
	public int getByte_dimension() {
		return byte_dimension;
	}
	
	/**
	 * Sets the byte dimension.
	 *
	 * @param byte_dimension the byte_dimension to set
	 */
	public void setByte_dimension(int byte_dimension) {
		this.byte_dimension = byte_dimension;
	}




}
