package com.service;

import java.util.Date;
import java.util.List;

public interface PatientService {

	void getPatientProfile(String id);

	void requestAppointment(String id, Date date);

	int getLastPatientId();

	List<String> getMyAppointments(String pid);

	void cancelAppointmentRequest(int i);

	void rescheduleAppointment(int aid, Date newDate);
}
