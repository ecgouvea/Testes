package testes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class XmlGregorianCalendarMain {

	public static void main(String[] args) {
		//Date d = new Date(1494541825394L);
		//Date d = new Date(1521904100900L); //2018-03-24 12:08:20.900
		Date d = new Date(1521904226503L);   //2018-03-24 12:10:26.503
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		System.out.println(sdf.format(d));
		
		Calendar dateTime = new GregorianCalendar();
//		XMLGregorianCalendarImpl.createDateTime(dateTime.get(Calendar.YEAR) + " " + dateTime.get(Calendar.MONTH) + " " + dateTime.get(Calendar.DATE) + " " + dateTime.get(Calendar.HOUR_OF_DAY) + " " + dateTime.get(Calendar.MINUTE) + " " + dateTime.get(Calendar.SECOND) + " " + dateTime.get(Calendar.MILLISECOND) + " " + 0).toXMLFormat();
		System.out.println(dateTime.get(Calendar.YEAR) + " " + dateTime.get(Calendar.MONTH) + " " + dateTime.get(Calendar.DATE) + " " + dateTime.get(Calendar.HOUR_OF_DAY) + " " + dateTime.get(Calendar.MINUTE) + " " + dateTime.get(Calendar.SECOND) + " " + dateTime.get(Calendar.MILLISECOND));
		
	}

}
