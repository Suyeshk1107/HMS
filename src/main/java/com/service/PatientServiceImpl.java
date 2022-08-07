package com.service;

import java.sql.Date;
import java.util.List;

import com.bean.Patient;
import com.persistence.AppointmentDaoImpl;
import com.persistence.PatientDaoImpl;

public class PatientServiceImpl implements PatientService {

	AppointmentDaoImpl appointmentDaoImpl = new AppointmentDaoImpl();
	PatientDaoImpl patientDaoImpl = new PatientDaoImpl();
	
	@Override
	public boolean rescheduleAppointment(int aid, Date newDate) {
		return appointmentDaoImpl.reschedule(aid, newDate);
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
	public List<String> getMyAppointments(String pid, int choice) {
		return appointmentDaoImpl.getAllAppointments(pid, choice);
	}

	@Override
	public void requestAppointment(String id, String doc_id, Date date) {
		appointmentDaoImpl.appointment(id, doc_id, date);
	}

	@Override
	public boolean cancelAppointmentRequest(int nextInt) {
		return appointmentDaoImpl.cancelAppointment(nextInt);
	}


}
