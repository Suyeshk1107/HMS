package com.persistence;

import java.sql.Array;
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
	
//	public static void main(String[] args) {
//	
//		DoctorDaoImpl doctorDaoImpl = new DoctorDaoImpl();
//		
//		doctorDaoImpl.searchDoctorId("Dr Lipp");
//		
//		Doctor doctor = doctorDaoImpl.getDoctorDetails(7);
//		System.out.println(doctor);
//	}

	@Override
	public int searchDoctorId(String doctorName) {
		
		ResultSet resultSet;
		int id = 0;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("select doctor_id from DOCTOR where name_of_doctor=?");) {
			preparedStatement.setString(1, doctorName);

			resultSet = preparedStatement.executeQuery(); 
			
			if(resultSet.next()) {
				id = resultSet.getInt("doctor_id");
			};
			
		} catch (SQLException e) {
			e.printStackTrace();
			id = -1;
		}
		return id;
	
	}
	

	@Override
	public Doctor getDoctorDetails(int doctorId) {
		
		ResultSet resultSet;
		Doctor doctorDetails = null;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from DOCTOR where doctor_id=?");) {
			preparedStatement.setInt(1, doctorId);

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
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital", "root",
				"wiley");
				Statement statement = connection.createStatement();) {

			ResultSet resultSet = statement.executeQuery("SELECT * FROM PATIENT");
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
		int rows;
		List<Doctor> doctorList = null;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("select contact_number from DOCTOR where doctor_id=?");) {
			preparedStatement.setString(1, doctorId);

			rows = preparedStatement.executeUpdate(); // not done

		} catch (SQLException e) {
			e.printStackTrace();
			rows = -1;
		}
		return contact;
		
	}

	@Override 
	public List<Doctor> getAvailableDoctors(Date date) { 

		
		List<Doctor> getAvailableDoctors = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from DOCTOR where available_day = ?");) { // 

			int day = date.getDay();
			
			preparedStatement.setInt(1, day);

			ResultSet resultSet = preparedStatement.executeQuery();
			
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
		// TODO Auto-generated method stub
		int rows = 0;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO DOCTOR values(?,?,?,?,?,?,?,?)");) {

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

		return true;
	}

	@Override
	public boolean removeDoctor(String doctorId) {
		int rows;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("DELETE FROM DOCTOR where doctor_id=?");) {
			preparedStatement.setString(1, doctorId);

			rows = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		if(rows<1) {
			return false;
		}
		return true;
	}

}
