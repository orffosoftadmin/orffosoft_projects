package co.orffosoft.core.util;

public class ThreadLocalConfig {

	public static final String TRACK_ID_HEADER = "trackId";

	public static final String LANGUAGE_CODE = "languageCode";

	private static final ThreadLocal<String> id = new ThreadLocal<String>();

	public static String getId() {
		return id.get();
	}

	public static void setId(String correlationId) {
		id.set(correlationId);
	}
}
