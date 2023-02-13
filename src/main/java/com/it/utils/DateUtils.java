package com.it.utils;

import java.sql.Timestamp;

public class DateUtils {
	
	public static Timestamp stringToTimestamp(String dateTime) {
		return  Timestamp.valueOf(dateTime);
	}

}
