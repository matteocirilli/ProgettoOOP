package it.univpm.projectOOP.filters_statistics;

import java.util.ArrayList;

import it.univpm.projectOOP.exceptions.WrongFilterException;
import it.univpm.projectOOP.model.FacebookAlbum;
import it.univpm.projectOOP.model.FbAlbumPhoto;

public class Filtri {


	public static ArrayList<FacebookAlbum> filtroLarghezza (ArrayList<FacebookAlbum> myfblist, String filter, int width, int height, int
			width2, int height2) throws WrongFilterException  {


		ArrayList<FacebookAlbum> filteredList = new ArrayList<FacebookAlbum>();


		FacebookAlbum albumfilt = new FacebookAlbum();


		if (!filter.equals("$gt") && !filter.equals("$gte") && !filter.equals("$lt") && !filter.equals("$lte") && !filter.equals("$bt"))
			throw new WrongFilterException("Il filtro inserito non è corretto");

		ArrayList <FbAlbumPhoto> photofilt = new ArrayList <FbAlbumPhoto>();


		for (int i = 0; i < myfblist.size(); i++) {		


			for (int j=0; j<myfblist.get(i).getAlbum().size(); j++) {

				FbAlbumPhoto fotofilt = new FbAlbumPhoto();

				if (filter.equals("$gt") && myfblist.get(i).getAlbum().get(j).getWidth()> width) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setByte_dimension(myfblist.get(i).getAlbum().get(j).getByte_dimension());

				}
				if (filter.equals("$gte") &&  myfblist.get(i).getAlbum().get(j).getWidth()>= width) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setByte_dimension(myfblist.get(i).getAlbum().get(j).getByte_dimension());
				}
				if (filter.equals("$lt") &&  myfblist.get(i).getAlbum().get(j).getWidth()< width) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setByte_dimension(myfblist.get(i).getAlbum().get(j).getByte_dimension());
				}
				if (filter.equals("$lte") &&  myfblist.get(i).getAlbum().get(j).getWidth()<= width) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setByte_dimension(myfblist.get(i).getAlbum().get(j).getByte_dimension());
				}
				if (filter.equals("$bt") &&  myfblist.get(i).getAlbum().get(j).getWidth()>= width && 
						myfblist.get(i).getAlbum().get(j).getWidth()>= width2 ) {
					fotofilt.setWidth(myfblist.get(i).getAlbum().get(j).getWidth());
					fotofilt.setHeight(myfblist.get(i).getAlbum().get(j).getHeight());
					fotofilt.setPixel(myfblist.get(i).getAlbum().get(j).getPixel());
					fotofilt.setCreated_time(myfblist.get(i).getAlbum().get(j).getCreated_time());
					fotofilt.setByte_dimension(myfblist.get(i).getAlbum().get(j).getByte_dimension());




				}
				if (fotofilt != null)
					photofilt.add(fotofilt);

			}
			if (photofilt!= null)
			{
				albumfilt.setAlbum(photofilt);
				filteredList.add(albumfilt);
			}

		}
		return filteredList;
	}



}
