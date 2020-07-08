package it.univpm.projectOOP.filters_statistics;

import java.util.ArrayList;

import it.univpm.projectOOP.model.FacebookAlbum;
import org.json.*;

public class Filtri {
	
	
	public static ArrayList<FacebookAlbum> filtroRisoluzione (ArrayList<FacebookAlbum> myfblist, String filter, int width, int height)  {
		// TODO Auto-generated method stub
		ArrayList<FacebookAlbum> filteredList = new ArrayList<FacebookAlbum>();
		
		
		FacebookAlbum albumfilt = new FacebookAlbum();
		ArrayList<String> datecreazione = new ArrayList <String>();
		ArrayList<Integer> dimensioni = new ArrayList <Integer>();
		ArrayList<String> pixel_img = new ArrayList <String>();

		
		
		for (int i = 0; i < myfblist.size(); i++) {
			/**Eccezione che parte dal momento in cui i filtri inseriti non sono corretti*/
			//if (!filter.equals("$gt") && !filter.equals("$gte") && !filter.equals("$lt") && !filter.equals("$lte") && !filter.contentEquals("$bt") ) 
			//throw new WrongFilterException("Il filtro inserito non è corretto!");
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
//				if (filter.equals("$bt")) {
//					/** Viene messo il controllo della size dato che parametri richiesti
//					 * sono esattamente due. Ciò evita anche IndexOutOfBounds */
//					if (!param.isJsonArray() || param.getAsJsonArray().size() != 2) {
//						/**Eccezione nel caso in cui sia sbagliato il filtro $bt*/
//						throw new WrongFilterException("Filtro $bt errato, sono richiesti 2 valori");
//					} else {
//						/**
//						 * Se sono inseriti in ordine errato (prima un paramatro maggiore e poi un minore) viene
//						 * invertito il controllo
//						 */
//						if (param.getAsJsonArray().get(0).getAsInt() <= param.getAsJsonArray().get(1).getAsInt()) {
//							if (list.get(i).getFavorite_count() >= param.getAsJsonArray().get(0).getAsInt()
//									&& list.get(i).getFavorite_count() <= param.getAsJsonArray().get(1).getAsInt())
//								filteredList.add(list.get(i));
//						} else {
//							if (list.get(i).getFavorite_count() <= param.getAsJsonArray().get(0).getAsInt()
//									&& list.get(i).getFavorite_count() >= param.getAsJsonArray().get(1).getAsInt())
//								filteredList.add(list.get(i));
//						}
//
//					}


				}
			albumfilt.setCreated_time(datecreazione);
			albumfilt.setByte_dimension(dimensioni);
			albumfilt.setPixel(pixel_img);
			
			filteredList.add(albumfilt);
			
			}
		return filteredList;
		}



	}
