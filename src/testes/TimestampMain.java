package testes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampMain {

	public static void main(String[] args) {
		//Date d = new Date(1494541825394L);
		//Date d = new Date(1521904100900L); //2018-03-24 12:08:20.900
		Date d = new Date(1521904226503L);   //2018-03-24 12:10:26.503
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		System.out.println(sdf.format(d));
	}

}
