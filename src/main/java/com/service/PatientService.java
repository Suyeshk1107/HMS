package com.service;

import java.util.Date;

public interface PatientService {

	void getPatientProfile(String id);

	void requestAppointment(String id, Date date);

	void cancelAppointmentRequest(String id);

	void rescheduleAppointment(String id, Date newDate);//can check only his/her patientHistory
}
