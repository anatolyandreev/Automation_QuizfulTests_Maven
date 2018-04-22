package by.htp.quizful.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Temp {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
		Calendar cal=Calendar.getInstance(TimeZone.getDefault());
		Date dateGMT=cal.getTime();
		System.out.println(dateGMT);
	}

}
