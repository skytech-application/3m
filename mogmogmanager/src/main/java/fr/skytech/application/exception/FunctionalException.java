package fr.skytech.application.exception;

public class FunctionalException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7270266781970475699L;

	public FunctionalException() {
    }

    public FunctionalException(String message) {
        super(message);
    }

    public FunctionalException(Throwable cause) {
        super(cause);
    }

    public FunctionalException(String message, Throwable cause) {
        super(message, cause);
    }
	
}
