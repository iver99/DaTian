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
	
	/**
	 * 日期转为字符串
	 * 
	 * @param date
	 * @return 返回yyyy-mm-dd
	 */
	public static String DateToString(Date date){
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		    String dateString = formatter.format(date);  
		    return dateString; 
	}
	
	//test
	public static void main(String [] args){
		
		System.out.println(DateToString(new Date()));
	}

}
