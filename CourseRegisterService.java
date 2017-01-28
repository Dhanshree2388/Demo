package com.learning.web.services;

import java.sql.SQLException;
import java.util.List;

import com.learning.web.dao.CourseRegisterDAO;
import com.learning.web.entity.CourseRegister;

public class CourseRegisterService {
	CourseRegisterDAO objDAO = new CourseRegisterDAO();
	
	public void Register(CourseRegister object) throws ClassNotFoundException, SQLException
	{
		objDAO.registration(object);
	}
	public List<CourseRegister> getRegister() throws ClassNotFoundException, SQLException
	{
		objDAO.getRegistrations();
		return objDAO.getRegistrations();
	}
	
}
