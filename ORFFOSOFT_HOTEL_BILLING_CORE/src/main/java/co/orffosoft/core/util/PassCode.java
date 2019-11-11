package co.orffosoft.core.util;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class PassCode {

	private static final String CHARS = "AaBbCcDdEeFfGgiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ";

	/**
	 * @param passwordLength
	 * @param onlyNumber
	 * @return
	 */
	public static String generate(int passwordLength, boolean onlyNumber) {
		if (onlyNumber) {
			return getNPassword(passwordLength, null, false);
		}
		return getNPassword(passwordLength, CHARS, false);

	}

	/**
	 * @param passwordLength
	 * @return
	 */
	public static String generateAsInt(int passwordLength) {
		String rtnCode = null;
		try {
			rtnCode = String.valueOf(Integer.parseInt(generate(passwordLength, true)));
		} catch (Exception e) {

		}
		return rtnCode;

	}

	/**
	 * @param passwordLength
	 * @return
	 */
	public static String generate(int passwordLength) {
		return getNPassword(passwordLength, CHARS, false);
	}

	/**
	 * @param length
	 * @param extraChars
	 * @param otherChars
	 * @return
	 */
	private static String getNPassword(int length, String extraChars, boolean otherChars) {
		return getNPassword(length, extraChars, otherChars, otherChars, otherChars, otherChars, otherChars, otherChars);
	}

	/**
	 * @param length
	 * @param extraChars
	 * @param firstNumber
	 * @param firstLower
	 * @param firstUpper
	 * @param latterNumber
	 * @param latterLower
	 * @param latterUpper
	 * @return
	 */
	private static String getNPassword(int length, String extraChars, boolean firstNumber, boolean firstLower,
			boolean firstUpper, boolean latterNumber, boolean letterLower, boolean letterUpper) {
		String rc = "";
		if (length > 0)
			rc = rc + getRandomNumber(firstNumber, firstLower, firstUpper, extraChars);
		for (int idx = 1; idx < length; ++idx) {
			rc = rc + getRandomNumber(latterNumber, letterLower, letterUpper, extraChars);
		}
		return rc;
	}

	/**
	 * @param number
	 * @param lower
	 * @param upper
	 * @param extra
	 * @return
	 */
	private static String getRandomNumber(boolean number, boolean lower, boolean upper, String extra) {
		String numberChars = "0123456789";
		String lowerChars = "1234567890";
		String upperChars = "0987654321";
		String charSet = extra == null ? numberChars : extra;
		if (number) {
			charSet += numberChars;
		}
		if (lower) {
			charSet += lowerChars;
		}
		if (upper) {
			charSet += upperChars;
		}
		return (new Character((charSet.charAt(getRandomNum(0, charSet.length())))).toString());
	}

	/**
	 * @param lbound
	 * @param ubound
	 * @return
	 */
	private static int getRandomNum(int lbound, int ubound) {
		double d;
		int rtn = 0;
		try {
			d = Math.floor(Math.random() * (ubound - lbound));
			String s = Double.toString(d);
			int i = s.indexOf(".");
			if (i > -1)
				s = s.substring(0, i);
			rtn = Integer.parseInt(s);
		} catch (Exception e) {
			rtn = 0;
			log.fatal("getRandomNum() Exception " + e.toString());
		}
		return (rtn + lbound);
	}

	/*
	 * https://github.com/ulisesbocchio/jasypt-spring-boot
	 */
	private static void encPwd() {

	}

//	public static void main(String[] args) {
//
//		System.out.println("Code: " + PassCode.generate(10, false));
//	}
}
