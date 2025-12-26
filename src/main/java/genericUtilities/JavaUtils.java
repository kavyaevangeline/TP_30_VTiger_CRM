package genericUtilities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class JavaUtils {

	/**
	 * This method is used to get random number
	 * @author Kavya
	 * @return
	 */
	public int getRandomNo() {
		
		Random ran = new Random();
		int random = ran.nextInt(1000);
		return random;
	}
	
	/**
	 * This method is used to get system date
	 * @author Kavya
	 * @return
	 */
	public String systemDate() {
		 LocalDate date= LocalDate.now();
		DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String systemdate = d.format(date);
		return systemdate;
	}
	
	/**
	 * This method is used to get system date and time
	 * @author Kavya
	 * @return
	 */
	public String sysDate() {
		
		Date date = new Date();
		
		SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String systemDateInFormat = sim.format(date);
		return systemDateInFormat;
	}
	
	/**
	 * This method is used to get future date in terms of month
	 * @author Kavya
	 * @param futureMon
	 * @return
	 */
	public String futureDateInTermsOfMonths(long futureMon) {
		
		LocalDate date= LocalDate.now();
		
		LocalDate future = date.plusMonths(futureMon);
		
		DateTimeFormatter d = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String futureMonth = d.format(future);
		return futureMonth;
	}
	
}
