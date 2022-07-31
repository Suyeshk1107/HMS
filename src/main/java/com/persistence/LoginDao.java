package com.persistence;

import com.bean.Doctor;
import com.bean.Patient;

public interface LoginDao {

	boolean registerUser();
	
	boolean validate(String id, String password);
	
}

//transaction, appointment