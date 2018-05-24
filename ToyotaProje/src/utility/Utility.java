package utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utility {
	
	public static Date convertFromStringToDate(String stringDate) {
		Date date=new Date();
		DateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
		try {
			date=formatter.parse(stringDate);
//			System.out.println(date);
//			System.out.println(formatter.format(date));
			
//			System.out.println("---------------------CALENDAR---------------------------");
//			
//			Calendar c=Calendar.getInstance();
//			c.setTime(date);
//			c.add(Calendar.DATE, 1);
//			System.out.println(c.getTime());
//			date=c.getTime();
//			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	} 

	
	public static String convertFromDateToString(Date date) {
		
		DateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
		
		return formatter.format(date);
	}
	
	public static String convertFromDateToStringForUpdate(Date date) {
		
		DateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
		
		return formatter.format(date);
	}
	
	public static Date SubMonthNow(int month) {
		
		Date date=new Date();
		
			
			Calendar c=Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.MONTH, -month);
			date=c.getTime();
			
			return date;
	} 
	
	public static Date AddYearNow(int year) {
		
		Date date=new Date();
		
			
			Calendar c=Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.YEAR, year);
			date=c.getTime();
			
			return date;
	} 
	
	
}
