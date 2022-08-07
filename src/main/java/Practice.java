import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

import com.persistence.AppointmentDaoImpl;

public class Practice {
	
	public static void main(String args[]) {
//		AppointmentDaoImpl impl = new AppointmentDaoImpl();
//		impl.appointment("P101", "2022-01-02");
		Date date = null;
		System.out.println("Day: "+date.valueOf(LocalDate.now()).getDay());
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(cal.DAY_OF_WEEK));
	}
}
