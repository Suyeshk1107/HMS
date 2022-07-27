package com.persistence;

import java.util.List;

import com.bean.Doctor;

public interface DoctorDao {

	
	boolean searchDoctorId(String doctorName);
	
	boolean getDoctorDetails(int doctorId);
	
	boolean getDoctorList();
	
	boolean addDoctor(Doctor doctor);
	
	boolean removeDoctor(int doctorId);
	
	boolean getEmergencyContact(int doctorId);
	
	List<Doctor> getAvailableDoctors();
}
