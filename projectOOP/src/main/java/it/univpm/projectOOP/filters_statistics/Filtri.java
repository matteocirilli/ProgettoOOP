package it.univpm.projectOOP.filters_statistics;

import java.util.ArrayList;

import it.univpm.projectOOP.exceptions.WrongFilterException;
import it.univpm.projectOOP.model.FacebookAlbum;
import it.univpm.projectOOP.model.FbAlbumPhoto;

// TODO: Auto-generated Javadoc
/**
 * The Class Filtri.
 */
public class Filtri {

	/**
	 * Filtro larghezza.
	 *
	 * @param myfblist the myfblist
	 * @param filter   the filter
	 * @param width    the width
	 * @param width2   the width 2
	 * @return the array list
	 * @throws WrongFilterException the wrong filter exception
	 */
	public static ArrayList<FacebookAlbum> filtroLarghezza(ArrayList<FacebookAlbum> myfblist, String filter, int width,
			int width2) throws WrongFilterException {

		ArrayList<FacebookAlbum> filteredList = new ArrayList<FacebookAlbum>();

		FacebookAlbum albumfilt = new FacebookAlbum();

		if (!filter.equals("$gt") && !filter.equals("$gte") && !filter.equals("$lt") && !filter.equals("$lte")
				&& !filter.equals("$bt"))
			throw new WrongFilterException("Il filtro inserito non è corretto");

		ArrayList<FbAlbumPhoto> photofilt = new ArrayList<FbAlbumPhoto>();

		FbAlbumPhoto NotPhoto = new FbAlbumPhoto();

		for (int i = 0; i < myfblist.size(); i++) {

			for (int j = 0; j < myfblist.get(i).getAlbum().size(); j++) {

				FbAlbumPhoto fotofilt = new FbAlbumPhoto();

				if (filter.equals("$gt") && myfblist.get(i).getAlbum().get(j).getWidth() > width) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setByte_dimension(myfblist.get(i).getAlbum().get(j).getByte_dimension());

				}
				if (filter.equals("$gte") && myfblist.get(i).getAlbum().get(j).getWidth() >= width) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setByte_dimension(myfblist.get(i).getAlbum().get(j).getByte_dimension());
				}
				if (filter.equals("$lt") && myfblist.get(i).getAlbum().get(j).getWidth() < width) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setByte_dimension(myfblist.get(i).getAlbum().get(j).getByte_dimension());
				}
				if (filter.equals("$lte") && myfblist.get(i).getAlbum().get(j).getWidth() <= width) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setByte_dimension(myfblist.get(i).getAlbum().get(j).getByte_dimension());
				}
				if (filter.equals("$bt") && myfblist.get(i).getAlbum().get(j).getWidth() >= width
						&& myfblist.get(i).getAlbum().get(j).getWidth() <= width2) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setByte_dimension(myfblist.get(i).getAlbum().get(j).getByte_dimension());

				}

				if (!fotofilt.equals(NotPhoto))
					photofilt.add(fotofilt);

			}
			if (!photofilt.equals(null)) {
				albumfilt.setAlbum(photofilt);
				filteredList.add(albumfilt);
			}

		}
		return filteredList;
	}

	/**
	 * Filtro altezza.
	 *
	 * @param myfblist the myfblist
	 * @param filter   the filter
	 * @param height   the height
	 * @param height2  the height 2
	 * @return the array list
	 * @throws WrongFilterException the wrong filter exception
	 */
	public static ArrayList<FacebookAlbum> filtroAltezza(ArrayList<FacebookAlbum> myfblist, String filter, int height,
			int height2) throws WrongFilterException {

		ArrayList<FacebookAlbum> filteredList = new ArrayList<FacebookAlbum>();

		FacebookAlbum albumfilt = new FacebookAlbum();

		FbAlbumPhoto NotPhoto = new FbAlbumPhoto();

		if (!filter.equals("$gt") && !filter.equals("$gte") && !filter.equals("$lt") && !filter.equals("$lte")
				&& !filter.equals("$bt"))
			throw new WrongFilterException("Il filtro inserito non è corretto");

		ArrayList<FbAlbumPhoto> photofilt = new ArrayList<FbAlbumPhoto>();

		for (int i = 0; i < myfblist.size(); i++) {

			for (int j = 0; j < myfblist.get(i).getAlbum().size(); j++) {

				FbAlbumPhoto fotofilt = new FbAlbumPhoto();

				if (filter.equals("$gt") && myfblist.get(i).getAlbum().get(j).getHeight() > height) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setByte_dimension(myfblist.get(i).getAlbum().get(j).getByte_dimension());

				}
				if (filter.equals("$gte") && myfblist.get(i).getAlbum().get(j).getHeight() >= height) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setByte_dimension(myfblist.get(i).getAlbum().get(j).getByte_dimension());
				}
				if (filter.equals("$lt") && myfblist.get(i).getAlbum().get(j).getHeight() < height) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setByte_dimension(myfblist.get(i).getAlbum().get(j).getByte_dimension());
				}
				if (filter.equals("$lte") && myfblist.get(i).getAlbum().get(j).getHeight() <= height) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setByte_dimension(myfblist.get(i).getAlbum().get(j).getByte_dimension());
				}
				if (filter.equals("$bt") && myfblist.get(i).getAlbum().get(j).getHeight() >= height
						&& myfblist.get(i).getAlbum().get(j).getHeight() <= height2) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setByte_dimension(myfblist.get(i).getAlbum().get(j).getByte_dimension());

				}
				if (!fotofilt.equals(NotPhoto))
					photofilt.add(fotofilt);

			}
			if (!photofilt.equals(null)) {
				albumfilt.setAlbum(photofilt);
				filteredList.add(albumfilt);
			}

		}
		return filteredList;
	}

	/**
	 * Filtro larghezza dim.
	 *
	 * @param myfblist        the myfblist
	 * @param filter          the filter
	 * @param width           the width
	 * @param width2          the width 2
	 * @param byte_dimension  the byte dimension
	 * @param byte_dimension2 the byte dimension 2
	 * @return the array list
	 * @throws WrongFilterException the wrong filter exception
	 */
	public static ArrayList<FacebookAlbum> filtroLarghezzaDim(ArrayList<FacebookAlbum> myfblist, String filter,
			int width, int width2, int byte_dimension, int byte_dimension2) throws WrongFilterException {

		ArrayList<FacebookAlbum> filteredList = new ArrayList<FacebookAlbum>();

		FacebookAlbum albumfilt = new FacebookAlbum();

		FbAlbumPhoto NotPhoto = new FbAlbumPhoto();

		if (!filter.equals("$gt") && !filter.equals("$gte") && !filter.equals("$lt") && !filter.equals("$lte")
				&& !filter.equals("$bt"))
			throw new WrongFilterException("Il filtro inserito non è corretto");

		ArrayList<FbAlbumPhoto> photofilt = new ArrayList<FbAlbumPhoto>();

		for (int i = 0; i < myfblist.size(); i++) {

			for (int j = 0; j < myfblist.get(i).getAlbum().size(); j++) {

				FbAlbumPhoto fotofilt = new FbAlbumPhoto();

				if (filter.equals("$gt") && myfblist.get(i).getAlbum().get(j).getWidth() > width
						&& myfblist.get(i).getAlbum().get(j).getByte_dimension() > byte_dimension) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setByte_dimension(myfblist.get(i).getAlbum().get(j).getByte_dimension());

				}
				if (filter.equals("$gte") && myfblist.get(i).getAlbum().get(j).getWidth() >= width
						&& myfblist.get(i).getAlbum().get(j).getByte_dimension() >= byte_dimension) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setByte_dimension(myfblist.get(i).getAlbum().get(j).getByte_dimension());
				}
				if (filter.equals("$lt") && myfblist.get(i).getAlbum().get(j).getWidth() < width
						&& myfblist.get(i).getAlbum().get(j).getByte_dimension() < byte_dimension) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setByte_dimension(myfblist.get(i).getAlbum().get(j).getByte_dimension());
				}
				if (filter.equals("$lte") && myfblist.get(i).getAlbum().get(j).getWidth() <= width
						&& myfblist.get(i).getAlbum().get(j).getByte_dimension() <= byte_dimension) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setByte_dimension(myfblist.get(i).getAlbum().get(j).getByte_dimension());
				}
				if (filter.equals("$bt") && myfblist.get(i).getAlbum().get(j).getWidth() >= width
						&& myfblist.get(i).getAlbum().get(j).getWidth() >= width2
						&& myfblist.get(i).getAlbum().get(j).getByte_dimension() >= byte_dimension
						&& myfblist.get(i).getAlbum().get(j).getByte_dimension() <= byte_dimension2) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setByte_dimension(myfblist.get(i).getAlbum().get(j).getByte_dimension());

				}
				if (!fotofilt.equals(NotPhoto))
					photofilt.add(fotofilt);

			}
			if (!photofilt.equals(null)) {
				albumfilt.setAlbum(photofilt);
				filteredList.add(albumfilt);
			}

		}
		return filteredList;
	}

	/**
	 * Filtro altezza dim.
	 *
	 * @param myfblist        the myfblist
	 * @param filter          the filter
	 * @param height          the height
	 * @param height2         the height 2
	 * @param byte_dimension  the byte dimension
	 * @param byte_dimension2 the byte dimension 2
	 * @return the array list
	 * @throws WrongFilterException the wrong filter exception
	 */
	public static ArrayList<FacebookAlbum> filtroAltezzaDim(ArrayList<FacebookAlbum> myfblist, String filter,
			int height, int height2, int byte_dimension, int byte_dimension2) throws WrongFilterException {

		ArrayList<FacebookAlbum> filteredList = new ArrayList<FacebookAlbum>();

		FacebookAlbum albumfilt = new FacebookAlbum();
		FbAlbumPhoto NotPhoto = new FbAlbumPhoto();

		if (!filter.equals("$gt") && !filter.equals("$gte") && !filter.equals("$lt") && !filter.equals("$lte")
				&& !filter.equals("$bt"))
			throw new WrongFilterException("Il filtro inserito non è corretto");

		ArrayList<FbAlbumPhoto> photofilt = new ArrayList<FbAlbumPhoto>();

		for (int i = 0; i < myfblist.size(); i++) {

			for (int j = 0; j < myfblist.get(i).getAlbum().size(); j++) {

				FbAlbumPhoto fotofilt = new FbAlbumPhoto();

				if (filter.equals("$gt") && myfblist.get(i).getAlbum().get(j).getHeight() > height
						&& myfblist.get(i).getAlbum().get(j).getByte_dimension() > byte_dimension) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setByte_dimension(myfblist.get(i).getAlbum().get(j).getByte_dimension());

				}
				if (filter.equals("$gte") && myfblist.get(i).getAlbum().get(j).getHeight() >= height
						&& myfblist.get(i).getAlbum().get(j).getByte_dimension() >= byte_dimension) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setByte_dimension(myfblist.get(i).getAlbum().get(j).getByte_dimension());
				}
				if (filter.equals("$lt") && myfblist.get(i).getAlbum().get(j).getHeight() < height
						&& myfblist.get(i).getAlbum().get(j).getByte_dimension() < byte_dimension) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setByte_dimension(myfblist.get(i).getAlbum().get(j).getByte_dimension());
				}
				if (filter.equals("$lte") && myfblist.get(i).getAlbum().get(j).getHeight() <= height) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setByte_dimension(myfblist.get(i).getAlbum().get(j).getByte_dimension());
				}
				if (filter.equals("$bt") && myfblist.get(i).getAlbum().get(j).getHeight() >= height
						&& myfblist.get(i).getAlbum().get(j).getHeight() >= height2
						&& myfblist.get(i).getAlbum().get(j).getByte_dimension() >= byte_dimension
						&& myfblist.get(i).getAlbum().get(j).getByte_dimension() <= byte_dimension2) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setByte_dimension(myfblist.get(i).getAlbum().get(j).getByte_dimension());

				}
				if (!fotofilt.equals(NotPhoto))
					photofilt.add(fotofilt);

			}
			if (!photofilt.equals(null)) {
				albumfilt.setAlbum(photofilt);
				filteredList.add(albumfilt);
			}

		}
		return filteredList;
	}

}
