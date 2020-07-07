package it.univpm.projectOOP.filters_statistics;

import java.util.ArrayList;
import java.util.HashMap;
import it.univpm.projectOOP.model.*;


public class Statistiche {
	//Classe Statischiche

	public static HashMap<String, Float> statistiche (ArrayList<FacebookAlbum> myfblist){

		HashMap<String, Float> statMap = new HashMap<String, Float>();
		

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
			
			statMap.put("Minimo Byte album " + i, (float) minByte);
			statMap.put("Massimo Byte album " + i, (float) maxByte);
			statMap.put("Media Byte album " + i, (float) mediaByte);
			statMap.put("Varianza Byte album " + i, (float) varianza);
			statMap.put("Deviazione standard Byte album " + i, (float) devStandard);		
			
						
		}
		
		return statMap;
		

	}

}
