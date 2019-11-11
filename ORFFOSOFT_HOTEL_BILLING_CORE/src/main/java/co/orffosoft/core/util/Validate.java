package co.orffosoft.core.util;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Class Validate.
 */
/**
 * @author user1
 *
 */

public class Validate {

	private static Pattern pattern;
	private static Matcher matcher;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final String MOBILE_PATTERN = "^[7-9][0-9]{9}$";

	private static final String PERCENTAGE_OF_MARKS_PATTERN = "[0-9]{1,13}(\\.[0-9]+)?";

	/**
	 * Not null.
	 *
	 * @param <E>
	 *            the element type
	 * @param object
	 *            the object
	 * @param parameterName
	 *            the parameter name
	 * @return the e
	 * @throws RestException
	 *             the rest exception
	 */
	public static <E> E notNull(E object, String parameterName) throws RestException {
		return notNull(object, parameterName, false);
	}

	public static void notNull(Object object, ErrorDescription.Error errorDescription) throws RestException {
		if (object == null) {
			throw new RestException(errorDescription);
		}
	}
	
	 
	
	public static void notNull(Object object, Integer errorDescription) throws RestException {
		if (object == null) {
			throw new RestException(errorDescription);
		}
	}

	public static void listNotNullOrEmpty(List<?> list, ErrorDescription.Error errorCode) throws RestException {
		if (list == null || list.isEmpty() || list.size() == 0)
			throw new RestException(errorCode);
	}

	public static void nonZeroOrNull(Double value, ErrorDescription.Error errorCodeDescription) throws RestException {
		if (value == 0 || value == null) {
			throw new RestException(errorCodeDescription);
		}
	}

	/**
	 * Assert true.
	 *
	 * @param flag
	 *            the flag
	 * @param errorCode
	 *            the error code
	 * @throws RestException
	 *             the rest exception
	 */

	public static void assertTrue(boolean flag, ErrorCodeDescription errorCode) throws RestException {
		if (!flag)
			throw new BadRequestException(errorCode);
	}
	
	public static void assertTrue(boolean flag, Integer errorCode) throws RestException {
		if (!flag)
			throw new BadRequestException(errorCode);
	}
	
	 

	/**
	 * Assert true.
	 *
	 * @param flag
	 *            the flag
	 * @param errorCode
	 *            the error code
	 * @throws RestException
	 *             the rest exception
	 */

	public static void assertTrue(boolean flag, ErrorDescription.Error errorCode) throws RestException {
		if (!flag)
			throw new BadRequestException(errorCode);
	}

	/**
	 * Assert false.
	 *
	 * @param flag
	 *            the flag
	 * @param errorCode
	 *            the error code
	 * @throws RestException
	 *             the rest exception
	 */
	public static void assertFalse(boolean flag, ErrorCodeDescription errorCode) throws RestException {
		if (flag)
			throw new BadRequestException(errorCode);
	}
	
	public static void assertFalse(boolean flag, Integer errorCode) throws RestException {
		if (flag)
			throw new BadRequestException(errorCode);
	}

	/**
	 * Assert false.
	 *
	 * @param flag
	 *            the flag
	 * @param errorCode
	 *            the error code
	 * @throws RestException
	 *             the rest exception
	 */
	public static void assertFalse(boolean flag, ErrorDescription.Error errorCode) throws RestException {
		if (flag)
			throw new BadRequestException(errorCode);
	}

	/**
	 * Not null.
	 *
	 * @param <E>
	 *            the element type
	 * @param object
	 *            the object
	 * @param parameterName
	 *            the parameter name
	 * @param checkPattern
	 *            the check pattern
	 * @return the e
	 * @throws RestException
	 *             the rest exception
	 */
	public static <E> E notNull(E object, String parameterName, boolean checkPattern) throws RestException {
		if (object == null) {
			throw new MissingParameterException("Parameter '" + parameterName + "' can not be null.");
		}
		if (checkPattern) {
			checkPattern(object, parameterName);
		}
		return object;
	}

	public static <E> E notNull(E object, String parameterName, boolean checkPattern,
			ErrorCodeDescription errorCodeDescription) {
		if (object == null) {
			throw new RestException(errorCodeDescription, "Parameter '" + parameterName + "' can not be null.");
		}
		if (checkPattern) {
			checkPattern(object, parameterName, errorCodeDescription);
		}
		return object;
	}

	/**
	 * Not null.
	 *
	 * @param object
	 *            the object
	 * @param errorCode
	 *            the error code
	 * @throws RestException
	 *             the rest exception
	 */
	public static void notNull(Object object, ErrorCodeDescription errorCode) throws RestException {
		if (object == null)
			throw new BadRequestException(errorCode);
	}

