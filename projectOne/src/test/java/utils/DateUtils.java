package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtils {

	private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);

	public static Date getDateFromText(String time) {
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yy:HH:mm:SS");
		Date output = null;
		try {
			output = df.parse(time);
		} catch (ParseException e) {
			logger.error(e.getMessage());
		}
		return output;
	}
}
