package com.service;

import java.util.List;

import com.bean.Doctor;
import com.persistence.DoctorDaoImpl;

public class AdminServiceImpl implements AdminService {

	DoctorDaoImpl doctorDaoImpl = new DoctorDaoImpl();
	
	@Override
	public boolean generateAppointment(int patientId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancelAppointment(int patientId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPatient(int doctorId, int patientId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removePatient(int doctorId, int patientId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerDoctorToDatabase(Doctor doctor) {
		
		return false;
	}

	@Override
	public boolean removeDoctorFromDatabase(String doctorID) {
		return doctorDaoImpl.removeDoctor(doctorID);
	}

	@Override
	public List<Doctor> getAvailableDoctors() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public boolean displayAvailableDoctors() {
//		// TODO Auto-generated method stub
//		return false;
//	}

	
}
