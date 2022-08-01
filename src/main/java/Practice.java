import com.persistence.AppointmentDaoImpl;

public class Practice {
	
	public static void main(String args[]) {
		AppointmentDaoImpl impl = new AppointmentDaoImpl();
		impl.appointment("P101", "2022-01-02");
	}
}
