package it.univpm.projectOOP.filters_statistics;

import java.util.ArrayList;
import java.util.LinkedHashMap;


import it.univpm.projectOOP.model.*;


public class Statistiche {
	

	public static LinkedHashMap<String, Float> statistiche (ArrayList<FacebookAlbum> myfblist){

		LinkedHashMap<String, Float> statMap = new LinkedHashMap<String, Float>();
		

		for (int i = 0; i < myfblist.size(); i++) {

			float mediaByte = 0;
			int minByte = myfblist.get(i).getByte_dimension().get(0);
			int maxByte = 0;
			float varianza = 0;
			float devStandard = 0;
			
			float somma = 0;
			
			ArrayList <Integer> anni = new ArrayList <Integer>();
			ArrayList <Integer> mesi = new ArrayList <Integer>();
			ArrayList <Integer> giorni = new ArrayList <Integer>();
			
			
			
			

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
			
			
			for (int j=0; j<myfblist.get(i).getCreated_time().size(); j++)
			{
				
				String data = myfblist.get(i).getCreated_time().get(j);
				int anno =Integer.parseInt( data.substring(6));
				int mese =Integer.parseInt(data.substring(3, 5));
				int giorno= Integer.parseInt(data.substring(0,2));
				anni.add(anno);
				mesi.add(mese);	
				giorni.add(giorno);
			}
			
			int minAnno = anni.get(0);
			int minMese = mesi.get(0);
			int minGiorno = giorni.get(0);
			int maxAnno = 0;
			int maxMese = 0;
			int maxGiorno = 0;
			
			for (int j=0; j<anni.size(); j++) {
				
				
				
				
				
				
			}
			
						
		}
		
		
		
		
		return statMap;
		

	}

}
