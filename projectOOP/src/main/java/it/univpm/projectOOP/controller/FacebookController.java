package it.univpm.projectOOP.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.net.MalformedURLException;

import java.io.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import it.univpm.projectOOP.service.*;
import it.univpm.projectOOP.exceptions.EmptyAlbumListException;
import it.univpm.projectOOP.exceptions.WrongFilterException;
import it.univpm.projectOOP.model.FbAlbumPhoto;


/**
 * Classe del controller.
 */
@RestController

/**
 * Il Controller gestisce le richieste varie di GET e POST
 * 
 * @see it.univpm.projectOOP.service.*
 */

public class FacebookController {

	/** crea un nuovo facebook service */
	FacebookService fbservice = new FacebookService();

	/**
	 * richiesta POST "/fb"
	 *
	 * @param prende dal body l'url per la richiesta post
	 * @return ritorna un messaggio di ok se la richiesta è andata a buon fine
	 * @throws MalformedURLException eccezione di errata scrittura dell'url
	 * @throws IOException           classe base per le eccezioni generate durante
	 *                               l'accesso a informazioni tramite flussi, file e
	 *                               directory
	 * @throws ParseException        eccezione che parte se il processo di parsing è
	 *                               errato
	 */
	@PostMapping("/fb")
	public ResponseEntity<Object> DownloadFbAlbums(@RequestBody String url)
			throws MalformedURLException, IOException, ParseException {

		fbservice.ParseJson(fbservice.getFromFacebook(url));
		return new ResponseEntity<Object>(
				"Foto scaricate correttamente dall'album. Per verificare, fare una richiesta GET all'indirizzo /fb",
				HttpStatus.OK);
	}

	/**
	 * richiesta GET "/fb"
	 * 
	 * @return ritorna tutti gli album con le relative foto
	 * @throws EmptyAlbumListException eccezione che parte quando la lista di album è vuota
	 */
	@RequestMapping(value = "/fb", method = RequestMethod.GET)
	public ResponseEntity<Object> getFbAlbums() throws EmptyAlbumListException {
		return new ResponseEntity<Object>(fbservice.getFacebookAlbums(), HttpStatus.OK);
	}

	/**
	 * 
	 * @see it.univpm.projectOOP.filters_statistics.*;
	 */

	/**
	 * richiesta POST "/fb/stats"
	 *
	 * @param prende dal body l'url per la richiesta post
	 * @return ritorna solo le foto degli album che soddisfano le i parametri dei
	 *         filtri
	 * @throws MalformedURLException eccezione di errata scrittura dell'url
	 * @throws IOException           classe base per le eccezioni generate durante
	 *                               l'accesso a informazioni tramite flussi, file e
	 *                               directory.
	 * @throws ParseException        eccezione che parte se il processo di parsing è
	 *                               errato
	 * @throws WrongFilterException  eccezione che parte se il filtro non è corretto
	 */
	@PostMapping("/fb/stats")
	public ResponseEntity<Object> statsFbAlbums(@RequestBody String body)
			throws MalformedURLException, IOException, ParseException, WrongFilterException {

		return new ResponseEntity<>(fbservice.statsFbService(body), HttpStatus.OK);
	}
	/**
	 * richiesta POST "/fb/filters"
	 *
	 * @param prende dal body l'url per la richiesta post
	 * @return ritorna solo le foto degli album che soddisfano le i parametri dei
	 *         filtri
	 * @throws MalformedURLException eccezione di errata scrittura dell'url
	 * @throws IOException           classe base per le eccezioni generate durante
	 *                               l'accesso a informazioni tramite flussi, file e
	 *                               directory.
	 * @throws ParseException        eccezione che parte se il processo di parsing è
	 *                               errato
	 * @throws WrongFilterException  eccezione che parte se il filtro non è corretto
	 */
	@PostMapping("/fb/filters")
	public ResponseEntity<Object> filterFbAlbums(@RequestBody String body)
			throws MalformedURLException, IOException, ParseException, WrongFilterException {

		return new ResponseEntity<>(fbservice.filterFbService(body), HttpStatus.OK);
	}
	
	

}
