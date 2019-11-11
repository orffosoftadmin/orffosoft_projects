/**
 * 
 */
package co.orffosoft.core.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.mail.internet.InternetAddress;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.orffosoft.dto.BaseDTO;
import co.orffosoft.entity.AddressMaster;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

/**
 * @author Pratap
 *
 */
@Log4j2
public final class AppUtil {

	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");

	public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");

	public static final SimpleDateFormat MONTH_FORMAT = new SimpleDateFormat("MMM");

	public static final SimpleDateFormat FULL_MONTH_NAME_FORMAT = new SimpleDateFormat("MMMM");

	public static final SimpleDateFormat YEAR_FORMAT = new SimpleDateFormat("yyyy");

	public static final SimpleDateFormat MONTH_YEAR_FORMAT = new SimpleDateFormat("MMM-yyyy");

	public static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

	private static AppUtil appUtil = null;
	
	public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");

	private static final String APPNAME_PORTAL = "PORTAL";

	@Getter
	@Setter
	private static Properties prop;

	private static ResourceBundle coreBundle = null;

	static {
		try {
			coreBundle = ResourceBundle.getBundle("application-core");
		} catch (Exception ex) {
			log.error("Exception at AppUtil.static block ", ex);
		}
	}

	public AppUtil() {
	}

	public static AppUtil getInstance() {
		if (appUtil == null) {
			appUtil = new AppUtil();
		}
		return appUtil;
	}

	/**
	 * @param strings
	 * @return
	 */
	public static String appendStrings(String... strings) {

		if (strings == null || strings.length == 0) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (String str : strings) {
			sb.append(str);
		}

		return sb.toString();
	}

	/**
	 * @param
	 * @return List<String>
	 */
	public static List<String> getAllMonthNames() {
		List<String> monthNameList = new ArrayList<String>();
		monthNameList.add("Jan");
		monthNameList.add("Feb");
		monthNameList.add("Mar");
		monthNameList.add("Apr");
		monthNameList.add("May");
		monthNameList.add("Jun");
		monthNameList.add("Jul");
		monthNameList.add("Aug");
		monthNameList.add("Sep");
		monthNameList.add("Oct");
		monthNameList.add("Nov");
		monthNameList.add("Dec");
		return monthNameList;
	}

