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
import it.univpm.projectOOP.filters_statistics.*;

@RestController
public class FacebookController {
	FacebookService serviziofb = new FacebookService();
	@PostMapping("/fb")
	public ResponseEntity<Object> FotoAlbum(@RequestBody String url) throws MalformedURLException, IOException, ParseException {


		serviziofb.ParseJson(serviziofb.getFromFacebook(url));
		return new ResponseEntity<>(
				"Foto scaricate correttamente dall'album. Per verificare, fare una richiesta GET all'indirizzo /fb",
				HttpStatus.OK);
	}

	@RequestMapping(value = "/fb", method = RequestMethod.GET)
	public ResponseEntity<Object> getFbAlbums()  throws EmptyAlbumListException{
		return new ResponseEntity<>(serviziofb.getFacebookAlbums(), HttpStatus.OK);
	}
	


	
	@RequestMapping(value = "/fb/statistiche/dimensionali", method = RequestMethod.GET)
	public ResponseEntity<Object> statistichedimensionali() throws EmptyAlbumListException{
		return new ResponseEntity<Object> (Statistiche.statistichedim(serviziofb.getFacebookAlbums()), HttpStatus.OK);
	}
	

	@RequestMapping(value = "/fb/statistiche/temporali", method = RequestMethod.GET)
	public ResponseEntity<Object> statistichetemporali() throws EmptyAlbumListException{
		return new ResponseEntity<Object> (Statistiche.statistichetemp(serviziofb.getFacebookAlbums()), HttpStatus.OK);
	}
	
	@PostMapping("/fb/filtri")
	public ResponseEntity<Object> Filtro (@RequestBody String  body) throws MalformedURLException, IOException, ParseException, WrongFilterException {


		serviziofb.filtro(body);
		return new ResponseEntity<>(
				"Foto filtrate. Per verificare fare richiesta GET a /fb",
				HttpStatus.OK);
	}











}

