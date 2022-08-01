package com.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.bean.Doctor;

public class DoctorDaoImpl implements DoctorDao {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private Statement statement;
	private ResultSet resultSet;
	
	Connection connectDB() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "wiley");
	}
	
	@Override
	public String searchDoctorId(String doctorName) {
		String id = null;
		
		try {
			this.connection = connectDB();
			preparedStatement = connection.prepareStatement("select doctor_id from DOCTOR where name_of_doctor=?");
			
			preparedStatement.setString(1, doctorName);
			resultSet = preparedStatement.executeQuery(); 
			
			if(resultSet.next()) {
				id = resultSet.getString("doctor_id");
			};
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	
	}
	

	@Override
	public Doctor getDoctorDetails(String doctorId) {
		
		Doctor doctorDetails = null;
		
		try{
			this.connection = connectDB();
			preparedStatement = connection.prepareStatement("select * from DOCTOR where doctor_id=?");
			
			preparedStatement.setString(1, doctorId);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				
				doctorDetails = new Doctor(
						resultSet.getString("doctor_id"),
						resultSet.getString("name_of_doctor"),
						resultSet.getString("specialisation"),
						resultSet.getInt("experience"),
						resultSet.getString("gender"),
						resultSet.getInt("age"),
						resultSet.getString("Contact_number"),
						resultSet.getString("Address"));
			};
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return doctorDetails;	
	}

	@Override
	public List<Doctor> getDoctorList() {

		List<Doctor> doctorList = new ArrayList<>();
		
		try{
			this.connection = connectDB();
			statement = connection.createStatement();

			resultSet = statement.executeQuery("SELECT * FROM PATIENT");
			while(resultSet.next()) {
				
				Doctor doctor = new Doctor(
						resultSet.getString("doctor_id"),
						resultSet.getString("name_of_doctor"),
						resultSet.getString("specialisation"),
						resultSet.getInt("experience"),
						resultSet.getString("gender"),
						resultSet.getInt("age"),
						resultSet.getString("Contact_number"),
						resultSet.getString("Address"));
				doctorList.add(doctor);
			};
			
		} catch (SQLException e) {
			e.printStackTrace();

			return null;
		}
		return doctorList;
	}

	
	
	@Override
	
	public String getEmergencyContact(String doctorId) {

		String contact = null;
		
		try{
			this.connection = connectDB();		
			preparedStatement = connection.prepareStatement("select contact_number from DOCTOR where doctor_id=?");
			preparedStatement.setString(1, doctorId);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				resultSet.getString(contact);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contact;
		
	}

	@Override 
	public List<Doctor> getAvailableDoctors(Date date) { 

		List<Doctor> getAvailableDoctors = new ArrayList<>();
		
		try{
			this.connection = connectDB();
			preparedStatement = connection.prepareStatement("select * from DOCTOR where available_day = ?");

			int day = date.getDay();
			
			preparedStatement.setInt(1, day);

			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Doctor doctor = new Doctor(
						resultSet.getString("doctor_id"),
						resultSet.getString("name_of_doctor"),
						resultSet.getString("specialisation"),
						resultSet.getInt("experience"),
						resultSet.getString("gender"),
						resultSet.getInt("age"),
						resultSet.getString("Contact_number"),
						resultSet.getString("Address"));
				getAvailableDoctors.add(doctor);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getAvailableDoctors;
	}
	
	@Override
	public boolean addDoctor(Doctor doctor) {
		
		int rows = 0;
		try{
			this.connection = connectDB();
			preparedStatement = connection.prepareStatement("INSERT INTO DOCTOR values(?,?,?,?,?,?,?,?)");

			preparedStatement.setString(1, doctor.getPersonId());
			preparedStatement.setString(2, doctor.getName());
			preparedStatement.setString(3, doctor.getDepartment());
			preparedStatement.setInt(4, doctor.getExperienceInYears()); 
			preparedStatement.setString(5, doctor.getGender());
			preparedStatement.setInt(6, doctor.getAge());
			preparedStatement.setString(7, doctor.getContactNumber());
			preparedStatement.setString(8, doctor.getAddress());

			rows = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		if(rows < 0)
			return false;
		return true;
	}

	@Override
	public boolean removeDoctor(String doctorId) {
		int rows = 0;
		
		try{
			this.connection = connectDB();
			preparedStatement = connection.prepareStatement("DELETE FROM DOCTOR where doctor_id=?");
			preparedStatement.setString(1, doctorId);

			rows = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		if(rows < 0) 
			return false;
		return true;
	}

}