	/**
	 * @param String,boolean
	 * @return String
	 */
	public static String getFileContent(String filePath, boolean inClassPath) {
		String fileContent = null;
		InputStream in = null;
		BufferedReader bReader = null;
		try {

			if (inClassPath) {
				in = AppUtil.class.getResourceAsStream(filePath);
				bReader = new BufferedReader(new InputStreamReader(in));
			} else {
				bReader = new BufferedReader(new FileReader(filePath));
			}

			String str;
			StringBuilder sb = new StringBuilder();
			while ((str = bReader.readLine()) != null) {
				sb.append(str);
			}

			fileContent = sb.toString();
		} catch (Exception e) {
			log.fatal("Exception at getFileContent(1) >>>> " + e.toString());
		} finally {
			try {
				if (bReader != null) {
					bReader.close();
				}
			} catch (Exception e) {
				log.fatal("Exception at getFileContent(2) >>>> " + e.toString());
			}

			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e) {
				log.fatal("Exception at getFileContent(3) >>>> " + e.toString());
			}
		}
		return fileContent;
	}

	/**
	 * @param input
	 * @param defaultOutput
	 * @return
	 */
	public static Long stringToLong(String input, Long defaultOutput) {
		if (input == null || input.isEmpty()) {
			return null;
		}
		try {
			return Long.valueOf(input);
		} catch (NumberFormatException e) {
			log.fatal("Exception at stringToLong: " + e.toString());
		}
		return null;
	}

	public static Integer stringToInteger(String input, Integer defaultOutput) {
		if (input == null || input.isEmpty()) {
			return null;
		}
		try {
			return Integer.valueOf(input);
		} catch (NumberFormatException e) {
			log.fatal("Exception at stringToInteger: " + e.toString());
		}
		return null;
	}

	/**
	 * @param input
	 * @param defaultOutput
	 * @return
	 */
	public static Double stringToDouble(String input, Double defaultOutput) {
		if (input == null || input.isEmpty()) {
			if (defaultOutput != null) {
				return defaultOutput;
			}
			return null;
		}
		try {
			return Double.valueOf(input);
		} catch (NumberFormatException e) {
			log.fatal("Exception at stringToDouble: " + e.toString());
		}
		return defaultOutput;
	}

	/**
	 * @param csv
	 * @return
	 */
	public static InternetAddress[] getInternetAddressList(String csv) {
		InternetAddress[] addressArr = null;
		try {
			if (csv == null) {
				return null;
			}
			StringTokenizer st = new StringTokenizer(csv, ",", false);
			int tokens = st.countTokens();
			if (tokens == 0) {
				return null;
			}
			addressArr = new InternetAddress[tokens];
			int i = 0;
			while (st.hasMoreTokens()) {
				addressArr[i] = new InternetAddress(st.nextToken());
				i++;
			}
		} catch (Exception e) {
			log.fatal("Exception at getInternetAddressList() >>>>> " + e.toString());
		}
		return addressArr;
	}

	/**
	 * @param
	 * @return String
	 */
	public static String getFormattedCurrentDate() {

		String formatedDate = "";
		try {
			formatedDate = DATE_FORMAT.format(new Date());
		} catch (Exception e) {
			log.fatal("Exception at getFormattedCurrentDate() >>>>> " + e.toString());
		}

		return formatedDate;
	}

	/**
	 * @param
	 * @return String
	 */
	public static String getFormattedCurrentDateTime() {

		String formatedDate = "";
		try {
			formatedDate = DATE_TIME_FORMAT.format(new Date());
		} catch (Exception e) {
			log.fatal("Exception at getFormattedCurrentDateTime() >>>>> " + e.toString());
		}

		return formatedDate;
	}

	/**
	 * @param String
	 * @return String
	 */
	public static String getFormattedCurrentDate(String requiredFormat) {
		String formatedDate = "";
		try {
			// yyyy-MM-dd HH:mm:ss
			DateFormat outputFormat = new SimpleDateFormat(requiredFormat);
			formatedDate = outputFormat.format(new Date());
		} catch (Exception e) {
			log.fatal("Exception at getFormattedCurrentDate() >>>>> " + e.toString());
		}

		return formatedDate;
	}

	/**
	 * @param String,Object[]
	 * @return String
	 */
	public static String getFormattedMessage(String message, Object[] values) {
		String rtnValue = message;
		try {
			MessageFormat mf = new MessageFormat(message);
			rtnValue = mf.format(values);
		} catch (Exception e) {
			log.fatal("Exception at getFormattedMessage() >>>>> " + e.toString());
		}
		return rtnValue;
	}

	/**
	 * @return
	 */
	public static String getClientLogoutURL() {
		try {
			return coreBundle.getString("client.signout.page").trim();
		} catch (Exception e) {
			log.fatal("Exception at getClientLogoutURL() >>>> " + e.toString());
		}
		return null;
	}

	/**
	 * @param
	 * @return String
	 */
	public static String getPortalServerURL() {
		try {
			return coreBundle.getString("portal.server.url").trim();
		} catch (Exception e) {
			log.fatal("Exception at getPortalServerURL() >>>> " + e.toString());
		}
		return null;
	}
	
	
	public static boolean isPortalClientEnabled() {
		try {
			return new Boolean(coreBundle.getString("portal.client.enabled").trim());
		} catch (Exception e) {
			log.fatal("Exception at isPortalClientEnabled() >>>> " + e.toString());
		}
		return true;
	}

	public static String getPortalClientURL() {
		try {
			return coreBundle.getString("portal.client.url").trim();
		} catch (Exception e) {
			log.fatal("Exception at getPortalClientURL() >>>> " + e.toString());
		}
		return null;
	}

	public static String getPortalClientLogoutURL() {
		try {
			return coreBundle.getString("portal.client.logout.url").trim();
		} catch (Exception e) {
			log.fatal("Exception at getPortalClientLogoutURL() >>>> " + e.toString());
		}
		return null;
	}

	public static String getPortalLandingPage() {
		try {
			return coreBundle.getString("portal.landing.page").trim();
		} catch (Exception e) {
			log.fatal("Exception at getPortalLandingPage() >>>> " + e.toString());
		}
		return null;
	}

	public static String getPortalLandingURL() {
		try {

			StringBuilder sb = new StringBuilder();
			sb.append(getPortalClientURL()).append(getPortalLandingPage());
			log.info("Portal Landing URL >>>> " + sb.toString());
			return sb.toString();
		} catch (Exception e) {
			log.fatal("Exception at getPortalLandingURL() >>>> " + e.toString());
		}
		return null;
	}
	
	public static String getNotificationServerURL() {
		try {
			return coreBundle.getString("notification.server.url").trim();
		} catch (Exception e) {
			log.fatal("Exception at getNotificationServerURL() >>>> " + e.toString());
		}
		return null;
	}

	public static String getEmailServiceURL() {
		try {

			return new StringBuilder().append(coreBundle.getString("notification.server.url").trim())
					.append("/send/emailservice").toString();

		} catch (Exception e) {
			log.fatal("Exception at getEmailServiceURL() >>>> " + e.toString());
		}
		return null;
	}

	public static String getCASServerURL() {
		try {
			return coreBundle.getString("cas.server.url").trim();
		} catch (Exception e) {
			log.fatal("Exception at getCASServerURL() >>>> " + e.toString());
		}
		return null;
	}

	public static String getCASServerLogoutURL() {
		try {
			return coreBundle.getString("cas.server.logout.url").trim();
		} catch (Exception e) {
			log.fatal("Exception at getCASServerLogoutURL() >>>> " + e.toString());
		}
		return null;
	}

	public static String getPortalClientSignOutURL() {
		try {
			return coreBundle.getString("portal.client.signout.page").trim();
		} catch (Exception e) {
			log.fatal("Exception at getPortalClientSignOutURL() >>>> " + e.toString());
		}
		return null;
	}

	/**
	 * @return
	 */
	public static String getPortalDefaultLandingPage() {
		try {
			return coreBundle.getString("portal.landing.page").trim();
		} catch (Exception e) {
			log.fatal("Exception at getPortalDefaultLandingPage() >>>> " + e.toString());
		}
		return null;
	}

	public static String getHelpdeskClientSignOutURL() {
		try {
			return coreBundle.getString("helpdesk.client.signout.page").trim();
		} catch (Exception e) {
			log.fatal("Exception at getHelpdeskClientSignOutURL() >>>> " + e.toString());
		}
		return null;
	}

	/**
	 * @return
	 */
	public static String getHelpdeskDefaultLandingPage() {
		try {
			return coreBundle.getString("helpdesk.landing.page").trim();
		} catch (Exception e) {
			log.fatal("Exception at getHelpdeskDefaultLandingPage() >>>> " + e.toString());
		}
		return null;
	}

	public static String getMisClientSignOutURL() {
		try {
			return coreBundle.getString("mis.client.signout.page").trim();
		} catch (Exception e) {
			log.fatal("Exception at getMisClientSignOutURL() >>>> " + e.toString());
		}
		return null;
	}

	/**
	 * @return
	 */
	public static String getMisDefaultLandingPage() {
		try {
			return coreBundle.getString("mis.landing.page").trim();
		} catch (Exception e) {
			log.fatal("Exception at getMisDefaultLandingPage() >>>> " + e.toString());
		}
		return null;
	}

	public static String getFinanceClientSignOutURL() {
		try {
			return coreBundle.getString("finance.client.signout.page").trim();
		} catch (Exception e) {
			log.fatal("Exception at getFinanceClientSignOutURL() >>>> " + e.toString());
		}
		return null;
	}

	public static String getFinanceDefaultLandingPage() {
		try {
			return coreBundle.getString("finance.landing.page").trim();
		} catch (Exception e) {
			log.fatal("Exception at getFinanceDefaultLandingPage() >>>> " + e.toString());
		}
		return null;
	}

	public static String getServerURL(String appName) {
		String serverURL = null;
		try {
			if (APPNAME_PORTAL.equals(appName)) {
				serverURL = AppUtil.getPortalServerURL();
			} 
		} catch (Exception e) {
			log.fatal("Exception at getFinanceServerURL() >>>> " + e.toString());
		}
		return serverURL;
	}

	/**
	 * @param String
	 * @return String
	 */
	public String getPropValues(String value) throws IOException {
		if (prop == null) {
			getInstance().load();
		}
		return prop.getProperty(value);

	}

	/**
	 * load application.properties
	 */
	public void load() throws IOException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
		prop = new Properties();
		prop.load(inputStream);
	}

	/**
	 * @param requestPath
	 * @param body
	 * @param bodyClass
	 * @param headers
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static Object getResponse(String requestPath, Object body, Class<?> bodyClass,
			MultiValueMap<String, String> headers) throws JsonParseException, JsonMappingException, IOException {
		Object obj = null;
		String searchUrl = getPortalServerURL() + requestPath;
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Object> requestEntity = new HttpEntity<Object>(body, headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(searchUrl, HttpMethod.POST, requestEntity,
				String.class);
		ObjectMapper mapper = new ObjectMapper();
		obj = mapper.readValue(responseEntity.getBody(),
				mapper.getTypeFactory().constructCollectionType(List.class, bodyClass));

		return obj;
	}

	/**
	 * @param String,HttpMethod,T,
	 *            Class<V>,MultiValueMap<String, String>
	 * @return <V, T> V
	 */
	public static <V, T> V getResponseObject(String requestPath, HttpMethod httpMethod, T request, Class<V> response,
			MultiValueMap<String, String> headers) throws JsonParseException, JsonMappingException, IOException {
		String searchUrl = getPortalServerURL() + requestPath;
		log.info("getResponseObject-searchUrl >>>> " + searchUrl);
		RestTemplate template = new RestTemplate();
		HttpEntity<T> requestEntity = new HttpEntity<T>(request, headers);
		ResponseEntity<V> resposnse = template.exchange(searchUrl, httpMethod, requestEntity, response);
		return resposnse.getBody();
	}

	/**
	 * @param String
	 * @return boolean
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}

	/**
	 * @param String
	 * @return String
	 */
	public static String isLikeSearch(String str) {
		return "%" + str.trim().toLowerCase() + "%";
	}

	/**
	 * @param String
	 * @return
	 */
	public static void addWarn(String str) {
		try {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, str, " "));
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		} catch (Exception e) {
			log.fatal("Exception at addWarn() >>>> " + e.toString());
		}
	}

	/**
	 * @param String
	 * @return
	 */
	public static void addError(String str) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, str, ""));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
	}

	/**
	 * @param String
	 * @return
	 */
	public static void addInfo(String str) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, str, ""));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
	}

	/**
	 * @param baseDTO
	 * @return boolean
	 */
	public static boolean isSuccess(BaseDTO baseDTO) {
		boolean isSuccess = false;
		if (baseDTO != null && baseDTO.getStatusCode() == 1) {
			isSuccess = true;
		}
		return isSuccess;
	}

	/**
	 * @param
	 * @return int
	 */
	public static int getCurrentMonthValue() {
		Date date = new Date();
		Calendar cal = getCalendar();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		return month;
	}

	/**
	 * @param Date,int
	 * @return Date
	 */
	public static Date addOrMinusMonth(Date date, int noOfMonth) {
		Calendar cal = getCalendar();
		cal.setTime(date);
		cal.add(Calendar.MONTH, noOfMonth);
		return cal.getTime();
	}

	/**
	 * @param Date,int
	 * @return Date
	 */
	public static Date addOrMinusYear(Date date, int noOfYear) {
		Calendar cal = getCalendar();
		cal.setTime(date);
		cal.add(Calendar.YEAR, noOfYear);
		return cal.getTime();
	}

	public static Calendar getCalendar() {
		Calendar cal = Calendar.getInstance();
		return cal;
	}

	public static boolean isListEmpty(List<?> list) {
		boolean listEmpty = false;
		// listEmpty = list == null ? true : list.isEmpty();
		listEmpty = list == null || list.isEmpty();
		return listEmpty;
	}

	/**
	 * @param Date
	 * @return Date
	 */
	public static Date getLastDateOfMonth(Date date) {
		Calendar cal = getCalendar();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}

	/**
	 * @param Date
	 * @return Date
	 */
	public static Date getFirstDateOfMonth(Date date) {
		Calendar cal = getCalendar();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}

	/**
	 * @param Month
	 * @return String
	 */
	public static String getMonthString(int month) {
		return new DateFormatSymbols().getMonths()[month - 1];
	}

	/**
	 * 
	 * @param month
	 * @return
	 */
	public static String getMonthAsString(int month) {
		return new DateFormatSymbols().getMonths()[month - 1].substring(0, 3);
	}

	/**
	 * @return String
	 */
	public static String getCurrentMonthString() {
		Calendar c = Calendar.getInstance();
		return new SimpleDateFormat("MMM").format(c.getTime()).toUpperCase();
	}
	
	/**
	 * @return String
	 */
	public static String getCurrentMonthNumber() {
		Calendar c = Calendar.getInstance();
		return new SimpleDateFormat("MM").format(c.getTime()).toUpperCase();
	}

	/**
	 * @return String
	 */
	public static String getCurrentYearString() {
		Calendar c = Calendar.getInstance();
		return new SimpleDateFormat("yy").format(c.getTime());
	}

	/**
	 * @param String
	 * @return Date
	 */
	public static Date serverDateFormat(String value) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		return (Date) formatter.parse(value.toString());
	}

	/**
	 * @param String
	 * @return int
	 */
	public static int getMonthNumber(String monthName) {
		return Month.valueOf(monthName.toUpperCase()).getValue();
	}

	/**
	 * @param Double
	 * @return Double
	 */
	public static Double ifNullRetunZero(Double value) {
		if (value == null) {
			return 0.0;
		}
		return value;
	}

	/**
	 * @param Double
	 * @return Double
	 */
	public static Double ifNegativeOrZeroRetunOne(Double value) {
		if (value <= 0) {
			return 1.0;
		}
		return value;
	}

	/**
	 * @param Date
	 * @return Date
	 */
	public static Date getEndOfDay(Date date) {
		Calendar calendar = getCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	/**
	 * @param dateOfBirth
	 * @return
	 */
	public static Integer getAge(Date dateOfBirth) {

		LocalDate selectedDate = dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate birthday = LocalDate.of(selectedDate.getYear(), selectedDate.getMonth(),
				selectedDate.getDayOfMonth());

		Date currentDate = new Date();
		LocalDate presentDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate now = LocalDate.of(presentDate.getYear(), presentDate.getMonth(), presentDate.getDayOfMonth());

		Period period = Period.between(birthday, now);
		Integer age = period.getYears();

		return age;

	}

	/**
	 * @param List<Long>
	 *            ids
	 * @return String
	 */
	public static String commaSeparatedIds(List<Long> ids) {
		if (ids == null) {
			return new String("");
		}
		Long[] idsArray = new Long[ids.size()];
		idsArray = ids.toArray(idsArray);
		return StringUtils.join(ids, ",");
	}

	/**
	 * @param Date
	 * @return Date
	 */
	public static Date getEndDateTime(Date endDateTime) {
		Calendar calendar = getCalendar();
		calendar.setTime(endDateTime);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		log.info("calendar.getTime() == >>" + calendar.getTime());
		return calendar.getTime();
	}

	/**
	 * @param Date
	 * @return Date
	 */
	public static Date getLastOfTheMonth(Date currentDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DATE, -1);
		Date lastDayOfMonth = calendar.getTime();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		log.info("Last Day of Month: " + sdf.format(lastDayOfMonth));
		return lastDayOfMonth;
	}

	/**
	 * @param Date
	 * @return int
	 */
	public static int getYear(Date date) {
		Calendar cal = getCalendar();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		return year;
	}

	/**
	 * @param Date
	 * @return int
	 */
	public static int getMonth(Date date) {
		Calendar cal = getCalendar();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1;
		return month;
	}

	/**
	 * @param Date
	 * @return int
	 */
	public static int getDay(Date date) {
		Calendar cal = getCalendar();
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		return day;
	}

	/**
	 * This method is used to cheack Integer or not
	 * 
	 * @param String
	 * @return boolean
	 */
	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		// only got here if we didn't return false
		return true;
	}

	/**
	 * This method is used to calculate Month-Year list based on month range
	 * 
	 * @param Date,int,int
	 * @return Set<String>
	 */
	public static Set<String> calculateMonthYear(Date date, int nextMonthCount, int endMonthCount) {
		log.info("AppUtil.calculateMonthYear Method Started");
		DateFormat formater = new SimpleDateFormat("dd-MMMM-yyyy");
		Date nextMonth = AppUtil.addOrMinusMonth(date, nextMonthCount);
		String nextMonthStr = formater.format(nextMonth);
		Date endMonth = AppUtil.addOrMinusMonth(nextMonth, endMonthCount);
		String endMonthStr = formater.format(endMonth);
		Set<String> monthYearList = new LinkedHashSet<String>();
		Calendar beginCalendar = getCalendar();
		Calendar finishCalendar = getCalendar();
		try {
			beginCalendar.setTime(formater.parse(nextMonthStr));
			finishCalendar.setTime(formater.parse(endMonthStr));
		} catch (ParseException e) {
			log.error("Error in AppUtil.calculateMonthYear", e);
		}
		while (beginCalendar.before(finishCalendar)) {
			String dateStr = formater.format(beginCalendar.getTime());
			beginCalendar.add(Calendar.MONTH, 1);
			String[] arr = dateStr.split("-");
			monthYearList.add(arr[1] + "-" + arr[2]);
		}
		return monthYearList;
	}

	/**
	 * @author Achyutananda Purpose : This method is used to get address for english
	 *         and tamil language
	 * @param AddressMaster
	 * @return String[] : (index 0 - english and index 1 - tamil address)
	 */
	public static String[] prepareAddress(AddressMaster address) {
		log.info("prepareAddress method started ");

		if (address == null) {
			return null;
		}

		String[] addressStr = new String[2];

		String addressEnglish = "";

		if (address.getAddressLineOne() != null && StringUtils.isNotEmpty(address.getAddressLineOne())) {
			addressEnglish = addressEnglish + address.getAddressLineOne() + "," + System.lineSeparator();
		}
		if (address.getAddressLineTwo() != null && StringUtils.isNotEmpty(address.getAddressLineTwo())) {
			addressEnglish = addressEnglish + address.getAddressLineTwo() + "," + System.lineSeparator();
		}
		if (address.getAddressLineThree() != null && StringUtils.isNotEmpty(address.getAddressLineThree())) {
			addressEnglish = addressEnglish + address.getAddressLineThree() + "," + System.lineSeparator();
		}
		if (address.getLandmark() != null && StringUtils.isNotEmpty(address.getLandmark())) {
			addressEnglish = addressEnglish + address.getLandmark() + "," + System.lineSeparator();
		}
//		if (address.getCityMaster() != null && address.getCityMaster().getName() != null) {
//			addressEnglish = addressEnglish + address.getCityMaster().getName() + "," + System.lineSeparator();
//		}
//		if (address.getTalukMaster() != null && address.getTalukMaster().getName() != null) {
//			addressEnglish = addressEnglish + address.getTalukMaster().getName() + "," + System.lineSeparator();
//		}
//		if (address.getDistrictMaster() != null && address.getDistrictMaster().getName() != null) {
//			addressEnglish = addressEnglish + address.getDistrictMaster().getName() + "," + System.lineSeparator();
//		}
//		if (address.getStateMaster() != null && address.getStateMaster().getName() != null) {
//			addressEnglish = addressEnglish + address.getStateMaster().getName();
//		}
		if (address.getPostalCode() != null && !address.getPostalCode().trim().isEmpty()) {
			if (addressEnglish.isEmpty()) {
				addressEnglish = address.getPostalCode() + System.lineSeparator();
			} else {
				addressEnglish = addressEnglish + " - " + address.getPostalCode() + System.lineSeparator();
			}
		}
		addressStr[0] = addressEnglish.replaceAll(",$", "");

		String addressTamil = "";
		if (address.getLocAddressLineOne() != null && StringUtils.isNotEmpty(address.getAddressLineOne())) {
			addressTamil = addressTamil + address.getLocAddressLineOne() + "," + System.lineSeparator();
		}
		if (address.getLocAddressLineTwo() != null && StringUtils.isNotEmpty(address.getAddressLineTwo())) {
			addressTamil = addressTamil + address.getLocAddressLineTwo() + "," + System.lineSeparator();
		}
		if (address.getLocAddressLineThree() != null && StringUtils.isNotEmpty(address.getAddressLineThree())) {
			addressTamil = addressTamil + address.getLocAddressLineThree() + "," + System.lineSeparator();
		}
		if (address.getLandmark() != null && StringUtils.isNotEmpty(address.getLandmark())) {
			addressTamil = addressTamil + address.getLandmark() + "," + System.lineSeparator();
		}
//		if (address.getCityMaster() != null && address.getCityMaster().getLocalName() != null) {
//			addressTamil = addressTamil + address.getCityMaster().getLocalName() + "," + System.lineSeparator();
//		}
//		if (address.getTalukMaster() != null && address.getTalukMaster().getLocalName() != null) {
//			addressTamil = addressTamil + address.getTalukMaster().getLocalName() + "," + System.lineSeparator();
//		}
//		if (address.getDistrictMaster() != null && address.getDistrictMaster().getLdistrictName() != null) {
//			addressTamil = addressTamil + address.getDistrictMaster().getLdistrictName() + "," + System.lineSeparator();
//		}
//		if (address.getStateMaster() != null && address.getStateMaster().getLstateName() != null) {
//			addressTamil = addressTamil + address.getStateMaster().getLstateName();
//		}
		if (address.getPostalCode() != null && !address.getPostalCode().trim().isEmpty()) {
			if (addressTamil.isEmpty()) {
				addressTamil = address.getPostalCode();
			} else {
				addressTamil = addressTamil + " - " + address.getPostalCode() + System.lineSeparator();
			}
		}
		addressStr[1] = addressTamil.replaceAll(",$", "");

		log.info("prepareAddress method completed : " + addressStr);
		return addressStr;
	}

	/**
	 * @author Achyutananda Purpose : This method is used to cap Each Word first
	 *         character
	 * @param String
	 * @return String
	 */
	public static String capEachWord(String source) {

		String result = "";
		String[] splitString = source.toLowerCase().split(" ");
		for (String target : splitString) {
			if (!target.trim().isEmpty()) {
				result += Character.toUpperCase(target.charAt(0)) + target.substring(1) + " ";
			}
		}
		return result.trim();
	}

	/**
	 * @author Achyutananda Purpose : This method is used to Get date with specific
	 *         timezone
	 * @param
	 * @return Date
	 */
	public static Date currentDateWithTimezone() {
		Calendar calendar = Calendar.getInstance(Calendar.getInstance().getTimeZone());
		return calendar.getTime();
	}

	public static int monthCountBetweenTwoDates(Date fromDate, Date toDate) {

		int diffMonth = 0;
		try {
			Calendar startCalendar = new GregorianCalendar();
			startCalendar.setTime(fromDate);

			Calendar endCalendar = new GregorianCalendar();
			endCalendar.setTime(toDate);

			int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR); // effdate
																								// -
																								// currdate
			diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

		} catch (Exception e) {
			log.error("Error in AppUtil.monthCountBetweenTwoDates", e);
		}
		return diffMonth;
	}

	public static Date prepareDate(int year, String month, int day) {

		String date = year + "/" + month + "/" + day;
		Date preparedDate = null;

		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MMM/dd");
			preparedDate = formatter.parse(date);
			log.info("preparedDate :" + preparedDate);
		} catch (ParseException e) {
			log.error(e.toString());
		}
		return preparedDate;
	}

	public static byte[] zip(String sourceDirPath) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try (ZipOutputStream zs = new ZipOutputStream(baos)) {
			Path pp = Paths.get(sourceDirPath);
			Files.walk(pp).filter(path -> !Files.isDirectory(path)).forEach(path -> {
				ZipEntry zipEntry = new ZipEntry(pp.relativize(path).toString());
				try {
					zs.putNextEntry(zipEntry);
					Files.copy(path, zs);
					zs.closeEntry();
				} catch (IOException e) {
					log.error("Exception Occured while Zipping", e);
				}
			});
		}
		return baos.toByteArray();
	}

	/**
	 * @author B_Benny
	 * @param date
	 * @return list of month-year string starting from the given date to current
	 *         date
	 */
	public static Set<String> generatePastMnthYear(Date date) {
		log.info("AppUtil.generatePastMnthYear Method Started");
		DateFormat formater = new SimpleDateFormat("dd-MMMM-yyyy");
		Calendar beginCalendar = getCalendar();
		Calendar finishCalendar = getCalendar();
		Set<String> monthYearList = new LinkedHashSet<String>();
		beginCalendar.setTime(date);
		while (beginCalendar.before(finishCalendar)) {
			String dateStr = formater.format(beginCalendar.getTime());
			beginCalendar.add(Calendar.MONTH, 1);
			String[] arr = dateStr.split("-");
			monthYearList.add(arr[1] + "-" + arr[2]);
		}
		return monthYearList;

	}

	public static boolean isJSONValid(String json) {
		log.info("To check the valid json format");
		try {
			new JSONObject(json);
		} catch (JSONException ex) {
			try {
				new JSONArray(json);
			} catch (JSONException ex1) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @author B_Benny
	 * @param fromDate
	 * @param toDate
	 * @return String
	 */
	public static String diffDaysBetweenTwoDates(Date fromDate, Date toDate) {
		String dayTime = "";
		try {
			log.info("Incoming from date and to date...." + fromDate + "..." + toDate);
			LocalDateTime localDate = fromDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			LocalDateTime todayDate = toDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

			long days = ChronoUnit.DAYS.between(localDate, todayDate);
			long hours = ChronoUnit.HOURS.between(localDate, todayDate);
			long minutes = ChronoUnit.MINUTES.between(localDate, todayDate);

			dayTime = "Days:" + days + " Time:" + hours % 24 + ":" + minutes % 60;
			log.info("Days:" + days + " Time:" + hours % 24 + ":" + minutes % 60);
		} catch (Exception e) {
			log.error("Exception occured while finding days difference between two dates...", e);
		}
		return dayTime;
	}

	public static int calculateWorkDays(Date startDate, Date endDate) {
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);

		int workDays = 0;

		if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			startCal.setTime(endDate);
			endCal.setTime(startDate);
		}

		do {
			startCal.add(Calendar.DAY_OF_MONTH, 1);
			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				workDays++;
			}
		} while (startCal.getTimeInMillis() <= endCal.getTimeInMillis());

		return workDays;
	}

	public static List<String> prepareFromMonthYearAndToMonthYear(int monthInterval) {
		List<String> monthYearList = new ArrayList<>();

		Calendar cal = GregorianCalendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("MMM-yyyy");

		Date currentMonth = new Date();
		cal.setTime(currentMonth);

		// current month
		String currentMonthAsSting = df.format(cal.getTime());
		monthYearList.add(currentMonthAsSting);

		/*
		 * cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+11); String nextMonthAsString
		 * = df.format(cal.getTime());
		 */

		for (int i = 1; i <= monthInterval; i++) {
			// Add next month
			cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + i);
			String nextMonthAsString = df.format(cal.getTime());
			monthYearList.add(nextMonthAsString);
			cal.setTime(currentMonth);
		}

		return monthYearList;
	}

	/**
	 * @param contextPath
	 * @return
	 * 
	 * 		To redirect unauthorized page if user doesn't have privilege to
	 *         access that particular page.
	 */
	static public String getUnAuthorizedPageUrl(String contextPath) {
		return contextPath + "/pages/unauthorized.xhtml?faces-redirect=true";
	}
	
	    /***
	     * Month value get into alphabets format
	     * @return the month name for alphabets format
	     */
		public static Map<String, String> getAllMonthWithAlphabet() {
			log.info(" <<<=== Inside AppUtil :: getAllMonthWithAlphabet ");
			Map<String, String> monthNameList = new HashMap<String, String>();
			monthNameList.put("01","A");
			monthNameList.put("02","B");
			monthNameList.put("03","C");
			monthNameList.put("04","D");
			monthNameList.put("05","E");
			monthNameList.put("06","F");
			monthNameList.put("07","G");
			monthNameList.put("08","H");
			monthNameList.put("09","I");
			monthNameList.put("10","J");
			monthNameList.put("11","K");
			monthNameList.put("12","L");
			log.info(" <<<=== Completed AppUtil :: getAllMonthWithAlphabet ");
			return monthNameList;
		}

}
