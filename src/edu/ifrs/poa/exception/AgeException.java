package edu.ifrs.poa.exception;

public class AgeException extends Exception {
	private static final long serialVersionUID = 1L;
	public static String MSG_AGE_INVALID = "Client age must be between 18 and 65 years old.";

	public AgeException(String msg) {
		super(msg);
	}

}
