package com.persistence;


public interface LoginDao {

	boolean registerUser();
	
	boolean validate(String id, String password);
	
}

//transaction, appointment