package it.univpm.projectOOP.filters_statistics;

import java.util.ArrayList;
import java.util.LinkedHashMap;


import it.univpm.projectOOP.model.*;


public class Statistiche {


	public static LinkedHashMap<String, Float> statistichedim (ArrayList<FacebookAlbum> myfblist){

		LinkedHashMap<String, Float> statMap = new LinkedHashMap<String, Float>();


		for (int i = 0; i < myfblist.size(); i++) {

			float mediaByte = 0;
			int minByte = myfblist.get(i).getAlbum().get(i).getByte_dimension();
			int maxByte = 0;
			float varianza = 0;
			float devStandard = 0;

			float somma = 0;







			for (int j = 0; j < myfblist.get(i).getAlbum().size(); j++) {	

				if( myfblist.get(i).getAlbum().get(j).getByte_dimension() < minByte) {
					minByte =  myfblist.get(i).getAlbum().get(j).getByte_dimension();					
				}

				if( myfblist.get(i).getAlbum().get(j).getByte_dimension() > maxByte) {
					maxByte =  myfblist.get(i).getAlbum().get(j).getByte_dimension();					
				}

				somma +=  myfblist.get(i).getAlbum().get(j).getByte_dimension();	

			}

			mediaByte = somma/myfblist.get(i).getAlbum().size();

			for (int j = 0; j < myfblist.get(i).getAlbum().size(); j++) {
				varianza += Math.pow(myfblist.get(i).getAlbum().get(j).getByte_dimension()-mediaByte, 2);
			}

			devStandard = (float) Math.sqrt(varianza);	
			int c = i+1;

			statMap.put("Minimo Byte album " + c, (float) minByte);
			statMap.put("Massimo Byte album " + c, (float) maxByte);
			statMap.put("Media Byte album " + c, (float) mediaByte);
			statMap.put("Varianza Byte album " + c, (float) varianza);
			statMap.put("Deviazione standard Byte album " + c, (float) devStandard);		


		}


		return statMap;

	}

	public static LinkedHashMap <String,String> statistichetemp (ArrayList<FacebookAlbum> myfblist) {


		LinkedHashMap<String, String> statMap = new LinkedHashMap<String, String>();


		for(int i=0; i<myfblist.size(); i++) {

			ArrayList <Integer> anni = new ArrayList <Integer>();
			ArrayList <Integer> mesi = new ArrayList <Integer>();
			ArrayList <Integer> giorni = new ArrayList <Integer>();


			for (int j=0; j<myfblist.get(i).getAlbum().size(); j++)
			{

				String data = myfblist.get(i).getAlbum().get(j).getCreated_time();
				int anno =Integer.parseInt( data.substring(6));
				int mese =Integer.parseInt(data.substring(3, 5));
				int giorno= Integer.parseInt(data.substring(0,2));
				anni.add(anno);
				mesi.add(mese);	
				giorni.add(giorno);
			}

			int [] cadenzamesi = new int [12];
			for (int k=0; k<mesi.size(); k++)
			{
				cadenzamesi[(mesi.get(k))-1]++;
			}



			int [] cadenzagiorni = new int [31];
			for (int k=0; k<giorni.size(); k++)
			{
				cadenzagiorni[(giorni.get(k))-1]++;
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
			int c = i+1;
			statMap.put("Data foto più vecchia album " + c, minGiorno + "-" + minMese + "-" + minAnno);
			statMap.put("Data foto più recente album " + c, maxGiorno + "-" + maxMese + "-" + maxAnno);
			
			for (int k=0; k<cadenzamesi.length;k++) {
				if (cadenzamesi[k]!=0)
					statMap.put("Cadenza foto nel mese numero " + (k+1) + ": ", cadenzamesi[k]+"");
			}
			
			for (int k=0; k<cadenzagiorni.length;k++) {
				if (cadenzagiorni[k]!=0)
					statMap.put("Cadenza foto nel giorno numero " + (k+1) + ": ", cadenzagiorni[k]+"");
			}


		}
		return statMap;
	}
}
