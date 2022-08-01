package com.service;

//import java.sql.Date;
import java.util.Date;

import com.persistence.AppointmentDaoImpl;

public class PatientServiceImpl implements PatientService {

	AppointmentDaoImpl appointmentDaoImpl = new AppointmentDaoImpl();
	
	@Override
	public boolean requestAppointment(String id, Date date) {
		appointmentDaoImpl.appointment(id, date.toString());
		return false;
	}

	@Override
	public boolean cancelAppointmentRequest(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rescheduleAppointment(String id, Date newDate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getPatientProfile(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
