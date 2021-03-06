package exception;

/**
 * Exception technique grave incompatible avec la poursuite de l'application.
 * 
 *
 *
 */
public class ExceptionTech extends RuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = -5592068178491785832L;

	/**
	 * Constructeur
	 * 
	 * @param message message associé à l'exception
	 */
	public ExceptionTech(String message) {
		super(message);
	}
}
