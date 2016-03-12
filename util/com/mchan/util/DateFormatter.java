package com.mchan.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author soe san
 *
 */
public class DateFormatter {

	/*-********************************************************************
	 *                         Methods                                    *
	 **********************************************************************/

	/**
	 * to format date according to user requirement
	 * @param format user required format
	 * @param date current date
	 * @return String which user required format
	 */
	public static String format(Date date, String format){
		Format formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}
}
