package com.service;

import com.bean.Doctor;
import com.bean.Patient;
import com.persistence.LoginDaoImpl;

public class ValidateUserServiceImpl implements ValidateUserService {

	LoginDaoImpl loginDaoImpl = new LoginDaoImpl();
	
	@Override
	public boolean registerPatient(Patient patient) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPatient(String id, String Password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDoctor(String id, String Password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAdmin(String id, String Password) {
		return loginDaoImpl.validate(id, Password);
	}

}
