package it.univpm.projectOOP;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.univpm.projectOOP.exceptions.EmptyAlbumListException;
import it.univpm.projectOOP.service.FacebookService;

/**
 * Classe TestParseJSON.
 */
public class TestParseJSON {

	/** Creazione di un service di prova */
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
	 * Test sul parsing del json.
	 *
	 * @throws EmptyAlbumListException Eccezione che parte se la lista di album è
	 *                                 vuota
	 * @throws ParseException          eccezione che parte se il processo di parsing
	 *                                 è errato
	 */
	@Test
	void testJson() throws EmptyAlbumListException, ParseException {

		String album = "{\r\n" + "  \"photos\": {\r\n" + "    \"data\": [\r\n" + "      {\r\n"
				+ "        \"width\": 720,\r\n" + "        \"height\": 720,\r\n"
				+ "        \"created_time\": \"2015-06-16T19:13:32+0000\",\r\n"
				+ "        \"id\": \"1021788234506336\"\r\n" + "      },\r\n" + "      {\r\n"
				+ "        \"width\": 720,\r\n" + "        \"height\": 720,\r\n"
				+ "        \"created_time\": \"2015-04-15T18:23:33+0000\",\r\n"
				+ "        \"id\": \"990101441008349\"\r\n" + "      },\r\n" + "      {\r\n"
				+ "        \"width\": 612,\r\n" + "        \"height\": 612,\r\n"
				+ "        \"created_time\": \"2015-01-04T18:53:54+0000\",\r\n"
				+ "        \"id\": \"933134740038353\"\r\n" + "      },\r\n" + "      {\r\n"
				+ "        \"width\": 479,\r\n" + "        \"height\": 720,\r\n"
				+ "        \"created_time\": \"2014-08-03T18:30:52+0000\",\r\n"
				+ "        \"id\": \"845966905421804\"\r\n" + "      },\r\n" + "      {\r\n"
				+ "        \"width\": 480,\r\n" + "        \"height\": 479,\r\n"
				+ "        \"created_time\": \"2014-06-27T18:48:57+0000\",\r\n"
				+ "        \"id\": \"826918883993273\"\r\n" + "      },\r\n" + "      {\r\n"
				+ "        \"width\": 612,\r\n" + "        \"height\": 612,\r\n"
				+ "        \"created_time\": \"2014-04-18T18:31:19+0000\",\r\n"
				+ "        \"id\": \"785880074763821\"\r\n" + "      },\r\n" + "      {\r\n"
				+ "        \"width\": 405,\r\n" + "        \"height\": 720,\r\n"
				+ "        \"created_time\": \"2014-03-05T20:28:19+0000\",\r\n"
				+ "        \"id\": \"762163127135516\"\r\n" + "      },\r\n" + "      {\r\n"
				+ "        \"width\": 720,\r\n" + "        \"height\": 720,\r\n"
				+ "        \"created_time\": \"2014-02-18T14:40:39+0000\",\r\n"
				+ "        \"id\": \"754364541248708\"\r\n" + "      }\r\n" + "    ],\r\n" + "    \"paging\": {\r\n"
				+ "      \"cursors\": {\r\n" + "        \"before\": \"MTAyMTc4ODIzNDUwNjMzNgZDZD\",\r\n"
				+ "        \"after\": \"NzU0MzY0NTQxMjQ4NzA4\"\r\n" + "      }\r\n" + "    }\r\n" + "  },\r\n"
				+ "  \"id\": \"152772134741288\"\r\n" + "}";

		provaservizio.ParseJson(album);

		assertAll("valori",
				() -> assertEquals(720, provaservizio.getFacebookAlbums().get(0).getAlbum().get(0).getWidth()),
				() -> assertEquals(720, provaservizio.getFacebookAlbums().get(0).getAlbum().get(0).getHeight()),
				() -> assertEquals("16-06-2015",
						provaservizio.getFacebookAlbums().get(0).getAlbum().get(0).getCreated_time()),
				() -> assertEquals("720 X 720", provaservizio.getFacebookAlbums().get(0).getAlbum().get(0).getPixel()),
				() -> assertEquals((720 * 720) / 1024,
						provaservizio.getFacebookAlbums().get(0).getAlbum().get(0).getKbyte_dimension()));

	}

}
