package co.orffosoft.core.util;


/**
 * The Class InvalidParameterFormatException.
 */
public class InvalidParameterFormatException extends RestException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8263143357588041554L;

    /**
     * Instantiates a new invalid parameter format exception.
     *
     * @param message the message
     */
    public InvalidParameterFormatException(final String message) {
        super(ErrorCodeDescription.INVALID_PARAMETER_FORMAT, message);
    }

}
