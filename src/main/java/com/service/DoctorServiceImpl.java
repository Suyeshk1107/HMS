package com.service;

import java.util.List;
import java.util.Map;

public class DoctorServiceImpl implements DoctorService {

	@Override
	public boolean getPatientProfile(int doctorId, int patientId) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean updatePatientProfile(int doctorId, int patientId, Map<String, String> editList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, List<String>> getDoctorSchedule(int doctorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateDoctorSchedule(int doctorId) {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public Map<String, String> getAvailableDoctors() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public boolean displayAvailableDoctors() {
		// TODO Auto-generated method stub
		return false;
	}

}
