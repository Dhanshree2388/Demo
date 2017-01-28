package com.learning.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.learning.web.entity.CourseRegister;


public class CourseRegisterDAO {
	public void registration(CourseRegister reg) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/admin", "root", "root");
		
		PreparedStatement pst = connection.prepareStatement("insert into register(name,email,batchcode,country,time) values(?,?,?,?,?)");
		pst.setString(1, reg.getName());
		pst.setString(2, reg.getEmail());
		pst.setString(3, reg.getBatch());
		pst.setString(4, reg.getCountry());
		pst.setString(5, reg.getTime());
	
		
		
		 pst.executeUpdate();
		
		
	
	}
	
	public List<CourseRegister> getRegistrations() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/admin", "root", "root");
		
		PreparedStatement pst = connection.prepareStatement("select * from register");
		ResultSet rs = pst.executeQuery();
		List<CourseRegister> ls = new ArrayList<CourseRegister>();
		while(rs.next())
		{
			CourseRegister obj = new CourseRegister();
			obj.setName(rs.getString(1));
			obj.setEmail(rs.getString(2));
			obj.setBatch(rs.getString(3));
			obj.setCountry(rs.getString(4));
			obj.setTime(rs.getString(5));
			ls.add(obj);
		}
		
		return ls;
		
	}
}
