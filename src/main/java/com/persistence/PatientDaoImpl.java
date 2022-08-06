package com.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.Patient;

public class PatientDaoImpl implements PatientDao {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private Statement statement;
	private ResultSet resultSet;
	
	Connection connectDB() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "wiley");
	}
	
	@Override
	public List<Patient> getPatientList() {
		
		List<Patient> patientList = new ArrayList<Patient>();
		
		try{
			this.connection = connectDB();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM PATIENT");

			while (resultSet.next()) {
				String id = resultSet.getString("patient_id");
				String name = resultSet.getString("name_of_patient");
				String gender = resultSet.getString("gender");
				int age = resultSet.getInt("age");
				String contact = resultSet.getString("Contact_number");
				String address = resultSet.getString("Address");
				String dept = resultSet.getString("department");
				
				
				patientList.add(new Patient(id,name,age,gender,contact,dept,address));
			}
			return patientList;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return patientList;
	}



	@Override
	public boolean addPatient(Patient patient) {
		int rows = 0;
		try{
			this.connection = connectDB();
			preparedStatement = connection.prepareStatement("INSERT INTO PATIENT values(?,?,?,?,?,?,?)");
			
			preparedStatement.setString(1, patient.getPersonId());
			preparedStatement.setString(2, patient.getName());
			preparedStatement.setString(3, patient.getGender());
			preparedStatement.setInt(4, patient.getAge());
			preparedStatement.setString(5, patient.getContactNumber());
			preparedStatement.setString(6, patient.getAddress());
			preparedStatement.setString(7, patient.getDepartment());

			rows = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rows>0)
			return true;
		return false;
	}

	@Override
	public boolean removePatient(String patientId) {
		// TODO Auto-generated method stub
		try{
			this.connection = connectDB();
			preparedStatement = connection.prepareStatement("DELETE FROM PATIENT where patient_id=?");
			preparedStatement.setString(1, patientId);

			preparedStatement.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public Patient getPatientById(String patientId) {
		Patient patient = null;
		try{
			this.connection = connectDB();
			preparedStatement = connection.prepareStatement("SELECT * FROM PATIENT where patient_id=?");
			preparedStatement.setString(1, patientId);
			
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String id = resultSet.getString("patient_id");
				String name = resultSet.getString("name_of_patient");
				String gender = resultSet.getString("gender");
				int age = resultSet.getInt("age");
				String contact = resultSet.getString("Contact_number");
				String address = resultSet.getString("Address");
				String dept = resultSet.getString("department");
				
				
				patient= new Patient(id,name,age,gender,contact,dept,address);
				return patient;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return patient;
	}

}
