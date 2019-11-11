package co.orffosoft.core.util;

/**
 * The Enum ErrorCodeDescription.
 */
public enum ErrorCodeDescription {
	
	SUCCESS_RESPONSE(0, "Success"),
	FAILURE_RESPONSE(1, "Failure"),
	INVALID_PARAMETER_FORMAT(1122,"Invalid Parameter Format"),
	MISSING_PARAMETER(1121,"Parameter Missing");
	
    /** The error code. */
	private int errorCode;

	/** The error description. */
	private String errorDescription;
	
	private String errorlDescription;

	/**
	 * Instantiates a new error code description.
	 *
	 * @param code
	 *            the code
	 * @param description
	 *            the description
	 */
	private ErrorCodeDescription(int code, String description) {
		this.errorCode = code;
		this.errorDescription = description;
	}
	
	/**
	 * Instantiates a new error code description.
	 *
	 * @param code
	 *            the code
	 * @param description
	 *            the description
	 */
	private ErrorCodeDescription(int code, String description,
			String ldescription) {

		this.errorCode = code;
		this.errorDescription = description;
		this.errorlDescription = ldescription;
	}

	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * Gets the error description.
	 *
	 * @return the error description
	 */
	public String getErrorDescription() {
		return errorDescription;
	}
	
	/**
	 * Gets the error description.
	 *
	 * @return the error description
	 */
	public String getErrorlDescription() {
		return errorlDescription;
	}

	/**
	 * This method returns description for the given error code
	 * 
	 * @param code
	 *            - input error code
	 * @return String - description
	 */
	public static String getDescription(int code) {
		for (ErrorCodeDescription codes : values()) {
			if (codes.getErrorCode() == code)
				return codes.getErrorDescription();
		}
		return null;
	}
	
	/**
	 * This method returns description for the given error code
	 *
	 * @param code
	 *            - input error code
	 * @return String - description
	 */
	public static String getDescription(int code, String language) {
		for (ErrorCodeDescription codes : values()) {
			if (codes.getErrorCode() == code)
				if (!language.equals("ta_IN"))
					return codes.getErrorDescription();
				else
					return codes.getErrorlDescription();
		}
		return null;
	}
}