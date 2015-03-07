package by.bsu.tender.exception;

public class TenderLogicException extends Exception {

	public TenderLogicException() {
	}
	
	public TenderLogicException(String message) {
		super(message);
	}

	public TenderLogicException(Throwable cause) {
		super(cause);
	}
	
	public TenderLogicException(String message, Throwable cause) {
		super(message, cause);
	}
}
