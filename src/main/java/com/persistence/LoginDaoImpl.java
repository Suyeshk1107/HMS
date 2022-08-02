package com.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDaoImpl implements LoginDao {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	Connection connectDB() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "wiley");
	}


	@Override
	public boolean validate(String id, String password) {
		String pssd = "";
		
		try {
			this.connection = connectDB();
			preparedStatement = connection.prepareStatement("select password from login_credentials where id=?");
			
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery(); 
			
			if(resultSet.next()) {
				pssd = resultSet.getString("password");
			}
			if(pssd.equals(password))
				return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean registerUser(String id, String password) {
		
		int rows = 0;
		try {
			this.connection = connectDB();
			preparedStatement = connection.prepareStatement("INSERT INTO login_credentials values(?,?)");
			
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, password);
			
			rows = preparedStatement.executeUpdate();
			
			if(rows < 1) 
				return false;
			return true;
			
		} catch (SQLException e) {
			
		}
		return false;
	}

}
