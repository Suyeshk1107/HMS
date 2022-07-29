package com.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.bean.Doctor;

public class DoctorDaoImpl implements DoctorDao {

	@Override
	public boolean searchDoctorId(String doctorName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getDoctorDetails(int doctorId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getDoctorList() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getEmergencyContact(int doctorId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Doctor> getAvailableDoctors() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		int rows = 0;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO DOCTOR values(?,?,?,?,?,?,?,?)");) {

			preparedStatement.setInt(1, doctor.getPersonId());
			preparedStatement.setString(2, doctor.getName());
			preparedStatement.setString(3, doctor.getSpecialization());
			preparedStatement.setInt(4, doctor.getExperienceInYears()); 
			preparedStatement.setString(5, doctor.getGender());
			preparedStatement.setInt(6, doctor.getAge());
			preparedStatement.setString(7, doctor.getContactNumber());
			preparedStatement.setString(8, doctor.getAddress());

			rows = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rows;
	}

	@Override
	public boolean removeDoctor(int doctorId) {
		// TODO Auto-generated method stub
//		Doctor doctor = null;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("DELETE FROM DOCTOR where doctor_id=?");) {
			preparedStatement.setInt(1, doctorId);

			preparedStatement.executeUpdate();
			System.out.println("Record deleted successfully");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

}
