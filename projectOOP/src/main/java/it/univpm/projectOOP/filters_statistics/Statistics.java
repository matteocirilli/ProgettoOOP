package it.univpm.projectOOP.filters_statistics;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import it.univpm.projectOOP.model.*;

/**
 * Classe delle Statistiche.
 */
public class Statistics {

	/**
	 * Statistiche in base alle dimensione in kilobyte
	 *
	 * @param myfblist prende come parametro la lista di album
	 * @return ritorna la linked hash map contenente le statistiche dimensionali
	 */
	public static LinkedHashMap<String, String> statistichedim(ArrayList<FacebookAlbum> myfblist) {

		LinkedHashMap<String, String> statMap = new LinkedHashMap<String, String>();

		for (int i = 0; i < myfblist.size(); i++) {

			float mediaKbyte = 0;
			int minKbyte = myfblist.get(i).getAlbum().get(i).getKbyte_dimension();
			int maxKbyte = 0;
			float varianza = 0;
			float devStandard = 0;

			float somma = 0;

			for (int j = 0; j < myfblist.get(i).getAlbum().size(); j++) {

				if (myfblist.get(i).getAlbum().get(j).getKbyte_dimension() < minKbyte) {
					minKbyte = myfblist.get(i).getAlbum().get(j).getKbyte_dimension();
				}

				if (myfblist.get(i).getAlbum().get(j).getKbyte_dimension() > maxKbyte) {
					maxKbyte = myfblist.get(i).getAlbum().get(j).getKbyte_dimension();
				}

				somma += myfblist.get(i).getAlbum().get(j).getKbyte_dimension();

			}

			mediaKbyte = somma / myfblist.get(i).getAlbum().size();

			for (int j = 0; j < myfblist.get(i).getAlbum().size(); j++) {
				varianza += Math.pow(myfblist.get(i).getAlbum().get(j).getKbyte_dimension() - mediaKbyte, 2);
			}

			devStandard = (float) Math.sqrt(varianza);
			DecimalFormat df = new DecimalFormat("#.##");

			statMap.put("(ALBUM N." + (i + 1) + ")" + " Minimo Kbyte", df.format(minKbyte));
			statMap.put("(ALBUM N." + (i + 1) + ")" + " Massimo Kbyte", df.format(maxKbyte));
			statMap.put("(ALBUM N." + (i + 1) + ")" + " Media Kbyte", df.format(mediaKbyte));
			statMap.put("(ALBUM N." + (i + 1) + ")" + " Varianza Kbyte", df.format(varianza));
			statMap.put("(ALBUM N." + (i + 1) + ")" + " Deviazione standard Kbyte", df.format(devStandard));

		}

		return statMap;

	}

	/**
	 * Statistiche in base alle dimensione in kilobyte
	 *
	 * @param myfblist prende come parametro la lista di album
	 * @return ritorna la linked hash map contenente le statistiche temporali
	 */
	public static LinkedHashMap<String, String> statistichetemp(ArrayList<FacebookAlbum> myfblist) {

		LinkedHashMap<String, String> statMap = new LinkedHashMap<String, String>();

		for (int i = 0; i < myfblist.size(); i++) {

			ArrayList<Integer> anni = new ArrayList<Integer>();
			ArrayList<Integer> mesi = new ArrayList<Integer>();
			ArrayList<Integer> giorni = new ArrayList<Integer>();

			for (int j = 0; j < myfblist.get(i).getAlbum().size(); j++) {

				String data = myfblist.get(i).getAlbum().get(j).getCreated_time();
				int anno = Integer.parseInt(data.substring(6));
				int mese = Integer.parseInt(data.substring(3, 5));
				int giorno = Integer.parseInt(data.substring(0, 2));
				anni.add(anno);
				mesi.add(mese);
				giorni.add(giorno);
			}

			int[] cadenzamesi = new int[12];
			for (int k = 0; k < mesi.size(); k++) {
				cadenzamesi[(mesi.get(k)) - 1]++;
			}

			int[] cadenzagiorni = new int[31];
			for (int k = 0; k < giorni.size(); k++) {
				cadenzagiorni[(giorni.get(k)) - 1]++;
			}

			int minAnno = anni.get(0);
			int minMese = mesi.get(0);
			int minGiorno = giorni.get(0);
			int maxAnno = 0;
			int maxMese = 0;
			int maxGiorno = 0;

			for (int j = 0; j < anni.size(); j++) {
				if (anni.get(j) < minAnno) {
					minAnno = anni.get(j);
					minMese = mesi.get(j);
					minGiorno = giorni.get(j);
				}
				if (anni.get(j) > maxAnno) {
					maxAnno = anni.get(j);
					maxMese = mesi.get(j);
					maxGiorno = giorni.get(j);
				}
				if (anni.get(j) == minAnno) {

					if (mesi.get(j) < minMese) {
						minMese = mesi.get(j);
						minGiorno = giorni.get(j);
					}
					if (mesi.get(j) == minMese) {
						if (giorni.get(j) <= minGiorno)
							minGiorno = giorni.get(j);
					}

				}

				if (anni.get(j) == maxAnno) {

					if (mesi.get(j) > maxMese) {
						maxMese = mesi.get(j);
						maxGiorno = giorni.get(j);
					}
					if (mesi.get(j) == maxMese) {
						if (giorni.get(j) >= maxGiorno)
							maxGiorno = giorni.get(j);
					}

				}

			}

			statMap.put("(ALBUM N." + (i + 1) + ")" + " Data foto più vecchia",
					minGiorno + "-" + minMese + "-" + minAnno);
			statMap.put("(ALBUM N." + (i + 1) + ")" + " Data foto più recente",
					maxGiorno + "-" + maxMese + "-" + maxAnno);

			for (int k = 0; k < cadenzamesi.length; k++) {
				if (cadenzamesi[k] != 0)
					statMap.put("(ALBUM N." + (i + 1) + ")" + " Cadenza foto nel mese numero " + (k + 1),
							cadenzamesi[k] + "");
			}

			for (int k = 0; k < cadenzagiorni.length; k++) {
				if (cadenzagiorni[k] != 0)
					statMap.put("(ALBUM N." + (i + 1) + ")" + " Cadenza foto nel giorno numero " + (k + 1),
							cadenzagiorni[k] + "");
			}

		}
		return statMap;
	}
}
