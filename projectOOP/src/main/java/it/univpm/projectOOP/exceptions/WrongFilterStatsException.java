package it.univpm.projectOOP.exceptions;

/**
 * Classe eccezione: WrongFilterStatsException.
 */
public class WrongFilterStatsException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Eccezione che parte se il tipo filtro o il tipo di statistica non è corretto
	 *
	 * @param message prende come parametro il messaggio di errore
	 */
	public WrongFilterStatsException(String message) {
		super(message);
	}

}
