package testes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampMain {

	public static void main(String[] args) {
		Date d = new Date(1494541825394L);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		System.out.println(sdf.format(d));
	}

}
