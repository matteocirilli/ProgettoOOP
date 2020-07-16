package it.univpm.projectOOP;

import java.text.ParseException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.univpm.projectOOP.exceptions.WrongFilterStatsException;

import it.univpm.projectOOP.service.FacebookService;
import static org.junit.jupiter.api.Assertions.*;

public class TestWrongFiltException {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testWrongFilterEx() throws WrongFilterStatsException, ParseException {

		FacebookService provaservizio = new FacebookService();

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

		String body = "{\"filter\": \"NotAFilter\",\r\n" + "\"filterType\":\"filterWidth\",\r\n" + "\"width\": 600,\r\n"
				+ "\"width2\":600}";
		String body2 = "{\"filter\": \"$gt\",\r\n" + "\"filterType\":\"NotAFilterType\",\r\n" + "\"width\": 600,\r\n"
				+ "\"width2\":600}";

		assertThrows(WrongFilterStatsException.class, () -> provaservizio.filterFbService(body));
		assertThrows(WrongFilterStatsException.class, () -> provaservizio.filterFbService(body2));

	}

}
