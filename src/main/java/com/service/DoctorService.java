package com.service;

import java.util.List;
import java.util.Map;

public interface DoctorService {

boolean getPatientProfile(int doctorId, int patientId);
	
	boolean updatePatientProfile(int doctorId, int patientId, Map<String,String> editList);
	
//	Map<String,String> getAvailableDoctors();
	
	boolean displayAvailableDoctors(); //doctor list + emergencyContact

	Map<String, List<String>> getDoctorSchedule(String doctorId);

	boolean updateDoctorSchedule(String doctorId);
}
