package base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Testing {

	public static void main(String[] args) {

		System.out.println(System.getProperty("user.dir") + "/Report/" + "Reports_" + getDate());

	}

	public static String getDate() {

		Date date = new Date();
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss:a");
		format.setTimeZone(TimeZone.getDefault());
		System.out.println(" Returned Date is  =  " + format.format(date));
		return format.format(date);

	}

}
