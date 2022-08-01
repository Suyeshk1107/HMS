package com.persistence;

import java.sql.Date;

public interface AppointmentDao {

	void appointment(String patient_id, String new_date);
	
	String checkSlot(String slot_to_check, String d_Id, Date date);
	
	void storeAppointment(String p_id, String p_name, String new_slot, Date date, String d_id, String d_name, String dept);
}
