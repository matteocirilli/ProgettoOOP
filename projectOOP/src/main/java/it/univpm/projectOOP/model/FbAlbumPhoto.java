package it.univpm.projectOOP.model;

/**
 * Classe FbAlbumPhoto
 */
public class FbAlbumPhoto {

	/** Dichiarazione larghezza. */
	private int width;

	/** Dichiarazione altezza. */
	private int height;

	/** Dichiarazione numero di pixel. */
	private String pixel;

	/** Dichiarazione numero kilobyte di una foto. */
	private int kbyte_dimension;

	/** Dichiarazione data di crezione. */
	private String created_time;

	/**
	 * Overriding del metodo equals
	 *
	 * @param obj oggetto
	 * @return true, se va a buon fine
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
		if (kbyte_dimension != other.kbyte_dimension)
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
	 * Metodo GET per numero di pixel
	 *
	 * @return numero di pixel
	 */
	public String getPixel() {
		return pixel;
	}

	/**
	 * Metodo SET per numero di pixel
	 *
	 * @param pixel numero di pixel da settare
	 */
	public void setPixel(String pixel) {
		this.pixel = pixel;
	}

	/**
	 * Metodo GET per altezza
	 *
	 * @return l'altezza
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Metodo SET per altezza
	 *
	 * @param height altezza da settare
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Metodo GET per larghezza
	 *
	 * @return l'altezza
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Metodo SET per larghezza
	 *
	 * @param width larghezza da settare
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Metodo GET per data di crezione
	 *
	 * @return la data di crezione
	 */
	public String getCreated_time() {
		return created_time;
	}

	/**
	 * Metodo SET per data di crezione
	 *
	 * @param created_time data di crezione da settare
	 */
	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}

	/**
	 * Metodo GET per numero kilobyte di una foto
	 *
	 * @return il numero kilobyte di una foto
	 */
	public int getKbyte_dimension() {
		return kbyte_dimension;
	}

	/**
	 * Metodo SET per numero kilobyte di una foto
	 *
	 * @param kbyte_dimension numero kilobyte da settare
	 */
	public void setKbyte_dimension(int kbyte_dimension) {
		this.kbyte_dimension = kbyte_dimension;
	}

}
