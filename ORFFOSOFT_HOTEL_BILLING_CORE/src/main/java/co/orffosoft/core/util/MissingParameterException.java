package co.orffosoft.core.util;


/**
 * The Class MissingParameterException.
 */
public class MissingParameterException extends RestException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7050154061340999132L;

    /**
     * Instantiates a new missing parameter exception.
     *
     * @param message the message
     */
    public MissingParameterException(final String message) {
        super(ErrorCodeDescription.MISSING_PARAMETER, message);
    }

}
