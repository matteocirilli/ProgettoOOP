package it.univpm.projectOOP;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.univpm.projectOOP.exceptions.EmptyAlbumListException;
import it.univpm.projectOOP.service.FacebookService;

/**
 * Classe TestEmptyAlbException.
 */
public class TestEmptyAlbException {

	/** The provaservizio. */
	FacebookService provaservizio;

	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		provaservizio = new FacebookService();
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test sull'eccezione di un album vuoto
	 *
	 * @throws EmptyAlbumListException Eccezione che parte se la lista di album è
	 *                                 vuota
	 */
	@Test
	void testEmptyAlbumEx() throws EmptyAlbumListException {

		assertThrows(EmptyAlbumListException.class, () -> provaservizio.getFacebookAlbums());

	}

}
