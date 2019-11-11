/**
 * 
 */
package co.orffosoft.core.util;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ftuser
 *
 */

public class NotificationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6239898380207909423L;

	@Getter
	@Setter
	private String message;

	@Getter
	@Setter
	private Integer errorCode;

	/**
	 * 
	 */
	public NotificationException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public NotificationException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public NotificationException(Integer errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}

}
