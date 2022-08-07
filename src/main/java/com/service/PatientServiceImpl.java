package com.service;

//import java.sql.Date;
import java.util.Date;
import java.util.List;

import com.bean.Patient;
import com.persistence.AppointmentDaoImpl;
import com.persistence.PatientDaoImpl;

public class PatientServiceImpl implements PatientService {

	AppointmentDaoImpl appointmentDaoImpl = new AppointmentDaoImpl();
	PatientDaoImpl patientDaoImpl = new PatientDaoImpl();
	
	@Override
	public void requestAppointment(String id, Date date) {
		appointmentDaoImpl.appointment(id, date.toString());
	}

	@Override
	public void cancelAppointmentRequest(int i) {
		
	}

	@Override
	public void rescheduleAppointment(int aid, Date newDate) {
		
	}

	@Override
	public void getPatientProfile(String id) {
		Patient patient = patientDaoImpl.getPatientById(id);
		System.out.println(patient.toString());
	}

	@Override
	public int getLastPatientId() {
		return patientDaoImpl.getLastPId();
	}
	
	@Override
	public List<String> getMyAppointments(String pid) {
		return appointmentDaoImpl.getAllAppointments(pid);
	}

}
