package it.univpm.projectOOP.filters_statistics;

import java.util.ArrayList;
import java.util.LinkedHashMap;


import it.univpm.projectOOP.model.*;


public class Statistiche {


	public static LinkedHashMap<String, Float> statistichedim (ArrayList<FacebookAlbum> myfblist){

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
	
	public static LinkedHashMap <String,String> statistichetemp (ArrayList<FacebookAlbum> myfblist) {
		
		
		LinkedHashMap<String, String> statMap = new LinkedHashMap<String, String>();
		
		
		for(int i=0; i<myfblist.size(); i++) {
			
		ArrayList <Integer> anni = new ArrayList <Integer>();
		ArrayList <Integer> mesi = new ArrayList <Integer>();
		ArrayList <Integer> giorni = new ArrayList <Integer>();
		

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
			if (anni.get(j)<minAnno) {
				minAnno = anni.get(j);
				minMese = mesi.get(j);
				minGiorno = giorni.get(j);
			}
			if (anni.get(j)>maxAnno) {
				maxAnno = anni.get(j);
				maxMese = mesi.get(j);
				maxGiorno = giorni.get (j);
			}
			if (anni.get(j)== minAnno) {


				if (mesi.get(j)<minMese) {
					minMese = mesi.get(j);
					minGiorno = giorni.get(j);
				}
				if (mesi.get(j)==minMese)
				{
					if (giorni.get(j)<=minGiorno)
						minGiorno = giorni.get(j);
				}

			}
			
			if (anni.get(j)== maxAnno) {


				if (mesi.get(j)>maxMese) {
					maxMese = mesi.get(j);
					maxGiorno = giorni.get(j);
				}
				if (mesi.get(j)==maxMese)
				{
					if (giorni.get(j)>=maxGiorno)
						maxGiorno = giorni.get(j);
				}

			}
			


		}
		statMap.put("Data foto più vecchia album" + i+1, minGiorno + "-" + minMese + "-" + minAnno);
		statMap.put("Data foto più recente album" + i+1, maxGiorno + "-" + maxMese + "-" + maxAnno);
		

	}
		return statMap;
	}
}
