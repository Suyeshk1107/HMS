package com.service;

import com.bean.Doctor;
import com.bean.Patient;
import com.persistence.DoctorDaoImpl;
import com.persistence.LoginDaoImpl;
import com.persistence.PatientDaoImpl;

public class ValidateUserServiceImpl implements ValidateUserService {

	LoginDaoImpl loginDaoImpl = new LoginDaoImpl();
	PatientDaoImpl patientDaoImpl = new PatientDaoImpl();
	DoctorDaoImpl doctorDaoImpl = new DoctorDaoImpl();
	
	@Override
	public boolean registerPatient(Patient patient) {
		return patientDaoImpl.addPatient(patient);
	}

	@Override
	public boolean registerDoctor(Doctor doctor) {
		return doctorDaoImpl.addDoctor(doctor);
	}

	@Override
	public boolean isPatient(String id, String Password) {
		return loginDaoImpl.validate(id, Password);
	}

	@Override
	public boolean isDoctor(String id, String Password) {
		return loginDaoImpl.validate(id, Password);
	}

	@Override
	public boolean isAdmin(String id, String Password) {
		return loginDaoImpl.validate(id, Password);
	}

	@Override
	public boolean registerUser(String id, String Password) {
		return loginDaoImpl.registerUser(id, Password);
	}
}
