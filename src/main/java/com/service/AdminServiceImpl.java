package com.service;

import java.sql.Date;
import java.util.List;

import com.bean.Doctor;
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
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public boolean addPatient(String doctorId, String patientId) {
//		return false;
//	}
//
//	@Override
//	public boolean removePatient(String doctorId, String patientId) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public boolean registerDoctorToDatabase(Doctor doctor) {
		return doctorDaoImpl.addDoctor(doctor);
	}

	@Override
	public boolean removeDoctorFromDatabase(String doctorID) {
		return doctorDaoImpl.removeDoctor(doctorID);
	}

	@Override
	public List<Doctor> getAvailableDoctors(Date date) {
		return doctorDaoImpl.getAvailableDoctors(date);
	}

//	@Override
//	public boolean displayAvailableDoctors() {
//		// TODO Auto-generated method stub
//		return false;
//	}

	
}
