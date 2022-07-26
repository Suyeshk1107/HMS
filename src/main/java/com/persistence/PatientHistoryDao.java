package com.persistence;

import java.util.Map;

public interface PatientHistoryDao {

	boolean getPatientHistory(int patientId);
	
	boolean editPatientHistory(int patientId, Map<String,String> patientHistory);
}
