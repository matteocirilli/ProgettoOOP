package it.univpm.projectOOP.filters_statistics;

import java.util.ArrayList;

import it.univpm.projectOOP.exceptions.WrongFilterException;
import it.univpm.projectOOP.model.FacebookAlbum;

public class Filtri {


	public static ArrayList<FacebookAlbum> filtroRisoluzione (ArrayList<FacebookAlbum> myfblist, String filter, int width, int height) throws WrongFilterException  {
		// TODO Auto-generated method stub

		ArrayList<FacebookAlbum> filteredList = new ArrayList<FacebookAlbum>();


		FacebookAlbum albumfilt = new FacebookAlbum();
		ArrayList<String> datecreazione = new ArrayList <String>();
		ArrayList<Integer> dimensioni = new ArrayList <Integer>();
		ArrayList<String> pixel_img = new ArrayList <String>();

		if (!filter.equals("$gt") && !filter.equals("$gte") && !filter.equals("$lt") && !filter.equals("$lte") ) 
			throw new WrongFilterException("Il filtro inserito non è corretto");

		for (int i = 0; i < myfblist.size(); i++) {		


			for (int j=0; j<myfblist.get(i).getByte_dimension().size(); j++) {


				if (filter.equals("$gt") && myfblist.get(i).getByte_dimension().get(j) > width*height) {
					dimensioni.add(myfblist.get(i).getByte_dimension().get(j));
					datecreazione.add(myfblist.get(i).getCreated_time().get(j));
					pixel_img.add(myfblist.get(i).getPixel().get(j));

				}
				if (filter.equals("$gte") && myfblist.get(i).getByte_dimension().get(j) >= width*height) {
					dimensioni.add(myfblist.get(i).getByte_dimension().get(j));
					datecreazione.add(myfblist.get(i).getCreated_time().get(j));
					pixel_img.add(myfblist.get(i).getPixel().get(j));
				}
				if (filter.equals("$lt") && myfblist.get(i).getByte_dimension().get(j) < width*height) {
					dimensioni.add(myfblist.get(i).getByte_dimension().get(j));
					datecreazione.add(myfblist.get(i).getCreated_time().get(j));
					pixel_img.add(myfblist.get(i).getPixel().get(j));
				}
				if (filter.equals("$lte") && myfblist.get(i).getByte_dimension().get(j) <= width*height) {
					dimensioni.add(myfblist.get(i).getByte_dimension().get(j));
					datecreazione.add(myfblist.get(i).getCreated_time().get(j));
					pixel_img.add(myfblist.get(i).getPixel().get(j));
				}

			}
			albumfilt.setCreated_time(datecreazione);
			albumfilt.setByte_dimension(dimensioni);
			albumfilt.setPixel(pixel_img);

			filteredList.add(albumfilt);

		}
		return filteredList;
	}



}
