package it.univpm.projectOOP.exceptions;

public class EmptyAlbumListException extends Exception{

	private static final long serialVersionUID = 1L;

	public EmptyAlbumListException (String message) {

		super(message);

	}

}