	/**
	 * Check pattern.
	 *
	 * @param <E>
	 *            the element type
	 * @param object
	 *            the object
	 * @param parameterName
	 *            the parameter name
	 * @return the e
	 * @throws RestException
	 *             the rest exception
	 */
	public static <E> E checkPattern(E object, String parameterName) throws RestException {
		if (object == null)
			return null;
		String[] patternAndErrorMessage = ParameterFormat.getPatternAndErrorMessage(parameterName);
		if (patternAndErrorMessage == null)
			return object;
		String parameterPattern = patternAndErrorMessage[0];
		String errorMessage = patternAndErrorMessage[1];
		Pattern pattern = Pattern.compile(parameterPattern);
		Matcher matcher = pattern.matcher(object.toString());
		boolean matchFound = matcher.matches();
		if (!matchFound) {
			// String message = "Parameter '" + parameterName + "' is in invalid
			// format";
			InvalidParameterFormatException ex = new InvalidParameterFormatException(
					errorMessage + " : the regex is : " + parameterPattern);
			throw ex;
		}
		return object;
	}

	public static <E> E checkPattern(E object, String parameterName, ErrorCodeDescription errorCodeDescription) {
		if (object == null)
			return null;
		String[] patternAndErrorMessage = ParameterFormat.getPatternAndErrorMessage(parameterName);
		if (patternAndErrorMessage == null)
			return object;
		String parameterPattern = patternAndErrorMessage[0];
		String errorMessage = patternAndErrorMessage[1];
		Pattern pattern = Pattern.compile(parameterPattern);
		Matcher matcher = pattern.matcher(object.toString());
		boolean matchFound = matcher.matches();
		if (!matchFound) {
			// String message = "Parameter '" + parameterName + "' is in invalid
			// format";
			// InvalidParameterFormatException ex = new
			// InvalidParameterFormatException(errorMessage + " : the regex is :
			// " + parameterPattern);
			throw new RestException(errorCodeDescription, errorMessage);
		}
		return object;
	}
	
	 

	public static <E> E checkPattern(E object, String parameterName, ErrorDescription.Error errorCodeDescription) {
		if (object == null)
			return null;
		String[] patternAndErrorMessage = ParameterFormat.getPatternAndErrorMessage(parameterName);
		if (patternAndErrorMessage == null)
			return object;
		String parameterPattern = patternAndErrorMessage[0];
		Pattern pattern = Pattern.compile(parameterPattern);
		Matcher matcher = pattern.matcher(object.toString());
		boolean matchFound = matcher.matches();
		if (!matchFound) {
			// String message = "Parameter '" + parameterName + "' is in invalid
			// format";
			// InvalidParameterFormatException ex = new
			// InvalidParameterFormatException(errorMessage + " : the regex is :
			// " + parameterPattern);
			throw new RestException(errorCodeDescription);
		}
		return object;
	}

	/**
	 * Not empty.
	 *
	 * @param list
	 *            the list
	 * @param errorCode
	 *            the error code
	 * @throws RestException
	 *             the rest exception
	 */
	public static void notEmpty(@SuppressWarnings("rawtypes") Collection list, ErrorCodeDescription errorCode)
			throws RestException {
		if (list == null || list.size() == 0)
			throw new RestException(errorCode);
	}

	/**
	 * @param object
	 * @param errorCode
	 * @throws RestException
	 */
	public static void validateString(String inputString) throws RestException {
		if (inputString == null || inputString.equals(""))
			throw new BadRequestException(ErrorCodeDescription.MISSING_PARAMETER);

	}

	/**
	 * @param object
	 * @param errorDescription
	 * @throws RestException
	 */
	public static void objectNotNull(Object object, ErrorDescription.Error errorCodeDescription) throws RestException {
		if (object == null) {
			throw new RestException(errorCodeDescription);
		}
	}

	/**
	 * @param object
	 * @param errorCodeDescription
	 * @throws RestException
	 */
	public static void objectNotNull(Object object, ErrorCodeDescription errorCodeDescription) throws RestException {
		if (object == null) {
			throw new RestException(errorCodeDescription);
		}
	}

	/**
	 * @param object
	 * @param errorCodeDescription
	 * @throws RestException
	 */
	public static void notNullOrEmpty(String object, ErrorCodeDescription errorCodeDescription) throws RestException {
		if (object == null || object.trim().length() == 0) {
			throw new RestException(errorCodeDescription);
		}
	}

	public static void notNullOrEmpty(String object, ErrorDescription.Error errorDescription) throws RestException {
		if (object == null || object.trim().length() == 0) {
			throw new RestException(errorDescription);
		}
	}

