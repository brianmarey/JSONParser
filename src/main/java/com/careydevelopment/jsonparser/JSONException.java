package com.careydevelopment.jsonparser;

public class JSONException extends Exception{

    /**
	 * 
	 */
	private static final long serialVersionUID = 6982630686326375563L;
	private Throwable cause;

    /**
     * Constructs a JSONException with an explanatory message.
     *
     * @param message Detail about the reason for the exception.
     */
    public JSONException(String message) {
        super(message);
    }

    public JSONException(Throwable cause) {
        super(cause.getMessage());
        this.cause = cause;
    }

    public Throwable getCause() {
        return this.cause;
    }
}
