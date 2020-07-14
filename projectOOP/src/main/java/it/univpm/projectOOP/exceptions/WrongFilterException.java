package it.univpm.projectOOP.exceptions;

/**
 * Classe eccezione: WrongFilterException.
 */
public class WrongFilterException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Eccezione che parte se il filtro non è corretto
	 *
	 * @param prende come parametro il messaggio di errore
	 */
	public WrongFilterException(String message) {
		super(message);
	}

}
