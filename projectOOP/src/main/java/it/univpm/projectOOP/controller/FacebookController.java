package it.univpm.projectOOP.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;

import java.io.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import it.univpm.projectOOP.service.*;

@RestController
public class FacebookController {
	FacebookService serviziofb = new FacebookService();
	@PostMapping("/fb")
	public ResponseEntity<Object> FotoAlbum(@RequestBody String url) throws MalformedURLException, IOException {


		serviziofb.ParseJson(serviziofb.getFromFacebook(url));
		return new ResponseEntity<>(
				"Foto scaricate correttamente dall'album. Per verificare, fare una richiesta GET all'indirizzo /fb",
				HttpStatus.OK);
	}

	@RequestMapping(value = "/fb", method = RequestMethod.GET)
	public ResponseEntity<Object> getFbAlbums()  {
		return new ResponseEntity<>(serviziofb.getFacebookAlbums(), HttpStatus.OK);
	}
	

//	@PostMapping("/fb/filter")
//	public ResponseEntity<Object> filtering(@RequestBody String bodyFilter) throws ParseException, WrongFilterException, GetTweetException {
//		
//		return new ResponseEntity<Object> (service.filtering(bodyFilter, service.getTweet()), HttpStatus.OK);
//	}
//
//	
//	@PostMapping("/fb/stats")
//	public ResponseEntity<Object> stats(@RequestBody String bodyFilter) throws ParseException, WrongFilterException, GetTweetException {
//		return new ResponseEntity<Object> (Stats.stats(service.filtering(bodyFilter, service.getTweet())), HttpStatus.OK);
//	}











}

