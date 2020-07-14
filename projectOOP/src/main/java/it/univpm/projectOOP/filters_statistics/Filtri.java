package it.univpm.projectOOP.filters_statistics;

import java.util.ArrayList;

import it.univpm.projectOOP.exceptions.WrongFilterException;
import it.univpm.projectOOP.model.FacebookAlbum;
import it.univpm.projectOOP.model.FbAlbumPhoto;

/**
 * Classe Filtri
 */
public class Filtri {

	/**
	 * Filtra in base alla larghezza.
	 *
	 * @param myfblist prende come parametro la lista di album
	 * @param filter   prende come parametro il tipo di filtro
	 * @param width    prende come parametro la larghezza
	 * @param width2   prende come parametro la seconda larghezza per il filtro $bt
	 * @return ritorna la lista filtrata
	 * @throws WrongFilterException Eccezione che parte se il filtro non è corretto
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
					fotofilt.setKbyte_dimension(myfblist.get(i).getAlbum().get(j).getKbyte_dimension());

				}
				if (filter.equals("$gte") && myfblist.get(i).getAlbum().get(j).getWidth() >= width) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setKbyte_dimension(myfblist.get(i).getAlbum().get(j).getKbyte_dimension());
				}
				if (filter.equals("$lt") && myfblist.get(i).getAlbum().get(j).getWidth() < width) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setKbyte_dimension(myfblist.get(i).getAlbum().get(j).getKbyte_dimension());
				}
				if (filter.equals("$lte") && myfblist.get(i).getAlbum().get(j).getWidth() <= width) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setKbyte_dimension(myfblist.get(i).getAlbum().get(j).getKbyte_dimension());
				}
				if (filter.equals("$bt") && myfblist.get(i).getAlbum().get(j).getWidth() >= width
						&& myfblist.get(i).getAlbum().get(j).getWidth() <= width2) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setKbyte_dimension(myfblist.get(i).getAlbum().get(j).getKbyte_dimension());

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
	 * Filtra in base all'altezza
	 *
	 * @param myfblist prende come parametro la lista di album
	 * @param filter   prende come parametro il tipo di filtro
	 * @param height   prende come parametro l'altezza
	 * @param height2  prende come parametro la seconda altezza per il filtro $bt
	 * @return ritorna la lista filtrata
	 * @throws WrongFilterException Eccezione che parte se il filtro non è corretto
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
					fotofilt.setKbyte_dimension(myfblist.get(i).getAlbum().get(j).getKbyte_dimension());

				}
				if (filter.equals("$gte") && myfblist.get(i).getAlbum().get(j).getHeight() >= height) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setKbyte_dimension(myfblist.get(i).getAlbum().get(j).getKbyte_dimension());
				}
				if (filter.equals("$lt") && myfblist.get(i).getAlbum().get(j).getHeight() < height) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setKbyte_dimension(myfblist.get(i).getAlbum().get(j).getKbyte_dimension());
				}
				if (filter.equals("$lte") && myfblist.get(i).getAlbum().get(j).getHeight() <= height) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setKbyte_dimension(myfblist.get(i).getAlbum().get(j).getKbyte_dimension());
				}
				if (filter.equals("$bt") && myfblist.get(i).getAlbum().get(j).getHeight() >= height
						&& myfblist.get(i).getAlbum().get(j).getHeight() <= height2) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setKbyte_dimension(myfblist.get(i).getAlbum().get(j).getKbyte_dimension());

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
	 * Filtra in base alla larghezza e alla dimensione in kilobyte
	 *
	 * @param myfblist         prende come parametro la lista di album
	 * @param filter           prende come parametro il tipo di filtro
	 * @param width            prende come parametro la larghezza
	 * @param width2           prende come parametro la seconda larghezza per il
	 *                         filtro $bt
	 * @param kbyte_dimension  prende come parametro la dimensione in kilobyte
	 * @param kbyte_dimension2 prende come parametro la seconda dimensione in
	 *                         kilobyte per il filtro $bt
	 * @return ritorna la lista filtrata
	 * @throws WrongFilterException Eccezione che parte se il filtro non è corretto
	 */
	public static ArrayList<FacebookAlbum> filtroLarghezzaDim(ArrayList<FacebookAlbum> myfblist, String filter,
			int width, int width2, int kbyte_dimension, int kbyte_dimension2) throws WrongFilterException {

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
						&& myfblist.get(i).getAlbum().get(j).getKbyte_dimension() > kbyte_dimension) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setKbyte_dimension(myfblist.get(i).getAlbum().get(j).getKbyte_dimension());

				}
				if (filter.equals("$gte") && myfblist.get(i).getAlbum().get(j).getWidth() >= width
						&& myfblist.get(i).getAlbum().get(j).getKbyte_dimension() >= kbyte_dimension) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setKbyte_dimension(myfblist.get(i).getAlbum().get(j).getKbyte_dimension());
				}
				if (filter.equals("$lt") && myfblist.get(i).getAlbum().get(j).getWidth() < width
						&& myfblist.get(i).getAlbum().get(j).getKbyte_dimension() < kbyte_dimension) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setKbyte_dimension(myfblist.get(i).getAlbum().get(j).getKbyte_dimension());
				}
				if (filter.equals("$lte") && myfblist.get(i).getAlbum().get(j).getWidth() <= width
						&& myfblist.get(i).getAlbum().get(j).getKbyte_dimension() <= kbyte_dimension) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setKbyte_dimension(myfblist.get(i).getAlbum().get(j).getKbyte_dimension());
				}
				if (filter.equals("$bt") && myfblist.get(i).getAlbum().get(j).getWidth() >= width
						&& myfblist.get(i).getAlbum().get(j).getWidth() >= width2
						&& myfblist.get(i).getAlbum().get(j).getKbyte_dimension() >= kbyte_dimension
						&& myfblist.get(i).getAlbum().get(j).getKbyte_dimension() <= kbyte_dimension2) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setKbyte_dimension(myfblist.get(i).getAlbum().get(j).getKbyte_dimension());

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
	 * Filtra in base all'altezza e alla dimensione in kilobyte
	 *
	 * @param myfblist         prende come parametro la lista di album
	 * @param filter           prende come parametro il tipo di filtro
	 * @param height           prende come parametro l'altezza
	 * @param height2          prende come parametro la seconda altezza per il
	 *                         filtro $bt
	 * @param kbyte_dimension  prende come parametro la dimensione in kilobyte
	 * @param kbyte_dimension2 prende come parametro la seconda dimensione in
	 *                         kilobyte per il filtro $bt
	 * @return ritorna la lista filtrata
	 * @throws WrongFilterException Eccezione che parte se il filtro non è corretto
	 */
	public static ArrayList<FacebookAlbum> filtroAltezzaDim(ArrayList<FacebookAlbum> myfblist, String filter,
			int height, int height2, int kbyte_dimension, int kbyte_dimension2) throws WrongFilterException {

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
						&& myfblist.get(i).getAlbum().get(j).getKbyte_dimension() > kbyte_dimension) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setKbyte_dimension(myfblist.get(i).getAlbum().get(j).getKbyte_dimension());

				}
				if (filter.equals("$gte") && myfblist.get(i).getAlbum().get(j).getHeight() >= height
						&& myfblist.get(i).getAlbum().get(j).getKbyte_dimension() >= kbyte_dimension) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setKbyte_dimension(myfblist.get(i).getAlbum().get(j).getKbyte_dimension());
				}
				if (filter.equals("$lt") && myfblist.get(i).getAlbum().get(j).getHeight() < height
						&& myfblist.get(i).getAlbum().get(j).getKbyte_dimension() < kbyte_dimension) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setKbyte_dimension(myfblist.get(i).getAlbum().get(j).getKbyte_dimension());
				}
				if (filter.equals("$lte") && myfblist.get(i).getAlbum().get(j).getHeight() <= height
						&& myfblist.get(i).getAlbum().get(j).getKbyte_dimension() <= kbyte_dimension) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setKbyte_dimension(myfblist.get(i).getAlbum().get(j).getKbyte_dimension());
				}
				if (filter.equals("$bt") && myfblist.get(i).getAlbum().get(j).getHeight() >= height
						&& myfblist.get(i).getAlbum().get(j).getHeight() >= height2
						&& myfblist.get(i).getAlbum().get(j).getKbyte_dimension() >= kbyte_dimension
						&& myfblist.get(i).getAlbum().get(j).getKbyte_dimension() <= kbyte_dimension2) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setKbyte_dimension(myfblist.get(i).getAlbum().get(j).getKbyte_dimension());

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
