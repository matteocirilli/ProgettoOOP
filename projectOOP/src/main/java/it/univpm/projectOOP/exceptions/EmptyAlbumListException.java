package it.univpm.projectOOP.exceptions;

/**
 * Classe eccezione: EmptyAlbumListException.
 */
public class EmptyAlbumListException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Eccezione che parte se la lista di album è vuota
	 *
	 * @param message prende come parametro il messaggio di errore
	 */
	public EmptyAlbumListException(String message) {

		super(message);

	}

}
