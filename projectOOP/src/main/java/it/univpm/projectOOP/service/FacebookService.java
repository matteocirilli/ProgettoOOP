package it.univpm.projectOOP.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

import it.univpm.projectOOP.exceptions.EmptyAlbumListException;
import it.univpm.projectOOP.exceptions.WrongFilterStatsException;
import it.univpm.projectOOP.filters_statistics.Filters;
import it.univpm.projectOOP.filters_statistics.Statistics;
import it.univpm.projectOOP.model.FacebookAlbum;
import it.univpm.projectOOP.model.FbAlbumPhoto;

import org.json.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;

/**
 * Classe FacebookService.
 */
public class FacebookService {

	/** creazione della lista di album (myfblist). */
	private ArrayList<FacebookAlbum> myfblist = new ArrayList<FacebookAlbum>();

	/**
	 * Metodo che ritorna la lista di facebook albums.
	 *
	 * @return ritorna la lista di tutti i facebook albums.
	 * @throws EmptyAlbumListException Eccezione che parte se la lista di album è
	 *                                 vuota.
	 */
	public ArrayList<FacebookAlbum> getFacebookAlbums() throws EmptyAlbumListException {

		if (myfblist.isEmpty())
			throw new EmptyAlbumListException("La lista di Album di Facebook è vuota");

		return myfblist;
	}

	/**
	 * Metodo per il parsing del json.
	 *
	 * @param jsonString json sotto forma di stringa.
	 * @throws ParseException eccezione che parte se il processo di parsing è
	 *                        errato.
	 */
	public void ParseJson(String jsonString) throws ParseException {

		FacebookAlbum album = new FacebookAlbum();

		ArrayList<FbAlbumPhoto> photo = new ArrayList<FbAlbumPhoto>();

		JSONObject obj = new JSONObject(jsonString);
		JSONObject photos = obj.getJSONObject("photos");
		JSONArray data = photos.getJSONArray("data");

		for (int i = 0; i < data.length(); i++) {
			FbAlbumPhoto foto = new FbAlbumPhoto();
			foto.setHeight((data.getJSONObject(i).getInt("height")));
			foto.setWidth((data.getJSONObject(i).getInt("width")));
			String s = data.getJSONObject(i).getString("created_time");

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+0000'");
			Date date = dateFormat.parse(s);
			DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String dateStr = formatter.format(date);
			foto.setCreated_time(dateStr);

			foto.setPixel(((data.getJSONObject(i).getInt("width")) + " X " + (data.getJSONObject(i).getInt("height"))));
			foto.setKbyte_dimension(
					(((data.getJSONObject(i).getInt("height")) * (data.getJSONObject(i).getInt("width")))) / 1024);
			photo.add(foto);

		}

		album.setAlbum(photo);

		myfblist.add(album);

	}

	/**
	 * Richiesta HTTP per i dati da facebook.
	 *
	 * @param fburl Viene passato come pametro una stringa contenente l'url.
	 * @return stringa vuota se tutto è andato a buon fine.
	 */
	public String getFromFacebook(String fburl) {

		String response = "";

		try {

			URL url = new URL(fburl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = read.readLine();

			response = line;

		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}

		return response;

	}

	/**
	 * Service del filtro.
	 *
	 * @param body Stringa contenente i valori con i quali confrontare tutte le foto
	 *             degli album.
	 * @return ritorna la lista filtrata.
	 * @throws WrongFilterStatsException Eccezione che parte se il tipo di filtro
	 *                                   filtro o il tipo di statistica non è
	 *                                   corretto
	 */
	public ArrayList<FacebookAlbum> filterFbService(String body) throws WrongFilterStatsException {

		ArrayList<FacebookAlbum> listafiltrata = new ArrayList<FacebookAlbum>();
		JSONObject jbody = new JSONObject(body);

		String filter = jbody.getString("filter");
		String filterType = jbody.getString("filterType");

		if (!filterType.equals("filterWidth") && !filterType.equals("filterHeight")
				&& !filterType.equals("filterWidthDim") && !filterType.equals("filterHeightDim"))
			throw new WrongFilterStatsException("Il filtro inserito non è corretto");

		if (filterType.equals("filterWidth")) {
			int width = jbody.getInt("width");
			if (filter.equals("$bt")) {
				int width2 = jbody.getInt("width2");
				listafiltrata = Filters.filtroLarghezza(myfblist, filter, width, width2);
			} else
				listafiltrata = Filters.filtroLarghezza(myfblist, filter, width, 0);
		}

		if (filterType.equals("filterHeight")) {

			int height = jbody.getInt("height");
			if (filter.equals("$bt")) {
				int height2 = jbody.getInt("height2");
				listafiltrata = Filters.filtroAltezza(myfblist, filter, height, height2);
			} else
				listafiltrata = Filters.filtroAltezza(myfblist, filter, height, 0);
		}

		if (filterType.equals("filterWidthDim")) {

			int width = jbody.getInt("width");
			int kbyte_dimension = jbody.getInt("kbyte_dimension");
			if (filter.equals("$bt")) {
				int width2 = jbody.getInt("width2");
				int kbyte_dimension2 = jbody.getInt("kbyte_dimension2");
				listafiltrata = Filters.filtroLarghezzaDim(myfblist, filter, width, width2, kbyte_dimension,
						kbyte_dimension2);
			} else
				listafiltrata = Filters.filtroLarghezzaDim(myfblist, filter, width, 0, kbyte_dimension, 0);

		}
		if (filterType.equals("filterHeightDim")) {

			int height = jbody.getInt("height");

			int kbyte_dimension = jbody.getInt("kbyte_dimension");
			if (filter.equals("$bt")) {
				int height2 = jbody.getInt("height2");
				int kbyte_dimension2 = jbody.getInt("kbyte_dimension2");
				listafiltrata = Filters.filtroAltezzaDim(myfblist, filter, height, height2, kbyte_dimension,
						kbyte_dimension2);
			} else
				listafiltrata = Filters.filtroAltezzaDim(myfblist, filter, height, 0, kbyte_dimension, 0);

		}

		return listafiltrata;

	}

	/**
	 * Service delle statistiche
	 *
	 * @param body stringa contenente il tipo di filtro da utilizzare.
	 * @return La linked Hash Map con tutte le statistiche.
	 * @throws WrongFilterStatsException Eccezione che parte se il tipo di filtro
	 *                                   filtro o il tipo di statistica non è
	 *                                   corretto
	 */
	public LinkedHashMap<String, String> statsFbService(String body) throws WrongFilterStatsException {

		JSONObject jbody = new JSONObject(body);
		String typeStat = jbody.getString("typeStat");
		if (!typeStat.equals("dim") && !typeStat.equals("temp"))
			throw new WrongFilterStatsException("Puoi solo cercare statistiche temporali o dimensionali!");
		if (typeStat.equals("temp"))
			return Statistics.statistichetemp(myfblist);
		else
			return Statistics.statistichedim(myfblist);

	}

	public String getMetadata(Class<?> myClass) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonSchemaGenerator schemaGen = new JsonSchemaGenerator(mapper);
			com.fasterxml.jackson.module.jsonSchema.JsonSchema schema = schemaGen.generateSchema(myClass);
			return mapper.writeValueAsString(schema);
		} catch (JsonProcessingException e) {
			return e.getLocalizedMessage();
		}
	}

}