	/**
	 * @param date
	 * @param errorDescription
	 * @throws RestException
	 */
	public static void dateNotNull(Date date, ErrorDescription.Error errorCodeDescription) throws RestException {
		if (date == null) {
			throw new RestException(errorCodeDescription);
		}
	}
	
	 

	/**
	 * @param date
	 * @param errorCodeDescription
	 * @throws RestException
	 */
	public static void dateNotNull(Date date, ErrorCodeDescription errorCodeDescription) throws RestException {
		if (date == null) {
			throw new RestException(errorCodeDescription);
		}
	}

	/**
	 * @param Double
	 * @param errorCodeDescription
	 * @throws RestException
	 */
	public static void nonZero(Double value, ErrorCodeDescription errorCodeDescription) throws RestException {
		if (value == 0) {
			throw new RestException(errorCodeDescription);
		}
	}

	/**
	 * @param Long
	 * @param errorCodeDescription
	 * @throws RestException
	 */
	public static void nonZero(Long value, ErrorCodeDescription errorCodeDescription) throws RestException {
		if (value == 0) {
			throw new RestException(errorCodeDescription);
		}
	}

	/**
	 * @param int
	 * @param errorCodeDescription
	 * @throws RestException
	 */
	public static void nonZero(int value, ErrorCodeDescription errorCodeDescription) throws RestException {
		if (value == 0) {
			throw new RestException(errorCodeDescription);
		}
	}

	/**
	 * @param Object
	 * @param min
	 * @param max
	 * @param errorCodeDescription
	 * @throws RestException
	 */
	public static void validateLength(Object object, int min, int max, ErrorCodeDescription errorCodeDescription)
			throws RestException {

		if (object != null) {
			if (object.toString().length() > max) {
				throw new RestException(errorCodeDescription);
			}

			if (object.toString().length() < min) {
				throw new RestException(errorCodeDescription);
			}
		}
	}

	public static void validateLength(Object object, int min, int max, ErrorDescription.Error errorDescription)
			throws RestException {

		if (object != null) {
			if (object.toString().length() > max) {
				throw new RestException(errorDescription);
			}

			if (object.toString().length() < min) {
				throw new RestException(errorDescription);
			}
		}
	}

	/**
	 * Validate email with regular expression
	 * 
	 * @param email
	 *            for validation
	 * @return true valid email, false invalid email
	 */
	public static boolean validateEmail(final String email) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		return matcher.matches();

	}

	/**
	 * Validate mobile with regular expression
	 * 
	 * @param mobile
	 *            for validation
	 * @return true valid mobile, false invalid mobile
	 */
	public static boolean validateMobileNo(final String mobile) {
		pattern = Pattern.compile(MOBILE_PATTERN);
		matcher = pattern.matcher(mobile);
		return matcher.matches();

	}

	/**
	 * Validate mobile with regular expression
	 * 
	 * @param mobile
	 *            for validation
	 * @return true valid mobile, false invalid mobile
	 */
	public static boolean validatePercentageOfMarks(final Double percentage) {
		pattern = Pattern.compile(PERCENTAGE_OF_MARKS_PATTERN);
		matcher = pattern.matcher(percentage.toString());
		return matcher.matches();

	}

	public static void notNullOrEmpty(Boolean status, ErrorCodeDescription errorCodeDescription) {
		if (status == null) {
			throw new RestException(errorCodeDescription);
		}
	}

	public static void notNullOrEmpt(Boolean status, ErrorDescription.Error errorDescription) {
		if (status == null) {
			throw new RestException(errorDescription);
		}
	}

	/**
	 * This method returns true if the objet is null.
	 * 
	 * @param object
	 * @return true | false
	 */
	public static void isEmpty(Object object, ErrorDescription.Error errorDescription) {
		if (object == null) {
			throw new RestException(errorDescription);
		}
	}

	public static void notNullId(Long long1, ErrorDescription.Error stateIdRequired) throws RestException {
		if (long1 == null) {
			throw new RestException(stateIdRequired);
		}
	}

	public static void notNull(Long id, ErrorCodeDescription stateMasterIdNotNull) {
		if (id == null) {
			throw new RestException(stateMasterIdNotNull);
		}
	}

	public static void NotNull(Double value, ErrorDescription.Error errorDescription) throws RestException {
		if (value == null) {
			throw new RestException(errorDescription);
		}
	}
	
	 

	public static void notNullOrEmpty(Object object, ErrorDescription.Error errorDescription) {
		if (object == null) {
			throw new RestException(errorDescription);
		}

	}
	 
	public static void nullOrZero(Double value, ErrorDescription.Error errorDescription) {
		if(value == null || value == 0.0D) {
			throw new RestException(errorDescription);
		}
	}
	

}
