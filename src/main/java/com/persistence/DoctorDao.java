package com.persistence;

import java.sql.Date;
import java.util.List;

import com.bean.Doctor;

public interface DoctorDao {

	
	int searchDoctorId(String doctorName);
	
	Doctor getDoctorDetails(int doctorId);
	
	List<Doctor> getDoctorList();
	
	boolean addDoctor(Doctor doctor); //return type changed
	
	boolean removeDoctor(int doctorId);
	
	String getEmergencyContact(int doctorId);
	
	List<Doctor> getAvailableDoctors(Date date);
}
