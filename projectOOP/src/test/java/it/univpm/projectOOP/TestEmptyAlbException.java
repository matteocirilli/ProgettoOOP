package it.univpm.projectOOP;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.univpm.projectOOP.exceptions.EmptyAlbumListException;
import it.univpm.projectOOP.service.FacebookService;



public class TestEmptyAlbException {


	FacebookService provaservizio;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testEmptyAlbumEx () throws EmptyAlbumListException {
		provaservizio = new FacebookService();
		assertThrows(EmptyAlbumListException.class, ()-> provaservizio.getFacebookAlbums());

	}





}
