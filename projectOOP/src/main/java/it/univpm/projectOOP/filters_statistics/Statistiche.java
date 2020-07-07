package it.univpm.projectOOP.filters_statistics;

import java.util.ArrayList;
import java.util.LinkedHashMap;


import it.univpm.projectOOP.model.*;


public class Statistiche {
	//Classe Statischiche

	public static LinkedHashMap<String, Float> statistiche (ArrayList<FacebookAlbum> myfblist){

		LinkedHashMap<String, Float> statMap = new LinkedHashMap<String, Float>();
		

		for (int i = 0; i < myfblist.size(); i++) {

			float mediaByte = 0;
			int minByte = myfblist.get(i).getByte_dimension().get(0);
			int maxByte = 0;
			float varianza = 0;
			float devStandard = 0;
			float somma = 0;
			
			

			for (int j = 0; j < myfblist.get(i).getByte_dimension().size(); j++) {	

				if(myfblist.get(i).getByte_dimension().get(j) < minByte) {
					minByte = myfblist.get(i).getByte_dimension().get(j);					
				}

				if(myfblist.get(i).getByte_dimension().get(j) > maxByte) {
					maxByte = myfblist.get(i).getByte_dimension().get(j);					
				}

				somma += myfblist.get(i).getByte_dimension().get(j);			

			}
			
			mediaByte = somma/myfblist.get(i).getByte_dimension().size();
			
			for (int j = 0; j < myfblist.get(i).getByte_dimension().size(); j++) {
				varianza += Math.pow(myfblist.get(i).getByte_dimension().get(j)-mediaByte, 2);
			}
			
			devStandard = (float) Math.sqrt(varianza);	
			
			statMap.put("Minimo Byte album " + i+1, (float) minByte);
			statMap.put("Massimo Byte album " + i+1, (float) maxByte);
			statMap.put("Media Byte album " + i+1, (float) mediaByte);
			statMap.put("Varianza Byte album " + i+1, (float) varianza);
			statMap.put("Deviazione standard Byte album " + i+1, (float) devStandard);		
			
						
		}
		
		return statMap;
		

	}

}
