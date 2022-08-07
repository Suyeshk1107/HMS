package com.service;

import java.sql.Date;
import java.util.List;

import com.bean.Doctor;
import com.bean.Schedule;
import com.persistence.DoctorDaoImpl;
import com.persistence.PatientDaoImpl;

public class AdminServiceImpl implements AdminService {

	DoctorDaoImpl doctorDaoImpl = new DoctorDaoImpl();
	PatientDaoImpl patientDaoImpl = new PatientDaoImpl();
	
	@Override
	public boolean generateAppointment(String patientId) {
		return false;
	}

	@Override
	public boolean cancelAppointment(String patientId) {
		return false;
	}

	@Override
	public boolean registerDoctorToDatabase(Doctor doctor) {
		return doctorDaoImpl.addDoctor(doctor);
	}

	@Override
	public boolean removeDoctorFromDatabase(String doctorID) {
		return doctorDaoImpl.removeDoctor(doctorID);
	}

	@Override
	public List<Schedule> getAvailableDoctors(Date date) {
		return doctorDaoImpl.getAvailableDoctors(date);
	}

	
}
