package cn.edu.bjtu.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 日期类型解析类，String to Date
 * @author RussWest0
 *
 */
public class ParseDate {
	public static Date parseDate(String date)
	{
		DateFormat dateFormat2=new SimpleDateFormat("yyyy-mm-dd");
		Date myDate2=null;
		try {
			myDate2 = dateFormat2.parse(date);
		} catch (ParseException e) {
			// 
			e.printStackTrace();
			return null;
		}
		return myDate2;
	}

}
