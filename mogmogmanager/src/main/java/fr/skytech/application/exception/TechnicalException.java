package fr.skytech.application.exception;

public class TechnicalException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7270266781970475699L;

	public TechnicalException() {
    }

    public TechnicalException(String message) {
        super(message);
    }

    public TechnicalException(Throwable cause) {
        super(cause);
    }

    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
    }
	
}
