package co.orffosoft.core.util;


/**
 * The Class RestException.
 */
public class RestException extends RuntimeException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5621993860252119284L;

    /** The error code description. */
    private ErrorCodeDescription errorCodeDescription;

    /** The message. */
    private String message;
    
    private Integer statusCode;

    /**
     * Instantiates a new rest exception.
     */
    public RestException() {

    }
    
    public RestException(Integer errorCode) {
    	this.statusCode = errorCode;
    }

    /**
     * Instantiates a new rest exception.
     *
     * @param errorCodeDescription the error code description
     */
    public RestException(ErrorCodeDescription errorCodeDescription) {
        this.errorCodeDescription = errorCodeDescription;
    }

    /**
     * Instantiates a new rest exception.
     *
     * @param message the message
     */
    public RestException(String message) {
        super(message);
        this.message = message;
        
    }
    
    
    
    public RestException(ErrorDescription.Error errorDescription) {
    	this.statusCode = errorDescription.getCode();
    }
    
    
    public Integer getStatusCode() {
		return statusCode;
	}

    /**
     * Instantiates a new rest exception.
     *
     * @param exceptionCode the exception code
     * @param message the message
     */
    public RestException(ErrorCodeDescription exceptionCode, String message) {
        this.errorCodeDescription = exceptionCode;
        this.message = message;
    }

    /**
     * Gets the error code description.
     *
     * @return the error code description
     */
    public ErrorCodeDescription getErrorCodeDescription() {
        return errorCodeDescription;
    }

    /* (non-Javadoc)
     * @see java.lang.Throwable#getMessage()
     */
    public String getMessage() {
        return message;
    }

    /* (non-Javadoc)
     * @see java.lang.Throwable#toString()
     */
    @Override
    public String toString() {
        return "RestException [errorCodeDescription=" + errorCodeDescription + ", message=" + message + "]";
    }

}
