package co.orffosoft.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import lombok.Data;
import org.apache.commons.lang.StringUtils;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Util {

	/*
	 * Singleton Class
	 */
	private static Util util = null;

	@Getter
	@Setter
	private static Properties prop;

	public Util() {

	}

	public static Util getInstance() {
		if (util == null) {
			util = new Util();
		}
		return util;
	}

	public static Date addDate(Date date, Integer day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, day);
		return calendar.getTime();
	}

	public static String commaSeparatedIds(List<Long> ids) {
		if (ids == null) {
			return new String("");
		}
		Long[] idsArray = new Long[ids.size()];
		idsArray = ids.toArray(idsArray);
		return StringUtils.join(ids, ",");
	}

	public String getPropValues(String value) throws IOException {
		if (prop == null) {
			getInstance().load();
		}
		return prop.getProperty(value);
	}

	public void load() throws IOException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");
		prop = new Properties();
		prop.load(inputStream);
	}

	public static boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}

	public static void addWarn(String str) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, str, " "));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
	}

	public static void addError(String str) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, str, ""));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
	}

	public static void addInfo(String str) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, str, ""));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
	}

	public String getPortalServerURL() {
		try {
			return getInstance().getPropValues("portal.server.url");
		} catch (IOException e) {
			log.fatal("Exception at loadValues() >>>> " + e.toString());
			e.printStackTrace();
		}
		return null;
	}

	public static Map<String, Integer> getMonthIdsByName() {
		Map<String, Integer> map = new LinkedHashMap<>();
		map.put("Jan", 1);
		map.put("Feb", 2);
		map.put("Mar", 3);
		map.put("Apr", 4);
		map.put("May", 5);
		map.put("Jun", 6);
		map.put("Jul", 7);
		map.put("Aug", 8);
		map.put("Sep", 9);
		map.put("Oct", 10);
		map.put("Nov", 11);
		map.put("Dec", 12);
		return map;
	}
	
	public static String formatDate(Date date) {
		final String dateFormat = "yyyy-MM-dd HH:mm:ss.SSS";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		return simpleDateFormat.format(date);
	}

	public static String getOnlyMonthFromDate(Date date) {
		String month = null;
		if (date != null) {
			DateFormat monthFormat = new SimpleDateFormat("MMM");
			month = monthFormat.format(date);
		}
		return month;
	}

	public static int getOnlyYearFromDate(Date date) {
		int year = 0;
		if (date != null) {
			DateFormat yearFormat = new SimpleDateFormat("yyyy");
			year = Integer.valueOf(yearFormat.format(date));
		}
		return year;
	}
	
	public static Map<String, Integer> getMonthIdsByDetailName() {
		Map<String, Integer> map = new LinkedHashMap<>();
		map.put("January", 1);
		map.put("February", 2);
		map.put("March", 3);
		map.put("April", 4);
		map.put("May", 5);
		map.put("June", 6);
		map.put("July", 7);
		map.put("August", 8);
		map.put("September", 9);
		map.put("October", 10);
		map.put("November", 11);
		map.put("December", 12);
		return map;
	}
	
	public static Map<Integer, String> getMonthNameByIds() {
		Map<Integer, String> map = new LinkedHashMap<>();
		map.put(1, "Jan");
		map.put(2, "Feb");
		map.put(3, "Mar");
		map.put(4, "Apr");
		map.put(5, "May");
		map.put(6, "Jun");
		map.put(7, "Jul");
		map.put(8, "Aug");
		map.put(9, "Sep");
		map.put(10, "Oct");
		map.put(11, "Nov");
		map.put(12, "Dec");
		return map;
	}
	
	public static List<Integer> getReportYearList() {
		List<Integer> yearList=Arrays.asList(2009,2010,2011,2012,2013,2014,2015,2016,2017,2018);
		return yearList;
	}

    public static List<Integer> getNextSixYearList() {
        Calendar now = Calendar.getInstance();
        int currentYear = now.get(Calendar.YEAR);

        List<Integer> yearList = Arrays.asList(currentYear, currentYear + 1,
                currentYear + 2, currentYear + 3, currentYear + 4,
                currentYear + 5, currentYear + 6);
        return yearList;
    }

    public static List<Integer> getNextSixYearListFromGivenYear(int year) {
        Calendar now = Calendar.getInstance();
        now.set(Calendar.YEAR, year);
        int currentYear = now.get(Calendar.YEAR);

        List<Integer> yearList = Arrays.asList(currentYear, currentYear + 1,
                currentYear + 2, currentYear + 3, currentYear + 4,
                currentYear + 5, currentYear + 6);
		return yearList;
	}

	public static Date stringToUtilDate(String stringDate) {
		Date date = null;
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			date = formatter.parse(stringDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(date);
		return  date;
	}

}
