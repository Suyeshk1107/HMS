package com.service;

import java.util.Date;

public interface PatientService {

	boolean getPatientProfile(String id);

	boolean requestAppointment(String id, Date date);

	boolean cancelAppointmentRequest(String id);

	boolean rescheduleAppointment(String id, Date newDate);//can check only his/her patientHistory
}
