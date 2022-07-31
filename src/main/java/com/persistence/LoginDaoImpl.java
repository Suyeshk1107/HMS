package com.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LoginDaoImpl implements LoginDao {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private Statement statement;
	private ResultSet resultSet;
	
	Connection connectDB() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "wiley");
	}
	
	@Override
	public boolean registerUser() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean validate(String id, String password) {
		String pssd = null;
		
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

}
