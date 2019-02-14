package test.tunnel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DatetimeUtil {
	public static final String DEFAULT_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";
	public static final String DEFAULT_DATE = "yyyy-MM-dd";
	
	/**
	 * 人员定位时间转化
	 * @param date
	 * @return
	 */
	public static String getDate(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE);
		format.format(date);
		return format.format(date);
	}
	
	
	/**
	 * 隧道人员定位-停留时间计算
	 */
	public static String stayTime(String startTime) {
		return stayTime(startTime, getCurDateString());
	}

	public static String stayTime(String startTime, String endTime) {
		long l = string2Date(endTime).getTime() - string2Date(startTime).getTime();
		if (l > 0) {
			long hour = l / (1000 * 60 * 60);
			long min = (l % (1000 * 60 * 60)) / 1000 / 60;
			return hour + "小时" + min + "分钟";
		} else {
			return "0小时0分钟";
		}

	}

	public static String toDefaultDateString(Date date) {
		if(date == null){
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat(DEFAULT_FORMAT_STRING);
		format.format(date);
		return format.format(date);
	}

	public static String getCurDateString(){
		return toDefaultDateString(new Date());
	}

	public static String dateFormate(String dateTime) {
		String regEx = "^\\d{2}/\\d{2}/\\d{4}  \\d:\\d{2}$";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(dateTime);
		if (m.find()) {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm");
			try {
				Date date = format.parse(dateTime);
				format = new SimpleDateFormat(DEFAULT_FORMAT_STRING);
				return format.format(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				return dateTime;
			}

		}
		return dateTime;
	}

	public static Date string2Date(String datetime) {
		SimpleDateFormat format = new SimpleDateFormat(DEFAULT_FORMAT_STRING);
		try {
			return format.parse(datetime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String formatDate(Date date,String regEx) {
		if (date == null) {
			return "";
		}
		DateFormat format = new SimpleDateFormat(regEx);
		return format.format(date);
	}
	
	public static Date getRealDate(Date date, String regEx) {
		DateFormat format = new SimpleDateFormat(regEx);
		String dateStr = format.format(date);
		try {
			return format.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}

	public static Date parseString2Date(String datetime, String regEx) {
		SimpleDateFormat format = new SimpleDateFormat(regEx);
		try {
			return format.parse(datetime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
