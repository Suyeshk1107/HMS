package com.persistence;


public interface LoginDao {
	
	boolean registerUser(String id, String password);
	
	boolean validate(String id, String password);
	
}